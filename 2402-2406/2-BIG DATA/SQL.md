# DBMS
1. DBMS used to maintain, query large datasets.
2. Benefits：
    - system crashes
    - concurrent access
    - quick application development
    - data integrity and security.
3. Levels of abstraction give data independence.
4. A DBMS typically has a layered architecture.
5. DBMS R&D is one of the broadest, most exciting areas in CS.

# ER Model 
1. **Entity (square)**: Real-world object distinguishable from other objects. An entity is described (in DB) using a set of **attributes (circles)**.
2. **Relationship (diamond)**: Association among two or more entities.
3. **关系选择**:
    - 一对一 (1:1) 关系：这种关系意味着一个实体的每个实例最多只能与另一个实体的一个实例相关联，反之亦然。
    - 一对多 (1:N) 或 多对一 (N:1) 关系：这种关系意味着一个实体的单个实例可以与另一个实体的多个实例相关联，但反向关系不成立。
    - 多对多 (N:M) 关系：在这种关系中，一个实体的实例可以与另一个实体的多个实例相关联，反之亦然。
    - 可选的关系 (0:N) 或 (0:1)：这种关系表示参与方不一定需要参与关系。
4. **Weak Entities**:
    - 弱实体不能仅通过其属性唯一标识的实体。它依赖于另一个实体（称为强实体）来提供其部分或全部标识。
    - 弱实体与强实体之间通过一种特殊类型的关系（称为识别关系）连接，并通过这种关系获得其标识属性（称为部分键）。
    - 在实体关系图中，弱实体通常通过双线框表示，而识别关系通过双线箭头表示。

# SQL Query
## Relational Database Definition
```
Students(sid:int, name:string, login:string, age:int, gpa:real)
```
Cardinality = 3, degree = 5, all rows distinct

## The SQL Query Language
1. 单数据查询:年龄18的学生,显示所有数据
```
SELECT * FROM Student S WHERE S.age = 18
```
2. 多数据查询:成绩为A,最后显示学生名字及cid
```
SELECT S.name, E.cid FROM Student S, Enrolled E 
    WHERE S.sid = E.cid AND E.grade = "A"
```
3. 创建关系:Observe that the type (domain) of each field is specified, and enforced by the DBMS whenever tuples are added or modified.
```
CREATE TABLE Student(
    sid: char(20),
    name: char(20),
    login:char(20),
    age:integer,
    gpa:real
)
```
```
CREATE TABLE Enrolled(
    sid:char(20),
    cid:char(20),
    grade:char(2)
)
```
4. 删除表:删除所有
```
DROP TABLE Student
```
5. 增加元素:every tuple in the current instance is extended with a **null** value in the new field.
```
ALTER TABLE Student
    ADD COLUMN firstYear: integer
```
6. 增加单元组数据:
```
INSERT INTO Students(sid,name,login,age,gpa)
    VALUE(1234,'Smith','Smith@ee',18,3.2)
```
7. 删除某一项相关所有数据
```
DELETE FROM Student S 
    WHERE S.name = 'Smith'
```
8. 
```
CREATE TABLE Works_In(
    ssn char(11),
    did INTEGER,
    since DATA,

    PRIMARY KEY(ssn,did),
    FOREIGN KEY(ssn)
        REFERENCES Employees,
    FOREIGN KEY(did)
        REFERENCES Departments
)
```
- 主键（Primary Key）：在这个表格中，组合键 ssn 和 did 被设为主键。这意味着每个员工在每个部门的组合是唯一的，同一个员工不能在同一个部门里被记录两次。
- 外键（Foreign Key）：外键用来链接到其他的表格。这里的 ssn 是外键，它参照（或链接到）Employees 表中的员工。did 也是外键，它链接到 Departments 表中的部门。这确保了 Works_In 表中的每个记录的员工和部门都是存在的。

9. 
```
CREATE TABLE Dept_Mgr(
did INTEGER,
dname CHAR(20),
budget REAL,
ssn CHAR(11),
since DATE,
PRIMARY KEY (did),
FOREIGN KEY (ssn) REFERENCES Employees)
```
- PRIMARY KEY (did)：
    - 这里设定 did 为这个表的主键。
    - 在数据库中，主键是唯一标识表中每行数据的键，这里意味着每个部门编号是唯一的，不会有两个部门拥有相同的编号。
- FOREIGN KEY (ssn) REFERENCES Employees：
    - 这里设定 ssn 为外键，并且引用了 Employees 表。
    - 这意味着表中的每个 ssn 必须在 Employees 表中存在，确保了 Dept_Mgr 表中记录的每位部门经理都是有效的员工记录。

10. 引用完整性
```
CREATE TABLE Enrolled
(sid CHAR(20),
cid CHAR(20),
grade CHAR(2),
PRIMARY KEY (sid,cid),
FOREIGN KEY (sid)
REFERENCES Students
ON DELETE CASCADE
ON UPDATE SET DEFAULT )
```
- PRIMARY KEY (sid, cid)：这里设定了一个复合主键（sid 和 cid），这意味着学生ID和课程ID的组合必须是唯一的。这防止了同一学生对同一课程的重复注册记录。
- FOREIGN KEY (sid) REFERENCES Students ON DELETE CASCADE ON UPDATE SET DEFAULT：
    - FOREIGN KEY (sid) REFERENCES Students：这里设定 sid 为外键，引用 Students 表中的学生ID。这确保了 Enrolled 表中每个学生ID都对应一个有效的学生。
    - ON DELETE CASCADE：这个选项设置了当一个引用的学生在 Students 表中被删除时，相应的在 Enrolled 表中的所有记录也会被自动删除。这有助于维持数据库的数据一致性，避免出现孤立的注册记录。
    - ON UPDATE SET DEFAULT：这个选项设置了当 Students 表中的一个学生ID被更新时，在 Enrolled 表中引用该学生ID的字段将被设为默认值。这个选项的实现需要在表定义中明确指定默认值，否则可能会导致更新操作失败。

## Queries, Constraints
### Basic SQL Query
1. 
```
SELECT [DISTINCT]target-list
    FROM relation-list
    WHERE qualification
```
- target-list : 关系属性列表
- relation-list ：关系名称列表
- qualification ： 限定比较(Attr op const o或 Attr1 op Attr2, op = "<, >, =, <=, >=, /=")
- DISTINCT ：可选的关键字，指示答案不包含重复项（默认不消除重复项）

2. Produce the name of sailors:
```
SELECT sname FROM Sailors
```
3. Change the column heading:
```
SELECT sname as "Sailor Name" FROM Sailors
```
4. Rename table name:
```
SELECT sname FROM Sailors S
```
5. Find names and ages of all sailors:
```
SELECT DISTINCT S.sname,S.age FROM Sailors S;
```
6. Find sailors with rating above 7:
```
SELECT * FROM Sailors WHERE rating > 7
```

### LIMIT and ORDER BY
1. Limit: limit the number of results 
```
//Get the 10 first Sailors
SELECT * FROM Sailors Limit 10
```

2. ORDER BY: order results by an attribute
```
SELECT * FROM Sailors ORDER BY age
```
- 升序排序 (ASC)
```
SELECT pname, age FROM Pilot
ORDER BY age ASC;  -- 或者简单地写为 ORDER BY age
```
- 降序排序 (DESC)
```
SELECT pname, points FROM Pilot
ORDER BY points DESC;
```

3. get TOP 10 Youngest Sailors
```
SELECT * FROM Sailors ORDER BY age LIMIT 10
```
4. Natural Join
```
SELECT *
    FROM Sailors
    natural join Reserves
    WHERE bid=103
```
- natural join Reserves：这是一个连接操作，它自动找出 Sailors 和 Reserves 表中**同名的列**，并用这些列作为连接条件。natural join 会**合并**两个表中所有同名的列，并且**只返回那些在两个表中具有相同值的记录**。例如，如果两个表都有一个叫做 sid 的列（通常是水手的ID），那么 natural join 会连接那些 sid 相同的行。

```
SELECT * 
    FROM Groups JOIN Musicians 
    WHERE Groups.MusicianId = Musicians.MusicianId
```

5. 
- **AS** and **=** 是结果字段的命名方式
- **LIKE**用于字符串匹配，**_** 代表任意字符，**%** 代表0或多个字符
Ex.Find sailors that have the character ‘u’ in theiR names
```
SELECT S.sname 
    FROM Sailors S
    WHERE S.sname LIKE '%u%'
```

6. **Union** 操作符用来合并两个查询结果集，条件是这两个结果集必须是结构兼容的（即具有相同数量和类型的列）
- 原查询：
```
SELECT S.sid
FROM Sailors S, Boats B, Reserves R
WHERE S.sid=R.sid AND R.bid=B.bid
AND (B.color='red' OR B.color='green')
```
- 使用Union
```
SELECT S.sid
FROM Sailors S, Boats B, Reserves R
WHERE S.sid=R.sid AND R.bid=B.bid
AND B.color='red'
UNION
SELECT S.sid
FROM Sailors S, Boats B, Reserves R
WHERE S.sid=R.sid AND R.bid=B.bid
AND B.color='green'
```

7. **Except / minus**: To substract a set from another

Ex: Find sids of sailors who have reserved green boats but not red boats.
```
SELECT R.sid
    FROM Reserves R, Boats B
    WHERE R.bid = B.bid AND B.color = ’green’
MINUS
SELECT R2.sid
    FROM Boats B2, Reserves R2
    WHERE R2.bid = B2.bid AND B2.color = ‘red’
```

8. **Intersect** 查找交集 Can be used to compute the intersection of any two union-compatible sets of tuples.

Ex: Find sid’s of sailors who’ve reserved a red and a green boat
```
SELECT S.sid
    FROM Sailors S, Boats B, Reserves R
    WHERE S.sid=R.sid AND R.bid=B.bid
    AND B.color=‘red’
INTERSECT
SELECT S.sid
    FROM Sailors S, Boats B, Reserves R
    WHERE S.sid=R.sid AND R.bid=B.bid
    AND B.color=‘green’
```

9. **EXISTS** is another set comparison operator, like **IN**.
```
SELECT S.sname
    FROM Sailors S
    WHERE EXISTS (SELECT *
        FROM Reserves R
        WHERE R.bid=103 AND S.sid=R.sid)
```

### Aggregate Operators
- COUNT (*)
- COUNT ( [DISTINCT] A)
- SUM ( [DISTINCT] A)
- AVG ( [DISTINCT] A)
- MAX (A)
- MIN (A)

### GROUP BY and HAVING
```
SELECT [DISTINCT] target-list
    FROM relation-list
    WHERE qualification
    GROUP BY grouping-list
    HAVING group-qualification
```
- GROUP BY 子句将结果集分为多个分组，在每个分组上可以进行聚合计算，如计算总和、平均值、最大值等。
- HAVING 子句是对分组后的结果的进一步筛选。它类似于 WHERE 子句，但 HAVING 是用在分组上，而不是用在单个行上。

### Division in SQL 
1. **Count**
```
SELECT sailor_name FROM Reserves
    WHERE boat_id IN (SELECT boat_id FROM Boats)
GROUP BY sailor_name
HAVING COUNT(DISTINCT(boat_id)) = (SELECT COUNT(boat_id) FROM Boats)
```
- 从Reserves表中选择sailor_name 分组
- 对分组后的结果进行HAVING筛选： COUNT计算水手使用的船只数=Boat中的船只数

2. Double Negation
```
SELECT DISTINCT(sailor_name) FROM Sailors AS S1 
    WHERE NOT EXISTS 
        (SELECT * FROM Boats AS B 
            WHERE NOT EXISTS 
                (SELECT * FROM RESERVES AS R
                    WHERE R.sid=S1.sid AND R.bid = B.bid
                )
)
```

### JOIN
1. INNER JOIN:仅返回两个表中满足连接条件的行。
```
//返回预定了船只的水手信息
SELECT S.name,S.sid,B.bid,B.bname
FROM Sailors S
INNER JOIN RESERVES R ON S.sid = R.sid
INNER JOIN BOATS B ON B.bid = R.bid;
```
2. RIGHT OUTER JOIN:返回JOIN 之后的右表中的所有行，以及JOIN 之前的左表中匹配的行。如果左表没有匹配，结果将为 NULL。
```
//返回所有船只信息，以及如果有水手预定了就返回水手信息
SELECT S.name,S.sid,B.bid,B.bname
FROM Sailors S
RIGHT OUTER JOIN RSERVES R ON S.sid = R.sid
RIGHT OUTER JOIN Boats B ON R.bid = B.bid;
```
3. LEFT OUTER JOIN:返回左表中的所有行，以及右表中匹配的行。如果右表没有匹配，结果将为 NULL。
```
// 返回所有水手信息，以及他们预定的船只信息（如果有预定）
SELECT S.sid, S.sname, B.bid, B.bname
FROM Sailors S
LEFT OUTER JOIN Reserves R ON S.sid = R.sid
LEFT OUTER JOIN Boats B ON R.bid = B.bid;
```
4. FULL OUTER JOIN:返回左表和右表中的所有行。当一侧没有匹配时，另一侧将为 NULL。
```
//返回所有水手和所有船只的信息，不管他们是否有预定关系
SELECT S.sid, S.sname, B.bid, B.bname
FROM Sailors S
FULL OUTER JOIN Reserves R ON S.sid = R.sid
FULL OUTER JOIN Boats B ON R.bid = B.bid;
```
5. CROSS JOIN:返回两个表的笛卡尔积，即每个左表的行与右表的每行相结合。不需要指定连接条件。
```
-- 返回水手和船只的所有可能组合
SELECT S.sid, S.sname, B.bid, B.bname
FROM Sailors S
CROSS JOIN Boats B;
```

## 3 PL_SQL
### PL/SQL Block Structure 
A PL/SQL program is structured into blocks, which may include a section for declarations (DECLARE), execution commands (BEGIN...END), and exception handling (EXCEPTION).

### Variables and Constants
PL/SQL allows the declaration of variables and constants. Variables can be initialized with a value or a DEFAULT clause, and constants must be initialized upon declaration.

### Control Structures
PL/SQL includes control structures such as conditional statements (IF...THEN...ELSE) and loops (LOOP, WHILE, FOR).
1. IF & LOOP
```
-- This PL/SQL block finds out if a sailor with a certain ID has reserved a red boat
DECLARE
    v_sailor_id SAILORS.sid%TYPE := 101; -- Example sailor ID
    v_color VARCHAR2(10) := 'red';
    v_has_reserved_red_boat BOOLEAN := FALSE;
BEGIN
    FOR r IN (SELECT * FROM Reserves JOIN Boats ON Reserves.bid = Boats.bid WHERE color = v_color) LOOP
        IF r.sid = v_sailor_id THEN
            v_has_reserved_red_boat := TRUE;
            EXIT;
        END IF;
    END LOOP;

    IF v_has_reserved_red_boat THEN
        dbms_output.put_line('Sailor ' || v_sailor_id || ' has reserved a red boat.');
    ELSE
        dbms_output.put_line('Sailor ' || v_sailor_id || ' has not reserved a red boat.');
    END IF;
END;

```

### Cursors
用于从结果集中逐行检索数据。

Cursors are used to retrieve data row by row from a result set. PL/SQL provides both implicit and explicit cursors for fetching data from database queries.

```
-- This PL/SQL block uses a cursor to find all boats reserved by a sailor
DECLARE
    CURSOR c_reservations IS
        SELECT Boats.*
        FROM Boats
        JOIN Reserves ON Boats.bid = Reserves.bid
        WHERE Reserves.sid = 101; -- Assume 101 is the sailor ID
    v_boat Boats%ROWTYPE;
BEGIN
    OPEN c_reservations;
    LOOP
        FETCH c_reservations INTO v_boat;
        EXIT WHEN c_reservations%NOTFOUND;
        dbms_output.put_line('Boat ID: ' || v_boat.bid || ' - Name: ' || v_boat.bname);
    END LOOP;
    CLOSE c_reservations;
END;

```

### Procedures and Functions

允许创建过程和函数来封装逻辑。过程执行操作，可能通过 OUT 参数返回值，而函数计算值并且必须返回结果。
```
-- Procedure to update the color of a boat
CREATE OR REPLACE PROCEDURE UpdateBoatColor(p_bid Boats.bid%TYPE, p_color Boats.color%TYPE) AS
BEGIN
    UPDATE Boats SET color = p_color WHERE bid = p_bid;
    COMMIT;
END UpdateBoatColor;
```

### Triggers

触发器是为了响应特定表或视图上的某些事件而自动执行的特殊过程。
```
-- Trigger to audit reserves of red boats
CREATE OR REPLACE TRIGGER AuditRedBoatReserve
AFTER INSERT ON Reserves
FOR EACH ROW
DECLARE
    v_color Boats.color%TYPE;
BEGIN
    SELECT color INTO v_color FROM Boats WHERE bid = :NEW.bid;
    IF v_color = 'red' THEN
        INSERT INTO ReserveAudit (sid, bid, reserve_date) VALUES (:NEW.sid, :NEW.bid, SYSDATE);
    END IF;
END;
```

### Exceptions
PL/SQL provides robust exception handling mechanisms to deal with runtime errors. These include predefined exceptions, user-defined exceptions, and the ability to explicitly raise exceptions with RAISE or RAISE_APPLICATION_ERROR.
```
-- This PL/SQL block inserts a new reservation and handles exceptions
DECLARE
    v_bid Boats.bid%TYPE := 103; -- Example boat ID
    v_sid Sailors.sid%TYPE := 101; -- Example sailor ID
    e_boat_not_found EXCEPTION;
BEGIN
    INSERT INTO Reserves (sid, bid, res_date) VALUES (v_sid, v_bid, SYSDATE);
EXCEPTION
    WHEN e_boat_not_found THEN
        dbms_output.put_line('The boat with ID ' || v_bid || ' does not exist.');
    WHEN OTHERS THEN
        dbms_output.put_line('An unexpected error occurred: ' || SQLERRM);
END;
```

### Transactions
PL/SQL handles transactions, allowing for COMMIT to save changes or ROLLBACK to undo them.

## 
### Transactions
- Transactions are fundamental database operations that must have ACID properties: Atomicity, Consistency, Isolation, and Durability. These properties ensure reliable processing even in the presence of errors and concurrent transaction execution .
- Scheduling transactions refers to the order in which multiple transactions are processed. A serial schedule doesn't interleave actions from different transactions. Serializable schedules allow transactions to run in parallel but produce results equivalent to some serial execution .

- 事务是数据库的基础操作，必须具备ACID属性：原子性（Atomicity）、一致性（Consistency）、隔离性（Isolation）和持久性（Durability）。这些属性确保即使在出现错误和并发事务执行的情况下也能保证可靠处理。
- 事务调度是指多个事务处理的顺序。串行调度不会交错来自不同事务的动作。可串行化调度允许事务并行运行，但产生的结果等同于某种串行执行的结果。

### Locks
- Locks are mechanisms used to control access to database objects like rows or tables during transactions to prevent conflicts. Different lock levels (row-level, table-level, shared, exclusive) provide varying degrees of access to the data by concurrent transactions .

- 锁是在事务期间用于控制对数据库对象（如行或表）的访问的机制，以防止冲突。不同级别的锁（行级锁、表级锁、共享锁、独占锁）为并发事务提供不同程度的数据访问权限

### Normalization
- Database normalization involves organizing the attributes of a database to reduce redundancy and improve data integrity. It typically involves decomposing a single table into multiple tables without losing data or the relationships between tables .
- Normal forms are a series of guidelines to follow when designing a database schema. The document discusses up to the Boyce-Codd Normal Form (BCNF), each with its specific conditions and properties .

- 数据库规范化涉及组织数据库的属性，以减少冗余和提高数据完整性。它通常涉及将单个表分解为多个表，而不丢失数据或表之间的关系。
- 规范形式是在设计数据库架构时遵循的一系列指导原则。文档讨论了直到BCNF（Boyce-Codd规范形式），每一种都有其特定的条件和属性。

### Security and Authorization in SQL
- SQL databases have security mechanisms to control access to data. Users are granted various types of privileges such as SELECT, INSERT, UPDATE, and DELETE. Moreover, the GRANT and REVOKE statements are used to confer and take back those privileges, respectively .
- Roles in SQL help to manage privileges more efficiently by allowing a collective set of privileges to be granted or revoked from a group of users at once .
- SQL数据库具有控制数据访问的安全机制。用户被授予各种类型的权限，如SELECT、INSERT、UPDATE和DELETE。此外，GRANT和REVOKE语句用于授予和收回这些权限。
- SQL中的角色通过允许一次性地从一组用户授予或撤销一组权限，有助于更有效地管理权限。

## 4 Administration & Performance for Databases

### Window Functions
- RANK(), ROW_NUMBER(), DENSE_RANK()和OVER()的使用。
    -  `RANK()` 函数在分组内对行进行排名。如果行之间的排序值相同，则这些行将共享相同的排名，下一个排名数字将是这些重复排名后的下一个数字。
    - `ROW_NUMBER()`函数为每个分组内的行分配一个唯一的连续整数,即使值相同也会为每行生成一个新的数字。
    - `DENSE_RANK()` 函数类似于 `RANK()`，但它在排名中不会跳过任何数字。如果有并列的排名，下一个排名将紧跟着并列排名之后，而不会留下间隔。
    - `OVER()` 子句用于定义窗口函数的作用范围和计算规则。它可以指定两个主要的方面：
        - `PARTITION BY`：这是可选的，用于指定窗口内的数据分组标准。
        - `ORDER BY`：这也是可选的，用于指定每个分组内数据的排序方式。
- 使用WITH语句简化复杂查询。
```
//按照得分对水手进行了排名。

SELECT sid, 
       RANK() OVER (ORDER BY score DESC) as rank
FROM Sailors
WHERE sid IN (SELECT sid FROM Reserves WHERE bid = 101);
```

### Overview of Database Administration (DBA) Responsibilities 数据库管理员（DBA）职责概述
- 管理员的目标、技能、工作中的难点和工具。
- 性能优化，如SQL优化器、解释计划（EXPLAIN）、索引使用和集群等。
```
// 为Sailors表中的name列创建了一个索引，以加速基于水手名字的查询操作

CREATE INDEX idx_sailors ON Sailors(name);
```

### Organization of Logical/Physical Structures 逻辑/物理结构组织
- 数据文件、表空间、区段、范围和数据块的管理。
```
//创建了一个新的表空间，用于存储水手数据。

CREATE TABLESPACE sailors_data 
DATAFILE 'sailors_data.dbf' SIZE 100M 
AUTOEXTEND ON NEXT 10M MAXSIZE UNLIMITED;
```

### Security and Authorization 安全性和授权
在SQL中如何管理用户权限、使用GRANT和REVOKE语句授予权限。

```
//授予user_readwrite用户在Sailors表上进行选择和插入操作的权限。 

GRANT SELECT, INSERT ON Sailors TO user_readwrite;
```
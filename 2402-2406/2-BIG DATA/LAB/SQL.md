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
```
SELECT [DISTINCT]target-list
    FROM relation-list
    WHERE qualification
```
- target-list : 关系属性列表
- relation-list ：关系名称列表
- qualification ： 限定比较(Attr op const o或 Attr1 op Attr2, op = "<, >, =, <=, >=, /=")
- DISTINCT ：可选的关键字，指示答案不包含重复项（默认不消除重复项）



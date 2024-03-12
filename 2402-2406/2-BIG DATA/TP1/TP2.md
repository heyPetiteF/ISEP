# Advanced Database - TP 2 - Part 2 PL/SQL

## Exercice 1. Functions

1. Create a function that gets an employee’s name from it’s empno. **[PPT P8]**

```
CREATE OR REPLACE PROCEDURE EXERSISE1(in_EMP_ID NUMERIC)
LANGUAGE plpgsql
AS $procedure$
DECLARE
    R_EMP EMP%ROWTYPE; 
BEGIN 
    SELECT * FROM EMP EMP WHERE EMPNO = in_emp_ID;
    --Print the employee name
    raise notice 'Employee Name : %, Employee Salary : %', 
    R_EMP.EFIRST, R_EMP.SAL;

END;
$procedure$
```

2. 验证: Procedures -> Script -> EXEC Script
Test the query with:
```
SELECT myFunction(7654) FROM DUAL;
```
```
CALL public.exercise1(7499)
```


## Exercice 2. Procedure & Display & Cursors
Create a procedure that displays the net salary of this employee and the average salary of
employees doing the same job **[PPT P65]**

```
CREATE OR REPLACE PROCEDURE EXERSISE2(in_EMP_ID NUMERIC)
LANGUAGE plpgsql
AS $procedure$
DECLARE
    R_EMP EMP%ROWTYPE; 
	AVG_SAL  NUMERIC;
	
BEGIN 
    SELECT * FROM EMP EMP WHERE EMPNO = in_emp_ID;
	SELECT AVG(SAL) into AVG_SAL FROM EMP 
        WHERE JOB IN(SELECT JOB FROM EMP WHERE EMPNO = in_EMP_ID);
	raise notice 'Employee Name : %, Employee Salary : %', 
    R_EMP.EFIRST, R_EMP.SAL;
	--Print the AVG salary
	raise notice 'AVG of salary : % ', AVG_SAL;
EXCEPTION 
	WHEN OTHERS THEN 
	raise notice 'SQL ERROR OG QUERY : % ', SQLERRM;
END;
$procedure$
```
```
CALL public.exercise2(7499)
```

## Exercice 5. SELECT for UPDATE
Change the commission for employees by putting them all to 0
Write the procedure UpdateCommission for modifying the commission of employees based on
their salary

- Sal<=1000 COMM=800
- Sal<=2000 COMM=1200
- Sal>2000 COMM=1500

Indications:


use the instruction “SELECT ... FROM table FOR UPDATE”

This will allow you to put a lock on the rows you want to update

The following statement specifies the current tuple to modify with an UPDATE or DELETE
WHERE CURRENT OF cursor **[PPT P43]**

```
UPDATE EMP SET COMM = 0;
```
MESSAGE -> UPDATE 14

```
UPDATE EMP SET COMM = 0;

CREATE OR REPLACE PROCEDURE EXERCISES()
language plpgsql
AS $procedure$

DECLARE
	ONE_EMP EMP%ROWTYPE;
	NEW_COMM numeric;
	E_SAL numeric;
	SAL_EMP CURSOR FOR SELECT * FROM EMP FOR UPDATE;
	
BEGIN
	--Open the cursor
	OPEN SAL_EMP;
	--Looping in the cursor
	LOOP
		FETCH SAL_EMP into ONE_EMP;
		EXIT WHEN NOT FOUND;
		--Cursor usage
		E_SAL := ONE_EMP.SAL;
		IF E_SAL <= 1000 THEN 
			NEW_COMM := 800;
		ELSE IF E_SAL <= 2000 THEN
			NEW_COMM := 1200;
		ELSE 
			NEW_COMM := 1500;
		END IF;
		END IF;
		
		UPDATE EMP SET COMM = NEW_COMM WHERE EMPNO = ONE_EMP.EMPNO;
		raise notice 'Empoyee Number; %, Employee Salary : %, New Commission: %,',
		ONE_EMP.EMPNO, ONE_EMP.SAL, NEW_COMM;
		
	END LOOP;
	--Closing the cursor
	CLOSE SAL_EMP;		

END
$procedure$
```
```
CALL public.exercise5()
```
```
SELECT * FOME public.emp
ORDER BY empno ASC
```






CREATE OR REPLACE PROCEDURE exercise6() 
LANGUAGE plpgsql
AS $procedure$
DECLARE
    R_EMP EMP%ROWTYPE; 
    counter INT := 0;
BEGIN

    RAISE NOTICE 'Highest salary employees:';
    FOR R_EMP IN SELECT * FROM EMP ORDER BY sal DESC LIMIT 5 LOOP
        RAISE NOTICE 'Employee Number: %, Employee Salary: %', R_EMP.empno, R_EMP.sal;
    END LOOP;
    
    RAISE NOTICE 'Lowest salary employees:';
    FOR R_EMP IN SELECT * FROM EMP ORDER BY sal ASC LIMIT 5 LOOP
        RAISE NOTICE 'Employee Number: %, Employee Salary: %', R_EMP.empno, R_EMP.sal;
    END LOOP;
END;
$procedure$;

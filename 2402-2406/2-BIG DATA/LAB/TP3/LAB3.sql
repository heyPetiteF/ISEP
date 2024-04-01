CREATE TABLE DEPT
       (DEPTNO integer constraint pk_dept primary key,
        DNAME VARCHAR(14),
        LOC VARCHAR(13) );
 
  
CREATE TABLE EMP
       (EMPNO integer constraint pk_emp primary key,
        ENAME VARCHAR(10),
        EFIRST VARCHAR(10),
        JOB VARCHAR(9),
        MGR integer not null,
        HIREDATE DATE,
        SAL integer constraint ck_sal check (SAL>=0),
        COMM integer,
        TEL char(10),
        DEPTNO integer,
        constraint fk_emp_dept foreign key(DEPTNO) references DEPT (DEPTNO));
        
CREATE TABLE DEPENDENTS
       (DNO integer,
        DNAME VARCHAR(10),
        DFIRST VARCHAR(10),
		EMPNO integer,
		constraint pk_dependent primary key (DNO, EMPNO),
        constraint fk_dependent_emp foreign key(EMPNO) references EMP (EMPNO));
        
        
CREATE TABLE BONUS
       (ENAME VARCHAR(10),
        JOB   VARCHAR(9),
        SAL   integer,
        COMM  integer);
 
CREATE TABLE SALGRADE
        (GRADE integer,
         LOSAL integer,
         HISAL integer);
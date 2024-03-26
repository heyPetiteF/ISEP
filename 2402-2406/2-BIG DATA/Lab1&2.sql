SELECT empno, COUNT(projno) AS num_projects
FROM project_emp
GROUP BY empno
HAVING COUNT(projno) >= 2;

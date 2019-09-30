select * from EMP;
select * from DEPT;
select * from SALGRADE;

select avg(sal) from emp;
select deptno,avg(sal) from emp group by deptno;

select max(hiredate) from emp;
select min(sal) from emp

select comm from emp
select sum(comm) from emp
select avg(comm) from emp 
select count(comm) from emp
select count(sal) from emp

select deptno,sum(sal) sum,avg(sal) avg
from emp
group by deptno

select empno,ename,sal,job
from EMP
where ename='SMITH'




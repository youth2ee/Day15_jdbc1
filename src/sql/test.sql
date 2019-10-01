select * from EMP;
select * from DEPT;
select * from SALGRADE;

select avg(sal) from emp;
select deptno,avg(sal) from emp group by deptno;

select max(hiredate) from emp;
-- sql에서는 주석을 '--'으로 쓴다.
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

select * from DEPT
where 
-- 중복데이터로는 값을 찾을 수 없다.
-- 중복되지않는 데이터로 값을 찾을 수 있다. 중복되지 않는 값을 넣을 컬럼이 필요하다.

select * from EMP
-- 사원번호는 중복되지 않는다. primary key(unique + not null) : 중복되지않고 꼭 들어가야하는 값

insert into DEPT (deptno,dname,loc)
values(50,'IT','SEOUL')

insert into DEPT (dname,loc,deptno)
values('Marketing','JEJU',70)

insert into DEPT
values(80, 'TEST','DAEGU')

insert into DEPT (deptno, dname)
values(90, 'TEST2')

insert into DEPT (deptno,dname,loc)
values(100,'S1','INCHEON')

select * from dept
order by deptno asc

select * from EMP

update dept set loc='SEOUL' where deptno=90

select * from DEPT

select * from dept
where deptno=10




select * from employees emp where emp.employee_id NOT IN (select NVL(manager_id,0) from employees);
select last_name,department_id from employees where department_id in(20,50) order by last_name;
select last_name,hire_date from employees where hire_date between TO_DATE('01-jan-2004') and TO_DATE('01-jan-2005');
select last_name,salary,commission_pct from employees where commission_pct is not null order by salary desc,commission_pct desc;
select last_name from employees where last_name like '__a%';
select last_name from employees where last_name like '%a%' and last_name like '%e%';
select last_name,job_id,salary from employees where job_id IN ('SA_REP','ST_CLERK') and salary not in(2500,3500,7000);
 select * from (select last_name,INITCAP(last_name) Name from employees) LEFT JOIN
(select last_name,LENGTH(last_name) length from employees where SUBSTR(last_name,1,1) in ('J','A','M')) using (last_name);
select last_name, ROUND(MONTHS_BETWEEN(sysdate,hire_date),0) MONTHS_WORKED from employees order by last_name;
select last_name,department_id from employees where department_id = (select department_id from employees where last_name='Abel');
select e.department_id department,e.last_name employee,c.last_name colleague from employees e join employees c on (e.department_id = c.department_id) where e.employee_id <> c.employee_id order by e.department_id , e.last_name,c.last_name;
select e.first_name,e.last_name,e.hire_date,m.first_name,m.last_name,m.hire_date from employees e join employees m on e.manager_id = m.employee_id  where e.hire_date < m.hire_date; 
select employee_id,last_name,department_id from employees where department_id in(select department_id from departments where location_id in( select location_id from locations where city like'T%'));
select * from employees e where not exists (select * from employees m where e.employee_id= m.manager_Id );
select e.last_name,e.hire_date,e.salary from employees e where exists (select * from employees m where e.department_id=m.department_id and e.hire_date>m.hire_date and e.salary>m.salary); 
select employee_id,last_name,department_name from employees join departments using(department_id);
select employee_id,last_name,department_name from employees e where exists(select * from departments d where e.department_id=d.department_id);
select last_name,employee_id,(select department_name from departments d where e.department_id=d.department_id) department_name from employees e order by 1;
with summary as( select d.department_name,sum(e.salary) as dept_total from employees e,departments d where e.department_id=d.department_id group by d.department_name)
select department_name,dept_total from summary where dept_total > (select sum(dept_total)*1/8 from summary) order by dept_total desc;
select employee_id,job_id,department_id from employees union all select employee_id,job_id,department_id from job_history order by employee_id;
select employee_id,job_id from employees intersect select employee_id,job_id from job_history;
select employee_id,job_id from employees minus select employee_id,job_id from job_history;
select employee_id,department_id,TO_NUMBER(null)location,hire_date,manager_id from employees union select TO_NUMBER(null),department_id,location_id,TO_DATE(null),TO_NUMBER(null) from departments;
select department_id,location_id,department_name,TO_CHAR(null) from departments union select 0,location_id,TO_CHAR(null),city from locations;
select employee_id,job_id,salary from employees union select employee_id,job_id,0 from job_history;
column a_dummy noprint
select 'sing' as "My dream", 3 a_dummy
from dual
union
select 'I''d like to teach', 1 a_dummy
from dual
union
select 'the world to', 2 a_dummy
from dual
order by a_dummy;

/*insert into departments(department_id,department_name,manager_id,location_id) values (281,'Public Relations',100,1700);
insert into departments values (101,'Finance',null,null);
rollback;*/
select * from departments order by department_id;
insert into employees(employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id) values(281,'Akash','Ramanna','AKRA','515.124.4567',sysdate,'AC_ACCOUNT',6900,null,205,100);

select * from employees;
insert into departments(department_id,department_name,location_id) values (&department_id,'&department_name',&location);
select * from departments;
insert into employees values (283,'Don','Rafael','DRAFAELL','515.127.4561',TO_DATE('FEB 3,1999','MON DD,YYYY'),'AC_ACCOUNT','11000',null,100,283);
select*from employees;

insert into sa_rep(id,name,salary,commission_pct) select employee_id,last_name,salary,commission_pct from employees where job_id like '%REP%';
UPDATE employees set department_id=70 where employee_id=113;
update employees set job_id = (select job_id from employees where employee_id=205),salary=(select salary from employees where employee_id=205) where employee_id=114;
delete from departments where department_name='Finance';
delete from employees where department_id=(select department_id from departments where department_name like '%TEST%');
insert into LOCATIONS VALUES(2702,null,null,'Hyderabad','Telangana','IN');
insert into departments values(71,'New Dept',203,2702);
insert into employees values(284,'Arun','W','ArunW','186.73262.87',sysdate,'AC_ACCOUNT','11000',null,203,71);
delete from employees where department_id=(select department_id from departments join locations using(location_id) where city= 'Hyderabad');
select * from employees;
select * from countries;
insert into(select employee_id,last_name,email,hire_date,job_id,salary,department_id from employees where department_id=50) values(99997,'Taylor','DTAYLORRR',TO_DATE('07-JUN-99','DD-MON-RR'),'ST_CLERK',5000,70);
UPDATE employees set department_id=70 where employee_id=106;
savepoint update_done;
insert into(select employee_id,last_name,email,hire_date,job_id,salary,department_id from employees where department_id=50) values(99996,'Taylor','DTAYLORRRR',TO_DATE('07-JUN-99','DD-MON-RR'),'ST_CLERK',5000,70);
rollback to update_done;
insert into(select employee_id,last_name,email,hire_date,job_id,salary,department_id from employees where department_id=50) values(99995,'Taylor','DTAYLORRRRR',TO_DATE('07-JUN-99','DD-MON-RR'),'ST_CLERK',5000,70);
create table dept80 as (select employee_id,last_name,salary*12 ANNSAL,hire_date from employees where department_id=80);
desc dept80;
create table copy_employee as (select * from employees);
desc copy_employee;
delete from copy_employee;
rollback;
select * from copy_employee;
create table role
(role_id number(3)
constraint role_role_id_pk PRIMARY KEY,
role_name varchar2(15)
constraint role_role_name_nn not null);

ALTER TABLE role
  RENAME TO roles;

create table users
(user_id NUMBER(6)
constraint usr_user_id_pk PRIMARY KEY,
name VARCHAR2(50)
constraint usr_name_nn NOT NULL,
username varchar2(30)
constraint usr_username_nn not null,
password varchar2(30)
CONSTRAINT usr_password_nn not null
constraint usr_password_ck CHECK(LENGTH(password)>=8),
email varchar(40)
constraint usr_email_nn not null
constraint usr_email_uk unique,
role_id number(3)
constraint usr_role_id_fk references role(role_id));

desc role;
desc users;

insert into roles values(101,'Admin');
insert into roles values(102,'Manager');
insert into roles values(103,'User');
select * from roles;

insert into users values(1001,'Akash K','akashk','akashk123','akashk@gmail.com',103);
insert into users values(1002,'Asha K','ashak','ashak123','ashak@gmail.com',103);
insert into users values(1003,'Kamal P','kamalp','kamalp123','kamalp@gmail.com',103);
insert into users values(1004,'Prakash R','prakashr','prakashr123','prakashr@gmail.com',103);
insert into users values(1005,'Killua Z','killuaz','killuaz123','killuaz@gmail.com',103);
insert into users values(1006,'Gon F','gonfreecs','gonfreecs123','gonfreecs@gmail.com',103);
insert into users values(1007,'Aizen S','aizens','aizens123','aizens@gmail.com',103);
insert into users values(1008,'Ichigo K','ichigok','ichigok123','ichigok@gmail.com',103);
insert into users values(1009,'Sasuke U','sasukeu','sasukeu123','sasukeu@gmail.com',103);
insert into users values(1010,'Naruto U','narutou','naruto123','narutou@gmail.com',102);
insert into users values(1011,'Walter W','walterw','walterw123','walterw@gmail.com',102);
insert into users values(1012,'Rama Krishna','ramakrish','ramakrish123','ramakrish@gmail.com',101);

alter table roles add privs varchar2(4);
desc roles;

alter table users add mobile_number number(10);
alter table users modify mobile_number constraint usr_mobile_number_uk unique; 

update users set mobile_number=1234567890 where user_id=1001;
update users set mobile_number=2234567890 where user_id=1010;
update users set mobile_number=3234567890 where user_id=1002;
update users set mobile_number=4234567890 where user_id=1003;
update users set mobile_number=5234567890 where user_id=1004;
update users set mobile_number=6234567890 where user_id=1005;
update users set mobile_number=7234567890 where user_id=1006;
update users set mobile_number=8234567890 where user_id=1007;
update users set mobile_number=9234567890 where user_id=1008;
update users set mobile_number=1134567890 where user_id=1009;
update users set mobile_number=1564567890 where user_id=1011;
update users set mobile_number=1684567890 where user_id=1012;

create view empvu80 as select employee_id,last_name,salary from employees where department_id=80;
desc empvu80;

select * from empvu80;

create or replace view empvu80 (id_number,name,sal,department_id) as select employee_id,first_name||' '||last_name,salary,department_id from employees where department_id=80;

create or replace view dept_sum_vu (name,minsal,maxsal,avgsal) as select d.department_name,min(e.salary),max(e.salary),avg(e.salary) from employees e join departments d on (e.department_id=d.department_id) group by d.department_name;

create or replace view empvu20 as select * from employees where department_id=20 with check option constraint empvu20_ck;

create or replace view empvu10(employee_number,employee_name,job_title) as select employee_id,last_name,job_id from employees where department_id=10 with read only;

create sequence usr_user_id_seq increment by 1 start with 1013 maxvalue 1020 nocache nocycle;

insert into users(user_id,name,username,password,email,role_id) values (usr_user_id_seq.NEXTVAL,'Karan K','karank','karank123','karank@gmail.com',103);
select * from users;
select usr_user_id_seq.CURRVAL from dual;

create sequence role_role_id_seq3 increment by 1 start with 101 maxvalue 1100 nocache nocycle;
insert into roles(role_id,role_name,privs) values(role_role_id_seq3.NEXTVAL,'NewRole','rw');
select * from roles;

create index user_name on users(username);

create or replace view mgr (Id,Name,Email) as select user_id,name,email from users where role_id=101;

describe dictionary;

select * from dictionary;

select object_name,object_type,created,status from user_objects order by object_type;

describe user_tables;

describe user_tab_columns;

select column_name,data_type,data_length,data_precision,data_scale,nullable from user_tab_columns where table_name = 'EMPLOYEES';
select constraint_name,constraint_type,search_condition,r_constraint_name,delete_rule,status from user_constraints where table_name = 'USERS';

select text from user_views where view_name='empvu20';

select sequence_name,min_value,max_value,increment_by,last_number from user_sequences;
comment on table employees is 'Employee Information';

select * from USER_TAB_COMMENTS;

create trigger NameChange
before update of first_name,last_name on employees
for each row
declare
begin
dbms_output.put_line('Employee names updated');
end;
/

create table audits (
    audit_id NUMBER PRIMARY KEY,
    table_name VARCHAR2(255),
    transaction_name VARCHAR2(10),
    by_user VARCHAR2(30),
    transaction_date DATE
);

create or replace trigger users_audit_trg
after 
update or delete
on  users 
for each row
declare
l_transaction VARCHAR2(10);
begin
l_transaction:=CASE
when updating then 'UPDATE'
when deleting then 'DELETE'
end;
insert into audits(audit_id,table_name,transaction_name,by_user,transaction_date) values(ROLE_ROLE_ID_SEQ3.nextval,'USERS',l_transaction,USER,sysdate);
end;
/
select * from users;
update users set username='qwertyuiop' where user_id=1003;
update users set username='kamalp' where user_id=1003;
delete from users where user_id=1003;
select * from audits;
rollback;

CREATE OR REPLACE PACKAGE personnel AS
  -- get employee's fullname
  FUNCTION get_fullname(n_emp_id NUMBER)
    RETURN VARCHAR2;
  -- get employee's salary
  FUNCTION get_salary(n_emp_id NUMBER)
    RETURN NUMBER;
END personnel;

CREATE OR REPLACE PACKAGE BODY personnel AS
  -- get employee's fullname
  FUNCTION get_fullname(n_emp_id NUMBER) RETURN VARCHAR2 IS
      v_fullname VARCHAR2(46);
  BEGIN
    SELECT first_name || ',' ||  last_name
    INTO v_fullname
    FROM employees
    WHERE employee_id = n_emp_id;
 
    RETURN v_fullname;
 
  EXCEPTION
  WHEN NO_DATA_FOUND THEN
    RETURN NULL;
  WHEN TOO_MANY_ROWS THEN
    RETURN NULL;
  END; -- end get_fullname
 
  -- get salary
  FUNCTION get_salary(n_emp_id NUMBER) RETURN NUMBER IS
    n_salary NUMBER(8,2);
  BEGIN
    SELECT salary
    INTO n_salary
    FROM employees
    WHERE employee_id = n_emp_id;
 
    RETURN n_salary;
 
    EXCEPTION
      WHEN NO_DATA_FOUND THEN
        RETURN NULL;
      WHEN TOO_MANY_ROWS THEN
        RETURN NULL;
  END;
END personnel;

DECLARE
  n_salary NUMBER(8,2);
  v_name   VARCHAR2(46);
  n_emp_id NUMBER := &emp_id;
BEGIN
 
  v_name   := personnel.get_fullname(n_emp_id);
  n_salary := personnel.get_salary(n_emp_id);
 
  IF v_name  IS NOT NULL AND
    n_salary IS NOT NULL
  THEN
    dbms_output.put_line('Employee: ' || v_name);
    dbms_output.put_line('Salary:' || n_salary);
  END IF;
END;
/
insert into author values('Arthur Conan Doyle','Britain');
insert into author values('Scott Fitzgerald','American');
insert into author values('J.K Rowling','Britain');

select * from author;
commit;

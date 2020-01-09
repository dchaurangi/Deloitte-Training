set serveroutput on

DECLARE 
a NUMBER :=4;
BEGIN
    a := a+1;
    if mod(a,2)=0 then
  dbms_output.put_line(a);
  else
  dbms_output.put_line(a+10);
  end if;
END;

/

DECLARE
 i NUMBER:=1;
 BEGIN
 LOOP 
    INSERT INTO T1 VALUES(i,i+1);
    i:=i+1;
    EXIT WHEN i>100;
 END LOOP;
END;
/

DECLARE
 i NUMBER;
 BEGIN
 
 FOR i in 101..200 LOOP
 INSERT INTO T1 VALUES(i,i);
 END LOOP;
END;
/

DECLARE
i NUMBER:=201;
BEGIN

WHILE i<=300 LOOP
INSERT INTO T1 VALUES(i,i);
i:=i+1;
END LOOP;
END;
/

DECLARE 
n_pct employees.commission_pct%TYPE;
v_eval varchar2(10);
n_emp_id employees.employee_id%TYPE := 145;

BEGIN

SELECT commission_pct
INTO n_pct
FROM employees
WHERE employee_id = n_emp_id;

CASE n_pct
    WHEN 0 THEN
    v_eval:='N/A';
    WHEN 0.1 THEN
    v_eval:='Low';
    WHEN 0.4 THEN
    v_eval:='High';
    ELSE
    v_eval:='Fair';
    END CASE;
    
    DBMS_OUTPUT.PUT_LINE('EMPLOYEE '||n_emp_id||' commission is '|| TO_CHAR(n_pct)||' which is '||v_eval);
    
    END;
    /
    
DECLARE
givenName users.name%TYPE:=&name;

BEGIN
dbms_output.put_line('The role of ' || givenName ||' is ' || getRole(givenName));
END;
/

CREATE OR REPLACE FUNCTION getRole(givenName in users.name%TYPE)
RETURN roles.role_name%TYPE IS
roleName roles.role_name%TYPE;
BEGIN
select role_name into roleName from users join roles using (role_id) where users.name=givenName;

RETURN roleName;
END;
/

select * from t1;

INSERT INTO employee_salary values(2,'Hari',15000,4000,1000,5000,15000,20000);
INSERT INTO employee_salary values(1,'Vikram',31000,8000,1000,5000,35000,40000);
INSERT INTO employee_salary values(3,'Vishal',14000,4000,1000,5000,15000,19000);
INSERT INTO employee_salary values(4,'Pawan',14000,4000,1000,5000,15000,19000);
INSERT INTO employee_salary values(5,'Kalyan',13000,4000,1000,5000,15000,18000);

declare
begin
INSERT INTO employee_salary values(6,'Sri',53000,4000,1000,5000,15000,58000);
declare 
ename employee_salary.emp_name%TYPE:='&name';
tax_percent NUMBER:=0;
tax NUMBER:=0;
grossSal employee_salary.gross_salary%TYPE:=0;
BEGIN
select gross_salary into grossSal from employee_salary where emp_name=ename;

case 
when (grossSal>=15000 and grossSal<25000) then
tax_percent:=5;
when (grossSal>=25000 and grossSal<50000) then
tax_percent:=10;
when grossSal>=50000 then
tax_percent:=20;
end case;
tax:=tax_percent*grossSal/100;
dbms_output.put_line('Tax for '|| ename || ' is '||tax);
END;
end;
/


DECLARE
  -- declare a cursor
  CURSOR cur_chief IS
      SELECT u.name,
             r.role_name
      FROM users u
      INNER JOIN roles r ON u.role_id = r.role_id;
 
  r_chief cur_chief%ROWTYPE;
BEGIN
  OPEN cur_chief;
  LOOP
    -- fetch information from cursor into record
    FETCH cur_chief INTO r_chief;
 
    EXIT WHEN cur_chief%NOTFOUND;
 
    -- print department - chief
    DBMS_OUTPUT.PUT_LINE(r_chief.name|| ' - ' ||
                         r_chief.role_name);
  END LOOP;
  -- close cursor cur_chief
  CLOSE cur_chief;
END;
/
delete from t1;


declare 
cursor cur_chief is select a,b from t1 where a<b for update;
r_chief cur_chief%ROWTYPE;
temp t1.a%type;
begin
open cur_chief;
loop
fetch cur_chief into r_chief;
exit when cur_chief%NOTFOUND;
temp:=r_chief.a;
update t1 set a=r_chief.b where b=r_chief.b;
update t1 set b=temp where b=r_chief.b;

end loop;
end;
/
select * from employee_salary;
select * from t1;

declare
cursor cur_chief is select employee_id,first_name,salary,hire_date from employees where hire_date>TO_DATE('31-Dec-2004');
r_chief cur_chief%ROWTYPE;
begin
OPEN cur_chief;
loop
fetch cur_chief into r_chief;
exit when cur_chief%NOTFOUND;
dbms_output.put_line(r_chief.first_name||q'['s]'||' updated salary is '||(r_chief.salary*0.1+r_chief.salary));

end loop;
end;
/

declare
cursor cur_chief is select last_name,first_name,hire_date from employees;
r_chief cur_chief%ROWTYPE;
oldDate employees.hire_date%TYPE:=sysdate;
first_name employees.first_name%TYPE;
last_name employees.last_name%TYPE;
begin
open cur_chief;
loop
fetch cur_chief into r_chief;
exit when cur_chief%NOTFOUND;
if r_chief.hire_date<oldDate 
then
oldDate:=r_chief.hire_date;
first_name:=r_chief.first_name;
last_name:=r_chief.last_name;
end if;
end loop;
dbms_output.put_line(first_name||' '||last_name||' is the oldest employee hired on '||oldDate);
end; 
/

select * from employees;

declare
cursor cur_chief is select * from employees;
r_chief cur_chief%ROWTYPE;
begin
open cur_chief;
loop
fetch cur_chief into r_chief;
exit when cur_chief%NOTFOUND;
 exit when r_chief.employee_id>12;
 dbms_output.put_line(r_chief.first_name||' '||r_chief.last_name);
end loop;
end;
/

DECLARE
  TYPE t_name IS RECORD(
     first_name employees.first_name%TYPE,
     last_name  employees.last_name%TYPE
  );
  r_name   t_name; -- name record
  n_emp_id employees.employee_id%TYPE := 200;
BEGIN
  SELECT first_name,
         last_name
  INTO r_name
  FROM employees
  WHERE employee_id = n_emp_id;
  -- print out the employee's name
  DBMS_OUTPUT.PUT_LINE(r_name.first_name || ',' || r_name.last_name );
END;
/

declare 
cursor cur_chief is select u.name,r.role_name from users u join roles r on u.role_id=r.role_id;
type t_users is record(
user_name users.name%TYPE,
role_name roles.role_name%TYPE
);
r_users t_users;
begin
open cur_chief;
loop
fetch cur_chief into r_users;
exit when cur_chief%NOTFOUND;
dbms_output.put_line(r_users.user_name||' - '||r_users.role_name);
end loop;
end;
/

DECLARE
  TYPE t_name IS RECORD(
    first_name employees.first_name%TYPE,
    last_name employees.last_name%TYPE
  );
  r_name      t_name;
  r_name2     t_name;
  r_name_null t_name;
  n_emp_id employees.employee_id%TYPE := 200;
BEGIN
  -- assign employee's infomation to record
  SELECT first_name,
         last_name
  INTO r_name
  FROM employees
  WHERE employee_id = n_emp_id;
 
  -- assign record to another record
  r_name2 := r_name;
  -- print out the employee's name
  DBMS_OUTPUT.PUT_LINE(r_name2.first_name || ',' || r_name2.last_name);
 
  -- assign record to NULL
  r_name2 := r_name_null; 
 
  -- check NULL for each individual field
  IF r_name2.first_name IS NULL AND
     r_name2.last_name IS NULL THEN
    DBMS_OUTPUT.PUT_LINE('Record r_name2 is NULL');
  END IF;
 
END;
/

declare
type t_emps is record(
emp_name employees.first_name%TYPE,
emp_id employees.employee_id%TYPE,
salary employees.salary%TYPE
);

type t_dept is record(
dept_id departments.department_id%TYPE,
location_id departments.location_id%TYPE
);

type t_comp is record(
r_emps t_emps,
r_dept t_dept,
location_name locations.city%TYPE
);



cursor cur_chief is select e.first_name,e.employee_id,e.salary,e.department_id,c.location_id,c.city  from employees e join (select d.department_id,d.location_id,l.city from departments d join locations l on d.location_id=l.location_id ) c on e.department_id=c.department_id;
r_comp t_comp;
begin
open cur_chief;
loop
fetch cur_chief into r_comp.r_emps.emp_name,r_comp.r_emps.emp_id,r_comp.r_emps.salary,r_comp.r_dept.dept_id,r_comp.r_dept.location_id,r_comp.location_name;
exit when cur_chief%NOTFOUND;
dbms_output.put_line(r_comp.r_emps.emp_name||r_comp.r_emps.emp_id||r_comp.r_emps.salary||r_comp.r_dept.dept_id||r_comp.r_dept.location_id||r_comp.location_name);
end loop;

end;
/

declare
password_too_short EXCEPTION;
PRAGMA exception_init(password_too_short, -20001);
user_password users.password%TYPE:='&password';
u_name users.username%TYPE;
begin
if length(user_password)<8 then
--RAISE password_too_short;
raise_application_error(-20001,'Password is too short');
else
select username into u_name from users where password=user_password;
dbms_output.put_line('Username: '||u_name||' Password: '||user_password);
end if;
exception 
when password_too_short then
dbms_output.put_line('The password is too short');
when too_many_rows then
dbms_output.put_line('The database returns more than one user');
when no_data_found then
dbms_output.put_line('User with password '||user_password||' does not exist');
end;
/

declare
u_name users.name%type;
u_id users.user_id%type:=&UserId;
begin

select name into u_name from users where user_id<=u_id;
dbms_output.put_line('customer name is '||u_name);
exception

when too_many_rows then
dbms_output.put_line('The database returns more than one user');
when no_data_found then
dbms_output.put_line('Customer '||u_id||' does not exist');

end;
/

declare 
salary_too_high exception;
pragma exception_init(salary_too_high,-20003);
l_emp_id employees.salary%TYPE:=&emp_id;
l_salary employees.salary%TYPE:=&salary;
l_max_sal employees.salary%TYPE;
l_min_sal employees.salary%TYPE;
begin
select MAX(salary),MIN(salary) into l_max_sal,l_min_sal from employees group by job_id having job_id=(select job_id from employees where employee_id=l_emp_id);

if l_salary>l_max_sal or l_salary<l_min_sal then
dbms_output.put_line('Given salary is '||l_salary||', max is '||l_max_sal||', min is '||l_min_sal);
raise salary_too_high;
else
update employees set salary=l_salary where employee_id=l_emp_id;
dbms_output.put_line('Salary updated');
end if;
exception
when salary_too_high then
dbms_output.put_line('The salary given is not in the range for the Job ID');

end;
/

select * from employees;
select max(salary),min(salary),job_id from employees group by job_id;

create or replace
procedure hello is
begin
dbms_output.put_line('Hello World');
end;
/

begin
hello();
end;
/
call hello();

create or replace 
procedure dispn(n int) is
begin
dbms_output.put_line(n||' square is : '||n*n);
end;
/
call dispn(4);

declare
n int:=&num;
begin
dispn(n);
end;
/

create or replace
procedure giveDetails(emp_id employees.employee_id%TYPE) is
emp_name employees.first_name%TYPE;
emp_sal employees.salary%TYPE;
begin
select first_name,salary into emp_name,emp_sal from employees where employee_id = emp_id;
dbms_output.put_line(emp_name|| q'['s salary is ]'||emp_sal);
end;
/

declare
emp_id employees.employee_id%TYPE:=&id;
begin
giveDetails(emp_id);
end;
/

create or replace 
procedure sum_ab(a int,b int,c out int) is
begin
c:=a+b;
end;
/

declare
r int;
begin
sum_ab(23,29,r);
dbms_output.put_line('sum is:' || r);
end;
/

create or replace
procedure giveName(emp_id employees.employee_id%TYPE,emp_name out employees.first_name%TYPE) is
begin
select first_name into emp_name from employees where employee_id = emp_id;
end;
/

create or replace
procedure giveSal(emp_name employees.first_name%TYPE,emp_sal out employees.salary%TYPE) is
begin
select salary into emp_sal from employees where first_name = emp_name;
end;
/

declare
emp_name employees.first_name%TYPE:='&name';
emp_sal employees.salary%TYPE;
begin
giveSal(emp_name,emp_sal);
dbms_output.put_line(emp_sal);
end;
/

declare
emp_name employees.first_name%TYPE;
emp_id employees.employee_id%TYPE:=&id;
begin
giveName(emp_id,emp_name);
dbms_output.put_line(emp_name);
end;
/

create or replace
function ADD_TWO(a int,b int) return int is
begin
return (A+B);
end;
/

declare 
begin
dbms_output.put_line(ADD_TWO(2,3));
end;
/

create or replace
function incrementSal(emp_id employees.employee_id%TYPE,x int) return employees.salary%TYPE is
l_sal employees.salary%TYPE;
begin
select salary into l_sal from employees where employee_id=emp_id;
return l_sal+(l_sal*x/100);
end;
/

create or replace
function returnSum return employees.salary%TYPE is
l_sum employees.salary%TYPE;
begin
select SUM(salary) into l_sum from employees;
return l_sum;
end;
/

declare 
begin
dbms_output.put_line(returnSum());
end;
/

declare 
begin
dbms_output.put_line(INCREMENTSAL(182,10));
end;
/

create or replace
procedure giveNumberOfBooks(auth_name author.name%TYPE,books_no out int) is
begin
select count(*) into books_no from book group by author_name having author_name=auth_name ;
end;
/

insert into publisher values('Publisher 1','Hyderabad');
insert into publisher values('Publisher 2','Bangalore');
insert into publisher values('Publisher 3','Chennai');
insert into publisher values('Publisher 4','Mumbai');

delete from publisher;

select * from publisher;

insert into book values(1,'Title1',58,2001,'short stories','Arthur Conan Doyle','Publisher 1');
insert into book values(2,'Title2',45,2020,'short stories','Arthur Conan Doyle','Publisher 2');
insert into book values(3,'Title3',354,2012,'short stories','Arthur Conan Doyle','Publisher 3');
insert into book values(4,'Title4',234,2010,'novellas','Scott Fitzgerald','Publisher 4');
insert into book values(5,'Title5',57,2009,'novellas','Scott Fitzgerald','Publisher 1');
insert into book values(6,'Title6',435,2006,'novels','Scott Fitzgerald','Publisher 2');
insert into book values(7,'Title7',35,2005,'novels','Scott Fitzgerald','Publisher 3');
insert into book values(8,'Title8',123,2001,'poems','J.K Rowling','Publisher 4');
insert into book values(9,'Title9',78,2002,'poems','J.K Rowling','Publisher 1');
insert into book values(10,'Title10',97,2004,'short stories','J.K Rowling','Publisher 2');

select * from book;
commit;




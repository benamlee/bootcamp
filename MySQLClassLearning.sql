-- 22 Aug
SHOW DATABASES;
use sys;
SHOW TABLES;
CREATE TABLE TEACHER(
    ID INTEGER NOT NULL, -- AUTO_INCREMENT
    NAME VARCHAR(20) NOT NULL, -- VARCHAR = String
    AGE NUMERIC(3) NOT NULL, -- NUMERIC(3) means INTEGER
    NATIONALITY VARCHAR(2) NOT NULL, -- HK, CN, US, UK
    MEMBERSHIP VARCHAR(1) NOT NULL -- S, G
);
-- Select Data from Table, * means all columns
SELECT * FROM TEACHER;
select id, name, age from TEACHER;
-- Insert records
Insert into teacher (id, name, age, nationality, membership) values (1, 'John Lau', 23, 'HK', 'G');
Insert into teacher values (2, 'Mary Lau', 27, 'CN', 'G'); -- 齊可以唔寫前面
-- Default 寫了not null

CREATE TABLE STAFF (
	ID INTEGER NOT NULL, -- NUMERIC(4) equals NUMERIC(4,0)
	NAME VARCHAR(20) NOT NULL,
	SALARY NUMERIC(10,2) -- Nullable, 8 digits goes to Integer, 2 belongs to decimal
);
-- All column alias
Delete from staff; -- Delete
insert into staff (id, name, salary) values (1, 'John Lau', 1001000.23);
insert into staff values (2, 'Mary Lau', null);
insert into staff (name, id, salary) values ('Eric Lee', 4, 1001000.23); -- not friendly, no need to be in order(id-name/input)
insert into staff (id, name) values (3, 'Peter Chu');
insert into staff values (5, 'John Lau', 20000.00);
select * from staff;

-- Update
update staff set salary = salary + 1000;
-- select data by criteria
select * from staff where id = 1;
select * from staff where id = 2;
select * from staff where name = 'John Lau';
select * from staff where name = 'John Lau' and salary < 50000;
select id from staff where name = 'John Lau' and salary < 50000;
select * from staff where name = 'John Lau' or name = 'Mary Lau';
select * from staff where name in ('John Lau', 'Mary Lau'); -- or
select * from staff where salary > 1;
select * from staff where salary is null; 
select id, name as fullname, salary from staff;
-- Update by criteria
update staff set salary = salary + 1000 where id = 4;
-- 分行寫更readable
update staff
set salary = salary + 10,
name = 'Mary Chan'
where name = 'Mary Lau';
-- Delete by criteria
delete from staff where id = 5;
delete from staff where id in (1, 2);
-- Order by (sorting)
insert into staff values (10, 'ABC', 100000);
insert into staff values (11, 'DEF', 34567);
insert into staff values (12, 'IJK', 2000);
select * from staff order by salary; -- default ascending order
select * from staff order by salary asc; -- same as the above
select * from staff order by salary desc; -- descending order
insert into staff values (13, 'BCD', 100000);
insert into staff values (14, 'EFG', 100000);
select * from staff order by salary asc, name desc; -- sort salary asc first, then name desc

-- Sub-query
select max(salary) from staff;
select id from staff where salary = (select max(salary) from staff);
select id from staff where salary = (select min(salary) from staff);

-- Function
select avg(salary) as AVERAGE_SALARY from staff;
select upper(name) as UPPER_CASE_NAME from staff;
select lower(name) as LOWER_CASE_NAME from staff;
insert into staff values (13, 'PETER CHU', 22000);
insert into staff values (14, 'peter chu', 21000);
select * from staff where upper(name) = 'PETER CHU';

-- Like
select * from staff where upper(name) like '% CHU'; -- % means any character
select * from staff where upper(name) like '%TER%'; -- % means any character
select * from staff where upper(name) like '%TER%' OR name = 'BCD';
select * from staff where name like 'pete%c%u'; -- "like" use with "%"
select * from staff where upper(name) like '_e%c_u'; -- "_" means exactly the position of character missing
-- MySQL "like" 大細楷都搵哂

-- count()
select * from staff;
select 1 from staff;
select count(*) from staff; -- data 數量
select count(1) from staff; -- 會快D
select count(DISTINCT name) from staff where salary > 30000;

-- group by
select upper(name) as NAME,
sum(salary) as TOTAL_SALARY, -- "salary" column is not allowed
avg(salary) as AVG_SALARY,
max(salary) as MAX_SALARY,
min(salary) as MIN_SALARY
from staff
group by upper(name); -- 轉哂大楷

select name as name
from staff
group by name; -- 保持原本大細楷，都有group同字母

-- String Operation
select * from staff where instr(name, 'chu') > 0;
select * from staff where length(name) > 10;
select substring(name, 2 ,4) from staff;
select length(trim(' testing something ')) from dual;
select ltrim(' testing something ') from dual;
select concat(rtrim(' testing something '), 'ABC') from dual; -- dual = 1 x 1 table
select replace('I love Java', 'Java', 'Python') from dual;

select name, max(salary), count(name)
from staff
where substring(name, 1, 1) in ('P', 'E') -- 1st filter, before group by
group by name having count(name) > 2; -- 2nd filter, after group by

select name, max(salary), count(name)
from staff
where substring(name, 1, 1) in ('P', 'E')
group by name having max(salary) > 100000;

insert into staff values (20, 'Eric Cheung', 200);
insert into staff values (20, 'Eric Cheung', 200000);

select name, min(salary), count(name) -- 3rd 回傳當中min salary
from staff
where substring(name, 1, 1) in ('P', 'E') -- 1st P/E 開頭
group by name having max(salary) > 100000; -- 2nd 在一組同名人，當中有人>100000

-- select name, distinct salary from staff group by name;

select distinct name, salary from staff; -- 2 fields both same, then remove

-- DECLARE
-- 	AGE VARCHAR(3) = 13;
-- 	CURSOR C_STUDENTS
--     IS
-- 		SELECT * 
--         FROM STUDENTS
--         ;
-- BEGIN
-- 	IF AGE > 10 THEN
-- 		AGE = 100;
-- 	ELSE
-- 		SGE = 120;
-- 	END;
--     
--     FOR (STU IN C_STUDENTS) LOOP
-- 		AGE = STU.AGE;
-- 	END LOOP;
-- END;

-- 23 Aug
DROP TABLE CUSTOMERS; -- DELETE existing table
CREATE TABLE CUSTOMERS (
	ID INTEGER NOT NULL,
    NAME VARCHAR(50) NOT NULL,
    EMAIL VARCHAR(50),
    VIP VARCHAR(1) NOT NULL
    -- ORDERS_ID INTEGER NOT NULL -- OPTION 2
);

-- ONT TO MANY (ONE CUSTOMER MAY HAVE MANY ORDERS)
DROP TABLE ORDERS;
CREATE TABLE ORDERS (
	ID INTEGER NOT NULL,
    AMOUNT NUMERIC(9,2) NOT NULL,
    CUSTOMER_ID INTEGER NOT NULL -- OPTION 1
);

DROP TABLE ITEMS;
CREATE TABLE ITEMS (
	ID INTEGER NOT NULL,
    AMOUNT NUMERIC(9,2) NOT NULL,
    DESCRIPTION VARCHAR(100) NOT NULL,
    ORDER_ID INTEGER NOT NULL
);


DELETE FROM CUSTOMERS;
INSERT INTO CUSTOMERS VALUES (1, 'JOHN', 'JOHN@GMAIL.COM', 'Y');
INSERT INTO CUSTOMERS VALUES (2, 'MARY', 'MARY@GMAIL.COM', 'N');
INSERT INTO CUSTOMERS VALUES (3, 'ERIC', 'ERIC@GMAIL.COM', 'Y');

DELETE FROM ORDERS;
INSERT INTO ORDERS VALUES (1, 100.23, 1);
INSERT INTO ORDERS VALUES (2, 2000, 1);
INSERT INTO ORDERS VALUES (3, 1550, 2);
INSERT INTO ORDERS VALUES (4, 120, 2);
INSERT INTO ORDERS VALUES (5, 550, 2);

-- ONE TO MANY (ONE ORDER MAY HAVE MANY ITEMS)
DELETE FROM ITEMS;
INSERT INTO ITEMS VALUES (1, 100.23, 'APPLE', 1);
INSERT INTO ITEMS VALUES (2, 1500, 'IPHONE', 2);
INSERT INTO ITEMS VALUES (3, 500, 'IPAD', 2);
INSERT INTO ITEMS VALUES (4, 1550, 'ORANGE', 3);
INSERT INTO ITEMS VALUES (5, 120, 'LEMON', 4);
INSERT INTO ITEMS VALUES (6, 500, 'BOOK', 5);
INSERT INTO ITEMS VALUES (7, 50, 'BOTTLE', 5);

SELECT * FROM CUSTOMERS;
SELECT * FROM ORDERS;

-- JOIN TABLE, INNER JOIN
SELECT O.ID AS ORDER_ID, O.AMOUNT AS ORDER_AMOUNT, O.CUSTOMER_ID, C.NAME AS CUSTOMER_NAME
FROM CUSTOMERS C INNER JOIN ORDERS O ON C.ID = O.CUSTOMER_ID -- INTERSECT BY KEY "ON STATEMENT"
WHERE C.ID = 2
;

-- JOIN use ON
SELECT O.CUSTOMER_ID,
C.NAME AS CUSTOMER_NAME,
O.ID AS ORDER_ID,
O.AMOUNT AS ORDER_AMOUNT,
I.DESCRIPTION AS ITEM_DESC,
I.AMOUNT AS ITEM_PRICE
FROM CUSTOMERS C
INNER JOIN ORDERS O ON C.ID = O.CUSTOMER_ID -- 先將O同C相連
INNER JOIN ITEMS I ON I.ORDER_ID = O.ID -- 再將I同O相連
;
-- APPROACH 2: INNER JOIN
SELECT O.CUSTOMER_ID,
C.NAME AS CUSTOMER_NAME,
O.ID AS ORDER_ID,
O.AMOUNT AS ORDER_AMOUNT,
I.DESCRIPTION AS ITEM_DESC,
I.AMOUNT AS ITEM_PRICE
FROM CUSTOMERS C, ORDERS O, ITEMS I -- 呢行做改名
WHERE C.ID = O.CUSTOMER_ID
AND I.ORDER_ID = O.ID
;

-- LEFT JOIN
SELECT C.ID,
C.NAME AS CUSTOMER_NAME,
O.ID AS ORDER_ID,
O.AMOUNT AS ORDER_AMOUNT
-- I.DESCRIPTION AS ITEM_DESC,
-- I.AMOUNT AS ITEM_PRICE
FROM CUSTOMERS C LEFT JOIN ORDERS O -- 以C為依歸
ON C.ID = O.CUSTOMER_ID
-- AND I.ORDER_ID = O.ID
;

-- 24 Aug
START TRANSACTION;
select * from CUSTOMERS;
INSERT INTO CUSTOMERS VALUES (1, 'ABC', 'BCD@GMAIL.COM', 'Y');
rollback;
commit;

-- Primary Key
CREATE TABLE STUDENTS (
	ID INTEGER AUTO_INCREMENT,
    NAME VARCHAR(50),
    AGE NUMERIC(3),
    -- SUBJECT_ID -- 如果咁寫即係一個stu只讀一科
    PRIMARY KEY(ID)
);
INSERT INTO STUDENTS (NAME, AGE) VALUES ('JOHN', 23);
INSERT INTO STUDENTS (NAME, AGE) VALUES ('MARY', 18);
SELECT * FROM STUDENTS;

CREATE TABLE SUBJECTS (
	ID INTEGER AUTO_INCREMENT,
    NAME VARCHAR(50),
    PRIMARY KEY(ID)
);

INSERT INTO SUBJECTS (NAME) VALUES ('ENGLISH');
INSERT INTO SUBJECTS (NAME) VALUES ('HSITORY');
INSERT INTO SUBJECTS (NAME) VALUES ('MATHS');
SELECT * FROM SUBJECTS;

-- DDL
CREATE TABLE STUDENT_SUBJECTS (
	ID INTEGER AUTO_INCREMENT,
    STUDENT_ID INTEGER NOT NULL,
    SUBJECT_ID INTEGER NOT NULL,
    PRIMARY KEY(ID),
    FOREIGN KEY(STUDENT_ID) REFERENCES STUDENTS(ID), -- MUST EXIST IN STUDENTS TABLE
    FOREIGN KEY(SUBJECT_ID) REFERENCES SUBJECTS(ID) -- MUST EXIST IN SUBJECTS TABLE
);

-- DML
INSERT INTO STUDENT_SUBJECTS (STUDENT_ID, SUBJECT_ID) VALUES (1, 2);
INSERT INTO STUDENT_SUBJECTS (STUDENT_ID, SUBJECT_ID) VALUES (1, 3);
INSERT INTO STUDENT_SUBJECTS (STUDENT_ID, SUBJECT_ID) VALUES (2, 2);
-- INSERT INTO STUDENT_SUBJECTS (STUDENT_ID, SUBJECT_ID) VALUES (2, 4); -- ERROR, FOREIGN KEY CONSTRAINT FAILS
SELECT * FROM STUDENT_SUBJECTS;

-- TRUNCATE (DELETE ALL DATA FROM TABLE)
TRUNCATE TABLE STUDENT_SUBJECTS;
SELECT * FROM STUDENT_SUBJECTS;

-- ALTER ADD/ DROP COLUMN (DDL)
ALTER TABLE STUDENTS ADD EMAIL VARCHAR(50); -- DEFAULT NULL VALUE TO EXISTING RECORDS
ALTER TABLE STUDENTS DROP EMAIL;
SELECT * FROM STUDENTS;

-- ALTER COLUMN DEFINITION
ALTER TABLE STUDENTS MODIFY EMAIL VARCHAR(60);
ALTER TABLE STUDENTS MODIFY EMAIL VARCHAR(55); -- ERROR IF DATA LENGTH EXCEED THE NEW COLUMN LENGTH

-- ON DELETE CASCADE
DROP TABLE DEPARTMENT;
CREATE TABLE DEPARTMENT (
	ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    DEPT_NAME VARCHAR(50) NOT NULL
);
SELECT * FROM DEPARTMENT;
INSERT INTO DEPARTMENT (DEPT_NAME) VALUES ('CS');
INSERT INTO DEPARTMENT (DEPT_NAME) VALUES ('MARKETING');

-- ONE TO MANY
DROP TABLE COURSE;
CREATE TABLE COURSE (
	ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    COURSE_NAME VARCHAR(50) NOT NULL,
    COURSE_CODE VARCHAR(5) NOT NULL,
    DEPT_ID INTEGER,
    -- FOREIGN KEY(DEPT_ID) REFERENCES DEPARTMENT(ID) ON DELETE CASCADE -- delete parent => delete child
    FOREIGN KEY(DEPT_ID) REFERENCES DEPARTMENT(ID) ON DELETE SET NULL -- delete parent => keep child set null
); 
SELECT * FROM COURSE;

INSERT INTO COURSE (COURSE_NAME, COURSE_CODE, DEPT_ID) VALUES ('JAVA', 'CS001', 1);
INSERT INTO COURSE (COURSE_NAME, COURSE_CODE, DEPT_ID) VALUES ('THEORY', 'MT001', 2);
-- INSERT INTO COURSE (COURSE_NAME, COURSE_CODE, DEPT_ID) VALUES ('THEORY', 'MT001', 3);

-- DELETE PARENT (DEPARTMENT)
DELETE FROM DEPARTMENT WHERE ID = 2; -- SUCCESS
-- ON DELETE CASCADE 在course，delete parent will delete child，但自動不是好事
-- 因為code reviewer 會睇死，不知道同時delete了什麼
-- 所以最好不寫ON DELETE CASCADE，然後逐個delete child，再delete parent

-- ALTER TABLE COURSE RENAME COLUMN COURSE_NAME TO NAME;
-- 不應該轉column名，因為一個table好多人用

ALTER TABLE COURSE ADD COLUMN START_DATE DATE DEFAULT NULL;
ALTER TABLE COURSE ADD COLUMN END_DATE DATE DEFAULT '1900-01-01';

-- MODIFY AND DEFAULT
INSERT INTO COURSE VALUES (3, 'PYTHON', 'CS002', 1, NULL, NULL);
ALTER TABLE COURSE MODIFY COLUMN END_DATE DATETIME DEFAULT '1900-01-01 00:00:00'; -- all non-null value will modify

-- LIMIT (ORDER BY)
SELECT * FROM COURSE ORDER BY ID LIMIT 2; -- 出first 2

-- OFFSET
SELECT * FROM COURSE ORDER BY ID LIMIT 2 OFFSET 1; -- SLIP 1 ROW , 出 2,3

-- EXISTS/ NOT EXISTS
INSERT INTO DEPARTMENT (DEPT_NAME) VALUES ('ENG');
INSERT INTO DEPARTMENT (DEPT_NAME) VALUES ('CVIL');

SELECT D.* -- CANNOT SELECT C.FIELD
FROM DEPARTMENT D
WHERE NOT EXISTS ( -- CHECK IF D.ID EXISTS IN COURSE'S DEPT_ID (CHECK ALL ROWS)
	SELECT 1
    FROM COURSE C
    WHERE C.DEPT_ID = D.ID -- KEY
-- ) AND NOT EXISTS (
-- 	SELECT ...
-- ) AND EXISTS (
-- 	SELECT ...
);

-- 25 Aug
-- selftry
drop table issuers;
CREATE TABLE ISSUERS (
	ISSUER_NAME varchar(2),
    Tight varchar(1),
    Ratio varchar(1)
);
INSERT INTO ISSUERS VALUES ('BI','Y','N');
INSERT INTO ISSUERS VALUES ('BP','N','Y');
INSERT INTO ISSUERS VALUES ('CS','Y','Y');
INSERT INTO ISSUERS VALUES ('CT','Y','Y');
INSERT INTO ISSUERS VALUES ('DS','Y','N');
INSERT INTO ISSUERS VALUES ('GS','Y','N');
INSERT INTO ISSUERS VALUES ('HS','Y','Y');
INSERT INTO ISSUERS VALUES ('HT','N','N');
INSERT INTO ISSUERS VALUES ('JP','N','Y');
INSERT INTO ISSUERS VALUES ('MB','N','N');
INSERT INTO ISSUERS VALUES ('SG','N','Y');
INSERT INTO ISSUERS VALUES ('UB','N','Y');
INSERT INTO ISSUERS VALUES ('VT','Y','N');
SELECT * FROM ISSUERS;

drop table products;
create table PRODUCTS (
	PRODUCT_NO integer(5),
    ISSUER VARCHAR(2),
    一手 integer
);
insert into products values(19804,'ct',50);
insert into products values(20873,'bi',10);
insert into products values(17984,'bi',100);
insert into products values(20531,'vt',20);
insert into products values(57981,'bi',25);
insert into products values(66422,'BP',5);
insert into products values(60500,'bi',1);
insert into products values(21421,'CS',10);
insert into products values(23758,'HS',100);
insert into products values(20942,'HS',20);
insert into products values(12371,'bi',50);
insert into products values(22559,'ZZ',50);
select * from products, issuers where issuer=issuer_name;
select * from products inner join issuers on issuer=issuer_name;
select * from issuers inner join products on issuer=issuer_name;
select * from products left join issuers on issuer=issuer_name; -- show all products with issuers information, if no => null
select * from issuers left join products on issuer=issuer_name; -- show all issuers with products, here each product has a row


-- class
select * from department;

with 
	cs001 as (
		select *
        from course
        where course_code = 'CS001'
    ),
    cs002 as (
		select *
        from course
        where course_code = 'CS002'
    )
select *
from cs002;

-- 28 Aug
select * from orders
union all
select * from orders
union all
select 1000, 10000, 2 from dual
;
-- UNION
select * from orders
union -- no all -> remove duplicates
select * from orders
;

INSERT INTO ORDERS VALUES (5, 550, 2);

select * from orders
union -- 5
select * from orders
UNION ALL -- 5 + 6 = 11
select * from orders
;

DROP VIEW VCUSTOMER_ORDERS;
CREATE VIEW VCUSTOMER_ORDERS -- VIEW DONT ALLOW INSERT/ DELETE
AS
SELECT C.ID, C.NAME, O.AMOUNT
from CUSTOMERS C, ORDERS O
WHERE C.ID = O.CUSTOMER_ID
;

SELECT * FROM VCUSTOMER_ORDERS;




DROP PROCEDURE INSERT_RESULT;
-- PROCEDURE INSERT_RESULT
DELIMITER //

CREATE PROCEDURE INSERT_RESULT()

BEGIN	
	DECLARE RES_AVG_AMT DECIMAL(10,2);
    DECLARE cust_id INT;

    DECLARE customer_cursor CURSOR FOR
			SELECT C.ID
			FROM customers c
            ;

    OPEN customer_cursor;
	LOOP     -- Loop through departments
    FETCH customer_cursor INTO cust_id;
		-- logic
		CALL CALC_AVG_AMOUNT(cust_id, RES_AVG_AMT);
        -- INESRT TO RESULT TABLE
        INSERT INTO CUSTOMER_ORDER_REPORT (CUSTOMER_ID, ORDER_AVG_AMT)
        VALUES (cust_id, RES_AVG_AMT);
	END LOOP;
    CLOSE customer_cursor;
END;
//
DELIMITER ;


DROP PROCEDURE CALC_AVG_AMOUNT;
-- CREATE PROCEDURE CALC_AVG_AMOUNT
DELIMITER //

CREATE PROCEDURE CALC_AVG_AMOUNT(IN CID INTEGER, OUT AVG_AMT DECIMAL(10,2))

BEGIN	
		DECLARE cust_id INT;
        DECLARE avg_amount DECIMAL(10,2);

		DECLARE calc_cursor CURSOR FOR
			SELECT o.customer_id, (SUM(o.amount) / count(1)) as avg_order_amt
			FROM customers c, orders o
            where c.id = o.customer_id
            and c.id = CID
            group by o.customer_id
            ;

		OPEN calc_cursor;
		calc_cursor: LOOP     -- Loop through departments
        FETCH calc_cursor INTO cust_id, avg_amount;
		END LOOP;
        CLOSE calc_cursor;

		SET AVG_AMT = avg_amount;
END;
//
DELIMITER ;

ALTER TABLE CUSTOMERS ADD ORDER_COUNT INT;

DELIMITER //
-- TABLE TRIGGER
CREATE TRIGGER TRIGGER_COUNT_ORDER
AFTER INSERT ON ORDERS
FOR EACH ROW
BEGIN
	UPDATE CUSTOMERS
    SET ORDER_COUNT = coalesce(ORDER_COUNT, 0) + 1
    WHERE ID = NEW.CUSTOMER_ID; -- ORDER
    -- NEW.AMOUNT, NEW.ID
END;
//
DELIMITER ;

SELECT * FROM ORDERS;
SELECT * FROM CUSTOMERS;
INSERT INTO ORDERS VALUES (6,1000,2);
INSERT INTO ORDERS VALUES (7,1000,2);
INSERT INTO ORDERS VALUES (8,1000,2);
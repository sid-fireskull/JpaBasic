INSERT INTO Course(id, name, created_date, updated_date) VALUES (10001, 'Spring Boot', sysdate(), sysdate());
INSERT INTO Course(id, name, created_date, updated_date) VALUES (10002, 'Java', sysdate(), sysdate());
INSERT INTO Course(id, name, created_date, updated_date) VALUES (10003, 'Javascript', sysdate(), sysdate());
INSERT INTO Course(id, name, created_date, updated_date) VALUES (10004, 'Python', sysdate(), sysdate());
INSERT INTO Course(id, name, created_date, updated_date) VALUES (10005, 'C++', sysdate(), sysdate());

INSERT INTO Passport (id, number) VALUES(101, 'P123456'),(102, 'P987654'), (103, 'P955654');

INSERT INTO Student (id, name, passport_id) VALUES(1001, 'Alice Smith', 101),(1002, 'Bob Johnson', 102),(1003, 'Emily Brown', 103);

INSERT INTO Review (id, rating, description, course_id) VALUES(201, 4, 'Excellent experience!', 10001),(202, 3, 'Average experience', 10003);

INSERT INTO STUDENT_COURSE(student_id, course_id) VALUES(1001, 10001),(1001, 10002), (1002, 10001), (1002, 10005), (1002, 10002), (1003, 10003);
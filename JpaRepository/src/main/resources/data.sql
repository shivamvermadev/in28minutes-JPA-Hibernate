insert into passport(id, number, created_at, updated_at) 
	values (4001, 'A12345', sysdate(), sysdate());
insert into passport(id, number, created_at, updated_at) 
	values (4002, 'B98765', sysdate(), sysdate());
insert into passport(id, number, created_at, updated_at) 
	values (4003, 'C10065', sysdate(), sysdate());
	
insert into student(id, name, created_at, updated_at, passport_id) 
	values (2001, 'Ranga', sysdate(), sysdate(), 4001);
insert into student(id, name, created_at, updated_at, passport_id) 
	values (2002, 'Adam', sysdate(), sysdate(), 4002);
insert into student(id, name, created_at, updated_at, passport_id) 
	values (2003, 'Jane', sysdate(), sysdate(), 4003);
	
insert into course(id, name, created_at, updated_at) 
	values (1001, 'Learn spring hibernate-jpa', sysdate(), sysdate());
insert into course(id, name, created_at, updated_at) 
	values (1002, 'Learn spring-boot', sysdate(), sysdate());
	
	
insert into review(id, rating, description, created_at, updated_at) 
	values (5001, '4', 'good course', sysdate(), sysdate());
insert into review(id, rating, description, created_at, updated_at) 
	values (5002, '5', 'ok course', sysdate(), sysdate());
insert into review(id, rating, description, created_at, updated_at) 
	values (5003, '4', 'not okay course',  sysdate(), sysdate());

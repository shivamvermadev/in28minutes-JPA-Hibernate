create table person(id integer not null, 
					name varchar(255), location varchar(255),
					birth_date timestamp, primary key(id));
					
insert into person (id, name, location, birth_date) values(1001, 'shivam', 'sre', sysdate());
insert into person (id, name, location, birth_date) values(1002, 'verma', 'sre', sysdate());
insert into person (id, name, location, birth_date) values(1003, 'dev', 'chd', sysdate());
insert into person (id, name, location, birth_date) values(1004, 'jatin', 'hisar', sysdate());
insert into person (id, name, location, birth_date) values(1005, 'gaurav', 'delhi', sysdate());
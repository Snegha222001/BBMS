insert into ROLES(role_id,role_name) values(1,'ADMIN');
insert into ROLES(role_id,role_name) values(2,'USER');

insert into USERS(username,password) values ('admin1','pass');
insert into USERS(username,password) values ('user1','userpass');

insert into user_role(user_id,role_id) values (1,1);
insert into user_role(user_id,role_id) values (2,2);

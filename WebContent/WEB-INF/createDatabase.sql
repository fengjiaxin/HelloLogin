drop database if exists example;
create database example;
use example;
create table t_user(
id int(10) primary key auto_increment,
name varchar(30) not null,
password varchar(30) not null
);
insert into t_user values(null,'lin','1234');
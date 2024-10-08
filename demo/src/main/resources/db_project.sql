create database db_project;
use db_project;

create table if not exists account(
	id int auto_increment primary key,
    username varchar(64) not null,
    password varchar(100) not null,
    role varchar(64) not null
);

create table if not exists user(
	account_id int,
    name varchar(64),
    adress varchar(200),
    age int unsigned,
    phone_number varchar(45),
    categories varchar(600),
    authors varchar(600),
    foreign key(account_id) references account(id) on delete cascade
);

create table if not exists offer(
	id int auto_increment primary key,
    account_id int,
    title varchar(64) not null,
    authors varchar(600) not null,
    category varchar(64) not null,
    summary varchar(600) not null,
    foreign key (account_id) references account(id) on delete cascade
);

create table if not exists request(
	id int auto_increment primary key,
	account_id int,
	offer_id int,
    foreign key (account_id) references account(id) on delete cascade,
    foreign key (offer_id) references offer(id) on delete cascade
);
use db_project;

create table if not exists account(
	id int unsigned auto_increment primary key,
    username varchar(64) not null,
    passwd varchar(64) not null,
    role varchar(64) not null,
    enabled boolean not null
);

create table if not exists user(
	accountId int unsigned,
    name varchar(64) not null,
    address varchar(600) not null,
    age int unsigned not null,
    phoneNumber varchar(45) not null,
    categories varchar(600) not null,
    authors varchar(600) not null,
    foreign key(accountId) references account(id) on delete cascade
);

create table if not exists book(
	id int unsigned auto_increment primary key,
    title varchar(64) not null,
    authors varchar(600) not null,
    category varchar(64) not null,
    summary varchar(600) not null
);

create table if not exists listing(
	id int unsigned auto_increment primary key,
    accountId int unsigned not null,
    bookId int unsigned not null,
    foreign key (accountId) references account(id) on delete cascade,
    foreign key (bookId) references book(id) on delete cascade
);

create table if not exists request(
	id int unsigned auto_increment primary key,
	accountId int unsigned not null,
	bookId int unsigned not null,
    foreign key (accountId) references account(id) on delete cascade,
    foreign key (bookId) references book(id) on delete cascade
);
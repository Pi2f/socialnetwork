create table STORY(
  id int identity ,
  content varchar(144)
);

create table users(
    username varchar_ignorecase(50) not null primary key,
    password varchar_ignorecase(250) not null,
    enabled boolean not null);

create table authorities (
    username varchar_ignorecase(50) not null,
    authority varchar_ignorecase(50) not null,
    constraint fk_authorities_users foreign key(username) references users(username));

create unique index ix_auth_username on authorities (username,authority);

insert into users values('zeros','$2a$10$3aBy44tPHGvATx6kYC9aZOuDH1j7pwRC.Up9O5yh0Gvyg9ayyBmWK',true);
insert into authorities values('zeros','ADMIN');

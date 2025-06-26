-- -------------------------------------------------
-- ** MY SITE 데이터베이스
-- -------------------------------------------------


-- #유저 테이블 만들기
create table users(
	no       			int 					primary key      auto_increment,
    id	 				varchar(20)		unique       		not null,
   password 		varchar(20),
   name 			varchar(20),
   gender   		varchar(10)
);


select *
from users;

insert into users
values(null,'aqwqw','111','최','w'); 
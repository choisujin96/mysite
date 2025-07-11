-- -------------------------------------------------
-- ** MY SITE 데이터베이스
-- -------------------------------------------------


-- #유저 테이블 만들기
create table users(
	no       			int 					primary key      auto_increment,
    id	 				varchar(20)		unique       		not null,
   password 		varchar(20)       not null,
   name 			varchar(20),
   gender   		varchar(10)   -- male,female
);


-- #게스트북 테이블 만들기

create table guestbook(
	no        int    primary key  auto_increment,
    name   varchar(80),
    password  varchar(20),
    content  text,
    reg_date  datetime
);


-- 테이블삭제
drop table users;

select 	no,
			id,
            password,
            name,
            gender
from users;


insert into users
values(null,'aqwqw','111','최','w'); 

-- 로그인(세션)
select   id,
            password
from users
where id = ''
and password = ''
; 

-- 회원정보 수정폼
select 	no,
			id,
            password,
            name,
            gender
from users
where no = 5
;


-- 회원정보 수정
update users
set  name = '최수진',
       password = '123',
       gender = 'female'
where no= 5
;


select *
from users;


select	no,
			id,
            name,
            gender
from users
where id = 'aaa'
;
/*
1이면 이미 사용중인 아이디
0이면 사용가능한 아이디
*/

-- -------------------------------------------------
-- **게시판
-- -------------------------------------------------


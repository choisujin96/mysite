-- -------------------------------------------------
-- ** MY SITE 데이터베이스
-- -------------------------------------------------
-- web_db 사용
use web_db;

-- 테이블 목록 조회
show tables;

-- 테이블 삭제
drop table gallery;

-- 갤러리 테이블 생성
create table gallery(
	no       			int 					primary key      auto_increment,
    user_no		int ,
    content			varchar(1000),
    filepath  		varchar(500) ,
    orgName  	 	varchar(200),
    saveName 	varchar(500),
    fileSize 			int ,
 constraint gallery_fk foreign key(user_no) 
 references users (no)
);



-- -------------------------------------------------
-- ** MY SITE 데이터베이스
-- -------------------------------------------------

create table galllery(
	no       			int 					primary key      auto_increment,
    userno			int		forign key,
    content     varchar(1000),
    filepath  	varchar(500) ,
 orgName   varchar(200),
 saveName varchar(500),
 fileSize int
 constraint book_fk foreign key(author_id) 
     references author(author_id)
);

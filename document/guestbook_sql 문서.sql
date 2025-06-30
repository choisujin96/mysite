-- -------------------------------------------------
-- **web 계정에서 사용 - guestbook
-- -------------------------------------------------


create table guestbook(
	no       		 int 				 primary key      auto_increment,
	name        varchar(20),
    password	 varchar(20)	 not null,
	content 	 varchar(100),
	reg_date   datetime  		not null
    );
    
    
    select *
    from guestbook;
    
    insert into guestbook
    values(null, '서민정','111','안녕 얘드라~~~*^^*', now())
    ;

    insert into guestbook
    values(null, '이민용','111','안녕안녕', now())
    ;
    
	select	no,
				name,
                password,
                content,
                date_format(reg_date, "%Y-%m-%d") regDate 
    from guestbook;
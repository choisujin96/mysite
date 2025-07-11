-- -------------------------------------------------
-- **web 계정에서 사용 - guestbook
-- -------------------------------------------------
drop table guestbook;

create table guestbook(
	no       		 int 				 primary key      auto_increment,
	name        varchar(20),
    password	 varchar(20)	 not null,
	content 	 varchar(100),
	reg_date   datetime  		not null
    );
    
    
    select *
    from guestbook;
    
    
	select	no,
				name,
                password,
                content,
                date_format(reg_date, "%Y-%m-%d") regDate 
    from guestbook
    where no = 20;
    
    
    
select count(*) count
from guestbook;
    
    
    -- 방명록 등록(페이징용)
    insert into guestbook values(null, '서민정','111','안녕 얘드라~~~*^^*', now());
    insert into guestbook values(null, '이민용','222','안녕안녕', now());
	insert into guestbook values(null, '정윤호','333','부릉부릉', now());
    insert into guestbook values(null, '이효리','444','후후후ㅜㅎ', now());
    insert into guestbook values(null, '최수진','555','반사오삼', now());
    insert into guestbook values(null, '노재원','666','민쑤!', now());
    insert into guestbook values(null, '서민정','111','안녕 얘드라~~~*^^*', now());
    insert into guestbook values(null, '이민용','222','안녕안녕', now());
	insert into guestbook values(null, '정윤호','333','부릉부릉', now());
    insert into guestbook values(null, '이효리','444','후후후ㅜㅎ', now());
    insert into guestbook values(null, '최수진','555','반사오삼', now());
    insert into guestbook values(null, '노재원','666','민쑤!', now());
    insert into guestbook values(null, '서민정','111','안녕 얘드라~~~*^^*', now());
    insert into guestbook values(null, '이민용','222','안녕안녕', now());
	insert into guestbook values(null, '정윤호','333','부릉부릉', now());
    insert into guestbook values(null, '이효리','444','후후후ㅜㅎ', now());
    insert into guestbook values(null, '최수진','555','반사오삼', now());
    insert into guestbook values(null, '노재원','666','민쑤!', now());
    insert into guestbook values(null, '서민정','111','안녕 얘드라~~~*^^*', now());
    insert into guestbook values(null, '이민용','222','안녕안녕', now());
	insert into guestbook values(null, '정윤호','333','부릉부릉', now());
    insert into guestbook values(null, '이효리','444','후후후ㅜㅎ', now());
    insert into guestbook values(null, '최수진','555','반사오삼', now());
    insert into guestbook values(null, '노재원','666','민쑤!', now());
    insert into guestbook values(null, '서민정','111','안녕 얘드라~~~*^^*', now());
    insert into guestbook values(null, '이민용','222','안녕안녕', now());
	insert into guestbook values(null, '정윤호','333','부릉부릉', now());
    insert into guestbook values(null, '이효리','444','후후후ㅜㅎ', now());
    insert into guestbook values(null, '최수진','555','반사오삼', now());
    insert into guestbook values(null, '노재원','666','민쑤!', now());
    insert into guestbook values(null, '서민정','111','안녕 얘드라~~~*^^*', now());
    insert into guestbook values(null, '이민용','222','안녕안녕', now());
	insert into guestbook values(null, '정윤호','333','부릉부릉', now());
    insert into guestbook values(null, '이효리','444','후후후ㅜㅎ', now());
    insert into guestbook values(null, '최수진','555','반사오삼', now());
    insert into guestbook values(null, '노재원','666','민쑤!', now());
    insert into guestbook values(null, '서민정','111','안녕 얘드라~~~*^^*', now());
    insert into guestbook values(null, '이민용','222','안녕안녕', now());
	insert into guestbook values(null, '정윤호','333','부릉부릉', now());
    insert into guestbook values(null, '이효리','444','후후후ㅜㅎ', now());
    insert into guestbook values(null, '최수진','555','반사오삼', now());
    insert into guestbook values(null, '노재원','666','민쑤!', now());
    insert into guestbook values(null, '서민정','111','안녕 얘드라~~~*^^*', now());
    insert into guestbook values(null, '이민용','222','안녕안녕', now());
	insert into guestbook values(null, '정윤호','333','부릉부릉', now());
    insert into guestbook values(null, '이효리','444','후후후ㅜㅎ', now());
    insert into guestbook values(null, '최수진','555','반사오삼', now());
    insert into guestbook values(null, '노재원','666','민쑤!', now());
    insert into guestbook values(null, '서민정','111','안녕 얘드라~~~*^^*', now());
    insert into guestbook values(null, '이민용','222','안녕안녕', now());
	insert into guestbook values(null, '정윤호','333','부릉부릉', now());
    insert into guestbook values(null, '이효리','444','후후후ㅜㅎ', now());
    insert into guestbook values(null, '최수진','555','반사오삼', now());
    insert into guestbook values(null, '노재원','666','민쑤!', now());
    insert into guestbook values(null, '서민정','111','안녕 얘드라~~~*^^*', now());
    insert into guestbook values(null, '이민용','222','안녕안녕', now());
	insert into guestbook values(null, '정윤호','333','부릉부릉', now());
    insert into guestbook values(null, '이효리','444','후후후ㅜㅎ', now());
    insert into guestbook values(null, '최수진','555','반사오삼', now());
    insert into guestbook values(null, '노재원','666','민쑤!', now());
    insert into guestbook values(null, '서민정','111','안녕 얘드라~~~*^^*', now());
    insert into guestbook values(null, '이민용','222','안녕안녕', now());
	insert into guestbook values(null, '정윤호','333','부릉부릉', now());
    insert into guestbook values(null, '이효리','444','후후후ㅜㅎ', now());
    insert into guestbook values(null, '최수진','555','반사오삼', now());
    insert into guestbook values(null, '노재원','666','민쑤!', now());
    insert into guestbook values(null, '서민정','111','안녕 얘드라~~~*^^*', now());
    insert into guestbook values(null, '이민용','222','안녕안녕', now());
	insert into guestbook values(null, '정윤호','333','부릉부릉', now());
    insert into guestbook values(null, '이효리','444','후후후ㅜㅎ', now());
    insert into guestbook values(null, '최수진','555','반사오삼', now());
	insert into guestbook values(null, '노재원','666','민쑤!', now());
	insert into guestbook values(null, '서민정','111','안녕 얘드라~~~*^^*', now());
    insert into guestbook values(null, '이민용','222','안녕안녕', now());
	insert into guestbook values(null, '정윤호','333','부릉부릉', now());
    insert into guestbook values(null, '이효리','444','후후후ㅜㅎ', now());
    insert into guestbook values(null, '최수진','555','반사오삼', now());
    insert into guestbook values(null, '노재원','666','민쑤!', now());
    insert into guestbook values(null, '서민정','111','안녕 얘드라~~~*^^*', now());
    insert into guestbook values(null, '이민용','222','안녕안녕', now());
	insert into guestbook values(null, '정윤호','333','부릉부릉', now());
    insert into guestbook values(null, '이효리','444','후후후ㅜㅎ', now());
    insert into guestbook values(null, '최수진','555','반사오삼', now());
    insert into guestbook values(null, '노재원','666','민쑤!', now());
    insert into guestbook values(null, '서민정','111','안녕 얘드라~~~*^^*', now());
    insert into guestbook values(null, '이민용','222','안녕안녕', now());
	insert into guestbook values(null, '정윤호','333','부릉부릉', now());
    insert into guestbook values(null, '이효리','444','후후후ㅜㅎ', now());
    insert into guestbook values(null, '최수진','555','반사오삼', now());
    insert into guestbook values(null, '노재원','666','민쑤!', now());
    insert into guestbook values(null, '서민정','111','안녕 얘드라~~~*^^*', now());
    insert into guestbook values(null, '이민용','222','안녕안녕', now());
	insert into guestbook values(null, '정윤호','333','부릉부릉', now());
    insert into guestbook values(null, '이효리','444','후후후ㅜㅎ', now());
    insert into guestbook values(null, '최수진','555','반사오삼', now());
    insert into guestbook values(null, '노재원','666','민쑤!', now());
    insert into guestbook values(null, '서민정','111','안녕 얘드라~~~*^^*', now());
    insert into guestbook values(null, '이민용','222','안녕안녕', now());
	insert into guestbook values(null, '정윤호','333','부릉부릉', now());
    insert into guestbook values(null, '이효리','444','후후후ㅜㅎ', now());
    insert into guestbook values(null, '최수진','555','반사오삼', now());
    insert into guestbook values(null, '노재원','666','민쑤!', now());
    insert into guestbook values(null, '서민정','111','안녕 얘드라~~~*^^*', now());
    insert into guestbook values(null, '이민용','222','안녕안녕', now());
	insert into guestbook values(null, '정윤호','333','부릉부릉', now());
    insert into guestbook values(null, '이효리','444','후후후ㅜㅎ', now());
    insert into guestbook values(null, '최수진','555','반사오삼', now());
    insert into guestbook values(null, '노재원','666','민쑤!', now());
    insert into guestbook values(null, '서민정','111','안녕 얘드라~~~*^^*', now());
    insert into guestbook values(null, '이민용','222','안녕안녕', now());
	insert into guestbook values(null, '정윤호','333','부릉부릉', now());
    insert into guestbook values(null, '이효리','444','후후후ㅜㅎ', now());
    insert into guestbook values(null, '최수진','555','반사오삼', now());
    insert into guestbook values(null, '노재원','666','민쑤!', now());
    insert into guestbook values(null, '서민정','111','안녕 얘드라~~~*^^*', now());
    insert into guestbook values(null, '이민용','222','안녕안녕', now());
	insert into guestbook values(null, '정윤호','333','부릉부릉', now());
    insert into guestbook values(null, '이효리','444','후후후ㅜㅎ', now());
    insert into guestbook values(null, '최수진','555','반사오삼', now());
    insert into guestbook values(null, '노재원','666','민쑤!', now());
    insert into guestbook values(null, '서민정','111','안녕 얘드라~~~*^^*', now());
    insert into guestbook values(null, '이민용','222','안녕안녕', now());
	insert into guestbook values(null, '정윤호','333','부릉부릉', now());
    insert into guestbook values(null, '이효리','444','후후후ㅜㅎ', now());
    insert into guestbook values(null, '최수진','555','반사오삼', now());
    insert into guestbook values(null, '노재원','666','민쑤!', now());
    insert into guestbook values(null, '서민정','111','안녕 얘드라~~~*^^*', now());
    insert into guestbook values(null, '이민용','222','안녕안녕', now());
	insert into guestbook values(null, '정윤호','333','부릉부릉', now());
    insert into guestbook values(null, '이효리','444','후후후ㅜㅎ', now());
    insert into guestbook values(null, '최수진','555','반사오삼', now());
    insert into guestbook values(null, '노재원','666','민쑤!', now());
    insert into guestbook values(null, '서민정','111','안녕 얘드라~~~*^^*', now());
    insert into guestbook values(null, '이민용','222','안녕안녕', now());
	insert into guestbook values(null, '정윤호','333','부릉부릉', now());
    insert into guestbook values(null, '이효리','444','후후후ㅜㅎ', now());
    insert into guestbook values(null, '최수진','555','반사오삼', now());
    insert into guestbook values(null, '노재원','666','민쑤!', now());
    insert into guestbook values(null, '서민정','111','안녕 얘드라~~~*^^*', now());
    insert into guestbook values(null, '이민용','222','안녕안녕', now());
	insert into guestbook values(null, '정윤호','333','부릉부릉', now());
    insert into guestbook values(null, '이효리','444','후후후ㅜㅎ', now());
    insert into guestbook values(null, '최수진','555','반사오삼', now());
	insert into guestbook values(null, '노재원','666','민쑤!', now());
	insert into guestbook values(null, '서민정','111','안녕 얘드라~~~*^^*', now());
    insert into guestbook values(null, '이민용','222','안녕안녕', now());
	insert into guestbook values(null, '정윤호','333','부릉부릉', now());
    insert into guestbook values(null, '이효리','444','후후후ㅜㅎ', now());
    insert into guestbook values(null, '최수진','555','반사오삼', now());
	insert into guestbook values(null, '노재원','666','민쑤!', now());
    insert into guestbook values(null, '서민정','111','안녕 얘드라~~~*^^*', now());

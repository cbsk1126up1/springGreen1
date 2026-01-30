show tables;

	-- varchar / char / text
	
create table jcat (
	idx int not null auto_increment Primary key, /* 고유번호 */
	kind varchar(10) not null,                   /* 종류(////) */
	name varchar(10) not null,                   /* 성명 */
	gender char(2) default '여자',                /* 성별 */
	fDate datetime not null,                     /* '발견/신고'일 */
	features text not null,                      /* 특징 */
	photo varchar(50) default 'noname.jpg',      /* 사진 */
	missing char(1) default '1',                 /* 전환(0:실종묘, 1:유기묘) */
	singoja varchar(10) not null,              /* 신고자이름 */
	singotel varchar(15) not null              /* 신고자 연락처 */
);
	
	-- content text 


desc jProduct;

-- drop table jcat;

select * from jcat;

select *, (select count(*) as cnt from jcat) from jcat order by idx desc;
select *, (select count(*) from jcat) as cnt from jcat order by idx desc;

select *,date_format(fDate, '%Y-%m-%d %H시') as fDate from jcat order by idx desc;


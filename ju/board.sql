--create user spring identified by java;
--grant resource, connect to spring;
--conn servlet/java;

drop table BOARD;
drop sequence BOARD_SEQ;
purge recyclebin;

create table BOARD(
   SEQ number constraint BOARD_PK primary key,
   WRITER varchar2(20),
   EMAIL varchar2(30),
   SUBJECT varchar2(40),
   CONTENT varchar2(200),
   RDATE date default SYSDATE
);
create sequence BOARD_SEQ increment by 1 start with 1 nocache;

insert into BOARD values(BOARD_SEQ.nextval, '권연주', 'kwon@hanmail.net','파이팅', '힘내자', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '김보라', 'lee@hanmail.net','제목2', '내용2', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '김성태', 'han@hanmail.net','제목3', '내용3', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '김세영', 'oh@hanmail.net','제목4', '내용4', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '김소담', 'chm@hanmail.net','제목5', '내용5', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '남철호', 'kim@hanmail.net','제목6', '내용6', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '모건일', 'lee@hanmail.net','제목7', '내용7', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '손영빈', 'han@hanmail.net','제목8', '내용8', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '송승훈', 'oh@hanmail.net','제목9', '내용9', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '안정은', 'chm@hanmail.net','제목10', '내용10', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '윤 별', 'kim@hanmail.net','제목11', '내용11', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '임성지', 'lee@hanmail.net','제목12', '내용12', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '장현봉', 'han@hanmail.net','제목13', '내용13', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '전세환', 'oh@hanmail.net','제목14', '내용14', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '조예진', 'chm@hanmail.net','제목15', '내용15', SYSDATE);

commit;

select CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints where TABLE_NAME='BOARD';
select * from BOARD order by SEQ desc;


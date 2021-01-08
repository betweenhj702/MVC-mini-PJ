drop table BOARDQ;
drop sequence BOARD_SEQ;
purge recyclebin;

create table BOARDQ(
   BQ_SEQ number constraint BOARDQ_PK primary key, 
   M_EMAIL varchar2(80) not null, 
   BQ_SUBJECT varchar2(60),
   BQ_CONTENT varchar2(500), 
   BQ_RDATE date,
   BQ_COUNT number,
   BQ_REFER number,
   BQ_LEV number,
   BQ_PLACE number,
   constraint BOARDQ_FK foreign key(M_EMAIL) references MEMBER(M_EMAIL),
); 
create sequence BOARDQ_SEQ increment by 1 start with 1 nocache;


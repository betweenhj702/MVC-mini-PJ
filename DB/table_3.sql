drop table REPLY;
drop table BOARDN;
drop table BOARDQ;
drop sequence BOARDQ_SEQ;
drop sequence BOARDN_SEQ;
drop sequence REPLY_SEQ;
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
   constraint BOARDQ_FK foreign key(M_EMAIL) references MEMBER(M_EMAIL)
); 
create sequence BOARDQ_SEQ increment by 1 start with 1 nocache;

create table BOARDN(
	BN_SEQ number constraint BOARDN_PK primary key,
	M_EMAIL varchar2(80) not null,
	BN_SUBJECT varchar2(60),
	BN_CONTENT varchar2(500),
	BN_RDATE date,
	BN_COUNT number,
	constraint BOARDN_FK foreign key(M_EMAIL) references MEMBER(M_EMAIL)
);
create sequence BOARDN_SEQ increment by 1 start with 1 nocache;

create table REPLY(
	R_SEQ number constraint REPLY_PK primary key,
	M_EMAIL varchar2(80) not null,
	BN_SEQ number not null,
	R_CONTENT varchar2(200),
	R_RDATE date,
	R_REFER number,
	R_LEV number,
	R_PLACE number,
	constraint REPLY_FK1 foreign key(M_EMAIL) references MEMBER(M_EMAIL),
	constraint REPLY_FK2 foreign key(BN_SEQ) references BOARDN(BN_SEQ)
);
create sequence REPLY_SEQ increment by 1 start with 1 nocache;
drop table ORDER; drop table REPLY;
drop table CART; drop table BOARDN; drop table BOARDQ;
drop table PRODUCT;
drop table MEMBER;
drop sequence CART_SQ;
drop sequence ORDER_SQ;
drop sequence BOARDQ_SEQ;
drop sequence BOARDN_SEQ;
drop sequence REPLY_SEQ;
purge recyclebin;

create table MEMBER(
	M_EMAIL VARCHAR2(80) constraint MEMBER_PK primary key,
	M_PWD varchar2(40) constraint MEMBER_NN1 not null,
	M_NAME varchar2(20) constraint MEMBER_NN2 not null,
	M_PHONE varchar2(30) constraint MEMBER_NN3 not null,
	M_ADDR varchar2(100) constraint MEMBER_NN4 not null,
	M_ADDR2 varchar2(100),
	M_ADMIN varchar2(2)
);

insert into MEMBER values('admin@gmail.com','1q2w3e4r','������','01077777777','��Ʈķ��',null,'y');
insert into MEMBER values('betweenhj702@gmail.com','12341234','�ŵ���','01012341234','���ֽ�',null,null);
insert into MEMBER values('ssu@gmail.com','12341234','�̼���','0104321421','�����',null, null);
insert into MEMBER values('kwon@gmail.com','12341234','�ǿ���','01022222222','�����',null, null);
insert into MEMBER values('lee@gmail.com','12341234','�̹ο�','01033333333','�����',null, null);

create table PRODUCT(
   P_CODE number constraint PRODUCT_PK primary key,
   P_TYPE varchar2(2),
   P_NAME varchar2(80) constraint PRODUCT_NN1 not null,
   P_PRICE number(20),
   P_IMG varchar2(20),
   P_INFO varchar2(100)
);

insert into PRODUCT values(1001, 1, '��Ϲ��� �Ƹ��', 7500, null, '210g');
insert into PRODUCT values(1002, 1, '���������� �Ƹ��',  7500, null, '210g');
insert into PRODUCT values(1003, 1, '��� �Ƹ��',  7500, null, '210g');
insert into PRODUCT values(1004, 1, '��Ʈ���� �Ƹ��',  7500, null,'210g');
insert into PRODUCT values(1005, 1, '���û� �Ƹ��', 7500, null,'210g');
insert into PRODUCT values(1006, 1, '������ �Ƹ��',  7500,null,'210g');

commit;

select * from PRODUCT order by P_CODE asc;
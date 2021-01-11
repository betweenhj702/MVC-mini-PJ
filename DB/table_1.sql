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

insert into PRODUCT values(1001, '1', '������ �Ƹ��', 7500, 'amd-black.png', '���뷮: 210g');
insert into PRODUCT values(1002, '1', '����ũƼ �Ƹ��',  7500, 'amd-blacksugar.png', '���뷮: 210g');
insert into PRODUCT values(1003, '1', 'ļ��� �Ƹ�������ÿ',  7500, 'amd-caramel.png', '���뷮: 210g');
insert into PRODUCT values(1004, '1', '��Ű��ũ�� �Ƹ��',  7500, 'amd-cookie.png','���뷮: 210g');
insert into PRODUCT values(1005, '1', '���������� �Ƹ��', 7500, 'amd-corn.png','���뷮: 210g');
insert into PRODUCT values(1006, '1', '�Ҵ߸� �Ƹ��',  7500,'amd-fire.png','���뷮: 210g');
insert into PRODUCT values(1007, '1', '���û� �Ƹ��', 7500, 'amd-garlic.png', '���뷮:210g');
insert into PRODUCT values(1008, '1', '���ָ��� �Ƹ��',  7500, 'amd-greentea.png', '���뷮: 210g');
insert into PRODUCT values(1009, '1', '��Ϲ��� �Ƹ��',  7500, 'amd-honey.png', '���뷮: 210g');
insert into PRODUCT values(1010, '1', '��ȫ��� �Ƹ��',  7500, 'amd-hongsam.png','���뷮: 210g');
insert into PRODUCT values(1011, '1', '������ �Ƹ��', 7500, 'amd-injeolmi.png','���뷮: 210g');
insert into PRODUCT values(1012, '1', '��� �Ƹ��',  7500,'amd-laver.png','���뷮: 210g');
insert into PRODUCT values(1013, '1', 'û�縶�� �Ƹ��', 7500, 'amd-mayo.png', '���뷮: 210g');
insert into PRODUCT values(1014, '1', '��Ʈ���� �Ƹ��',  7500, 'amd-mint.png', '���뷮: 210g');
insert into PRODUCT values(1015, '1', '�������� �Ƹ��',  7500, 'amd-star.png', '���뷮: 210g');
insert into PRODUCT values(1016, '1', 'Ƽ��̼��� �Ƹ��',  7500, 'amd-tiramisu.png','���뷮: 210g');
insert into PRODUCT values(1017, '1', '���ǳӶ� �Ƹ��', 7500, 'amd-toffee.png','���뷮: 210g');
insert into PRODUCT values(1018, '1', '�����̸� �Ƹ��',  7500,'amd-tteok.png','���뷮: 210g');
insert into PRODUCT values(1019, '1', '�ͻ��� �Ƹ��',  7500,'amd-wasabi.png','���뷮: 210g');

insert into PRODUCT values(1020, '2', '��Ϲ��� ĳ����', 2500, 'cashew-honey.png', '���뷮: 50g');
insert into PRODUCT values(1021, '2', 'ü������� ��ī�ٹ̾�',  8900, 'maca-cherry.png', '���뷮: 150g');
insert into PRODUCT values(1022, '2', 'Ƽ��̼��� ��ī�ٹ̾�',  8900, 'maca-tiramisu.png', '���뷮: 150g');
insert into PRODUCT values(1023, '2', '��Ϲ��� �ͽ���',  5900, 'mix-honey.png','���뷮: 300g');
insert into PRODUCT values(1024, '2', 'ļ����Ƽ�� ���������ÿ', 5900, 'peanut-caramel.png','���뷮: 300g');
insert into PRODUCT values(1025, '2', '���������� ����',  5900,'peanut-corn.png','���뷮: 300g');
insert into PRODUCT values(1026, '2', '��Ϲ��� ����', 5900, 'peanut-honey.png', '���뷮: 300g');
insert into PRODUCT values(1027, '2', '�ͻ��� ����',  5900, 'peanut-wasabi.png', '���뷮: 300g');


commit;

select * from PRODUCT order by P_CODE asc;
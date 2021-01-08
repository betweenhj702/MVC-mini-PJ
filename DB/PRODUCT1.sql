drop table PRODUCT;
purge recyclebin;

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


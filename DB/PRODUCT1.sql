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

insert into PRODUCT values(1001, 1, '허니버터 아몬드', 7500, null, '210g');
insert into PRODUCT values(1002, 1, '군옥수수맛 아몬드',  7500, null, '210g');
insert into PRODUCT values(1003, 1, '김맛 아몬드',  7500, null, '210g');
insert into PRODUCT values(1004, 1, '민트초코 아몬드',  7500, null,'210g');
insert into PRODUCT values(1005, 1, '마늘빵 아몬드', 7500, null,'210g');
insert into PRODUCT values(1006, 1, '흑임자 아몬드',  7500,null,'210g');
commit;

select * from PRODUCT order by P_CODE asc;


drop table ORD;
drop table CART;
drop sequence CART_SEQ;
drop sequence ORD_SEQ;
purge recyclebin;

create table CART(
	C_SEQ number constraint CART_PK primary key,
	M_EMAIL varchar2(80) not null,
	P_CODE number not null,
	C_AMOUNT number not null,
	C_VALID varchar2(2) not null,
	constraint CART_FK foreign key(M_EMAIL) references MEMBER(M_EMAIL),
	constraint CART_FK2 foreign key(P_CODE) references PRODUCT(P_CODE)
    );
   create sequence CART_SEQ increment by 1 start with 1 nocache;
    
create table ORD(
       O_SEQ number constraint ORD_PK primary key,
       C_SEQ number not null,
       O_ODATE date not null,
       O_ONAME varchar2(20) not null,
       O_OADDR varchar2(100) not null,
       O_MSG varchar2(100),
       O_OVALID varchar2(2) default 'n',
       constraint ORD_FK foreign key(C_SEQ) references CART(C_SEQ)
    );

    create sequence ORD_SEQ increment by 1 start with 1 nocache;
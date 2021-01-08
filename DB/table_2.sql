drop table ORDER;
drop table CART;
drop sequence CART_SQ;
drop sequence ORDER_SQ;
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
    
create table ORDER(
       O_SEQ number constraint ORDER_PK primary key,
       C_SEQ number not null,
       O_ODATE date not null,
       constraint ORDER_FK foreign key(C_SEQ) references CART(C_SEQ),
      
    );
    create sequence ORDER_SEQ increment by 1 start with 1 nocache;
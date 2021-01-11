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

insert into MEMBER values('admin@gmail.com','1q2w3e4r','관리자','01077777777','비트캠프',null,'y');
insert into MEMBER values('betweenhj702@gmail.com','12341234','신동오','01012341234','전주시',null,null);
insert into MEMBER values('ssu@gmail.com','12341234','이수진','0104321421','서울시',null, null);
insert into MEMBER values('kwon@gmail.com','12341234','권연주','01022222222','광명시',null, null);
insert into MEMBER values('lee@gmail.com','12341234','이민용','01033333333','서울시',null, null);

create table PRODUCT(
   P_CODE number constraint PRODUCT_PK primary key,
   P_TYPE varchar2(2),
   P_NAME varchar2(80) constraint PRODUCT_NN1 not null,
   P_PRICE number(20),
   P_IMG varchar2(20),
   P_INFO varchar2(100)
);

insert into PRODUCT values(1001, '1', '흑임자 아몬드', 7500, 'amd-black.png', '내용량: 210g');
insert into PRODUCT values(1002, '1', '흑당밀크티 아몬드',  7500, 'amd-blacksugar.png', '내용량: 210g');
insert into PRODUCT values(1003, '1', '캬라멜 아몬드앤프레첼',  7500, 'amd-caramel.png', '내용량: 210g');
insert into PRODUCT values(1004, '1', '쿠키앤크림 아몬드',  7500, 'amd-cookie.png','내용량: 210g');
insert into PRODUCT values(1005, '1', '군옥수수맛 아몬드', 7500, 'amd-corn.png','내용량: 210g');
insert into PRODUCT values(1006, '1', '불닭맛 아몬드',  7500,'amd-fire.png','내용량: 210g');
insert into PRODUCT values(1007, '1', '마늘빵 아몬드', 7500, 'amd-garlic.png', '내용량:210g');
insert into PRODUCT values(1008, '1', '제주말차 아몬드',  7500, 'amd-greentea.png', '내용량: 210g');
insert into PRODUCT values(1009, '1', '허니버터 아몬드',  7500, 'amd-honey.png', '내용량: 210g');
insert into PRODUCT values(1010, '1', '꿀홍삼맛 아몬드',  7500, 'amd-hongsam.png','내용량: 210g');
insert into PRODUCT values(1011, '1', '인절미 아몬드', 7500, 'amd-injeolmi.png','내용량: 210g');
insert into PRODUCT values(1012, '1', '김맛 아몬드',  7500,'amd-laver.png','내용량: 210g');
insert into PRODUCT values(1013, '1', '청양마요 아몬드', 7500, 'amd-mayo.png', '내용량: 210g');
insert into PRODUCT values(1014, '1', '민트초코 아몬드',  7500, 'amd-mint.png', '내용량: 210g');
insert into PRODUCT values(1015, '1', '별빛팡팡 아몬드',  7500, 'amd-star.png', '내용량: 210g');
insert into PRODUCT values(1016, '1', '티라미수맛 아몬드',  7500, 'amd-tiramisu.png','내용량: 210g');
insert into PRODUCT values(1017, '1', '토피넛라떼 아몬드', 7500, 'amd-toffee.png','내용량: 210g');
insert into PRODUCT values(1018, '1', '떡볶이맛 아몬드',  7500,'amd-tteok.png','내용량: 210g');
insert into PRODUCT values(1019, '1', '와사비맛 아몬드',  7500,'amd-wasabi.png','내용량: 210g');

insert into PRODUCT values(1020, '2', '허니버터 캐슈넛', 2500, 'cashew-honey.png', '내용량: 50g');
insert into PRODUCT values(1021, '2', '체리쥬빌레 마카다미아',  8900, 'maca-cherry.png', '내용량: 150g');
insert into PRODUCT values(1022, '2', '티라미수맛 마카다미아',  8900, 'maca-tiramisu.png', '내용량: 150g');
insert into PRODUCT values(1023, '2', '허니버터 믹스넛',  5900, 'mix-honey.png','내용량: 300g');
insert into PRODUCT values(1024, '2', '캬라멜솔티드 땅콩앤프레첼', 5900, 'peanut-caramel.png','내용량: 300g');
insert into PRODUCT values(1025, '2', '군옥수수맛 땅콩',  5900,'peanut-corn.png','내용량: 300g');
insert into PRODUCT values(1026, '2', '허니버터 땅콩', 5900, 'peanut-honey.png', '내용량: 300g');
insert into PRODUCT values(1027, '2', '와사비맛 땅콩',  5900, 'peanut-wasabi.png', '내용량: 300g');


commit;

select * from PRODUCT order by P_CODE asc;
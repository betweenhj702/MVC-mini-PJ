īƮ�� ���

insert CART values(c_seq.nextval, betweenhj702, 1����ǰ, ����);
insert CART values(c_seq.nextval, betweenhj702, 1����ǰ, ����2);
insert CART values(c_seq.nextval, kwon111, 2����ǰ, ����3);

....


��ٱ��� Ȯ��

select * from CART where m_email = �ŵ���;
select * from CART where m_email = kwon111;

1.��Ϲ���(�̹���, �̸�, ����), ����, �ݾ�
2.�ͻ��(�̹���, �̸�, ����), ����, �ݾ�

�� �ݾ� 9999

�����Ҷ�

�ŵ���(�����, ��ȭ��ȣ)�� ��Ϲ��͸� 3�� �ֹ��ϰ�, �ͻ�� 2�� �ֹ��ߴ�. 

�ֹ���ȣ, �ֹ���, ����, �ѱݾ�

insert Order values(o_seq.nextval, ��Ϲ���, �ŵ���, ����, �ݾ�, sysdate)
insert Order values(o_seq.nextval, �ͻ��, �ŵ���, ����, �ݾ�, sysdate)


��������



select * from Order where email = �ŵ���;
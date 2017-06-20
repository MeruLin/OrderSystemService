create table tb_menu
(
    menu_id int auto_increment primary key,  -- ���� ID
    menu_name varchar(30) not null, -- ��������
    menu_introduce varchar(200), -- ���׽���
    menu_address varchar(200), -- ���ײ���
    menu_price double, -- ��ʵ�۸�
    menu_cutprice double, -- �Żݺ�۸�
    menu_discount double, -- ������
    menu_is_discount boolean, -- �Ƿ����
    menu_is_decommend boolean, -- �Ƿ��ʦ�Ƽ�
    menu_is_order boolean, -- �Ƿ�ɵ�
    menu_pic_url varchar(100), -- ͼƬ·��(���Ǵ�ͼƬ)
    menu_order_count int, -- �㵥����
    menu_create_date varchar(30), -- ���״���ʱ��
    menu_status boolean, -- ����״̬
    sort_id int -- ��ϵ id(���)
);
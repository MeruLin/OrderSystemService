create table tb_order_detail(
    detail_id int auto_increment primary key, 
    order_id int, -- ��������id
    menu_id int, -- ����id
    menu_name varchar(20), -- ��������
    detail_count int-- ����
)
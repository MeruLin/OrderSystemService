create table tb_type 
(
    type_id int auto_increment primary key,  -- ���� id 
    type_name varchar(20) not null, -- ��������
    type_parent_id int -- ������ id 
);
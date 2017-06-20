create table tb_type 
(
    type_id int auto_increment primary key,  -- 分类 id 
    type_name varchar(20) not null, -- 分类名称
    type_parent_id int -- 父分类 id 
);
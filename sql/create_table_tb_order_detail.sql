create table tb_order_detail(
    detail_id int auto_increment primary key, 
    order_id int, -- 所属订单id
    menu_id int, -- 菜谱id
    menu_name varchar(20), -- 菜谱名称
    detail_count int-- 数量
)
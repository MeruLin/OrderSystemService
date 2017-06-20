create table tb_menu
(
    menu_id int auto_increment primary key,  -- 菜谱 ID
    menu_name varchar(30) not null, -- 菜谱名称
    menu_introduce varchar(200), -- 菜谱介绍
    menu_address varchar(200), -- 菜谱产地
    menu_price double, -- 真实价格
    menu_cutprice double, -- 优惠后价格
    menu_discount double, -- 打折率
    menu_is_discount boolean, -- 是否打折
    menu_is_decommend boolean, -- 是否厨师推荐
    menu_is_order boolean, -- 是否可点
    menu_pic_url varchar(100), -- 图片路径(不是存图片)
    menu_order_count int, -- 点单次数
    menu_create_date varchar(30), -- 菜谱创建时间
    menu_status boolean, -- 菜谱状态
    sort_id int -- 菜系 id(外键)
);
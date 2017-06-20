create table tb_menu_type(
    menu_type_id int auto_increment primary key,
    menu_id int, -- 菜谱 id(外键)
    type_id int  -- 类型 id(外键)
);
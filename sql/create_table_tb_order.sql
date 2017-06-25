create table tb_order(
    order_id int auto_increment primary key,
    order_price double,
    order_cut_price double,
    order_time varchar(20),
    order_state varchar(10), 
    order_table int -- ×À×Ó±àºÅ
);
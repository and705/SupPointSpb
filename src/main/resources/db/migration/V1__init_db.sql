#     alter table booking_details drop foreign key booking_details_fk_booking;
#     alter table booking_details drop foreign key booking_details_fk_timetable;
#     alter table bookings drop foreign key bookings_fk_users;
#     alter table bookings_details drop foreign key bookings_details_fk_details;
#     alter table bookings_details drop foreign key bookings_details_fk_bookings;
#     alter table buckets drop foreign key buckets_fk_users;
#     alter table buckets_products drop foreign key buckets_products_fk_products;
#     alter table buckets_products drop foreign key buckets_products_fk_buckets;
#     alter table order_details drop foreign key order_details_fk_orders;
#     alter table order_details drop foreign key order_details_fk_products;
#     alter table orders drop foreign key orders_fk_users;
#     alter table orders_details drop foreign key orders_details_fk_details;
#     alter table orders_details drop foreign key orders_details_fk_orders;
#     alter table posts drop foreign key posts_fk_users;
#     alter table products_categories drop foreign key products_categories_fk_category;
#     alter table products_categories drop foreign key products_categories_fk_product;
#     alter table timetables drop foreign key timetables_fk_route;
#     alter table timetables drop foreign key timetables_fk_users;
#     alter table users drop foreign key users_fk_buckets;
#     drop table if exists booking_details;
#     drop table if exists booking_details_seq;
#     drop table if exists booking_seq;
#     drop table if exists bookings;
#     drop table if exists bookings_details;
#     drop table if exists bucket_seq;
#     drop table if exists buckets;
#     drop table if exists buckets_products;
#     drop table if exists categories;
#     drop table if exists category_seq;
#     drop table if exists order_details;
#     drop table if exists order_details_seq;
#     drop table if exists order_seq;
#     drop table if exists orders;
#     drop table if exists orders_details;
#     drop table if exists post_seq;
#     drop table if exists posts;
#     drop table if exists product_seq;
#     drop table if exists products;
#     drop table if exists products_categories;
#     drop table if exists route_seq;
#     drop table if exists routes;
#     drop table if exists timetable_seq;
#     drop table if exists timetables;
#     drop table if exists user_seq;
#     drop table if exists users;
create table booking_details (
    id bigint not null,
    amount decimal(38,2),
    price decimal(38,2),
    booking_id bigint,
    timetable_id bigint,
    primary key (id));

create table booking_details_seq (
    next_val bigint);

insert into booking_details_seq values ( 1 );

create table booking_seq (next_val bigint);

insert into booking_seq values ( 1 );

create table bookings (
    id bigint not null,
    created datetime(6),
    status varchar(255),
    sum decimal(38,2),
    updated datetime(6),
    user_id bigint,
    primary key (id));

create table bookings_details (
    bookings_id bigint not null,
    details_id bigint not null);

create table bucket_seq (next_val bigint);

insert into bucket_seq values ( 1 );

create table buckets (
    id bigint not null,
    user_id bigint,
    primary key (id));

create table buckets_products (
    bucket_id bigint not null,
    product_id bigint not null);

create table categories (
    id bigint not null,
    title varchar(255),
    primary key (id));

create table category_seq (next_val bigint);

insert into category_seq values ( 1 );
create table order_details (
    id bigint not null,
    amount decimal(38,2),
    price decimal(38,2),
    order_id bigint,
    product_id bigint,
    primary key (id));

create table order_details_seq (next_val bigint);

insert into order_details_seq values ( 1 );

create table order_seq (next_val bigint);

insert into order_seq values ( 1 );

create table orders (
    id bigint not null,
    adress varchar(255),
    created datetime(6),
    status varchar(255),
    sum decimal(38,2),
    updated datetime(6),
    user_id bigint,
    primary key (id));

create table orders_details (
    orders_id bigint not null,
    details_id bigint not null);

create table post_seq (next_val bigint);

insert into post_seq values ( 1 );

create table posts (
    id bigint not null,
    created datetime(6),
    post_annotatition varchar(255),
    post_full_text varchar(255),
    shows integer not null,
    title varchar(255),
    updated datetime(6),
    user_id bigint,
    primary key (id));

create table product_seq (next_val bigint);

insert into product_seq values ( 1 );

create table products (
    id bigint not null,
    price decimal(38,2),
    title varchar(255),
    primary key (id));

create table products_categories (
    product_id bigint not null,
    category_id bigint not null);

create table route_seq (next_val bigint);

insert into route_seq values ( 1 );

create table routes (
    id bigint not null,
    description varchar(255),
    duration integer not null,
    finish_point varchar(255),
    map varchar(255),
    name varchar(255),
    photo varchar(255),
    price decimal(38,2),
    start_point varchar(255),
    primary key (id));

create table timetable_seq (next_val bigint);

insert into timetable_seq values ( 1 );

create table timetables (
    id bigint not null,
    available_places integer not null,
    comment varchar(255),
    date date,
    photo_link varchar(255),
    places integer not null,
    time time,
    route_id bigint,
    user_id bigint,
    primary key (id));

create table user_seq (next_val bigint);

insert into user_seq values ( 1 );

create table users (
    id bigint not null,
    archive bit not null,
    comment varchar(255),
    email varchar(255),
    name varchar(255),
    password varchar(255),
    phone_number varchar(255),
    role varchar(255),
    tg_id varchar(255),
    tg_name varchar(255),
    bucket_id bigint,
    primary key (id));

alter table bookings_details add constraint bookings_details_fk_details unique (details_id);

alter table orders_details add constraint orders_details_fk_details unique (details_id);

alter table booking_details add constraint booking_details_fk_booking foreign key (booking_id) references bookings (id);

alter table booking_details add constraint booking_details_fk_timetable foreign key (timetable_id) references timetables (id);

alter table bookings add constraint bookings_fk_users foreign key (user_id) references users (id);

alter table bookings_details add constraint bookings_details_fk_details foreign key (details_id) references booking_details (id);

alter table bookings_details add constraint bookings_details_fk_bookings foreign key (bookings_id) references bookings (id);

alter table buckets add constraint buckets_fk_users foreign key (user_id) references users (id);

alter table buckets_products add constraint buckets_products_fk_products foreign key (product_id) references products (id);

alter table buckets_products add constraint buckets_products_fk_buckets foreign key (bucket_id) references buckets (id);

alter table order_details add constraint order_details_fk_orders foreign key (order_id) references orders (id);

alter table order_details add constraint order_details_fk_products foreign key (product_id) references products (id);

alter table orders add constraint orders_fk_users foreign key (user_id) references users (id);

alter table orders_details add constraint orders_details_fk_details foreign key (details_id) references order_details (id);

alter table orders_details add constraint orders_details_fk_orders foreign key (orders_id) references orders (id);

alter table posts add constraint posts_fk_users foreign key (user_id) references users (id);

alter table products_categories add constraint products_categories_fk_category foreign key (category_id) references categories (id);

alter table products_categories add constraint products_categories_fk_product foreign key (product_id) references products (id);

alter table timetables add constraint timetables_fk_route foreign key (route_id) references routes (id);

alter table timetables add constraint timetables_fk_users foreign key (user_id) references users (id);

alter table users add constraint users_fk_buckets foreign key (bucket_id) references buckets (id);


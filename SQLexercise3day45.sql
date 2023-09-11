-- create database exercise3;
use exercise3;

create table city (
	id int primary key,
    city_name varchar(255)
);

create table customer (
	id int primary key,
    customer_name varchar(255),
    city_id int,
    customer_address varchar(255),
    contact_person varchar(255),
    email varchar(128),
    phone varchar(128),
    foreign key (city_id) references city(id)
);

create table product (
	id int primary key,
    sku varchar(32),
    product_name varchar(128),
    product_description text,
    current_price decimal(8,2),
    quantity_in_stock int
);

create table invoice (
	id int primary key,
    invoice_number varchar(255),
    customer_id int,
    user_account_id int,
    total_price decimal(8,2),
    time_issued varchar(255),
    time_due varchar(255),
    time_paid varchar(255),
    time_canceled varchar(255),
    time_refunded varchar(255),
    foreign key (customer_id) references customer(id)
);

create table invoice_item(
	id int primary key,
    invoice_id int,
    product_id int,
    quantity int,
    price decimal(8,2),
    line_total_price decimal(8,2),
    foreign key (invoice_id) references invoice(id),
    foreign key (product_id) references product(id)
);

insert into city values (1, 'HK'), (2, 'KL'), (3, 'NT'), (4, 'WS');
select * from city;

insert into customer values (1, 'Drogerie Wien', 1, 'Deckergasse 15A', 'Emil Steinbach', 'emil@drogeriewien.com', '094234234');
insert into customer values (2, 'Cosmetics Store', 4, 'Watling Street 347', 'Jeremy Corbyn', 'jeremy@c-store.org', '093923923');
insert into customer values (3, 'Kosmetikstudio', 3, 'Rothenbaumchaussee 53', 'Willy Brandt', 'willy@kosmetikstudio.com', '0941562222');
insert into customer values (4, 'Neue Kosmetik', 1, 'Karlsplatz 2', null, 'info@neuekosmetik.com', '094109253');
insert into customer values (5, 'Bio Kosmetik', 2, 'MotzstraBe 23', 'Clara Zetkin', 'clara@biokosmetik.org', '093825825');
insert into customer values (6, 'K-Wien', 1, 'Karntner StraBe 204', 'Maria Rauch-Kallat', 'maria@kwien.org', '093427002');
insert into customer values (7, 'Natural Cosmetics', 4, 'Clerkenwell Road 14B', 'Glenda Jackson', 'glena.j@natural-cosmetics.com', '093555123');
insert into customer values (8, 'Kosmetik Plus', 2, 'Unter den Linden 1', 'Angela Merkel', 'angela@k-plus.com', '094727727');
insert into customer values (9, 'New Line Cosmetics', 4, 'Devonshire Street 92', 'Oliver Cromwell', 'oliver@nlc.org', '093202404');

select * from customer;

insert into product values (1, '330120', 'Game Of Thrones - URBAN DECAY', 'Game Of Thrones Eyeshadow Palette', 65, 122);
insert into product values (2, '330121', 'Advanced Night Repair - ESTEE LAUDER', 'Advanced Night ...', 98, 51);
insert into product values (3, '330122', 'Rose Deep Hydration - FRESH', 'Rose Deep ...', 45, 34);
insert into product values (4, '330123', 'Pore-Perfecting Moisturizer - TATCHA', 'Pore-Perfecting ...', 25, 393);
insert into product values (5, '330124', 'Capture Youth - DIOR', 'Capture ...', 95, 74);
insert into product values (6, '330125', 'Slice of Glow - GLOW RECIPE', 'Slice of ...', 45, 40);
insert into product values (7, '330126', 'Healthy Skin - KIEHLS SINCE 1851', 'Healthy Skin ...', 68, 154);
insert into product values (8, '330127', 'Power Pair! - IT COSMETICS', 'IT is ...', 80, 0);
insert into product values (9, '330128', 'Dewy Skin Mist - TATCHA', 'Limited Edition ...', 20, 281);
insert into product values (10, '330129', 'Silk Pillowcase - SLIP', 'Silk Pillowcase ...', 170, 0);

select * from product;

insert into invoice values (1, 'asad', 7, 4, 1436, '1', '1', '1', null, null);
insert into invoice values (2, 'sgr', 9, 2, 1000, '1', '1', '1', null, null);
insert into invoice values (3, 'tue', 3, 2, 360, '1', '1', '1', null, null);
insert into invoice values (4, 'rtywq', 5, 2, 1675, '1', '1', null, null, null);
insert into invoice values (5, 'qqwe', 6, 2, 9500, '1', '1', null, '1', null);
insert into invoice values (6, 'eqfd', 4, 2, 150, '1', '1', '1', null,'1');

select * from invoice;

insert into invoice_item values (1, 1, 1, 20, 65, 1300);
insert into invoice_item values (2, 1, 7, 2, 68, 136);
insert into invoice_item values (3, 1, 5, 10, 100, 1000);
insert into invoice_item values (4, 3, 10, 2, 180, 360);
insert into invoice_item values (5, 4, 1, 5, 65, 325);
insert into invoice_item values (6, 4, 2, 10, 95, 950);
insert into invoice_item values (7, 4, 5, 4, 100, 400);
insert into invoice_item values (8, 5, 10, 100, 95, 9500);
insert into invoice_item values (9, 6, 4, 6, 25, 150);

select * from invoice_item;

-- 1

-- 2
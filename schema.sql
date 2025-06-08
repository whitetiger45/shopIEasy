drop database ecommercedb;
create database ecommercedb;
use ecommercedb;

drop table if exists authorities;
create table authorities (authorityId int auto_increment, emailId longtext, authorities longtext, primary key(authorityId));

drop table if exists billingAddress;
create table billingAddress (billingAddressId int auto_increment, address longtext, city longtext, state longtext, zipcode longtext, country longtext, primary key(billingAddressId));

drop table if exists cart;
create table cart (cartId int auto_increment, customerId int, cartItem blob, totalPrice double, primary key(cartId));

drop table if exists cartitem;
create table cartitem (cartItemId int auto_increment, quality int, price double, productId int, cartId int, primary key(cartItemId));

drop table if exists customer;
create table customer (customerId int auto_increment, quality int, firstName longtext, lastName longtext, customerPhone longtext, shippingAddressId int, billingAddressId int, userId int, cartId int, primary key(customerId));

drop table if exists customerorder;
create table customerorder (customerOrderId int auto_increment, cartId int, customerId int, shippingAddressId int, billingAddressId int, primary key(customerOrderId));

drop table if exists item;
create table item (Id int auto_increment, category longtext, description longtext, manufacturer longtext, name longtext, price double, unit longtext, image blob, primary key(Id));

drop table if exists query;
create table query (Id int auto_increment, email longtext, subject longtext, message longtext, primary key(Id));

drop table if exists shippingAddress;
create table shippingAddress (shippingAddressId int auto_increment, address longtext, city longtext, state longtext, zipcode longtext, country longtext, primary key(shippingAddressId));

drop table if exists users;
create table users (userId int auto_increment, emailId longtext, password longtext, enabled boolean, primary key(userId));
insert into users values(1, "admin@shopieasy.com","admin",1);
insert into authorities values(1, "admin@shopieasy.com","ROLE_ADMIN");

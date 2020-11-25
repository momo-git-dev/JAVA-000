-- Table user

CREATE TABLE IF NOT EXISTS user

(userId int unsigned not null primary key,

username varchar(32) not null,

address varchar(256) not null,

phone number varchar(64) not null);



-- Table product

CREATE TABLE IF NOT EXISTS product

(productId int unsigned not null primary key,

name varchar(128) not null,

alias varchar(128),

price long not null, -- use long to save price, in Fen rather than in Yuan

discount long);



-- Table order

CREATE TABLE IF NOT EXISTS order

(orderId int unsigned not null primary key,

userId  int unsigned not null,

productId int unsigned not null ,

count long not null, 

price long not null,

discount long);


-- Table inventory

CREATE TABLE IF NOT EXISTS inventory

(inventoryId int unsigned not null primary key,

productId int unsigned not null ,

position varchar(128),

remainingCount long);


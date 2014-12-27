drop database if exists waimai;
create database waimai;
use waimai;
drop table if exists UserInfo;
create table UserInfo(
	userID int not null auto_increment primary key,
    loginName char(20) not null,
    loginPass char(20) not null,
    address char(30) not null,
    telephone char(20) not null,
    photo char(20)
)engine= MyISAM character set utf8;

drop table if exists FoodInfo;
create table FoodInfo(
	foodID int not null auto_increment primary key,
    foodName char(20) not null,
    foodPrice double not null,
    ingredient char(20) not null,
    description char(20),
    soldNum int default 0,
    goodNum int default 0,
    isLeft boolean default true,
    foodImage char(20) not null
)engine= MyISAM character set utf8;


drop table if exists FoodOrderInfo;
create table FoodOrderInfo(
	orderID int not null auto_increment primary key,
    customerName char(20) not null,
    address char(30) not null,
    telephonr char(20) not null,
    allFoodInfo char(50) not null,
    totalPrice double not null,
    wordLeft char(20),
    state char(10) default '已完成'
)engine= MyISAM character set utf8;

insert into UserInfo (loginName,loginPass,address,telephone,photo) 
values ('qwer','qwer','南大','15912341234','safsaf');

insert into FoodInfo (foodName,foodPrice,ingredient,description,soldNum,goodNum,isLeft,foodImage)
values ('酸辣土豆丝','10.00','土豆 青椒','酸辣','0','0','true','500008.jpg');
insert into FoodInfo (foodName,foodPrice,ingredient,description,soldNum,goodNum,isLeft,foodImage)
values ('酸菜鱼','18.00','黑鱼 酸菜','中辣','0','0','true','500023.jpg');
    
    
    

    
    
    

DROP TABLE if exists seckill_order,orders,seckill_goods,goods,user,role,userrole,permission,rolepermission;

create table seckill_order
(
    id bigint(20) auto_increment NOT NULL primary key,
    userId bigint(20) NOT NULL,
    goodId bigint(20) NOT NULL,
    orderId bigint(20) NOT NULL
) ENGINE = InnoDB AUTO_INCREMENT = 100 DEFAULT CHARSET = utf8mb4
    comment 'table for our seckill_order';

create table orders
(
    id bigint(20) NOT NULL primary key,
    userId bigint(20) NOT NULL,
    goodId bigint(20) NOT NULL,
    good_name varchar(20) DEFAULT NULL,
    good_count int(11) DEFAULT '1',
    good_price decimal(10,2) DEFAULT '0.00',
    order_channel tinyint(4) DEFAULT 0 COMMENT '1pc 2android 3ios',
    status tinyint(4) DEFAULT 0 COMMENT '0-new 1-paid 2-delivered 3-recieved 4-refunded 5-completed',
    delivery_addr_id bigint(20) NOT NULL,
    inventory int(11) DEFAULT '0',
    start_date datetime DEFAULT NULL,
    end_date datetime DEFAULT NULL
) ENGINE = InnoDB AUTO_INCREMENT = 100 DEFAULT CHARSET = utf8mb4
    comment 'table for our order';

create table seckill_goods
(
    id bigint(20) NOT NULL primary key,
    goodId bigint(20) DEFAULT NULL,
    seckill_price decimal(10,2) DEFAULT '0.00',
    inventory int(11) DEFAULT '0',
    start_date datetime DEFAULT NULL,
    end_date datetime DEFAULT NULL
) ENGINE = InnoDB AUTO_INCREMENT = 100 DEFAULT CHARSET = utf8mb4
    comment 'table for our seckill_goods';

create table goods
(
    id bigint(20) NOT NULL primary key,
    name varchar(16) DEFAULT NULL,
    title varchar(64) DEFAULT NULL,
    img varchar(64) DEFAULT NULL,
    detail longtext,
    price decimal(10,2) DEFAULT '0.00',
    inventory int(11) DEFAULT '0'
) ENGINE = InnoDB AUTO_INCREMENT = 100 DEFAULT CHARSET = utf8mb4
  comment 'table for our goods';

CREATE TABLE IF NOT EXISTS user (
    id         int auto_increment primary key,
    username   varchar(255)                        not null,
    password   varchar(255)                        not null,
    salt varchar(10) default NULL,
    head varchar(128) default NULL,
    last_login_date datetime DEFAULT NULL,
    login_count int(11) DEFAULT 0,
    created_at timestamp default CURRENT_TIMESTAMP null
    )  ENGINE=INNODB,
        AUTO_INCREMENT = 100 ;

CREATE TABLE IF NOT EXISTS userrole (
    id INT AUTO_INCREMENT PRIMARY KEY,
    userid INT NOT NULL,
    roleid INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    )  ENGINE=INNODB,
    AUTO_INCREMENT = 100 ;

CREATE TABLE IF NOT EXISTS role (
    id INT AUTO_INCREMENT PRIMARY KEY,
    role varchar(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=INNODB,
    AUTO_INCREMENT = 100 ;


CREATE TABLE IF NOT EXISTS rolepermission (
    id INT AUTO_INCREMENT PRIMARY KEY,
    roleid INT NOT NULL,
    permissionid INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)  ENGINE=INNODB,
    AUTO_INCREMENT = 100 ;

CREATE TABLE IF NOT EXISTS permission (
    id INT AUTO_INCREMENT PRIMARY KEY,
    permission varchar(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)  ENGINE=INNODB,
    AUTO_INCREMENT = 100 ;
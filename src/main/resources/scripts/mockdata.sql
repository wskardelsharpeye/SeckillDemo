delete from seckill_goods;
delete from goods;
delete from user;
delete from userrole;
delete from role;
delete from rolepermission;
delete from permission;

INSERT INTO seckill_goods VALUES(100,100,888.88,10,'2021-07-06 00:00:00','2021-07-11 11:59:59');
INSERT INTO seckill_goods VALUES(200,200,1888.88,10,'2021-07-06 00:00:00','2021-07-11 11:59:59');
INSERT INTO goods VALUES (100,'Iphone12 Pro Max','Iphone seckill','/img/seckill/iphone12.img','this is details for seckill Iphone12',1888.88,10);
INSERT INTO goods VALUES (200,'Iphone13 Pro Max','Iphone seckill','/img/seckill/iphone13.img','this is details for seckill Iphone13',2888.88,10);

INSERT INTO user(username,password)
VALUES('trainee', '123'), ('admin','123'), ('supervisor', '123'),('marketing','123'),('inspector','123');

INSERT INTO role(role)
VALUES('trainee'), ('admin'),('supervisor'),('marketing'),('inspector');

INSERT INTO userrole(userid,roleid)
VALUES(100,100),(101,101),(102,102),(103,103),(104,104),(105,105);

INSERT INTO permission(id,permission)
values(100, 'user_read'),(101, 'user_write');

INSERT INTO rolepermission(roleid,permissionid)
VALUES(101,100),(101,101),(102,100),(102,101),(103,100),(104,101)
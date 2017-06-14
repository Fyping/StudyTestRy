CREATE DATABASE personalBlog
CHARACTER SET utf8
COLLATE utf8_general_ci;

use personalBlog;

DROP TABLE IF EXISTS tb_Member;
CREATE TABLE tb_Member
( 
  memberid INT(10) NOT NULL AUTO_INCREMENT
, memberuuid   varchar(255) not null
, username VARCHAR(255) NOT NULL 
, userpwd VARCHAR(255) NOT NULL 
, email VARCHAR(255) NOT NULL 
, phonenum CHAR(11) NOT NULL 
, sex INT(10) NOT NULL 
, realname VARCHAR(255)  NOT NULL 
, address VARCHAR(255) NOT NULL 
, postcode VARCHAR(255) NOT NULL 
, CONSTRAINT PRIMARY KEY ( memberid ) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS tb_User;
CREATE TABLE tb_User
( 
  usrid INT(10) NOT NULL AUTO_INCREMENT
, uip VARCHAR(255) NOT NULL
, CONSTRAINT PRIMARY KEY (usrid) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS tb_Message;
CREATE TABLE tb_Message
( 
  msgid INT(10) NOT NULL AUTO_INCREMENT
, memberid INT(10) NOT NULL references tb_Member(memberid)
, msg text CHARACTER SET utf8 COLLATE utf8_general_ci not null 
, CONSTRAINT PRIMARY KEY (msgid) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TRIGGER IF EXISTS trigger_after_insert_on_tb_tb_Member;
CREATE TRIGGER trigger_after_insert_on_tb_tb_Member
BEFORE INSERT ON tb_Member
FOR EACH ROW
insert into tb_Message (cartuuid,memberid)values(new.memberuuid,memberid);

insert into tb_User(uip)values('127.0.0.1');
insert into tb_Member(memberuuid,memberid) values("fypinguuid",1);
insert into tb_Message(memberid,msg)values(1,'The first message');


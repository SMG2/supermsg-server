CREATE TABLE `tb_push_his` (
	`pushid` VARCHAR (32) NOT NULL,
	`userid` VARCHAR (32) NOT NULL,
	`createtime` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
	`tags` VARCHAR (45) NOT NULL DEFAULT '',
	`isPushToAll` bit NOT NULL COMMENT '���Ϊ���͵�ȫ����Ա����ô����ΪTRUE����1',
	PRIMARY KEY (`pushid`),
	CONSTRAINT `FK_push_user` FOREIGN KEY (`userid`) REFERENCES `user_baseinfo` (`id`) ON DELETE
SET NULL ON UPDATE CASCADE
);


/*CREATE DATABASE db_chat;*/
USE db_chat;

DROP TABLE
IF EXISTS school_info;

CREATE TABLE `school_info` (
	`school_num` VARCHAR (15) NOT NULL,
	`school_name` VARCHAR (50) NOT NULL,
	PRIMARY KEY (`school_num`)
);

DROP TABLE
IF EXISTS user_baseinfo;

CREATE TABLE `user_baseinfo` (
	`id` VARCHAR (32) NOT NULL,
	`school_num` VARCHAR (15) NOT NULL,
	`nation` VARCHAR (10) NOT NULL,
	`st_num` VARCHAR (12) NOT NULL,
	`pwd` VARCHAR (32) NOT NULL,
	`sex` VARCHAR (4) NOT NULL,
	`name` VARCHAR (10) NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `FK_sch_num` FOREIGN KEY (`school_num`) REFERENCES `school_info` (`school_num`)
);

DROP TABLE
IF EXISTS tag;

CREATE TABLE `tag` (
	`tagName` VARCHAR (20) NOT NULL,
	`tagid` VARCHAR (50) NOT NULL,
	PRIMARY KEY (`tagid`)
);

DROP TABLE
IF EXISTS user_tag;

CREATE TABLE `user_tag` (
	`id` VARCHAR (32) NOT NULL,
	`tagid` VARCHAR (50) NOT NULL,
	PRIMARY KEY (`id`, `tagid`),
	CONSTRAINT `FK_tag_bi` FOREIGN KEY (`id`) REFERENCES `user_baseinfo` (`id`)
);
/*CONSISTENT `FK_tag_tag`*/
ALTER TABLE `user_tag` ADD  FOREIGN KEY (`tagid`) REFERENCES `tag` (`tagid`);

DROP TABLE
IF EXISTS user_detailinfo;

CREATE TABLE `user_detailinfo` (
	`id` VARCHAR (32) NOT NULL,
	`class` VARCHAR (20) NOT NULL,
	`college` VARCHAR (20) NOT NULL,
	`major` VARCHAR (30) NOT NULL,
	`grade` VARCHAR (20) NOT NULL,
	`phone` VARCHAR (11) NOT NULL,
	`mail` VARCHAR (50) NOT NULL,
	PRIMARY KEY (`id`)
);

/*'CONSTRAINT `FK_sch_num` FOREIGN KEY (`school_num`,`st_num`) REFERENCES `user_baseinfo` (`school_num`,`st_num`) '*/
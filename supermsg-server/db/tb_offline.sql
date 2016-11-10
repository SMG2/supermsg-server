USE db_chat;

-- Create table --openfire聊天记录
DROP TABLE
IF EXISTS tb_person_msg;

CREATE TABLE tb_person_msg (
	MESSAGEID INT PRIMARY KEY,
	-- 消息id
	SESSIONJID VARCHAR (30),
	-- 用户session jid名称
	SENDER VARCHAR (30),
	-- 消息发送者
	RECEIVER VARCHAR (30),
	-- 接受者    
	CREATEDATE VARCHAR (30),
	-- 消息发送、创建时间
	CONTENT VARCHAR (2000),
	-- 消息内容
	DETAIL VARCHAR (4000) -- 消息源报文
);

DROP TABLE
IF EXISTS tb_group_msg;

CREATE TABLE tb_group_msg (
MESSAGEID INT PRIMARY KEY,
 -- 消息id
SESSIONJID VARCHAR (30),
 -- 用户session jid名称
SENDER VARCHAR (30),
 -- 消息发送者
CREATEDATE VARCHAR (30),
 -- 消息发送、创建时间
CONTENT VARCHAR (2000),
 -- 消息内容
DETAIL VARCHAR (4000) -- 消息源报文
);
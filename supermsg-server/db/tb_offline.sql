USE db_chat;

-- Create table --openfire�����¼
DROP TABLE
IF EXISTS tb_person_msg;

CREATE TABLE tb_person_msg (
	MESSAGEID INT PRIMARY KEY,
	-- ��Ϣid
	SESSIONJID VARCHAR (30),
	-- �û�session jid����
	SENDER VARCHAR (30),
	-- ��Ϣ������
	RECEIVER VARCHAR (30),
	-- ������    
	CREATEDATE VARCHAR (30),
	-- ��Ϣ���͡�����ʱ��
	CONTENT VARCHAR (2000),
	-- ��Ϣ����
	DETAIL VARCHAR (4000) -- ��ϢԴ����
);

DROP TABLE
IF EXISTS tb_group_msg;

CREATE TABLE tb_group_msg (
MESSAGEID INT PRIMARY KEY,
 -- ��Ϣid
SESSIONJID VARCHAR (30),
 -- �û�session jid����
SENDER VARCHAR (30),
 -- ��Ϣ������
CREATEDATE VARCHAR (30),
 -- ��Ϣ���͡�����ʱ��
CONTENT VARCHAR (2000),
 -- ��Ϣ����
DETAIL VARCHAR (4000) -- ��ϢԴ����
);
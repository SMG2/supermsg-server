USE db_chat;

-- Create table --openfire�����¼
DROP TABLE
IF EXISTS offLine_msg;

CREATE TABLE offLine_msg (
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
	LENGTH INT,
	-- ��Ϣ���ȡ���С
	CONTENT VARCHAR (2000),
	-- ��Ϣ����
	DETAIL VARCHAR (4000),
	-- ��ϢԴ����
	STATE INT -- ɾ��״̬��1��ʾɾ��
);


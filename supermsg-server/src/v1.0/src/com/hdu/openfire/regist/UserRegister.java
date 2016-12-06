package com.hdu.openfire.regist;

import org.jivesoftware.smack.AccountManager;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

import com.hdu.openfire.conf.SMKProperties;

/**
 * @author zhuxin
 * 在openfire中注册用户
 */
public class UserRegister {
	
	/**
	 * 注册
	 * @param id
	 * @param pwd
	 * @return
	 */
	public boolean regist(String id,String pwd){
		ConnectionConfiguration config = new ConnectionConfiguration(SMKProperties.HOST, SMKProperties.PORT);
		XMPPConnection connection = new XMPPConnection(config);
		try {
			connection.connect();
		} catch (XMPPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		AccountManager manager = new AccountManager(connection);
		
		try {
			manager.createAccount(id, pwd);
			return true;
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				manager.deleteAccount();
			} catch (XMPPException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
	}

}

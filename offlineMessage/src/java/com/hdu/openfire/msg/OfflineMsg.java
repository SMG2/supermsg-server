package com.hdu.openfire.msg;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jivesoftware.openfire.XMPPServer;
import org.jivesoftware.openfire.container.Plugin;
import org.jivesoftware.openfire.container.PluginManager;
import org.jivesoftware.openfire.interceptor.PacketInterceptor;
import org.jivesoftware.openfire.interceptor.PacketRejectedException;
import org.jivesoftware.openfire.session.Session;
import org.jivesoftware.openfire.user.UserManager;
import org.xmpp.packet.JID;
import org.xmpp.packet.Message;
import org.xmpp.packet.Packet;
import org.xmpp.packet.Presence;

import com.hdu.openfire.dao.PersonMsgDAO;
import com.hdu.openfire.jedis.pool.JedisPoolTool;

import redis.clients.jedis.Jedis;

public class OfflineMsg implements Plugin,PacketInterceptor{
	
	private PersonMsgDAO PersonMsgDAO = new PersonMsgDAO();
	private JedisPoolTool pool = JedisPoolTool.getInstance();
	private Jedis jedis = null;
	private DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Override
	public void initializePlugin(PluginManager manager, File pluginDirectory) {
		// TODO Auto-generated method stub
		System.out.println("offlinemsg plugin initialized.");
		
	}

	@Override
	public void destroyPlugin() {
		// TODO Auto-generated method stub
		
	}

	@Override
    public void interceptPacket(Packet packet, Session session, boolean incoming, boolean processed) throws PacketRejectedException {
        
        JID recipient = packet.getTo();
        if (recipient != null) {
            String username = recipient.getNode();
            
            if (username == null || !UserManager.getInstance().isRegisteredUser(recipient)) {
                return;
            } else if (!XMPPServer.getInstance().getServerInfo().getXMPPDomain().equals(recipient.getDomain())) {
                
                return;
            } else if ("".equals(recipient.getResource())) {
            }
        }
        this.doAction(packet, incoming, processed, session);
    }
	

    private void doAction(Packet packet, boolean incoming, boolean processed, Session session) {
        Packet copyPacket = packet.createCopy();
        System.out.println("*********************************************************************************");
        if (packet instanceof org.xmpp.packet.Message) {
            Message message = (Message) copyPacket;
            
            
           //p2p
            if (message.getType() == Message.Type.chat) {
            	String msgid = message.getID();
            	JID sessionid = session.getAddress();
            	JID from = message.getFrom();
            	JID to = message.getTo();
                PersonMsgDAO.addp2p(msgid, sessionid.toFullJID(), from.toFullJID(), to.toFullJID(), 
                		format.format(new Date()), message.getBody(), message.toXML());
            	
            	
               
//                logsManager.add(this.get(packet, incoming, session));
                
            //p2g
            } else if (message.getType() ==  Message.Type.groupchat) {
                List<?> els = message.getElement().elements("x");
                if (els != null && !els.isEmpty()) {
                	
                    System.out.println(message.toXML());
                } else {
                	
                	System.out.println("xitong xiao xi:"+message.toXML());
                }
                
	        } 
        }else if (packet instanceof Presence) {
            Presence presence = (Presence) copyPacket;
            if (presence.getType() == Presence.Type.unavailable) {
            	//offline
            	JID from = presence.getFrom();
            	storeInRedis(from.toFullJID(), format.format(new Date()));
            }
	     } 
    }
    
    private void storeInRedis(String userid,String dateTime){
    	if(jedis == null)
    		jedis = pool.getJedis();
    	Map<String, String> map = new HashMap<String, String>();
		map.put("offLineTime", dateTime);
		jedis.hmset("user_"+userid,map);
    }

}

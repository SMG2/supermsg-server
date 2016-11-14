package com.hdu.openfire.msg;

import java.io.File;

import org.jivesoftware.openfire.container.Plugin;
import org.jivesoftware.openfire.container.PluginManager;
import org.jivesoftware.openfire.interceptor.InterceptorManager;

import com.hdu.openfire.interceptor.ZxInterceptor;

public class OfflineMsg implements Plugin{

	private static ZxInterceptor interceptor = null;
	private static InterceptorManager InterceptorManager = null;
	
	@Override
	public void initializePlugin(PluginManager manager, File pluginDirectory) {
		
		if(interceptor == null)
			interceptor = new ZxInterceptor();
		
		if(InterceptorManager ==null)
			InterceptorManager = org.jivesoftware.openfire.interceptor.InterceptorManager.getInstance();
		InterceptorManager.addInterceptor(interceptor);
		System.out.println("-----------------------------------------------------------------------------");
		
		
		System.out.println("offlinemsg plugin initialized.");
		
	}

	@Override
	public void destroyPlugin() {
		if(InterceptorManager != null)
			InterceptorManager.removeInterceptor(interceptor);
		
	}

}

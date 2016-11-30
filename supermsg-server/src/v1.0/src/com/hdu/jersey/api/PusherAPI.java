package com.hdu.jersey.api;

import com.hdu.jersey.model.PusherModel;

public interface PusherAPI {
	
	public String pushAllDev(PusherModel model);
	
	public String pushByTags(PusherModel model);

}

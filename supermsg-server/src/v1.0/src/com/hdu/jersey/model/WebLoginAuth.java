package com.hdu.jersey.model;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author F-zx
 * @date 2016.12.9
 * 
 * ÍøÒ³¶ËÑéÖ¤µÄmodel
 */
@XmlRootElement
public class WebLoginAuth {
	@FormParam("pwd")
	private String pwd;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}

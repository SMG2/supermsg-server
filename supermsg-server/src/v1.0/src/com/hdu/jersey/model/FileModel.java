package com.hdu.jersey.model;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author F-zx
 *	文件上传model，用于文件上传以及创建
 */
@XmlRootElement
public class FileModel {
	
	@FormParam("content")
	private String fileContent;

	public String getFileContent() {
		return fileContent;
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
	

}

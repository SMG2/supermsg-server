package com.hdu.jersey.model;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author F-zx
 *	�ļ��ϴ�model�������ļ��ϴ��Լ�����
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

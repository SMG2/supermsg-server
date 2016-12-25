package com.hdu.jersey.api.deprecated;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.FileUtils;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;

import net.sf.json.JSONObject;

@Path("/images")
public class Images {

	private final static String ROOT_IMAGE_DIR = "e://resources/";
	private final static String IMAGE_TYPE = ".jpg";
	private final static String URL_PREFIX = "http://www.zlpix.top/resources/images/";
	
    /** 
     * * 
     * 第二种方式上传 使用FormDataMultiPart 获取表单数据 
     * 
     * @param form 
     * @param response 
     * @return 
     * @throws UnsupportedEncodingException 
     */  
    @POST  
    @Path("/upload")  
    @Consumes(MediaType.MULTIPART_FORM_DATA)  
    @Produces(MediaType.TEXT_PLAIN)  
    public String upload(FormDataMultiPart form) {  
	    //获取文件流  
	    FormDataBodyPart filePart = form.getField("image");  
		JSONObject object = new JSONObject();
 
	    InputStream fileInputStream = filePart.getValueAs(InputStream.class);  
	    
	    String fn = String.valueOf(System.currentTimeMillis()); 
	  
	    String filePath = ROOT_IMAGE_DIR + fn + IMAGE_TYPE;  
	    File file = new File(filePath);  
	    System.out.println("file " + file.getAbsolutePath());  
	    try {  
	        //保存文件  
	        FileUtils.copyInputStreamToFile(fileInputStream, file);  
			object.accumulate("url", URL_PREFIX + fn + IMAGE_TYPE);
			object.accumulate("status", "SUCCESS");
	    } catch (IOException ex) {  
	    	System.out.println("updload images error."); 
			object.accumulate("url", "null");
			object.accumulate("status", "FAILED");
	    }  
	    
//	    response.setCharacterEncoding("UTF-8");  
	    
	    return object.toString();  
    }  

}

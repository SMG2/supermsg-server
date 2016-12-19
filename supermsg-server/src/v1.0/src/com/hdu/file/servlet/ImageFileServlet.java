package com.hdu.file.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import net.sf.json.JSONObject;

/**
 * @author F-zx
 * 		image文件的上传servlet
 *
 */
public class ImageFileServlet extends HttpServlet {


	private final static String ROOT_IMAGE_DIR = "/data/wwwroot/www.zlpix.top/resources/images/";
	private final static String IMAGE_TYPE = ".jpg";
	private final static String URL_PREFIX = "http://www.zlpix.top/resources/images/";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8950944519110199562L;
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws UnsupportedEncodingException  {
		request.setCharacterEncoding("utf-8"); 
		PrintWriter pout = null;
		try {
			pout = resp.getWriter();
		} catch (IOException e1) {
			e1.printStackTrace();
		}


		JSONObject object = new JSONObject();
        
        //获得磁盘文件条目工厂  
        DiskFileItemFactory factory = new DiskFileItemFactory();  
        //获取文件需要上传到的路径  
        String path = request.getSession().getServletContext().getRealPath("/temp") ;  
        System.out.println(path);

        factory.setRepository(new File(path));  
        //设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室  
        factory.setSizeThreshold(1024*1024) ;  
          
        //高水平的API文件上传处理  
        ServletFileUpload upload = new ServletFileUpload(factory);  
        String fn = String.valueOf(System.currentTimeMillis()); 
        String filename = fn + IMAGE_TYPE;  
          
        try {  
            //可以上传多个文件  
            @SuppressWarnings("unchecked")
			List<FileItem> list = (List<FileItem>)upload.parseRequest(request);  
            
            
            for(FileItem item : list){
                  
            	//判断是否为文件
            	if(!item.isFormField()){ 
                    OutputStream out = new FileOutputStream(new File(ROOT_IMAGE_DIR,filename));  
                      
                    InputStream in = item.getInputStream() ;  
                      
                    int length = 0 ;  
                    byte [] buf = new byte[1024] ;  
                      
                    System.out.println("获取上传文件的总共的容量："+item.getSize());  
   
                    while( (length = in.read(buf) ) != -1)  
                    {  
                        //在   buf 数组中 取出数据 写到 （输出流）磁盘上  
                        out.write(buf, 0, length);  
                    }  
                      
                    in.close();  
                    out.close();  
                    
        			setResponse(object, true, fn);
            	}else{
            		setResponse(object,false,null);
            	}
            }  
              
        } catch (FileUploadException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
    		setResponse(object,false,null);
        }  
        catch (Exception e) {  
            e.printStackTrace(); 
    		setResponse(object,false,null);
        }  
          
        //修改文件访问权限
        File file = new File(ROOT_IMAGE_DIR,filename);
        file.setReadable(true, false);
        pout.write(object.toString());
        pout.close();
        
        
        try {
			resp.sendRedirect("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void setResponse(JSONObject object,boolean isSuccess,String fn){
		if(isSuccess){
			object.accumulate("url", URL_PREFIX + fn + IMAGE_TYPE);
			object.accumulate("status", "SUCCESS");
		}else{
			System.out.println("updload images error."); 
			object.accumulate("url", "null");
			object.accumulate("status", "FAILED");
		}
	
	}
	
	
	

}

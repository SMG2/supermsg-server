package com.hdu.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author F-zx
 * �ļ��洢��
 */
public class FileSaver {
	
	private final static String FILE_SUFFIX = ".html";
//	private final static String FILE_SURFIX = "e://sources/notice/"; // /data/wwwroot/www.zlpix.top/resources/notice/
	private final static String FILE_SURFIX = "/data/wwwroot/www.zlpix.top/resources/notice/";
	private static FileWriter fw = null;
	
	
	/**
	 * @param content �ļ����ݣ�html��ҳ
	 * @return ʧ�ܷ���null
	 */
	public static String save(String content){
		long timestamp = System.currentTimeMillis();
		
		String fileName = FILE_SURFIX+String.valueOf(timestamp)+FILE_SUFFIX;
		
		File file = new File(fileName);
		
		try {
			fw = new FileWriter(file);
			//д�ļ�
			fw.write(content);
			file.setReadable(true, false);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return String.valueOf(timestamp)+FILE_SUFFIX;
	}
	
	public static void main(String[] args) throws URISyntaxException, IOException {
		File file = new File(new URI("http://www.zlpix.top"));
		FileReader reader = new FileReader(file);
		
		BufferedReader br = new BufferedReader(reader);
		String line = "";
		while((line = br.readLine()) != null)
			System.out.println(line);;
			br.close();
	}

}

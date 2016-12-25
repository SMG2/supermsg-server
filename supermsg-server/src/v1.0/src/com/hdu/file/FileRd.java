package com.hdu.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author F-zx
 *	文件读入类
 */
public class FileRd {

	private static File file;
	private static BufferedReader br;
	private static StringBuffer buffer;
	private static String line;
	
	/**
	 * @param fileName 文件名称
	 * @return 成功则返回该文件的内容，失败返回null
	 */
	public static String getFileContent(String fileName){
		file = new File(fileName);
		try {
			br = new BufferedReader(
					new FileReader(file));
			
		buffer = new StringBuffer();
		while((line = br.readLine())!=null)
			buffer.append(line);
			
		} catch (IOException e) {
			return null;
		} 
		
		return buffer.toString();
	}
}

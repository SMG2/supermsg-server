package com.hdu.jersey.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/*
BASE64�ļ��ܽ�����˫��ģ������󷴽�.
BASE64Encoder��BASE64Decoder�Ƿǹٷ�JDKʵ���ࡣ��Ȼ������JDK�����ҵ���ʹ�ã�������API��鲻����
JRE �� sun �� com.sun ��ͷ�����඼��δ���ĵ����ģ��������� java, javax ���Ļ��������е�ʵ�ִ������ײ�ƽ̨�йأ�
һ����˵�ǲ��Ƽ�ʹ�õġ� 
BASE64 �ϸ��˵�����ڱ����ʽ�����Ǽ����㷨 
��Ҫ����BASE64Encoder��BASE64Decoder�����࣬����ֻ��Ҫ֪��ʹ�ö�Ӧ�ķ������ɡ�
��BASE���ܺ�������ֽ�λ����8�ı������������λ����=������䡣 
BASE64 
����RFC2045�Ķ��壬Base64������Ϊ��Base64���ݴ��ͱ��뱻����������������е�8λ�ֽ�����Ϊһ�ֲ��ױ���ֱ��ʶ�����ʽ��
��The Base64 Content-Transfer-Encoding is designed to represent arbitrary sequences of octets in a form that need not be humanly readable.�� 
�������ʼ���http���ܣ���ȡhttp��Ϣ����ͻᷢ�ֵ�¼�������û����������ֶ�ͨ��BASE64���ܵġ�
*/


public class BASE64 {
    /**  
     * BASE64����  
     *   
     * @param key  
     * @return  
     * @throws Exception  
     */  
    public static byte[] decryptBASE64(String key) throws Exception {   
        return (new BASE64Decoder()).decodeBuffer(key);   
    }   
      
    /**  
     * BASE64����  
     *   
     * @param key  
     * @return  
     * @throws Exception  
     */  
    public static String encryptBASE64(byte[] key) throws Exception {   
        return (new BASE64Encoder()).encodeBuffer(key);   
    }  

}
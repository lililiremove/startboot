package com.startboot.dev.common;

import org.apache.commons.lang.StringUtils;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.security.MessageDigest;
import java.util.Base64;

public class EncryptUtil {
	
	/**
	 * MD5+base64加密文件获取值
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "restriction", "unused", "finally" }) 
	public  static String getMd5Digist(File file) {
		InputStream is = null;
		String encode = "";
		try {
			is = new FileInputStream(file);
			char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
			byte[] bytes = new byte[1024];  
			 int len = 0;       
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			while ((len = is.read(bytes)) > 0) {  
				 mdInst.update(bytes, 0, len);  
			} 
			// 获得密文
			byte[] md = mdInst.digest();
			BASE64Encoder encoder = new BASE64Encoder();
			encode = encoder.encode(md);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return encode;
		}
	}
	
	
	 /**
     * 将文件base64加密
     * @param file
     * @return
     */
    @SuppressWarnings("resource")
    public static String encodeBase64File(File file) {
    	String encode = "";
    	try {
			if(file == null || !file.exists()) {
				return encode;
			}
			InputStream is = new FileInputStream(file);
			byte[] data = new byte[is.available()];
			is.read(data);
			encode = Base64.getEncoder().encodeToString(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return encode;
    }
    
    /**
     * base64解密文件
     * @param decode
     */
    public static File decodeBase64File(String decode,String path) {
    	File f = null;
    	try {
			if(StringUtils.isBlank(decode) || StringUtils.isBlank(path)) {
				return f;
			}
			byte[] bs = Base64.getDecoder().decode(decode);
			f = new File(path);
			if(f.exists()) {
				f.delete();
			}
			f.createNewFile();
			OutputStream os  = new FileOutputStream(f);
			os.write(bs);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return f;
    }
	
	
}

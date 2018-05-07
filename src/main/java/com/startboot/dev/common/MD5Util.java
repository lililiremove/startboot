package com.startboot.dev.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	public static String getMd5(String inStr) {
		String outStr = null;
		if (inStr == null) {
			outStr = null;
		} else if ("".equals(inStr)) {
			outStr = "";
		} else {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(inStr.getBytes());
				byte b[] = md.digest();
				StringBuffer buf = new StringBuffer();
				for (int i = 1; i < b.length; i++) {
					int c = b[i] >>> 4 & 0xf;
					buf.append(Integer.toHexString(c));
					c = b[i] & 0xf;
					buf.append(Integer.toHexString(c));
				}
				outStr = buf.toString();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		return outStr;
	}
}

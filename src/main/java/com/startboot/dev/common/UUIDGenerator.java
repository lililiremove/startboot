package com.startboot.dev.common;

import java.util.Random;
import java.util.UUID;

public class UUIDGenerator {
	public UUIDGenerator() {   
    } 
	/**
	 * 根据num获取uuid 最大可以获取32
	 * @param num
	 * @return
	 */
    public static String getUUID(Integer num) {   
        UUID uuid = UUID.randomUUID();   
        String str = uuid.toString();   
        str=str.replaceAll("-", "");
        StringBuffer sb = new StringBuffer(); 
        if (num<=str.length()) {
        	Random random = new Random();     
            for (int i = 0; i < num; i++) {     
                int number = random.nextInt(str.length());     
                sb.append(str.charAt(number));     
            }     
        } else {
        	 sb.append(str);   
        }
        return sb.toString();  
    }   
    
    public static void main(String[] args) {   
        for (int i = 0; i < 10; i++) {   
        	System.out.println(getUUID(32));   
        }   
    }   
}

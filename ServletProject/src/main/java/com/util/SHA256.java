package com.util;

import java.security.MessageDigest;
import java.util.Random;

public class SHA256 {
	public static String getSalt() {
	     Random random = new Random();     
	     byte[] salt = new byte[10];

	     random.nextBytes(salt);     

	     StringBuffer sb = new StringBuffer();

	     for(int i=0; i<salt.length; i++) {
	     	sb.append(String.format("%02x", salt[i]));
	     }     

	     return sb.toString();
	  }  
 
	  public static String getEncrypt(String pwd, String salt) {
		    String result = "";
	      byte[] bytes = (pwd+salt).getBytes();
	      try {
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        md.update(bytes);

	        byte[] b = md.digest();
	  
	        StringBuffer sb = new StringBuffer();
        
	    	for(byte data : b) {
				sb.append(Integer.toString(data & 0xff, 16));
			}

	        result = sb.toString();

	     } catch (Exception e) {
	    	 e.printStackTrace();
	     }

	     return result;
	  }
	

}

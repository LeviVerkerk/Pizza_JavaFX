package Encryption;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5_method {
	public static String encodeMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);
			while(hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
	
}

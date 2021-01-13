package Encryption;

import lib.BCrypt;

public class BCrypt_method {
	public static String toBCrypt(String input) {
		String hashed = BCrypt.hashpw(input, BCrypt.gensalt());
		
		return hashed;
		}


public static boolean checkpass(String input, String check) {
	return BCrypt.checkpw(input, check);
	
}


}
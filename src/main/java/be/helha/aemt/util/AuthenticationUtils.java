package be.helha.aemt.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class AuthenticationUtils {

	/**
	 * Retourne une chaine de caractère encodée en SHA-256
	 * @param password - la chaîne de caractère à encoder 
	 * @return une chaine de caractère encodée en SHA-256
	 * @throws UnsupportedEncodingException si l'UTF8 n'est pas supporté par le système 
	 * @throws NoSuchAlgorithmException si SHA-256 n'est pas supporté par le système
	 */
	public static String encodeSHA256(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password.getBytes("UTF-8"));
        byte[] digest = md.digest();
        
        return DatatypeConverter.printBase64Binary(digest).toString();
    }
}

package be.helha.aemt.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class AuthenticationUtils {

	/**
	 * Retourne une chaine de caract�re encod�e en SHA-256
	 * @param password - la cha�ne de caract�re � encoder 
	 * @return une chaine de caract�re encod�e en SHA-256
	 * @throws UnsupportedEncodingException si l'UTF8 n'est pas support� par le syst�me 
	 * @throws NoSuchAlgorithmException si SHA-256 n'est pas support� par le syst�me
	 */
	public static String encodeSHA256(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password.getBytes("UTF-8"));
        byte[] digest = md.digest();
        
        return DatatypeConverter.printBase64Binary(digest).toString();
    }
}

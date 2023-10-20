package Modelo;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import Vista.VRegistro;

public class Encriptacion {
    
//    VRegistro vRegistro = new VRegistro();

	private String key = "oFWP1a1mChuKipd6o1SapG2IwafamV5Ihu1QIVLI1SU=";

//    public Encriptacion(){
//    }
	
    	// Clave encriptar/Des-encriptar
	public SecretKeySpec crearClave(String llave){
		try {
			byte[] cadena = llave.getBytes("UTF-8");
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
			cadena = messageDigest.digest(cadena);
			cadena = Arrays.copyOf(cadena, 16);
			SecretKeySpec secretKeySpec = new SecretKeySpec(cadena, "AES");
			return secretKeySpec;
		} catch (Exception e) {
			return null;
		}
	}

	// Encriptar
	public String encriptar(String encriptar){
		try {
			SecretKeySpec secretKeySpec = crearClave(key);
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

			byte[] cadena = encriptar.getBytes("UTF-8");
			byte[] encriptada = cipher.doFinal(cadena);

            String encript = Base64.getEncoder().encodeToString(encriptada);
            return encript;
		} catch (Exception e) {
			System.out.println(e);
			return "";
		}
	}

    // Desencriptar
    public String desencriptar(String desencriptar){
		try {
			SecretKeySpec secretKeySpec = crearClave(key);
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

			byte[] cadena = Base64.getDecoder().decode(desencriptar);
			byte[] desencriptada = cipher.doFinal(cadena);

            String desencript = new String(desencriptada);
            return desencript;
		} catch (Exception e) {
			System.out.println(e);
			return "";
		}
	}

}

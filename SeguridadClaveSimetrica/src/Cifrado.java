/**
 * 
 */


import java.security.spec.KeySpec;
import java.security.spec.AlgorithmParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.util.Calendar;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.io.UnsupportedEncodingException;
import java.io.IOException;

/**
 * @author INDRA Sistemas
 *
 */
public class Cifrado {
	Cipher ecipher;
    Cipher dcipher;

	public static void main(String[] args) {
		
		String cadena = "123456";
		System.out.println("Cipher Algorithms: " + Security.getAlgorithms("cipher"));
		
		Cifrado e = new Cifrado("ediag");
		String res = e.encrypt(cadena);
		//System.out.println("Encrypt devuelve: "+res);
		String cadena2 = e.decrypt(res);	
		/*System.out.println("Decrypt devuelve: "+cadena2);
		System.out.println("Fecha hoy: "+ Calendar.getInstance().getTime());*/
	}
    
    public Cifrado(String passPhrase) {

        // 8-bytes Salt
        byte[] salt = {
            (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
            (byte) 0x56, (byte) 0x34, (byte) 0xE3, (byte) 0x03
        };

        // Iteration count
        int iterationCount = 19;

        try {

            KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), salt, iterationCount);
            SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
           
            ecipher = Cipher.getInstance(key.getAlgorithm());
            dcipher = Cipher.getInstance(key.getAlgorithm());

            //System.out.println("Algoritmo: "+key.getAlgorithm());
            
            // Prepare the parameters to the cipthers
            AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);

            ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
            dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);

        } catch (InvalidAlgorithmParameterException e) {
            System.out.println("EXCEPTION: InvalidAlgorithmParameterException");
        } catch (InvalidKeySpecException e) {
            System.out.println("EXCEPTION: InvalidKeySpecException");
        } catch (NoSuchPaddingException e) {
            System.out.println("EXCEPTION: NoSuchPaddingException");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("EXCEPTION: NoSuchAlgorithmException");
        } catch (InvalidKeyException e) {
            System.out.println("EXCEPTION: InvalidKeyException");
        }
    }

	public String encrypt(String str) {
        try {
            // Encode the string into bytes using utf-8
        	/*System.out.println("Entra en el metodo encrypt");
        	System.out.println("La cadena que recibe encrypt es: "+str);*/
            byte[] utf8 = str.getBytes("UTF8");

            // Encrypt
            byte[] enc = ecipher.doFinal(utf8);
            
            
            // Encode bytes to base64 to get a string
            return new sun.misc.BASE64Encoder().encode(enc);

        } catch (BadPaddingException e) {
        } catch (IllegalBlockSizeException e) {
        } catch (UnsupportedEncodingException e) {
        } catch (Exception e) {
        }
        return null;
    }


    public String decrypt(String str) {

        try {

        	/*System.out.println("Entra en el metodo decrypt");
        	System.out.println("La cadena que recibe decrypt es: "+str);*/
            // Decode base64 to get bytes
            byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);

            // Decrypt
            byte[] utf8 = dcipher.doFinal(dec);
            
            /*System.out.println(utf8);
            System.out.println(new String(utf8, "UTF8"));*/

            // Decode using utf-8
            return new String(utf8, "UTF8");

        } catch (BadPaddingException e) {
        } catch (IllegalBlockSizeException e) {
        } catch (UnsupportedEncodingException e) {
        } catch (IOException e) {
        }
        return null;
    }
}

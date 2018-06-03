package encrypt.kisa.aria;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ARIATest {
	Logger logger = LoggerFactory.getLogger(ARIATest.class);
	
	@Test
	public void ariaEncryptTest() {
		/***given***/
		String plainText = "password";
		logger.debug("{}", "plainText :" + plainText);
		
		try {
			String encryptText = ARIAUtil.ariaEncrypt(plainText);
			logger.debug("{}", "encryptText :" + encryptText);
			
			String decryptText = ARIAUtil.ariaDecrypt(encryptText);
			logger.debug("{}", "decryptText : " + decryptText);
			
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		/***when***/

		/***then***/
		
	}


}

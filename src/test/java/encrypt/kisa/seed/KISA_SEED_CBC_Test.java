package encrypt.kisa.seed;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KISA_SEED_CBC_Test {

	Logger logger = LoggerFactory.getLogger(KISA_SEED_CBC_Test.class);

	@Test
	public void seedEncryptTest() {
		/*** given ***/

		String plainText = "password";
		String encryptText;
		String decryptText;
		logger.debug("{}", "plainText : " + plainText);
		

		/*** when ***/
		encryptText = KISA_SEED_CBC.Encrypt(plainText);
		logger.debug("{}", "encryptText : " + encryptText);
		
		decryptText = KISA_SEED_CBC.Decrypt(encryptText);
		System.out.println("decryptText : " + decryptText);

		/*** then ***/
		assertEquals(plainText, decryptText);
	}
}
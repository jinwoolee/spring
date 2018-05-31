package encrypt;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EncryptTest {
	Logger logger = LoggerFactory.getLogger(EncryptTest.class);

	@Test
	public void encryptTest() throws Exception {
		/***given***/
		String originalText = "plain text";
		String key = "key";
		
		/***when***/
		String en = SecurityUtil.Encrypt(originalText, key);
		String de = SecurityUtil.Decrypt(en, key);
		
		String en2 = SecurityUtil.Encrypt(originalText, "saltKey");
		
		/***then***/
		assertEquals(originalText, de);
		assertNotEquals(en, en2);
	}
	
	@Test
	public void encryptSHA256Test() {
		/***given***/
		String originalText = "plain text";
		
		/***when***/
		String en = SecurityUtil.encryptSHA256(originalText);
		logger.debug("{}", originalText + " / " + en);
		
		/***then***/
		assertNotEquals(originalText, en);
	}
	

}

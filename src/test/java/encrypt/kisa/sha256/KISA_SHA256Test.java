package encrypt.kisa.sha256;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KISA_SHA256Test {
	Logger logger = LoggerFactory.getLogger(KISA_SHA256Test.class);

	@Test
	public void kisaSha256Test() throws UnsupportedEncodingException {
		/***given***/
		String plainText = "password2";
		StringBuffer encryptStringBuffer = new StringBuffer();
		byte[] encryptByte = new byte[32];	
				
		/***when***/
		KISA_SHA256.SHA256_Encrpyt(plainText.getBytes(), plainText.getBytes().length, encryptByte);
		
		/***then***/
		for (int i=0; i<32; i++)
			encryptStringBuffer.append(Integer.toHexString(0xff&encryptByte[i]));
			
		logger.debug("{}", encryptStringBuffer.toString());
		//password : 5e884898da2847151d0e56f8dc6292773603dd6aabbdd62a11ef721d1542d8
		//password2 : 6cf615d5bcaac778352a8f1f3360d23f2f34ec182e259897fd6ce485d7870d4
	}
	
	@Test
	public void kisaSha256EncryptTest() throws UnsupportedEncodingException {
		/***given***/
		String plainText = "password";
				
		/***when***/
		String encryptText = KISA_SHA256.encrypt(plainText);
		
		/***then***/		
		logger.debug("{}", encryptText);
		assertEquals("5e884898da2847151d0e56f8dc6292773603dd6aabbdd62a11ef721d1542d8", encryptText);
	
	}
}


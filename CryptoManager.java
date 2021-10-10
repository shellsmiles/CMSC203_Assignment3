


public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	
	//Check if the string plainText is valid 
	public static boolean stringInBounds (String plainText) {
		//throw new RuntimeException("method not implemented");
		
		char character ;
		for (int i=0; i< plainText.length(); i++)
		{	
			character = plainText.charAt(i);
			if ((character < LOWER_BOUND)|| (character > UPPER_BOUND))
				return false;
			
		}
		return true;
	}
	

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	//Encrypt a String plainText with a key according to Caesar Cipher.
	public static String encryptCaesar(String plainText, int key) {
		//throw new RuntimeException("method not implemented");
		String encryptedText= "";
		final int MAX= (int)UPPER_BOUND;
		char character ;
		int encryptedCode=0;
		
		
		for (int i=0; i< plainText.length(); i++)
		{	
			character = plainText.charAt(i);
			int intL= (int)character ;
			int newK= intL + key;
			
			while (newK > MAX)
				{ encryptedCode= newK- RANGE;
				  newK-= RANGE;
				}
			char encryptedLetter= (char)newK;
			encryptedText += encryptedLetter;
		}
		return encryptedText;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	//Decrypt a encryptedText with a key to originalText according to Caesar Cipher
	public static String decryptCaesar(String encryptedText, int key) {
		//throw new RuntimeException("method not implemented");
		final int MAX= (int)UPPER_BOUND;
		final int MIN= (int) LOWER_BOUND;
		int encryptedCode ;
		String decryptedText="";
		char character = 0 ;
		
		for (int i=0; i< encryptedText.length(); i++)
		{	
			character = encryptedText.charAt(i);
			int intL= (int)character ;
			int newK= intL - key;
			
			while (newK < MIN)
				{encryptedCode = newK+ RANGE;
				 newK+= RANGE;
				}
			char decryptedLetter= (char)newK;
			decryptedText += decryptedLetter;
			
		} 
		return decryptedText;
	}
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	//Encrypt a String plainText with a string bellasoStr according the Bellaso Cipher
	public static String encryptBellaso(String plainText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
		final int MAX= (int)UPPER_BOUND;
		final int MIN= (int) LOWER_BOUND;
		char character;
		char l ;
		int encryptedCode=0;
		char encryptedL;
		String encryptedStr="";
		String text="";
		String text1="";
		String text0="";
		
		
		if (plainText.length() < bellasoStr.length())
		{
			for (int i=0; i< plainText.length(); i++)
			{	character= bellasoStr.charAt(i);
				text += character;
			}
			System.out.println(text);
		}
		
		else
		{	
			int x= plainText.length() / bellasoStr.length();
			int y= plainText.length() % bellasoStr.length();
			
			for (int i=0; i< x; i++) {
				for (int k=0; k< bellasoStr.length(); k++) {
					l= bellasoStr.charAt(k);
					text1 += l;}
			}	
			
			for (int i=0; i< y; i++) {	
				l= bellasoStr.charAt(i);
				text0 += l;
			}
			
			text1 += text0;
		}
		
		for(int i=0; i< text1.length();i++)	
		{
			int intCharText= (int)text1.charAt(i);//CMSCCMS 
			int intCharPT= (int)plainText.charAt(i);//ABCDEF
			int x= intCharText + intCharPT;
			
			if (x < MAX && x> MIN )
				encryptedCode= intCharText + intCharPT;
			
			while (x> MAX)
			{
				encryptedCode= x- RANGE;
				x -= RANGE;
			}
			
			encryptedL= (char)encryptedCode;
			encryptedStr +=encryptedL;
		}
		return encryptedStr;
	}
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	// Decrypt a encryptedText with a string bellasoStr according the Bellaso Cipher.
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
		
		char encryptedL;
		char l;
		int oiginalCode=0;
		String encryptedBellaso = "";
		final int MAX= (int)UPPER_BOUND;
		final int MIN= (int) LOWER_BOUND;
		char originalL;
		String originalText="";
		String text= "";
		String text1="";
		String text0="";
		
		if (encryptedText.length() < bellasoStr.length())
		{
			for (int i=0; i< encryptedText.length(); i++)
			{	char character = bellasoStr.charAt(i);
				text += character;
			}
			System.out.println(text);
		}
		else
		{	
			int x= encryptedText.length() / bellasoStr.length();
			int y= encryptedText.length() % bellasoStr.length();
			
			for (int i=0; i< x; i++) {
				for (int k=0; k< bellasoStr.length(); k++) {
					l= bellasoStr.charAt(k);
					text1 += l;}
			}	
			
			for (int i=0; i< y; i++) {	
				l= bellasoStr.charAt(i);
				text0 += l;
			}
			
			text1 += text0;  // HELLOHELLO....
		}
		//String encryptedText, String bellasoStr
		for(int i=0; i< text1.length();i++)	
		{
			int intBellText= (int)text1.charAt(i); 
			int intEncrypt= (int)encryptedText.charAt(i); //DOVGHSZ  encrypted
			int x = intEncrypt - intBellText;
			
			if (x < MAX && x> MIN )
				oiginalCode = intEncrypt - intBellText;
			
			while (x< MIN)
			{
				oiginalCode = x+ RANGE;
				x += RANGE;
			}
		
			originalL= (char) oiginalCode;
			originalText +=originalL; 	
		}
		return originalText;
	}
}
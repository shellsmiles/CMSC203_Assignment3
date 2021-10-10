

public class CryptoTestPublic {

	public static void main(String[] args) {

		String str1 = "\"THIS TEST SHOULD SUCCEED\"";
		String str4 = "HELLO WORLD"; 
		String str5 = "IFMMP!XPSME";


		boolean good = CryptoManager.stringInBounds(str1);	
		System.out.println(str1+" Is it in bounds? "+good);
		System.out.println("Caesar cipher of \""+str4+"\" should return \"IFMMP!XPSME\":   "+ CryptoManager.encryptCaesar(str4, 1));
		System.out.println("Caesar decryption of \""+str5+"\" should return \"HELLO WORLD\":    "+ CryptoManager.decryptCaesar(str5, 1));
	}

}
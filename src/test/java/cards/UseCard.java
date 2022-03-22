package cards;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UseCard {
	
	public static void main(String[] args) {
			
		
		BaseCard dog = new BaseCard("st-00", "cane", 1, 1, 1, null);
		BaseCard cat = new BaseCard("st-01", "gatto", 1, 0, 0, null);
		
		
		assertEquals("st-00",dog.getIdCard());
		assertEquals("st-01",cat.getIdCard());
		
	}
}

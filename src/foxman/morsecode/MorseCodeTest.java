package foxman.morsecode;

import org.junit.Assert;
import org.junit.Test;

public class MorseCodeTest {

	@Test
	public void testEncode() {
		MorseCode m = new MorseCode();
		Assert.assertEquals(".... . .-.. .-.. ---   .... . .-.. .-.. ---",
				m.encode("hello hello"));
	}

	@Test
	public void testDecode() {
		MorseCode m = new MorseCode();
		Assert.assertEquals("APPLE HELLO",
				m.decode(".- .---. .---. .-.. .   .... . .-.. .-.. ---"));
	}
}

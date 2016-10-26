import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class CustomDictionarySpec {

	private CustomDictionary customDictionary = new CustomDictionary();

	@Test
	public void assertNoWordOccurrence() {
		String test_word = "test_word";
		assertEquals("Occurrence for absent word should be 0", 0, customDictionary.getOccurrence(test_word));
	}

	@Test
	public void assertFirstOccurrence() {
		String test_word = "test_word1";
		customDictionary.store(test_word);
		assertEquals("Occurrence should be 1 after 1 store", 1, customDictionary.getOccurrence(test_word));
	}

	@Test
	public void assertOccurrenceIsIncreasedProperly() {
		String test_word = "test_word2";
		Random generator = new Random();
		int count = generator.nextInt(100);
//		или так? for (int i = 0; i < count; i++) {
//			customDictionary.store(test_word);
//		}
		IntStream.range(0, count).forEach(
				nbr -> customDictionary.store(test_word)
		);
		assertEquals("Occurrence should be count properly", count, customDictionary.getOccurrence(test_word));
	}

	@Test(expected = IllegalArgumentException.class)
	public void assertNoAbilityToAddNullWord() {
		customDictionary.store(null);
	}

}


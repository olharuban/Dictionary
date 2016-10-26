import java.util.HashMap;

public class CustomDictionary implements Dictionary {

	private HashMap<String, Integer> dictionary = new HashMap();

	public void store(String word) {
		if (word != null) {
			dictionary.merge(word, 1, (a, b) -> a + b);
		} else {
			throw new IllegalArgumentException("Word can not be null");
		}
	}

	public int getOccurrence(String word) {
		return dictionary.getOrDefault(word, 0);
	}

}


public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
		String tail = str.substring(1);
		return tail;
	}

	public static int levenshtein(String word1, String word2) {

		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();
		
		if (word1.length()==0) {
			return word2.length();
		}

		if (word2.length()==0) {
			return word1.length();
		}

		if (word1.charAt(0)== word2.charAt(0)) {
			return levenshtein(word1.substring(1), word2.substring(1));
		}

		
		return 1 + Math.min(
				levenshtein(tail(word1),word2), Math.min(
					levenshtein(word1, tail(word2)), levenshtein(tail(word1), tail(word2))));
		
	}

	public static String[] readDictionary(String fileName) {

		String[] dictionary = new String[3000];

		In in = new In(fileName);
		
		for (int i = 0; i<dictionary.length; i++){
			dictionary[i] = in.readLine();
		}

		return dictionary;
	}
	public static String spellChecker(String word, int threshold, String[] dictionary) {
		String mostSimilar = word;

		for (int i = 0; i < dictionary.length; i++){

			
				/*
				The method might not always return the closest match since it breaks at the first word in the dictionary 
				that satisfies the threshold condition. It should iterate through the entire dictionary and return the word
				with the minimum Levenshtein distance that satisfies the threshold condition.
					*/
				if (threshold >= levenshtein(word, dictionary[i])) {
					mostSimilar = dictionary[i];
					break;
				
			}
		}
		return mostSimilar;
	}

}

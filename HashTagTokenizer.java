import java.lang.annotation.Retention;

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);
		
		for (int i = 0; i<dictionary.length; i++){
			dictionary[i] = in.readLine();
		}

		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {
		boolean exist = false;

		for (int i = 0; i < dictionary.length; i++ ){
			if (word.equals(dictionary[i])) {
				exist = true;
				break;
			}
		} 
		return exist;
	
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }

		hashtag = hashtag.toLowerCase();
 
        int N = hashtag.length();
		int indexZero = 0;

        for (int i = 1; i <= N; i++) {
			String currentString = hashtag.substring(indexZero, i);
			if (existInDictionary(currentString, dictionary)) {
				System.out.println(currentString);
				indexZero = i;
			}
        }
    }

}

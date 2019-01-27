package Jan19_Pre_Orchard_Challenge;
import java.util.*;
public class AA_13_ReverseAlphabets {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String reverseText = reverseSentence("1 cup of hot coffee\r\n" + 
				"costs 8.00, whereas\r\n" + 
				"cold coffe");
		
		System.out.println(reverseText);
	}
	public static String reverseWord(String word) {
		int index = word.length();
		String wordReversed = "";
		while(index-- > 0) {
			wordReversed = wordReversed + word.charAt(index);
		}
		return wordReversed;
	}
	public static String reverseSentence(String sentence) {
//		String[] words = sentence.split("(?<= )");
		String[] words = sentence.split("\\s");
		int wordsLength = words.length;
		String sentenceReversed = "";
		for (int index = 0; index < wordsLength; index++) {
			sentenceReversed += reverseWord(words[index]);
		}
		return sentenceReversed;
	}
	public static String reverseAphabets(String text) {
//		String result = Arrays.toString(text.split("((?<=[.0-9])|(?=[.0-9]))"));
		String[] sentences = text.split("((?<=[.0-9])|(?=[.0-9]))");
		int sentencesLength = sentences.length;
		String alphabetsReversed = "";
		for (int index = 0; index < sentencesLength; index++) {
			String sentence = sentences[index];
			if(sentence.matches(".*\\d+.*")) {
				sentence = reverseSentence(sentence);
			}
			alphabetsReversed += sentence;
		}
		return alphabetsReversed;
	}

}

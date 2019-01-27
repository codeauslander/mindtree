package Jan19_Pre_Orchard_Challenge;
public class AA_12_Compression {
	public static String compress(String text) {
		String result = "";
		text = text.toLowerCase();
		int textLegth = text.length();
		for (int index = 0; index < textLegth; index++) {
			char temporary = ' ';
			if(text.charAt(index) != temporary) {
				temporary = text.charAt(index);
				result += temporary;
				int counter = 1;
				index++;
				while((index < textLegth) && text.charAt(index) == temporary) {
					counter++;
					index++;
				}
				index--;
				result += "" + counter;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String textA = "aAbcccccaaA";
		String textB = "BBBBbbb";
		System.out.println(compress(textA));
		System.out.println(compress(textB));
	}

}

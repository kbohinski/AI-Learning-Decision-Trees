public class KeywordRange extends Attribute {

	String choice;
	String type = "KeywordRange";

	public KeywordRange(int i) {
		choice = options[i];
		type = "KeywordRange";
	}

	private String[] options = { "zerothirty", "thirtyfifty", "fiftyeighty",
			"eightyonehundred" };
	int len = 4;
	int index;

}
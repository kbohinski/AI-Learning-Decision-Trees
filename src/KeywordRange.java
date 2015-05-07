public class KeywordRange extends Attribute {

	String choice;

	public KeywordRange(int i) {
		choice = options[i];
	}

	private String[] options = { "zerothirty", "thirtyfifty", "fiftyeighty",
			"eightyonehundred" };
	int len = 4;
	int index;
	String type = "KeywordRange";

}
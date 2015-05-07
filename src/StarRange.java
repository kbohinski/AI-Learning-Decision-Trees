public class StarRange extends Attribute {

	String choice;

	public StarRange(int i) {
		choice = options[i];
		type = "StarRange";
	}

	private String[] options = { "zerofifty", "fiftyonehundred",
			"onehundredfivehundred", "onethousandormore" };
	int index;
	int len = 4;
	String type = "StarRange";

}

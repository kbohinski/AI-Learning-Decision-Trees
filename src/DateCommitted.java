public class DateCommitted extends Attribute {

	String choice;
	String type = "DateCommitted";

	public DateCommitted(int i) {
		choice = options[i];
		type = "DateCommitted";
	}

	private String[] options = { "weekorless", "monthorless", "yearorless",
			"morethanyear" };
	int index;
	int len = 4;

}
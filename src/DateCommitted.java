public class DateCommitted extends Attribute {

	String choice;

	public DateCommitted(int i) {
		choice = options[i];
	}

	private String[] options = { "weekorless", "monthorless", "yearorless",
			"morethanyear" };
	int index;
	int len = 4;
	String type = "DateCommitted";

}
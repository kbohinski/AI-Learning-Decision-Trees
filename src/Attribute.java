public class Attribute {
	public String attribute; // The name of this attribute
	public AttributeOption[] choices; // The choices associated with this
										// attribute
	public int numExamples = 0; // The number of examples given with this
								// attribute.
	public int positiveExamples = 0; // The number of examples given with this
										// attribute that have a positive
										// outcome.
	public int negativeExamples = 0; // The number of examples given with this
										// attribute that have a negative
										// outcome.
	public Attribute goal; // Our goal

	public Attribute(String attribute) {
		this.attribute = attribute;
	}

	// Returns the number of all positive examples.
	public int positives() {
		int numPositives = 0;
		for (int i = 0; i < choices.length; i++)
			numPositives += choices[i].positiveExamples;

		return numPositives;
	}

	// Returns the number of all negative examples.
	public int negatives() {
		int numNegatives = 0;
		for (int i = 0; i < choices.length; i++)
			numNegatives += choices[i].negativeExamples;
		return numNegatives;
	}

	public Attribute goal() {
		return goal;
	}

	public void setGoal(Attribute goal) {
		this.goal = goal;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public int numExamples() {
		return numExamples;
	}

	public void setNumExamples(int numExamples) {
		this.numExamples = numExamples;
	}

	// Classification for suggesting or not
	public static final int NO = 0;
	public static final int YES = 1;

	// Classification for the most recent commit date
	public static final int WEEKORLESS = 0;
	public static final int MONTHORLESS = 1;
	public static final int YEARORLESS = 2;
	public static final int MORETHANYEAR = 3;

	// Classification for keyword scores
	public static final int ZEROTHIRTY = 0;
	public static final int THIRTYFIFTY = 1;
	public static final int FIFTYEIGHTY = 2;
	public static final int EIGHTYONEHUNDRED = 3;

	// Classification for star ranges
	public static final int ZEROFIFTY = 0;
	public static final int FIFTYONEHUNDRED = 1;
	public static final int ONEHUNDREDFIVEHUNDRED = 2;
	public static final int FIVEHUNDREDONETHOUSAND = 3;
	public static final int ONETHOUSANDORMORE = 4;

}
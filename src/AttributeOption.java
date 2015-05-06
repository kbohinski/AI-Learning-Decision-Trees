public class AttributeOption {
	public String description;
	public int positiveExamples;
	public int negativeExamples;

	public AttributeOption(String description) {
		this.description = description;
	}

	// Returns the number of all positive examples associated with a certain
	// attribute.
	public int positiveExamples(int index) {
		return choices[index].positiveExamples;
	}

	// Returns the number of all negative examples associated with a certain
	// attribute.
	public int negativeExamples(int index) {
		return choices[index].negativeExamples;
	}
}
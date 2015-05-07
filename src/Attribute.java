public class Attribute {

	/**
	 * The parent class of the attributes of KeywordRange, DateCommited,
	 * StarRange and LikedRepo
	 */
	int index;
	String[] options;
	int len;
	String type;
	String choice;

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	public int getLen() {
		return len;
	}

	public String[] getOptions() {
		return options;
	}

	public String getType() {
		return type;
	}

	public String getChoice() {
		return choice;
	}

}

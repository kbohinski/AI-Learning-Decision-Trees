import java.util.Arrays;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Attribute [index=" + index + ", options="
				+ Arrays.toString(options) + ", len=" + len + ", type=" + type
				+ ", choice=" + choice + "]";
	}

}

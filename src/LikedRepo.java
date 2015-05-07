public class LikedRepo extends Attribute {

	String choice;
	private boolean likedRepo = false;
	String type;

	public LikedRepo(int i) {
		if (i == 0)
			likedRepo = false;
		else
			likedRepo = true;
		type = "LikedRepo";
	}

	int index;
	int len = 2;
	String[] options = { "False, True" };

	@Override
	public int getIndex() {
		if (likedRepo) {
			index = 1;
		} else {
			index = 0;
		}
		return index;
	}

}
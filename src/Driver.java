import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

public class Driver {

	public static void main(String[] args) throws IOException {

		ArrayList<Example> examples = new ArrayList<Example>();
		ArrayList<Attribute> attributes = new ArrayList<Attribute>();

		FileReader inF = new FileReader("training_data_set_1.txt");
		BufferedReader in = new BufferedReader(inF);
		String inputLine = "";
		while ((inputLine = in.readLine()) != null) {
			String[] tmpString = inputLine.split(" ");

			long lastCommit = Long.valueOf(tmpString[0]);
			String lang = tmpString[1];
			int watchers = Integer.valueOf(tmpString[2]);
			boolean liked = false;

			if (tmpString[3].equals("1")) {
				liked = true;
			} else if (tmpString[3].equals("0")) {
				liked = false;
			}

			Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
			lastCommit = cal.getTimeInMillis() / 1000L - lastCommit;

			int date = -1;
			if (lastCommit <= 604800) {
				date = 0;
			} else if (lastCommit <= 2592000) {
				date = 1;
			} else if (lastCommit <= 31536000) {
				date = 2;
			} else if (lastCommit > 31536000) {
				date = 3;
			}

			int likedInt = -1;
			if (liked) {
				likedInt = 1;
			} else {
				likedInt = 0;
			}

			int stars = 0;
			if (watchers <= 50) {
				stars = 0;
			} else if (watchers <= 100) {
				stars = 1;
			} else if (watchers <= 500) {
				stars = 2;
			} else if (watchers > 500) {
				stars = 3;
			}

			DateCommitted a = new DateCommitted(date);
			KeywordRange b = new KeywordRange(0);
			LikedRepo c = new LikedRepo(likedInt);
			StarRange d = new StarRange(stars);

			Random rng = new Random();
			Example ex = new Example(b, a, d, c, rng.nextBoolean());
			examples.add(ex);

		}

		Attribute attri = new Attribute();
		Node<Attribute> tmpNode = new Node<Attribute>(attri);
		DTree<Attribute> tree = new DTree<Attribute>(tmpNode);

		DateCommitted a = new DateCommitted(0);
		KeywordRange b = new KeywordRange(0);
		LikedRepo c = new LikedRepo(0);
		StarRange d = new StarRange(0);

		attributes.add(a);
		attributes.add(b);
		attributes.add(c);
		attributes.add(d);

		tree.decisionTreeLearning(examples, attributes, examples);

	}
}
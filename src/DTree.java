import java.util.ArrayList;
import java.util.Random;

public class DTree<T> {

	protected Node<T> parent;

	/**
	 * @param dTree
	 */
	public DTree(DTree<T> dTree) {
		this.parent = dTree.getParent();
	}

	public DTree(Node<T> element) {
		this.parent = element;
	}

	/**
	 * @return the parent
	 */
	public Node<T> getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

	public ArrayList<Node<T>> getChildren() {
		return parent.getChildren();
	}

	public Node<T> getChild(int index) {
		return parent.getChild(index);
	}

	public static DTree decisionTreeLearning(ArrayList<Example> examples,
			ArrayList<Attribute> attributes, ArrayList<Example> parentExamples) {
		boolean check = true;
		for (Example ex : examples) {
			if (!ex.isShowRepo()) {
				check = false;
				break;
			}
		}

		if (examples.isEmpty()) {
			return getPlurality(parentExamples);
		} else if (check) {
			Node<Boolean> tmpNode = null;

			if (check) {
				tmpNode = new Node<Boolean>(true);
			} else {
				tmpNode = new Node<Boolean>(false);
			}

			DTree<Boolean> tmpTree = new DTree<Boolean>(tmpNode);

			return tmpTree;
		} else if (attributes.size() == 0) {
			return getPlurality(examples);
		} else {
			double maxInfo = -1;
			double lastMax = -1;
			Attribute high = null;
			for (Attribute attri : attributes) {
				maxInfo = Math.max(
						informationGain(
								examples.toArray(new Example[examples.size()]),
								attri.getType()), maxInfo);
				if (lastMax != maxInfo) {
					lastMax = maxInfo;
					high = attri;
				}
			}

			// Dis be where recursion happens
			Node<Attribute> tmpNode = new Node<Attribute>(high);
			DTree<Attribute> tmp = new DTree<Attribute>(tmpNode);
			for (int i = 0; i < high.getLen(); i++) {
				ArrayList<Example> newExs = new ArrayList<Example>();
				for (int j = 0; j < examples.size(); j++) {
					if (examples.get(j).getChoice(high)
							.equals(high.getOptions()[high.getIndex()])) {
						newExs.add(examples.get(j));
					}
				}
				attributes.remove(high);
				DTree<Attribute> subtree = new DTree<Attribute>(
						decisionTreeLearning(newExs, attributes, examples));
				tmp.parent.addChild(subtree.getParent());
			}

			return tmp;

		}

	}

	public static DTree<Boolean> getPlurality(ArrayList<Example> examples) {
		int trueCount = 0;
		int falseCount = 0;
		for (int i = 0; i < examples.size(); i++) {
			if (examples.get(i).isShowRepo()) {
				trueCount++;
			} else {
				falseCount++;
			}
		}

		Node<Boolean> tmpNode = null;

		if (trueCount > falseCount) {
			tmpNode = new Node<Boolean>(true);
		} else if (falseCount > trueCount) {
			tmpNode = new Node<Boolean>(false);
		} else {
			Random rng = new Random();
			tmpNode = new Node<Boolean>(rng.nextBoolean());
		}

		DTree<Boolean> tmpTree = new DTree<Boolean>(tmpNode);

		return tmpTree;

	}

	public static double entropy(double q) {
		return -1 * (q * Logarithm.log2(q) + (1 - q) * Logarithm.log2(1 - q));
	}

	public static double remainder(Example[] e, String toCheck) {
		double sum = 0;
		double one = 0;
		double posOne = 0;
		double two = 0;
		double posTwo = 0;
		double three = 0;
		double posThree = 0;
		double four = 0;
		double posFour = 0;
		
		if (toCheck != null) {
			if (toCheck.equals("KeywordRange")) {
				for (Example ex : e) {
					/*
					 * "zerothirty", "thirtyfifty", "fiftyeighty",
					 * "eightyonehundred"
					 */
					int num = ex.getKeywordRange().getIndex();
					if (num == 1) {
						one += 1;
						if (ex.isShowRepo()) {
							posOne += 1;
						}
					} else if (num == 2) {
						two += 1;
						if (ex.isShowRepo()) {
							posTwo += 1;
						}
					} else if (num == 3) {
						three += 1;
						if (ex.isShowRepo()) {
							posThree += 1;
						}
					} else if (num == 4) {
						four += 1;
						if (ex.isShowRepo()) {
							posFour += 1;
						}
					}
				}
				sum += (one / e.length) * entropy((posOne / one));
				sum += (two / e.length) * entropy((posTwo / two));
				sum += (three / e.length) * entropy((posThree / three));
				sum += (four / e.length) * entropy((posFour / four));
			} else if (toCheck.equals("DateCommitted")) {
				for (Example ex : e) {
					int num = ex.getDateCommitted().getIndex();
					if (num == 1) {
						one += 1;
						if (ex.isShowRepo()) {
							posOne += 1;
						}
					} else if (num == 2) {
						two += 1;
						if (ex.isShowRepo()) {
							posTwo += 1;
						}
					} else if (num == 3) {
						three += 1;
						if (ex.isShowRepo()) {
							posThree += 1;
						}
					} else if (num == 4) {
						four += 1;
						if (ex.isShowRepo()) {
							posFour += 1;
						}
					}
				}
				sum += (one / e.length) * entropy((posOne / one));
				sum += (two / e.length) * entropy((posTwo / two));
				sum += (three / e.length) * entropy((posThree / three));
				sum += (four / e.length) * entropy((posFour / four));
			} else if (toCheck.equals("StarRange")) {
				for (Example ex : e) {
					int num = ex.getStarRange().getIndex();
					if (num == 1) {
						one += 1;
						if (ex.isShowRepo()) {
							posOne += 1;
						}
					} else if (num == 2) {
						two += 1;
						if (ex.isShowRepo()) {
							posTwo += 1;
						}
					} else if (num == 3) {
						three += 1;
						if (ex.isShowRepo()) {
							posThree += 1;
						}
					} else if (num == 4) {
						four += 1;
						if (ex.isShowRepo()) {
							posFour += 1;
						}
					}
				}
				sum += (one / e.length) * entropy((posOne / one));
				sum += (two / e.length) * entropy((posTwo / two));
				sum += (three / e.length) * entropy((posThree / three));
				sum += (four / e.length) * entropy((posFour / four));
			} else if (toCheck.equals("LikedRepo")) {
				for (Example ex : e) {
					int num = ex.getLikedRepo().getIndex();
					if (num == 1) {
						one += 1;
						if (ex.isShowRepo()) {
							posOne += 1;
						}
					} else if (num == 0) {
						two += 1;
						if (ex.isShowRepo()) {
							posTwo += 1;
						}
					}
				}
				sum += (one / e.length) * entropy((posOne / one));
				sum += (two / e.length) * entropy((posTwo / two));
			}
		}
		
		return sum;
	}

	public static double goalEntropy(Example[] e) {
		double posNum = 0;

		for (Example ex : e) {
			if (ex.isShowRepo()) {
				posNum++;
			}
		}

		return entropy(posNum / e.length);
	}

	public static double informationGain(Example[] e, String toCheck) {
		return goalEntropy(e) - remainder(e, toCheck);
	}

}

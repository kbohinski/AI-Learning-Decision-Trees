import javax.swing.JTree;

//This class contains formulas used in our decision tree's processes.
public class DecisionFormula {
	// This formula returns the entropy value of a number. It only works for
	// numbers between 0 and 1, but does not test this because why would I. <
	// Preach
	public static double Entropy(double q) {
		return -1 * (q * Logarithm.log2(q) + (1 - q) * Logarithm.log2(1 - q));
	}

	// This formula returns the remainder value of an attribute as a fraction of
	// the number of examples contained in this attribute choice versus all of
	// the choices
	// and the entropy of its postive values divided by all its values.
	public static double Remainder(Attribute a) {
		double sum = 0;
		for (int i = 0; i < a.numExamples(); i++) {
			sum += ((a.positiveExamples(i) + a.negativeExamples(i))
					/ (a.goal().positives() + a.goal().negatives()) * Entropy(a
					.positiveExamples(i)
					/ (a.positiveExamples(i) + a.negativeExamples(i))));
		}
		return sum;
	}

	public static double GoalEntropy(Attribute a) {
		return Entropy(a.goal().positives()
				/ (a.goal().positives() + a.goal().negatives()));
	}

	// This formula calculates the information gain of an attribute by taking
	// the difference of the entropy of the goal attribute and the remainider of
	// the attribute.
	public static double InformationGain(Attribute a) {
		return GoalEntropy(a) - Remainder(a);
	}

	// This formula returns either the attribute with the most values, or breaks
	// ties randomly
	public static JTree PluralityValue(Attribute[] AList) {
		JTree pluralityValue = new JTree();
		return pluralityValue;
	}
}
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class DecisionTree
{
	//want to have this tree as our decision tree 
	public JTree<Attribute> TheDecisionTree;

	public DecisionTree() 
	{
		//want to call Build Decision Tree when the constructor is called 
	}

	//Builds a decision tree given some examples, the attributes that describe our problem, and the initial examples
	public JTree BuildDecisionTree(String[] examples, String[] attributes, String[] parent_examples)
	{
		if(examples.length == 0 || length == null)
			return DecisionFormula.PluralityValue(parent_examples);
		if(examples.haveSameClassification())
			return theClassification; //either yes or no 
		if(attributes.length == 0 || attributes == null)
			return PluralityValue(examples);

		//Find the value with the highest information gain
		Attribute a = max(InformationGain(a, examples));
		DefaultMutableTreeNode rootA = new DefaultMutableTreeNode(a);//make our root node for the tree 
		//attribute A = max(InformationGain(attribute,examples));
		JTree test = new JTree(rootA); //take our root node and turn it into a JTree 
		for(String value : A)
		{
			//For all examples passed through above, and for every attribute within those examples, assign it to the new examples array exs
			//String[] exs = {e : examples && e.A = value}
			JTree subtree = BuildDecisionTree(exs, attributes - a, examples); //recursively call the function to continue to make the tree 
			//add a branch to tree with label (A = value) and the above subtree
			DefaultMutableTreeNode branch = new DefaultMutableTreeNode(subtree) //need to add the subtrees to the tree as branches...
			test.add

		}
		return test; //want to return the tree that we are building 
	}

	private String PluralityValue(String[] examples)
	{
		//They would have said the majority class if there were only two classes. 
		//Plurality is just the generalization of majority to more than 2 classes. 
		//It just means take the most frequent class in that leaf and return that as your prediction. 
		//For example, if you are classifying the colors of balls, and there are 3 blue balls, 2 red balls, and 2 white balls in a leaf, 
		//return blue as your prediction.

	}
}
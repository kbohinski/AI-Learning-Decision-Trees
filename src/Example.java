public class Example
{
	Attribute[] attributes;
	boolean noOrYes; //NO = 0, YES = 1.
	public static final boolean NO = false;
	public static final boolean YES = true;

	//default constructor
	public Example() 
	{
		attributes = new Attribute[2]; //each example will have 3 attributes attached to it; yes, no, or it "ask a new question"
		noOrYes = NO;
	}

	//alternate constructor taking in two parameters that are the attributes associated with the constructor and the boolean NO or YES
	public Example(Attribute[] attributes, boolean noOrYes)
	{
		this.attributes = attributes;
		this.noOrYes = noOrYes;
	}

	//It adds attributes to the example.
	public void addAttribute(int index, Attribute attribute)
	{
		if(index == 0 || index == 1)
			attributes[index] = attribute;
		else
			System.err.println("Index is out of range.");
	}

	//checks to see if all the examples have the same classification and returns that classification if they do
	//i.e. if all the examples are positive it will return positive and will do the same if they are negative  
	//want to return the classification itself but they are enums...need to return an enum type 
	public haveSameClassification()
	{
		for (int i = 0; i < attributes.length; i++) //want to go through all the attributes of an example 
		{
			//check to see if their classifications are equal and if they are, return that classification
		}
	}
}
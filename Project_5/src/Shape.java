import java.text.DecimalFormat;
public class Shape {
	
	//ToDo: Declare class variables using UML diagram
	private String name;
	private int sideA;
	private int sideB;
	private int sideC;
	
	public Shape() {
		this.name = "";
		this.sideA = 0;
		this.sideB = 0;
		this.sideC = 0;
	}
	
	//ToDo: define a constructor for the shape circle
	public Shape(int sideOne) {
		//initialize the required variables
		//Shape name will assigned as "circle"
		//All the variables other than sideOne will be assigned as -1
		this.name = "circle";
		this.sideA = sideOne;
		this.sideB = -1;
		this.sideC = -1;
	}
	
	//ToDo: define a constructor for shape rectangle
	public Shape(int sideOne, int sideTwo) {
		//initialize the required variables
		//Shape name will assigned as "Rectangle"
		//variable sideThree will be assigned as -1
		this.name = "Rectangle";
		this.sideA = sideOne;
		this.sideB = sideTwo;
		this.sideC = -1;
	}
	
	//ToDo: constructor for triangle
	public Shape(int sideOne, int sideTwo, int sideThree) {
		//initialize the required variables
		//Shape name will assigned as "Triangle"
		this.name = "Triangle";
		this.sideA = sideOne;
		this.sideB = sideTwo;
		this.sideC = sideThree;
	}
	
	// ToDo: Complete this method so that it returns area of specific shape
	public double getArea() {
		double area = 0.0;
		
		// use the name and a if-else statement to compute the appropriate area.
		if (this.name.equalsIgnoreCase("circle")) {
			area = Math.PI * this.sideA * this.sideA; 
		}
		else if (this.name.equalsIgnoreCase("Rectangle")) {
			area = (double)sideA * (double)sideB;
		}
		else if (this.name.equalsIgnoreCase("Triangle")) {
			double s = (sideA + sideB + sideC) / 2.0;
			area = Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
		}
		return area;
	}

	//ToDo: Below methods will update the dimensions of the shapes
	//set side one for circle
	public boolean setSideOne(int i) {
		//will change only one side
		this.sideA = i;
		return true;
	}
	
	//ToDo: set sideTwo only if it's a rectangle or triangle
	public boolean setSideTwo(int j) {
		if(this.name.equalsIgnoreCase("Rectangle") || this.name.equalsIgnoreCase("Triangle")) {
			this.sideB = j;
			return true;
		}
		return false;
	}
	
	//ToDo: set sideThree only if it's a triangle
	public boolean setSideThree(int k) {
		if(this.name.equalsIgnoreCase("Triangle")) {
			this.sideC = k;
		}
		return false;
	}
	
	//ToDo: This method will display the details of the shape 
	//to a String
	public String toString() {
		DecimalFormat df = new DecimalFormat(".##");
		//you need to write the code to return the String with information of shape
		return "Area of " + this.name + " is " + df.format(getArea());
	}

}


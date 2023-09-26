import java.util.ArrayList;

/**
 * This is a donor class, here you have to complete the class as shown in the UML
 */

/**
 * @author 
 *
 */
public class Donor {	
	private String name;
	private ArrayList<Double> donations;
	
	//default constructor
	public Donor() {
		this.name = "";
		this.donations = new ArrayList<Double>();
	}
	//non-default constructors
	public Donor(String name) {
		this.name = name;
		this.donations = new ArrayList<Double>();
	}
	public Donor(String name, double donation) {
		this.name = name;
		this.donations  = new ArrayList<Double>();
		this.donations.add(donation);
	}
	
	//get method for name of Donor object
	public String getName() {
		return this.name;
	}
	
	//get sum of donations of Donor object
	public double getTotalDonations() {
		double sum = 0.0;
		for (int i = 0; i < this.donations.size(); i++) {
			sum += this.donations.get(i);
		}
		return sum;
	}
	
	//print name in specific format
	public String toString() {
		return this.name + " has donated: " + getTotalDonations();
	}
	
	//add new donation to ArrayList
	public void addDonation(double donation) {
		this.donations.add(donation);
	}

}

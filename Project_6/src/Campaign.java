import java.util.ArrayList;

public class Campaign {

	// Declare the class variables with proper access specifier
	// Do not initialize here
	private String candidateName;
	private ArrayList<Donor>donors;
	
	//constructor
	public Campaign(String name)
	{
		this.candidateName = name;
		this.donors = new ArrayList<Donor>();
	}
	
	public String getCandidateName()
	{
		return this.candidateName;
	}

	public String getDonors()
	{
		String result = candidateName + "\n";
		result += donors.toString();
		
		return result;
	}
	
	public double getAllDonations()
	{
		//get total sum of donations from all donors
		double sum = 0.0;
		for (int i = 0; i < donors.size(); i++) {
			sum += donors.get(i).getTotalDonations();
		}
		return sum;
	}
	
	public void addDonor(String name)
	{
		//if specified donor is in donors, return to main
		for (Donor donor : donors) {
			if (donor.getName().equalsIgnoreCase(name)) {
				System.out.println("The donor already exists");
				return;
			}
		}
		
		// if specified donor not in donors, add newDonor object to donors
		Donor newDonor = new Donor(name);
		donors.add(newDonor);
		//for testing 
		System.out.println(name + " has been added");
	}
	
	public double getDonation(String donor)
	{
		//if specified donor is in donors, get their total donation amount
		for (int i = 0; i < donors.size(); i++) {
			if(donors.get(i).getName().equalsIgnoreCase(donor)) {
				return donors.get(i).getTotalDonations();
			}
		}
		//specified donor not found
		return -1; // stub
	}
	
	public String getDonationList(String donor)
	{
		for (int i=0; i < donors.size(); ++i)
		{
			Donor d = donors.get(i);
			if (d.getName().equals(donor))
			{
				return d.toString();
			}
		}

		return "No donor with that name was found";
	}
	
	public void addDonation(String donorName, double donation)
	{
		//add donation amount if donorName in donors ArrayList then return to main
		for (Donor Donor : donors) {
			if (Donor.getName().equalsIgnoreCase(donorName)) {
				Donor.addDonation(donation);;
				return;
			}
		}
		//if donorName not in donors ArrayList, add create new Donor object and add to donors
		Donor newDonor = new Donor(donorName, donation);
		donors.add(newDonor);
	}
}

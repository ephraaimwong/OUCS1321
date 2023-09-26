import java.util.Scanner;

/** This class runs a campaign for Mickey Mouse.
 * 
 * @author Deborah A. Trytten
 *
 */
public class Election {

	// These constants are used for a menu system
	private static final int ADD_DONOR = 1;
	private static final int DONATION = 2;
	private static final int SUM_DONATIONS = 3;
	private static final int SINGLE_DONOR_DETAILS = 4;
	private static final int QUIT = 5;
	
	public static void main(String[] args) 
	{
		Campaign candidate = new Campaign("Mickey Mouse");
		Scanner keyboard = new Scanner(System.in);
		
		int menuChoice = 0;
		while (menuChoice != QUIT)
		{
			menuChoice = menu(keyboard);
			
			if (menuChoice == ADD_DONOR)
				addDonor(keyboard, candidate);
			else if (menuChoice == DONATION)
				addDonation(keyboard, candidate);
			else if (menuChoice == SUM_DONATIONS)
				sumDonations(candidate);
			else if (menuChoice == SINGLE_DONOR_DETAILS)
				singleDonorDetails(keyboard, candidate);
			else if (menuChoice == QUIT)
				System.out.println("Goodbye");
			else
				System.out.println("Unanticipated case");
		}
		
	}

	private static final int menu(Scanner keyboard)
	{
		System.out.println("Enter your choice below");
		System.out.println(ADD_DONOR + ": add new donor");
		System.out.println(DONATION + ": make donation");
		System.out.println(SUM_DONATIONS + ": find total donations");
		System.out.println(SINGLE_DONOR_DETAILS + ": single donor details");
		System.out.println(QUIT + ": quit");
		
		int value = keyboard.nextInt();
		keyboard.nextLine();
		if (value < ADD_DONOR || value > QUIT)
		{
			System.out.println(value + " is not in the legal range. Please re-enter");
			return menu(keyboard); // this is a cool trick called recursion
		}
		else // it was legal
		{
			return value;
		}
	}
	
	//add donor to donors ArrayList
	private static void addDonor(Scanner keyboard, Campaign candidate)
	{
		System.out.println("Enter the name of the donor");
		String name = keyboard.nextLine();
		candidate.addDonor(name);
	}
	
	//add donation to donor object in donors ArrayList 
	private static void addDonation(Scanner keyboard, Campaign candidate)
	{
		//TODO Fill in this method
		// First, ask the user for the name of the donor,
		// then use the method from your Campaign class to add the funds to the donor 
		System.out.println("Enter the name of donor: ");
		String name = keyboard.nextLine();
		System.out.println("Enter donation amount: ");
		double donation = keyboard.nextDouble();
		//consume EOL char
		keyboard.nextLine();
		candidate.addDonation(name, donation);
	}
	
	private static void sumDonations(Campaign candidate)
	{
		System.out.println(candidate.getCandidateName() + " has $" + candidate.getAllDonations()
				+ " of donations");
	}
	
	//get total donation of donor object 
	private static void singleDonorDetails(Scanner keyboard, Campaign candidate)
	{
		//TODO Get the details of donor to this candidate
		// First, ask the user for the name of the donor,
		// then use the method from your Campaign class and get donation of that donor.
		// Finally print the donor's name and their donation
		System.out.println("Enter the name of donor: ");
		String name = keyboard.nextLine();
		System.out.println(name + " has donated $ " + candidate.getDonation(name));
		

	}
}

import java.text.DecimalFormat;
import java.util.Scanner;
public class Project_2 {

	public static void main(String[] args) {
		// DecimalFormat initialized and set to 2 D.P.
		//df.format(d)to use
		DecimalFormat df = new DecimalFormat("#.##");
		//Scanner initialized
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to Imperial to Metric Conversion Calculator");
		
		//Convert F to C
		System.out.println("Please enter the temperature in degree Fahrenheit:");
		double tempF = input.nextDouble();
		double tempC = (tempF - 32) * 5 / 9;
		System.out.println("The temperature in degree Celsius is " + df.format(tempC) + " C");
		
		//Convert fluid oz to liter
		System.out.println("Please enter the volume of liquid in fluid ounces:");
		double fl_oz = input.nextDouble();
		double liter = (fl_oz * 29.5735) / 1000;
		System.out.println("The volume of the liquid in Liters is " + df.format(liter) + " L");
		
		//Convert lb to kg
		System.out.println("Please enter the weight of an object in pounds:");
		double lb = input.nextDouble();
		double kg = (lb * 454) / 1000;
		System.out.println("The weight of an object in kilograms is " + df.format(kg) + " Kg");
		
		//Convert miles to km
		System.out.println("Please enter the distance to a city in miles:");
		double miles = input.nextDouble();
		double km = miles * 1.609;
		System.out.println("The distance to a city in kilometers is " + df.format(km) + " Km");
		
	}

}

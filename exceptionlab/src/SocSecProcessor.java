import java.util.*;

public class SocSecProcessor 
{
	public static void main(String args[])
	{
		String name, num;
		String choice = "y"; //choice stores y/n answer to continue/end program
		Scanner input = new Scanner(System.in);
		boolean valid = false;
		//do while loop here
		do {
			System.out.println("Name?");
			name = input.nextLine();
			System.out.println("SSN?");
			num = input.nextLine();
			try 
			{
				valid = isValid(num);
				if(valid) //VALID OUTPUT
					System.out.println(name + " " + num + " is valid.");
			}
			catch(SocSecException e)
			{
				System.out.println(e.getMessage()); //INVALID OUTPUT
			}
			System.out.println("Continue?");
			choice = input.nextLine();
			choice = choice.toLowerCase();
		} while(choice.charAt(0) == 'y');
		input.close();
	}
	public static boolean isValid(String ssn) throws SocSecException
	{
		//Checking for Length
		if(ssn.length() != 11)
			throw new SocSecException("wrong number of characters");
		//Checking for Dashes
		if(ssn.charAt(3) != '-' || ssn.charAt(6) != '-')
			throw new SocSecException("dashes at wrong positions");
		//Checking for Other Characters
		for(int i = 0; i < 11; i++)
		{
			if(i != 3 && i != 6)
			{
				if(!Character.isDigit(ssn.charAt(i))) //if it is NOT a digit
				{
					throw new SocSecException("contains a character that is not a digit");
				}
			}
		}
		return true;
	}
}
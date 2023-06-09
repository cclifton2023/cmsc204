/*
 * CMSC 204 CRN: 40541
 * Author: Caitlyn Clifton
 * Professor Gary Thai
 * Project: Password Checker
 */
package application; 
public class NoDigitException extends Exception
{
	public NoDigitException()
	{
		super("The password must contain at least one digit.");
	}
}

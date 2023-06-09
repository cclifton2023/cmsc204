/*
 * CMSC 204 CRN: 40541
 * Author: Caitlyn Clifton
 * Professor Gary Thai
 * Project: Password Checker
 */
package application; 
public class LengthException extends Exception
{
	public LengthException()
	{
		super("The password must be at least 6 characters long");
	}
}

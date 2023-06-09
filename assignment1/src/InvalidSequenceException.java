/*
 * CMSC 204 CRN: 40541
 * Author: Caitlyn Clifton
 * Professor Gary Thai
 * Project: Password Checker
 */
package application; 
public class InvalidSequenceException extends Exception
{
	public InvalidSequenceException()
	{
		super("The password cannot contain more than two of the same character in sequence.");
	}
}

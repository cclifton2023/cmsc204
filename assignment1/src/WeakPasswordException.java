/*
 * CMSC 204 CRN: 40541
 * Author: Caitlyn Clifton
 * Professor Gary Thai
 * Project: Password Checker
 */
package application; 
public class WeakPasswordException extends Exception
{
	public WeakPasswordException()
	{
		super("The password is OK but weak - it contains fewer than 10 characters."); 
	}
}

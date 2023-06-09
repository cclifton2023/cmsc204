/*
 * CMSC 204 CRN: 40541
 * Author: Caitlyn Clifton
 * Professor Gary Thai
 * Project: Password Checker
 */
package application; 
public class NoUpperAlphaException extends Exception
{
	public NoUpperAlphaException()
	{
		super("The password must contain at least one uppercase character.");
	}
}

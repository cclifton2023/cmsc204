/*
 * CMSC 204 CRN: 40541
 * Author: Caitlyn Clifton
 * Professor Gary Thai
 * Project: Password Checker
 */

package application; 
public class NoLowerAlphaException extends Exception
{
	public NoLowerAlphaException()
	{
		super("The password must contain at least one lowercase alphabetic character");
	}
}

/*
 * CMSC 204 CRN: 40541
 * Author: Caitlyn Clifton
 * Professor Gary Thai
 * Project: Password Checker
 */
package application; 
import java.util.*;
import java.util.regex.*; //used for pattern

public class PasswordCheckerUtility extends Object
{
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException
	{
		if (!password.equals(passwordConfirm))
			throw new UnmatchedException();
	}
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm)
	{
		if (password.equals(passwordConfirm))
			return true;
		else
			return false;
	}
	public static boolean isValidLength(String password) throws LengthException
	{
		if (password.length() < 6) //if the password is not at least 6 characters
			throw new LengthException();
		else
			return true;
	}
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException
	{
		int upperAlphas = 0;
		for (int i = 0; i < password.length(); i++)
		{
			if(Character.isUpperCase(password.charAt(i)))
			{
				upperAlphas++;
			}
		}
		if (upperAlphas == 0)
			throw new NoUpperAlphaException();
		else
			return true;
	}
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException
	{
		int lowerAlphas = 0;
		for (int i = 0; i < password.length(); i++)
		{
			if(Character.isLowerCase(password.charAt(i)))
			{
				lowerAlphas++;
			}
		}
		if (lowerAlphas == 0)
			throw new NoLowerAlphaException();
		else
			return true;
	}
	public static boolean hasDigit(String password) throws NoDigitException
	{
		int digits = 0;
		for (int i = 0; i < password.length(); i++)
		{
			if(Character.isDigit(password.charAt(i)))
			{
				digits++;
			}
		}
		if (digits == 0)
			throw new NoDigitException();
		else
			return true;
	}
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException
	{
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		
		if (matcher.matches())
			throw new NoSpecialCharacterException();
		else
			return true;
	}
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException
	{
		char c;
		for (int i = 0; i < password.length() - 2; i++)
		{
			c = password.charAt(i);
			if (c == password.charAt(i+1) && c == password.charAt(i+2))
				throw new InvalidSequenceException();
		}
		return true;
	}
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException,NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
		try 
		{
			isValidLength(password);
			hasUpperAlpha(password);
			hasLowerAlpha(password);
			hasDigit(password);
			hasSpecialChar(password);
			NoSameCharInSequence(password);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		finally
		{
			if(isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasDigit(password) && hasSpecialChar(password) && NoSameCharInSequence(password))
				return true;
		}
		return false;
	}
	public static boolean hasBetweenSixAndNineChars(String password)
	{
		if (password.length() < 6 && password.length() > 9) //if the password is between 6-9 (inclusive)
			return false;
		else
			return true;
	}
	public static boolean isWeakPassword(String password) throws WeakPasswordException
	{
		boolean valid = false;
		try 
		{
			valid = isValidPassword(password);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		finally
		{
			if (valid && hasBetweenSixAndNineChars(password))
				throw new WeakPasswordException();
		}
		return false;
	}
 	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords)
	{
		ArrayList<String> invalidPasswords = new ArrayList<String>();
		
		for(int i = 0; i < passwords.size(); i++)
		{
			try
			{
				isValidPassword(passwords.get(i));
			}
			catch(Exception e)
			{
				invalidPasswords.add(passwords.get(i) + " " + e.getMessage());
			}
		}
		return invalidPasswords;
	}
}
import static org.junit.Assert.*;

import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Caitlyn Clifton
 *
 */
public class PasswordCheckerTest_STUDENT 
{
	ArrayList<String> passwords;
	
	@Before
	public void setUp() throws Exception 
	{
		passwords = new ArrayList<String>();
	}

	@After
	public void tearDown() throws Exception 
	{
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try 
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("a2cDe"));
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw LengthException", true);
		}
		catch(Exception e)
		{
			assertTrue("Threw a different exception", false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try 
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("bertha22"));
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw NoUpperAlphaException", true);
		}
		catch(Exception e)
		{
			assertTrue("Threw a different exception", false);
		}
	}
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try 
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("334455BB#"));
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw NoLowerAlphaException", true);
		}
		catch(Exception e)
		{
			assertTrue("Threw a different exception", false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try 
		{
			assertTrue(PasswordCheckerUtility.isWeakPassword("4Sale#"));
		}
		catch(WeakPasswordException e)
		{
			assertTrue("Successfully threw WeakPasswordException", true);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try 
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("george2ZZZ#"));
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw InvalidSequenceException", true);
		}
		catch(Exception e)
		{
			assertTrue("Threw a different exception", false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("ApplesxxYYzz#"));
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw NoDigitException", true);
		}
		catch(Exception e)
		{
			assertTrue("Threw a different exception", false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try 
		{
			assertEquals(true, PasswordCheckerUtility.isValidPassword("myPassword2#"));
		}
		catch(Exception e)
		{
			assertTrue("Threw an exception", false);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() 
	{
		PasswordCheckerUtility.getInvalidPasswords(passwords);
	}
	
}

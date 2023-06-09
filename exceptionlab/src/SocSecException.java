public class SocSecException extends Exception 
{
	public SocSecException(String message)
	{
		super("Invalid social security number, " + message);
	}
}

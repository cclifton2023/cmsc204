public class StackOverflowException extends Exception
{
	public StackOverflowException()
	{
		super("Error; the stack is full.");
	}
}
public class StackUnderflowException extends Exception
{
	public StackUnderflowException()
	{
		super("Error; the stack is empty.");
	}
}
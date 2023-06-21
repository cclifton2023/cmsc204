public class QueueOverflowException extends Exception
{
	public QueueOverflowException()
	{
		super("Error; the queue is full.");
	}
}
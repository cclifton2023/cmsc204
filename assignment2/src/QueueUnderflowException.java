public class QueueUnderflowException extends Exception 
{
	public QueueUnderflowException()
	{
		super("Error; the queue is empty.");
	}
}
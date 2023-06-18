/**
 * @author Caitlyn Clifton
 * @date 6/12/2023
 */
package main;

import java.util.*;

public class Queue<T> implements QueueInterface<T>
{
	int firstNode = -1, lastNode = -1;
	ArrayList<T> queue = new ArrayList<>();
	
	/** Adds a new entry to the back of this queue.
    @param newEntry  An object to be added. */
	public void enqueue(T newEntry)
	{
		if(isEmpty())
		{
			firstNode = 0;
			lastNode = 0;
		}
		else
		{
			lastNode++;
		}
		queue.add(newEntry);
	}
	/** Removes and returns the entry at the front of this queue.
	    @return  The object at the front of the queue. 
	    @throws  EmptyQueueException if the queue is empty before the operation. */
	public T dequeue() throws EmptyQueueException
	{
		if(!isEmpty())
		{
			T removedElement = queue.get(firstNode);
			if(firstNode == lastNode)
			{
				firstNode = -1;
				lastNode = -1;
			}
			else
			{
				queue.remove(firstNode);
				firstNode++;
			}
			return removedElement;
		}
		else
			throw new EmptyQueueException();
	}
	/**  Retrieves the entry at the front of this queue.
	    @return  The object at the front of the queue.
	    @throws  EmptyQueueException if the queue is empty. */
	public T getFront() throws EmptyQueueException
	{
		if(!isEmpty())
			return queue.get(firstNode);
		else
			throw new EmptyQueueException();
	}
	/** Detects whether this queue is empty.
	    @return  True if the queue is empty, or false otherwise. */
	public boolean isEmpty()
	{
		return queue.isEmpty();
	}
	/** Removes all entries from this queue. */
	public void clear()
	{
		queue.clear();
	}
}

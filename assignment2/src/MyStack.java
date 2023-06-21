/**
 * @author Caitlyn Clifton
 * @date 6/12/2023
 */
import java.util.*;

public class MyStack<T> implements StackInterface<T>
{
	private int maxSize; //max size of stack
	private int size; //size of the stack
	Stack <T> stack = new Stack <T>();
	
	/**
	 * Provide two constructors
	 * 1. takes in an int as the size of the stack
	 * 2. default constructor - uses default as the size of the stack
	 */
	public MyStack() //default constructor
	{
		this.maxSize = 15;
		this.size = 0;
		stack.setSize(maxSize);
	}
	public MyStack(int size) 
	{
		this.maxSize = size;
		this.size = 0;
	}
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	public boolean isEmpty()
	{
		if (size == 0)
			return true;
		else
			return false;
	}

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	public boolean isFull()
	{
		if(size == maxSize)
			return true;
		else
			return false;
	}
	

	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	public T pop() throws StackUnderflowException
	{
		if(!isEmpty())
		{
			size--;
			return stack.pop();
		}
		else
			throw new StackUnderflowException();
	}
	
	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	public T top() throws StackUnderflowException
	{
		if(!isEmpty())
			return stack.peek();
		else
			throw new StackUnderflowException();
	}

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	public int size()
	{
		return stack.size();
	}
	
	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
	public boolean push(T e) throws StackOverflowException
	{
		if(!isFull())
		{
			stack.push(e);
			size++;
			return true;
		}
		else
			throw new StackOverflowException();
	}
	
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	public String toString()
	{
		String s = "";
		for (int i = 0; i < size; i++)
		{
			if(stack.get(i) != null)
				s += stack.get(i);
		}
		return s;
	}
	
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	public String toString(String delimiter)
	{
		String s = "";
		for (int i = 0; i < stack.size(); i++)
		{
			if(stack.get(i) != null)
				s += stack.get(i) + delimiter;
		}
		return s.substring(0,s.length()-1);
	}
	
	 /**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the Stack from bottom to top
	  * @throws StackOverflowException if stack gets full
	  */
	public void fill(ArrayList<T> list) throws StackOverflowException
	{
		ArrayList<T> listCopy = new ArrayList<>(list);
		
		for(int i = 0; i < listCopy.size(); i++)
		{
			if(isFull())
				throw new StackOverflowException();
			else
			{
				stack.push(listCopy.get(i));
				size++;
			}
				
		}
	}
}

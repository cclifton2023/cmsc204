import java.util.*;

public class ArraySumDriver 
{
	private final static int ARRAY_SIZE = 6;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int index = 0;

		Integer[] myArray = new Integer[ARRAY_SIZE];
		
		myArray[index++] = 13;
		myArray[index++] = 5;
		myArray[index++] = 12;
		myArray[index++] = 6;
		
		int sum = sumOfArray(myArray, 3);
		System.out.println(sum);
		
		myArray[index++] = 7;
		myArray[index++] = 1;
		
		sum = sumOfArray(myArray, 5);
		System.out.println(sum);
		
		System.out.print("The 8th number in the Fibonacci sequence is " + Fibonacci(8));
	}
	
	/**
	 * Recursive method for generating sum of values in array
	 * @param arr array of Integers
	 * @param num index of array to sum all previous index values (including num)
	 * @return sum of array values
	 */
	
	public static int sumOfArray(Integer[] arr, int num) //IMPLEMENTED BY CAITLYN CLIFTON
	{
			if (num == 0)
				return arr[num];
			else
				return arr[num] + sumOfArray(arr, num-1);
	}
	public static int Fibonacci(int num) //CREATED BY CAITLYN CLIFTON
	{
		int f[] = new int[num+2]; //array to store sequence
		
		//THESE VALUES DO NOT CHANGE
		f[0] = 0;
		f[1] = 1;
		
		for(int i = 2; i <= num + 1; i++)
		{
			//Adds the previous 2 numbers and stores the sum
			f[i] = f[i-1] + f[i-2];
		}
		return f[num + 1];
	}
}
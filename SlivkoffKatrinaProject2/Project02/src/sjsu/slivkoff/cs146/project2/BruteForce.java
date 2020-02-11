/**
 * method implements maximum subarray using brute force
 * the run time is O(n^2)
 *
 * @author Katrina Slivkoff
 */
package sjsu.slivkoff.cs146.project2;

public class BruteForce {

	public static int[] findMaxSubarray(int[] array)		
	{
		int max = 0; //initializes the max value in array
		int start = 0; //initializes the start value in array
		int end = 0; //initializes the end value in array
		for	(int i = 0; i < array.length; i++)
		{
			int sum = 0; //initializes the sum in array			
			for (int j = i; j < array.length; j++)	
			{
				sum = sum + array[j];
				if(sum > max)
				{
					max = sum;
					start = i;
					end = j;
				}
			}
		}
		return new int[] {max, start, end}; //returns the max, start, and end of array
	}

	/*
	 * test for Brute Force implementation
	 */
	public static void main(String[] args)
	{
		int array[] = { -2, -3, 4, -1, -2, 1, 5, -3, 7, 2, 6 };
		int a[] = findMaxSubarray(array);

		System.out.println("Maximum earning is $" + a[0]);
		System.out.println("Start day " + a[1]);
		System.out.println("End day " + a[2]);
	}
}

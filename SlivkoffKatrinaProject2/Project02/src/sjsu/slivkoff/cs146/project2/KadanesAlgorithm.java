/**
* method implements maximum subarray using Kadane's Algorithm
* the run time is O(n)
*
* @author Katrina Slivkoff
*/
package sjsu.slivkoff.cs146.project2;

public class KadanesAlgorithm {

	private static int maxSum = 0; //instance variable for the max sum
	private static int arrive = -1; //instance variable for the arrival date
	private static int depart = -1; //instance variable for the departure date

	public static int[] findMaxSubarray(int[] array)
	{
		int maxTemp = 0; // initializes the temporary max value to 0
		int tempArrive = 0; // initializes the temp0rary arrival value to 0

		for (int i = 0; i < array.length; i++) 
		{
			maxTemp = maxTemp + array[i];
			if (maxTemp < 0) 
			{
				maxTemp = 0;
				arrive = i + 1;
			}

			if (maxSum < maxTemp) 
			{
				maxSum = maxTemp;
				depart = i;
				tempArrive = arrive;
			}
		}
		arrive = tempArrive;
		return new int[] {maxSum, arrive, depart}; //returns the max sum, arrival day, and departure day
	}

	/*
	 * test for Kadane's Algorithm implementation
	 */
	public static void main(String[] args)
	{
		int array[] = { -2, -3, 4, -1, -2, 1, 5, -3, 7, 2, 6 };
		findMaxSubarray(array);

		System.out.println("Maximum earning is $" + maxSum);
		System.out.println("Arrival " + arrive);
		System.out.println("Departure " + depart);
	}
}

/**
* method implements maximum subarray using divide and conquer
* the run time is O(nlgn)
*
* @author Katrina Slivkoff
*/
package sjsu.slivkoff.cs146.project2;

public class DivideAndConquer {
	private int start; // instance variable for start value
	private int end; // instance variable for end value
	private int maxSum; // instance variable for maxSum value
	
	public DivideAndConquer(int start, int end, int maxSum)
	{
		this.start = start;
		this.end = end;
		this.maxSum = maxSum;
	}

	public static DivideAndConquer findMaxCrossSubarray(int[] array, int low, int mid, int high)	
	{	
		int leftSum = 0; // initializes left side of array sum
		int sum = 0; // initializes sum of array
		int leftMax = 0; // initializes max of left side of array
		for(int i = mid; i >= low; i--)
		{
			sum = sum + array[i];
			if(sum > leftSum)
			{
				leftSum = sum;
				leftMax = i;
			}
		}
		
		int rightSum = 0; // initializes right side of array sum
		sum = 0; // initializes sum of this array
		int rightMax = 0;
		for(int j = mid + 1; j <= high; j++)
		{
			sum = sum + array[j];
			if(sum > rightSum)
			{
				rightSum = sum;
				rightMax = j;
			}
		}
		return new DivideAndConquer(leftMax, rightMax, leftSum + rightSum);
	}
	
	public static DivideAndConquer findMaxSubarray(int[] array, int low, int high)
	{
		if(high == low)
		{
			return new DivideAndConquer(low, high, array[low]);
		}
		else
		{
			int mid = (low + high)/2; // middle of array is the low plus high divided by 2
			DivideAndConquer leftSum = findMaxSubarray(array, low, mid); //recursive call to find left sum of array
			DivideAndConquer rightSum = findMaxSubarray(array, mid + 1, high); //recursive call to find right sum of array
			DivideAndConquer crossSum = findMaxCrossSubarray(array, low, mid, high); //recursive call to find cross sum of array
	        if (leftSum.maxSum >= rightSum.maxSum && leftSum.maxSum >= crossSum.maxSum)
	        {
	            return leftSum;
	        }
	        else if (rightSum.maxSum >= leftSum.maxSum && leftSum.maxSum >= crossSum.maxSum) 
	        {
	            return rightSum;
	        }
	        else 
	        {
	            return crossSum;
	        }
		}	
	}
	
	/*
	 * test for Divide and Conquer implementation
	 */
	public static void main(String[] args)
	{
		int array[] = { -2, -3, 4, -1, -2, 1, 5, -3, 7, 2, 6 };
		DivideAndConquer max = findMaxSubarray(array, 0, array.length-1);
		System.out.println("Maximum earning is $" + max.maxSum);
		System.out.println("Start day is " + max.start);
		System.out.println("End day is " + max.end);
	}
}

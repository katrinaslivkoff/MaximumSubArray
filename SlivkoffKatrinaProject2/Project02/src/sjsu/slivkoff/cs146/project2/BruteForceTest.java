/**
 * JUnit test for brute force algorithm
 *
 * @author Katrina Slivkoff
 */
package sjsu.slivkoff.cs146.project2;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;


public class BruteForceTest {
	Random random = new Random(); // initializes the random value
	
	@Test
	public void test() {
		ArrayList<Integer> array = new ArrayList<>();
		try {
			Scanner scan = new Scanner(new File("maxSumtest.txt"));
			while(scan.hasNext()) 
			{
				array.add(scan.nextInt());
			}
			scan.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}	
		
		int array1[] = { -2, -3, 4,	-1,	-2,	1, 5, -3, 7, 2,	6 };
		int a[] = BruteForce.findMaxSubarray(array1);
		assertEquals(19, a[0]);
		assertEquals(2, a[1]);
		assertEquals(10, a[2]);
	}
	
	/*
	 * the following test is the same format for the rest of the tests with a different array size
	 * it first creates a new array with specific size
	 * makes a loop to create a random array 
	 * finds the maximum sub array at that random array
	 */
	@Test
	public void test1() {
		int[] array = new int[100];
		for	(int i = 1; i < 100; i++)		
		{
			array[i] = random.nextInt();
		}
		long begin = System.nanoTime();
		BruteForce.findMaxSubarray(array);
		long finish = System.nanoTime();
		long timeElapsed = finish - begin;
		System.out.println("Total time for size 100: " + (timeElapsed/10) + " nanoseconds");
	}

	@Test
	public void test2() {
		int[] array = new int[200];
		for	(int i = 1; i < 200; i++)		
		{
			array[i] = random.nextInt();
		}
		long begin = System.nanoTime();
		BruteForce.findMaxSubarray(array);
		long finish = System.nanoTime();
		long timeElapsed = finish - begin;
		System.out.println("Total time for size 200: " + (timeElapsed/10) + " nanoseconds");
	}

	@Test
	public void test3() {
		int[] array = new int[500];
		for	(int i = 1; i < 500; i++)		
		{
			array[i] = random.nextInt();
		}
		long begin = System.nanoTime();
		BruteForce.findMaxSubarray(array);
		long finish = System.nanoTime();
		long timeElapsed = finish - begin;
		System.out.println("Total time for size 500: " + timeElapsed/10 + " nanoseconds");
	}

	@Test
	public void test4() {
		int[] array = new int[1000];
		for	(int i = 1; i < 1000; i++)		
		{
			array[i] = random.nextInt();
		}
		long begin = System.nanoTime();
		BruteForce.findMaxSubarray(array);
		long finish = System.nanoTime();
		long timeElapsed = finish - begin;
		System.out.println("Total time for size 1000: " + (timeElapsed/10) + " nanoseconds");
	}

	@Test
	public void test5() {
		int[] array = new int[2000];
		for	(int i = 1; i < 2000; i++)		
		{
			array[i] = random.nextInt();
		}
		long begin = System.nanoTime();
		BruteForce.findMaxSubarray(array);
		long finish = System.nanoTime();
		long timeElapsed = finish - begin;
		System.out.println("Total time for size 2000: " + (timeElapsed/10) + " nanoseconds");
	}

	@Test
	public void test6() {
		int[] array = new int[5000];
		for	(int i = 1; i < 5000; i++)		
		{
			array[i] = random.nextInt();
		}
		long begin = System.nanoTime();
		BruteForce.findMaxSubarray(array);
		long finish = System.nanoTime();
		long timeElapsed = finish - begin;
		System.out.println("Total time for size 5000: " + (timeElapsed/10) + " nanoseconds");
	}

	@Test
	public void test7() {
		int[] array = new int[10000];
		for	(int i = 1; i < 10000; i++)		
		{
			array[i] = random.nextInt();
		}
		long begin = System.nanoTime();
		BruteForce.findMaxSubarray(array);
		long finish = System.nanoTime();
		long timeElapsed = finish - begin;
		System.out.println("Total time for size 10000: " + (timeElapsed/10) + " nanoseconds");
	}
}


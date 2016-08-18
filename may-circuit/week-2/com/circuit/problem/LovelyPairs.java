package com.circuit.problem;

import java.util.Scanner;

public class LovelyPairs {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();
		for (int a0 = 1; a0 <= numOfTestCases; a0++) {
			int n = in.nextInt();
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
			}
			sort(a,0,a.length-1);
			System.out.println(calculateLovelyPairs(a));
		}
		in.close();
	}

	private static int calculateLovelyPairs(int[] a) 
	{
		int leftCount = 1;
		int rightCount = 1;
		int result = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == a[i + 1] && a[i + 1] != a[a.length - 1]) {
				leftCount++;
			} else
				break;
		}

		for (int i = a.length - 1; i > 0; i--) {
			if (a[i] == a[i - 1] && a[i - 1] != a[0]) {
				rightCount++;
			} else
				break;
		}
		if (leftCount > 1 && rightCount > 1)
			result = leftCount + rightCount;
		else
			result = leftCount + rightCount - 1;
		return result;
	}

	/*private static void sort(int[] a) {// Bubble sort
		for (int pass = 0; pass < a.length; pass++) {
			for (int j = pass; j < (a.length - pass - 1); j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}*/
	private static void sort(int[] a, int low, int high) {// Bubble sort
		int N = high - low;         
        if (N <= 1) 
            return; 
        int mid = low + N/2; 
        // recursively sort 
        sort(a, low, mid); 
        sort(a, mid, high); 
        // merge two sorted subarrays
        int[] temp = new int[N];
        int i = low, j = mid;
        for (int k = 0; k < N; k++) 
        {
            if (i == mid)  
                temp[k] = a[j++];
            else if (j == high) 
                temp[k] = a[i++];
            else if (a[j]<a[i]) 
                temp[k] = a[j++];
            else 
                temp[k] = a[i++];
        }    
        for (int k = 0; k < N; k++) 
            a[low + k] = temp[k];    
	}
}

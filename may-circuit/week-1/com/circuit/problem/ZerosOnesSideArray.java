package com.circuit.problem;

/**
 * Segregate 0s and 1s in an array Asked by kapil.
 * 
 * You are given an array of 0s and 1s in random order. Segregate 0s on left
 * side and 1s on right side of the array. Traverse array only once.
 * 
 * Input array = [0, 1, 0, 1, 0, 0, 1, 1, 1, 0] Output array = [0, 0, 0, 0, 0,
 * 1, 1, 1, 1, 1] Method 1 (Count 0s or 1s) Thanks to Naveen for suggesting this
 * method. 1) Count the number of 0s. Let count be C. 2) Once we have count, we
 * can put C 0s at the beginning and 1s at the remaining n – C positions in
 * array.
 * 
 * Time Complexity: O(n)
 * 
 * The method 1 traverses the array two times. Method 2 does the same in a
 * single pass.
 * 
 * 
 * 
 * Method 2 (Use two indexes to traverse) Maintain two indexes. Initialize first
 * index left as 0 and second index right as n-1.
 * 
 * Do following while left < right a) Keep incrementing index left while there
 * are 0s at it b) Keep decrementing index right while there are 1s at it c) If
 * left < right then exchange arr[left] and arr[right]
 *
 */
public class ZerosOnesSideArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = { 0, 1, 0, 0, 1, 0, 1, 1, 0 };

		int left = 0;
		int right = array.length - 1;

		while (left < right) {
			while (array[left] == 0 && left < right)
				left++;
			while (array[right] == 1 && left < right)
				right--;

			if (left < right) {
				array[left] = 0;
				array[right] = 1;
				left++;
				right--;
			}
		}
		// ={{0,0,0,0,0,,1,1,1,1}
		for (int i = 0; i < array.length; i++) {
			System.out.print(" " + array[i]);
		}
	}
}

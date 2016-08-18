package com.circuit.problem;

import java.util.Scanner;

public class AngryProfessor {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
        int numOfTestCases = in.nextInt();
        for(int a0 = 1; a0 <= numOfTestCases; a0++){
            int n = in.nextInt();
            int k = in.nextInt();	
            int a[] = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            System.out.println(calculateIfClassPossible(n, k, a));
        }
	}

	private static String calculateIfClassPossible(int numOfStudents, int threshold, int[] studentArray) {

		int count = 0;
		for (int str : studentArray) {
			if (str >= 0) 
				count++;
		}
		System.out.println("THRTESHOLD->"+ threshold+", "+"count->"+count);
		if (count < threshold)
			return "YES";
		
		return "NO";
	}
}

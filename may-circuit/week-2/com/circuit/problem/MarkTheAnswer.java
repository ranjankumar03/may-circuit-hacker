package com.circuit.problem;

import java.util.Scanner;

public class MarkTheAnswer {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int numOfQuestions = in.nextInt();
		int threshold = in.nextInt();

		int a[] = new int[numOfQuestions];
		int score = 0;
		int breakCount = 0;
		for (int i = 0; i < numOfQuestions; i++) {
			a[i] = in.nextInt();
			if (a[i] <= threshold && breakCount < 2) {
				score++;
			} 
			else if (a[i] > threshold && breakCount < 2){
				breakCount++;
				continue;
			}
			else
				break;
		}

		/*for (int i = 0; i < numOfQuestions; i++) {
			if (a[i] <= threshold && breakCount < 2) {
				score++;
			} 
			else if (a[i] > threshold && breakCount < 2){
				breakCount++;
				continue;
			}
			else
				break;
		}	*/
		System.out.println(score);
	}
}

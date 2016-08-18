package com.circuit.problem;

import java.util.Arrays;
import java.util.Scanner;

public class JPRotations {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();

		int source[] = new int[N];
		int target[] = new int[N];

		for (int i = 0; i < N; i++)
			source[i] = in.nextInt();
		for (int i = 0; i < N; i++)
			target[i] = in.nextInt();

		int result = -1;
		for (int i = 0; i < M; i++) {

			String direction = in.next();
			int d = in.nextInt();
			rotate(direction, d, source);

			if (Arrays.equals(source, target)) {
				result = i+2;
				System.out.println(i + 1);
				break;
			}
		}
		if(result == -1)
			System.out.println(result);
		System.exit(0);
	}

	private static void rotate(String direction, int d, int[] source) {

		for (int i = 0; i < d; i++) {
			if (direction.equalsIgnoreCase("L")) {
				leftRotatebyOne(source, source.length - 1);
			} else if (direction.equalsIgnoreCase("R")) {
				rightRotatebyOne(source, source.length - 1);
			}
		}

	}

	private static void rightRotatebyOne(int[] arr, int n) {
		// TODO Auto-generated method stub
		int i, temp;
		temp = arr[n];
		for (i = n; i > 0; i--)
			arr[i] = arr[i - 1];
		arr[0] = temp;
	}

	private static void leftRotatebyOne(int[] arr, int n) {
		// TODO Auto-generated method stub
		int i, temp;
		temp = arr[0];
		for (i = 0; i < n; i++)
			arr[i] = arr[i + 1];
		arr[n] = temp;
	}
}

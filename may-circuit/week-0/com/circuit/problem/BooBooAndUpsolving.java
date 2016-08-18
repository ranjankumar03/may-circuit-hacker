package com.circuit.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BooBoo and Upsolving The hero of this story is a toddler named BooBoo.
 * Inspired by the legendary competitive coder Gena, BooBoo has also started
 * preparing to race to the top of the ranks.
 * 
 * BooBoo is going to practice N different problems in the exact given order
 * over the next M days. For each problem, he writes down the amount of time q i
 * qi he will take to think and code the ith ith problem (He is quite good at
 * estimating!). Before starting on the problems, he took advice from
 * experienced competitive programmers on his practice routine and almost all of
 * them advised him to keep his daily load at the minimum possible and avoid
 * over training.
 * 
 * Since BooBoo already has N problems to solve, he asks you to find the minimum
 * time T T such that training everyday for a time ti≤Tti≤T is sufficient to
 * solve all the N problems in M M days.
 * 
 * Note : Unlike in real world, you cannot think on a problem on one day and
 * solve it on the other day. You need to do it on the very same day!
 * 
 * Input Format:
 * 
 * The first line contains two space separated integers N N and The next line
 * contains N space separated integers denoting the time qi required to solve
 * the ith problem.
 * 
 * Output Format:
 * 
 * The output consists of one integer, the minimum time T as described in the
 * problem statement.
 * 
 * SAMPLE INPUT 5 3 1 2 2 1 3 SAMPLE OUTPUT 3 Explanation By setting T = 3, we
 * can solve 1st two questions on day 1, next two on day 2 and 5th one on day 3.
 *
 */
public class BooBooAndUpsolving {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader firstLine = null;
		BufferedReader secondLine = null;
		final int TIME_SERIES_LENGTH = 0;
		final int TOTAL_DAY_LENGTH = 1;
		final String SPACE_DELIMITER = " ";

		try {
			firstLine = new BufferedReader(new InputStreamReader(System.in));
			String[] fstLine = firstLine.readLine().split(SPACE_DELIMITER);
			int M = Integer.parseInt(fstLine[TIME_SERIES_LENGTH]);
			int N = Integer.parseInt(fstLine[TOTAL_DAY_LENGTH]);

			secondLine = new BufferedReader(new InputStreamReader(System.in));
			String[] timeLineArray = secondLine.readLine().split(SPACE_DELIMITER);

			boolean ifValid = true;
			ifValid = validate(M, N, timeLineArray, ifValid);
			if (ifValid) {
				compute(M, N, timeLineArray);
			}
			System.exit(0);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	private static void compute(int m, int n, String[] timeLineArray) {

		int sum = 0;
		for (String str : timeLineArray) {
			sum += Integer.parseInt(str);
		}
		int minTimeToFinish = (int) Math.floor(sum / n);
		System.out.println(minTimeToFinish);
	}

	private static boolean validate(int m, int n, String[] timeLineArray, boolean ifValid) {

		if (timeLineArray.length != m || m < 0 || n < 0) {
			return false;
			// throw new
			// IllegalArgumentException("Input is incorrect.........");
		}
		return true;
	}
}

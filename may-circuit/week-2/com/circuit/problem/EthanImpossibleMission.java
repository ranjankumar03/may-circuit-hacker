package com.circuit.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EthanImpossibleMission {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		BufferedReader firstLine = null;
		BufferedReader secondLine = null;
		BufferedReader thirdLine = null;
		final int TIME_SERIES_LENGTH = 0;
		final int TOTAL_DAY_LENGTH = 1;
		final String SPACE_DELIMITER = " ";

		try {
			firstLine = new BufferedReader(new InputStreamReader(System.in));
			String[] fstLine = firstLine.readLine().split(SPACE_DELIMITER);
			int N = Integer.parseInt(fstLine[0]);
			System.out.println("N->"+ N);
			int Q = Integer.parseInt(fstLine[1]);//query
			System.out.println("Q->"+ Q);
			int M = Integer.parseInt(fstLine[2]); //modulo
			System.out.println("M->"+ M);

			secondLine = new BufferedReader(new InputStreamReader(System.in));
			String[] elementArray = secondLine.readLine().split(SPACE_DELIMITER);
			System.out.println("elementArray length->"+ elementArray.length);
			
			if(elementArray.length != N)
				throw new IllegalArgumentException("Number of Elements eneterd is incorrect..pleas chck");

			int i = 0;
			while(i <= (Q-1)){
				thirdLine = new BufferedReader(new InputStreamReader(System.in));
				int index = Integer.parseInt(thirdLine.readLine());
				compute(elementArray, Q, M);
				i++;
			}
				
			/*boolean ifValid = true;
			ifValid = validate(M, N, timeLineArray, ifValid);
			if (ifValid) {*/
				//compute(M, N, M);
			//}
			//System.exit(0);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	private static void compute(String[] elementArray, int q, int M) {

		int sum = 0;
		int counter =1;
		for (String str : elementArray) {
			if(counter == q)
				continue;
			sum *= Integer.parseInt(str);
		}
		int result = sum % M;
		System.out.println(result);
	}

	/*private static boolean validate(int m, int n, String[] timeLineArray, boolean ifValid) {

		if (timeLineArray.length != m || m < 0 || n < 0) {
			return false;
			// throw new
			// IllegalArgumentException("Input is incorrect.........");
		}
		return true;
	}*/
	//}

}

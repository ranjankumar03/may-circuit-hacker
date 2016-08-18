package com.circuit.problem;

/**
 *  Xenny and Classroom
	Xenny was a teacher and his class consisted of 
	N
	N boys and 
	N
	N girls. He took all his students to the playground and asked them to stand in a straight line. The boys and the girls formed a perfect line, 
	but Xenny seemed unhappy. He wanted them to form an alternating sequence of boys and girls, i.e., he wanted that after a boy, there should be
	a girl in the line, and vice-versa.
	In order to form an alternating sequence, a boy and a girl could swap their positions.
	Given the original sequence in which the boys and girls were standing, find the minimum number of swaps required to form an alternating sequence.
	
	Note: An alternating sequence can start either with a boy or a girl.
	
	Input
	
	First line of input consists of a natural number 
	T - the number of testcases.
	For each testcase:
	
	First line consists of a single integer 
	N
	N - the number of boys, and the number of girls.
	Second line consists of a string of length 
	2
	N
	2N, representing the original sequence.
	In this string, a boy is represented by uppercase character 
	B
	B and a girl by G
		
		For each testcase, print the minimum number of swaps required to get an alternating sequence on a new line.
		
		SAMPLE INPUT 
		1
		2
		BBGG
		SAMPLE OUTPUT
		1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XennyAndClassroom 
{
	public static void main(String[] args) {

		BufferedReader testCaseNumberReader = null;
		BufferedReader sexNumberReader = null;
		BufferedReader sequenceReader = null;

		try {
			testCaseNumberReader = new BufferedReader(new InputStreamReader(System.in));
			int testCaseNumber = Integer.parseInt(testCaseNumberReader
					.readLine());

			for (int i = 0; i < testCaseNumber; i++) {
				sexNumberReader = new BufferedReader(new InputStreamReader(System.in));
				int sexNumber = Integer.parseInt(sexNumberReader.readLine());

				sequenceReader = new BufferedReader(new InputStreamReader(System.in));
				String sequence = sequenceReader.readLine();

				validate(sequence, sexNumber);//validation
				int count = 0;
				count = compute(sequence, count);//compute
				System.out.println(count);
				if (i == (testCaseNumber - 1)) {
					System.exit(0);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	private static void validate(String sequence, int sexNumber) {

		if (sequence.length() != sexNumber * 2) {
			throw new IllegalArgumentException("Sequence length is incorrect...........");
		}
		int boyCount=0 ,girlCount = 0;
		char[] charArray = sequence.toLowerCase().toCharArray();
		for (int i = 0; i < sequence.length(); i++) {
			if (charArray[i] == 'b')
				boyCount++;
			else
				girlCount++;
		}
		if (boyCount != girlCount)
			throw new IllegalArgumentException("Number of boys and girls mismatch...........");
	}

	private static int compute(String sequence, int count) {
		
		char[] charSeq = sequence.toLowerCase().toCharArray();
		int boyIndex = 0;
		int girlIndex = 1;
		if (charSeq[0] == 'G') {
			boyIndex = 1;
			girlIndex = 0;
		}

		boolean jump = false;
		for (int i = 1; i < sequence.length(); i++) {
			if (charSeq[i - 1] == charSeq[i]) {
				for (int j = i + 1; j < sequence.length(); j++) {
					if (charSeq[j] == 'g' && j % 2 == boyIndex) {
						swap(charSeq, i, j);
						jump = true;
						break;
					} else if (charSeq[j] == 'b' && j % 2 == girlIndex) {
						swap(charSeq, i, j);
						jump = true;
						break;
					}
				}
				if (jump) {
					i = i + 2;
					count++;
				}
			}
		}
		return count;
	}

	private static void swap(char[] charSeq, int i, int j) {
		char temp = charSeq[i];
		charSeq[i] = charSeq[j];
		charSeq[j] = temp;
	}
}

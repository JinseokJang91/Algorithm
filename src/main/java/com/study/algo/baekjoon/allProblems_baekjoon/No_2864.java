package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2864 {

	public static void main(String[] args) throws Exception{

		//2864�� 5�� 6�� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//�� �� A, B�� �־����� �� �� ���� �ּڰ��� �ִ�
		//��, 5�� 6����, 6�� 5�� �� �� �ִٴ� ������ ����
		
		//�ּڰ��� 6�� ���� 5��, �ִ��� 5�� ���� 6���� �ٲٸ� ��
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		String A = st.nextToken();
		String B = st.nextToken();
		
		//replaceAll Ȱ��
		int minA = Integer.parseInt(A.replaceAll("6", "5"));
		int maxA = Integer.parseInt(A.replaceAll("5", "6"));
		int minB = Integer.parseInt(B.replaceAll("6", "5"));
		int maxB = Integer.parseInt(B.replaceAll("5", "6"));
		
		//System.out.println("�ּڰ� : " + (minA + minB));
		//System.out.println("�ִ� : " + (maxA + maxB));
		System.out.println((minA + minB) + " " + (maxA + maxB));
		
		br.close();
	}

}

package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_11943 {

	public static void main(String[] args) throws Exception{

		//11943�� ���� �ű��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = null;
		int A = 0;
		int B = 0;
		int C = 0;
		int D = 0;
		for(int i=0; i<2; i++) {
			String input = br.readLine();
			st = new StringTokenizer(input, " ");
			if(i == 0) {
				A = Integer.parseInt(st.nextToken());
				B = Integer.parseInt(st.nextToken());
			}else {
				C = Integer.parseInt(st.nextToken());
				D = Integer.parseInt(st.nextToken());
			}
		}
		
		//ù ��° �ٱ��� - ��� A / ������ B
		//�� ��° �ٱ��� - ��� C / ������ D
		//1. A + D
		//2. B + C
		int minMove = Math.min(A + D, B + C);
		System.out.println("�ּ� Ƚ�� : " + minMove);
		br.close();
	}

}

package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2475 {

	public static void main(String[] args) throws Exception{

		//2475�� ������
		//ó�� �ټ� �ڸ��� ���� ������ ���� ������ ���� �� �� ���� 10���� ���� ��������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		
		int powSum = 0;
		while(st.hasMoreTokens()) {
			powSum += (int)Math.pow(Integer.parseInt(st.nextToken()), 2);
		}
		//System.out.println("powSum : " + powSum);
		
		int answer = powSum % 10;
		System.out.println(answer);
		
		br.close();
	}

}

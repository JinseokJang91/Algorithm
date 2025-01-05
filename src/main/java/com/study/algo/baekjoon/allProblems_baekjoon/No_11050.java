package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_11050 {

	public static void main(String[] args) throws Exception{

		//11050번 이항계수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//이항계수
		//(n)
		//(k) 이면 nCk를 의미 - nCk = n! / ((n-k)! x k!)

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int result = cal(n,k);

		//### 공식으로 풀었지만 이항계수의 원리에 대해 파악하는 것도 중요!

		br.close();
	}

	//nCk 계산
	public static int cal(int n, int k) {

		int num1 = 1;
		int num2 = 1;
		int num3 = 1;

		//n!
		for(int i=n; i>1; i--) {
			num1 *= i;
		}

		//(n-k)!
		for(int i=(n-k); i>1; i--) {
			num2 *= i;
		}

		//k!
		for(int i=k; i>1; i--) {
			num3 *= i;
		}

		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		System.out.println("num3 : " + num3);

		//nCk
		int answer = num1 / (num2 * num3);
		System.out.println("answer : " + answer);

		return answer;
	}

}

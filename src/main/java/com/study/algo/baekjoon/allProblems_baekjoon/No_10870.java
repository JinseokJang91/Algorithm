package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_10870 {

	public static void main(String[] args) throws Exception{

		//10870번 피보나치 수 5
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//피보나치수 - 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
		//Fn = Fn-1 + Fn-2 ( n>=2 )
		//n번째 피보나치수는 앞 두 피보나치 수의 합

		int n = Integer.parseInt(br.readLine());

		//0번째는 0, 1번째는 1, 2번째부터 공식 적용됨
		int answer = 0;
		if(n >= 0) {
			switch(n) {
				case 0 :
					answer = 0;
					break;
				case 1 :
					answer = 1;
					break;
				default :
					answer = fibonacci(n);
					break;
			}
		}

		System.out.println(answer);

	}

	public static int fibonacci(int n) {

		//n번째 까지의 피보나치 수를 List에 넣던지 값을 바로 구하자

		int num1 = 0;		//0번째 피보나치 수
		int num2 = 1;		//1번째 피보나치 수
		int result = 0;		//n번째 피보나치 수를 담을 변수

		int idx = 2;	//2번째 피보나치 수부터 구하는 것이므로 인덱스는 2부터
		while(idx <= n) {
			result = num1 + num2;
			num1 = num2;
			num2 = result;
			//System.out.println("result : " + result);
			//System.out.println("num1 : " + num1);
			//System.out.println("num2 : " + num2);
			idx++;
		}

		return result;
	}

}

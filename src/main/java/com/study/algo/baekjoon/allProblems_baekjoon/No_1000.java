package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_1000 {

	public static void main(String[] args) throws Exception{

		//코로나에 걸린 관계로 쉬운 문제를 풀자..
		//1000번 A+B
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		String[] inputs = input.split(" ");
		int A = Integer.parseInt(inputs[0]);
		int B = Integer.parseInt(inputs[1]);

		System.out.println(A + B);
		br.close();
	}

}

package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_2741 {

	public static void main(String[] args) throws Exception{

		//2741번 N찍기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for(int i=1; i<=N; i++) {
			System.out.println(i);
		}

		br.close();
	}
}

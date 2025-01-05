package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_11382 {

	public static void main(String[] args) throws Exception{

		//11382번 꼬마 정민
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");

		long A = 0;
		long B = 0;
		long C = 0;
		while(st.hasMoreTokens()) {
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			C = Long.parseLong(st.nextToken());
		}

		System.out.println(A + B + C);
		br.close();
	}

}

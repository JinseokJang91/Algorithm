package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_8370 {

	public static void main(String[] args) throws Exception{

		//8370번 Plane
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");

		int n1 = Integer.parseInt(st.nextToken());
		int k1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		int k2 = Integer.parseInt(st.nextToken());

		System.out.println(n1 * k1 + n2 * k2);
		br.close();

	}

}

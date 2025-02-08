package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_16430 {

	public static void main(String[] args) throws Exception{

		//16430 제리와 톰
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		System.out.println("" + (B-A) + " " + B);
		br.close();
	}

}

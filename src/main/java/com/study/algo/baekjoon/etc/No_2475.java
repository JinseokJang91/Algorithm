package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2475 {

	public static void main(String[] args) throws Exception{

		//2475번 검증수
		//처음 다섯 자리에 들어가는 각각의 수의 제곱을 합한 후 그 합을 10으로 나눈 나머지값
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

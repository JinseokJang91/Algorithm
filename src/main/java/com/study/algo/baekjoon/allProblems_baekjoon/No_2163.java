package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2163 {

	public static void main(String[] args) throws Exception{

		//2163번 초콜릿 자르기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		//NxM 크기의 초콜릿을 NxM개의 조각으로 나누기 위해 쪼개야 하는 횟수는 N*M-1번임

		System.out.println(N * M - 1);
		br.close();
	}

}

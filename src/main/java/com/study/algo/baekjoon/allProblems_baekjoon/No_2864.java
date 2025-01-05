package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2864 {

	public static void main(String[] args) throws Exception{

		//2864번 5와 6의 차이
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//두 수 A, B가 주어졌을 때 두 수의 최솟값과 최댓값
		//단, 5를 6으로, 6을 5로 볼 수 있다는 조건이 있음

		//최솟값은 6을 전부 5로, 최댓값은 5를 전부 6으로 바꾸면 됨
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		String A = st.nextToken();
		String B = st.nextToken();

		//replaceAll 활용
		int minA = Integer.parseInt(A.replaceAll("6", "5"));
		int maxA = Integer.parseInt(A.replaceAll("5", "6"));
		int minB = Integer.parseInt(B.replaceAll("6", "5"));
		int maxB = Integer.parseInt(B.replaceAll("5", "6"));

		//System.out.println("최솟값 : " + (minA + minB));
		//System.out.println("최댓값 : " + (maxA + maxB));
		System.out.println((minA + minB) + " " + (maxA + maxB));

		br.close();
	}

}

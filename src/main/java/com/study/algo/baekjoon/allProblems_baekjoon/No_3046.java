package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_3046 {

	public static void main(String[] args) throws Exception{

		//3046�� R2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		int R1 = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		//S = R1 + R2 / 2 �̹Ƿ�
		//R2 = 2S - R1
		
		int R2 = 2 * S - R1;
		System.out.println(R2);
		
		br.close();
	}

}

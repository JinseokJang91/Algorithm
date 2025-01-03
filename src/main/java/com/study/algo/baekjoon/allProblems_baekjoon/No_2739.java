package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_2739 {

	public static void main(String[] args) throws Exception{
		
		//2739�� ������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=9; i++) {
			System.out.println(N + " * " + i + " = " + (N * i));
		}
		
		br.close();
	}
}

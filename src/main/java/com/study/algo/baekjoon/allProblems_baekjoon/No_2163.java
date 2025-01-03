package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2163 {

	public static void main(String[] args) throws Exception{

		//2163�� ���ݸ� �ڸ���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//NxM ũ���� ���ݸ��� NxM���� �������� ������ ���� �ɰ��� �ϴ� Ƚ���� N*M-1����
		
		System.out.println(N * M - 1);
		br.close();
	}

}

package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_1001 {

	public static void main(String[] args) throws Exception{
		//�ڷγ��� �ɸ� ����� ���� ������ Ǯ��..
		//1001�� A-B
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		String[] inputs = input.split(" ");
		int A = Integer.parseInt(inputs[0]);
		int B = Integer.parseInt(inputs[1]);
		
		System.out.println(A - B);
		br.close();

	}

}

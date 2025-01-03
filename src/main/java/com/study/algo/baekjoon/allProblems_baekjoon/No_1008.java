package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_1008 {

	public static void main(String[] args) throws Exception{

		//1008�� A/B
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String[] inputs = input.split(" ");
		
		double A = Double.parseDouble(inputs[0]);
		double B = Double.parseDouble(inputs[1]);
		//String ans = String.format("%.24f", A/B); //����ó�� �ڸ����� �� ���� �ʿ�� ���� �� ����. �׸��� ����ϸ� 0.333333333333333000~�̷������� ����
		System.out.println(A/B);
	}

}
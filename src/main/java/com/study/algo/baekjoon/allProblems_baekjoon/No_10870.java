package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_10870 {

	public static void main(String[] args) throws Exception{

		//10870�� �Ǻ���ġ �� 5
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//�Ǻ���ġ�� - 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
		//Fn = Fn-1 + Fn-2 ( n>=2 )
		//n��° �Ǻ���ġ���� �� �� �Ǻ���ġ ���� ��

		int n = Integer.parseInt(br.readLine());
		
		//0��°�� 0, 1��°�� 1, 2��°���� ���� �����
		int answer = 0;
		if(n >= 0) {
			switch(n) {
			case 0 :
				answer = 0;
				break;
			case 1 :
				answer = 1;
				break;
			default : 
				answer = fibonacci(n);
				break;
			}
		}
		
		System.out.println(answer);
		
	}
	
	public static int fibonacci(int n) {
		
		//n��° ������ �Ǻ���ġ ���� List�� �ִ��� ���� �ٷ� ������
		
		int num1 = 0;		//0��° �Ǻ���ġ ��
		int num2 = 1;		//1��° �Ǻ���ġ ��
		int result = 0;		//n��° �Ǻ���ġ ���� ���� ����
		
		int idx = 2;	//2��° �Ǻ���ġ ������ ���ϴ� ���̹Ƿ� �ε����� 2����
		while(idx <= n) {
			result = num1 + num2;
			num1 = num2;
			num2 = result;
			//System.out.println("result : " + result);
			//System.out.println("num1 : " + num1);
			//System.out.println("num2 : " + num2);
			idx++;
		}
		
		return result;
	}

}

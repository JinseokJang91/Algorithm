package com.study.algo.baekjoon.allProblems_baekjoon;

import java.util.Scanner;

public class No_2839 {

	public static void main(String[] args) {
		
		//���� ���
		//3ų��, 5ų�� ���� �� ����
		//Nų�α׷� �ּ� ���� ���� �� �������� ���ϱ�
		
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine());
		*/
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		//5x + 3y = N �� ��
		//x + y �� �ּҰ� �Ǵ� ���� ���ϱ�
		
		//N = 18
		//5x + 3y = 18
		
		int x_size = N/5;	//N�� 5�� ���� �ִ��
		int yCases = N;		//n�� 3���� ���� ��� ���ϱ� ���� �ʱⰪ
		int xCases = 0;
		
		boolean yn = false;	//3���� �������������� ���� �Ǵ��� ��
		
		if(N % 5 == 0) {
			System.out.println("#1 :  " + N / 5);
			return;
		}
		
		if(N % 3 == 0) {
			//System.out.println("#2 :  " + N / 3);
			//return;
			yCases = N/3;
		}		
		
		
		for(int i=0; i<=x_size; i++) {
			int n = N - 5 * i;	//�ִ�� ������ŭ N���� 5*i��ŭ ���� ��
			//n�� 3���� ������������ ����Ǽ� ���
			//x=1 -> 18-5*1 = 13 -> 13%3 != 0
			//x=2 -> 18-5*2 = 8 -> 8%3 != 0
			//x=3 -> 18-5*3 = 3 -> 3%3 == 0
			if(n % 3 == 0) {
				if(n / 3 <= yCases) {
					xCases = i;
					yCases = n / 3;
					yn = true;
				}
			}
		}
		System.out.println("xCases : " + xCases);
		System.out.println("yCases : " + yCases);
		
		if(yn == true) {
			System.out.println("#3 :  " + (xCases + yCases));
			return;
		}
		
		if(yn == false) {
			System.out.println("#4 :  " + -1);
			return;
		}
		
		sc.close();
	
		//�ٸ� ��� Ǯ�̸� ����
		//5�� �����°� �켱 �ּ� ����� ���̱� ������
		//5�� ���� ���� ���� ������ �������� ������ -3�� ���ʴ�� �ϸ鼭 
		//5�� ������ ������ ������ Ƚ���� ī��Ʈ���ִ� ������ �ѵ� �ʹ�.(while��)
		//����) N�� 21�� ��
		//21, cnt(0) -> �ȳ����� �������Ƿ� -3 -> 18, cnt(1) -> �ȳ����� �������Ƿ� 15, cnt(2)
		//15/5 = 3�̹Ƿ� 3 + cnt = 5
	}
}

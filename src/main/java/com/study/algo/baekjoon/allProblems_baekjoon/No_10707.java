package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_10707 {

	public static void main(String[] args) throws Exception{

		//10707�� �������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//X�� : 1���ʹ� A��
		//Y�� : �⺻��� B��. ��뷮�� C���� �����̸� �⺻��ݸ� û��. C���� �ʰ� �� �⺻��� + 1���ʹ� D���� �߰����
		
		//�� �� ��뷮(����)�� �־����� �� �ּ� ������� ���ϱ�
		//P�� �־����� ��,
		//1. X���� �������
		//2-1. Y�� ���� �ʰ��� ��� : �⺻��� + �߰����
		//2-2. Y�� ���� ������ ��� : �⺻���
		//1�� 2�� ��
		
		//X�� - 1���ʹ� ��� A
		int A = Integer.parseInt(br.readLine());
		
		//Y�� - �⺻��� B, ���� C, �߰���� D
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine());
		
		//�� �ް� ���� ��뷮
		int P = Integer.parseInt(br.readLine());
	
		int X = P * A;
		int Y = 0;
		if(P > C) {
			Y = B + (P - C) * D;
		}else {
			Y = B;
		}
		
		System.out.println(Math.min(X, Y));
		br.close();
	}

}

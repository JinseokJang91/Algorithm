package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_5532 {

	public static void main(String[] args) throws Exception{

		//5532�� ���� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//���� : �� L��
		//������� : �� A������
		//���м��� : �� B������
		//�Ϸ翡 ������� �ִ� : C������
		//�Ϸ翡 ���м��� �ִ� : D������
		
		//������ ���� �ʰ� �� �� �ִ� �ִ� ���� ���� ���ϱ�
		
		int L = Integer.parseInt(br.readLine());
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine());
		
		//���� ������ ���� ����, ���� ���� �Ϸ翡 �ִ�� Ǯ �� ����
		//���� ���� �Ǵ� ���� �߿� ������ �ϴµ� �ִ�� �ɸ��� ���� ���� ��ü���� ���� �ȴ�.
	
		//System.out.println("�ִ� �ɸ��� �� �� : " + Math.max(A / C + 1, B / D + 1));
		int maxKor = 0;
		int maxMath = 0;
		if(A % C == 0) {
			maxKor = A / C;
		}else {
			maxKor = A / C + 1;
		}
		
		if(B % D == 0) {
			maxMath = B / D;
		}else {
			maxMath = B / D + 1;
		}
		
		int answer = L - Math.max(maxKor, maxMath);
		
		System.out.println(answer);
		br.close();
	}

}

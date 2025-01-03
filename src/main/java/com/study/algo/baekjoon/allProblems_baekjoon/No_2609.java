package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_2609 {

	public static void main(String[] args) throws Exception{
		//2609�� �ִ������� �ּҰ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String[] inputs = input.split(" ");
		int num1 = Integer.parseInt(inputs[0]);
		int num2 = Integer.parseInt(inputs[1]);
		
		//�ּҰ������ �� ���� ���� �ִ������� ���� ��
		
		//1. �ִ����� ���ϱ�
		//�ִ������� �� �� �� ���� ���� ���� �������� ��� 1���� �������� �������� 0�� �Ǵ� ���� ���� ū ��
		
		int share = 1; //���� ���� ���� ����
		int maxShare = 0; //�ִ������� ���� ����
		while(true) {
			if((num1 % share == 0) && (num2 % share == 0)) {
				maxShare = share;
			}
			
			share++; //���� �� �� �� ���� ���� ������ ������ +1
			//�� �� �� ���� ������ �� ���� Ŀ���� �ݺ��� ��������
			if(share > Math.min(num1, num2)) {
				break;
			}
		}
		//System.out.println("�ִ����� : " + maxShare);
		
		//2. �ּҰ���� ���ϱ�
		//�ּҰ���� = �� ���� �� / �ִ�����
		//�� ���� ���� ������ �ִ������� ������ �������Ƿ� �Ҽ����� �Ű� �� �ᵵ ��
		int minTimes = (num1 * num2) / maxShare;
		//System.out.println("�ּҰ���� : " + minTimes);
		
		System.out.println(maxShare + "\n" + minTimes);
		
		br.close();
	}

}

package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_9655 {

	public static void main(String[] args) throws Exception{

		//9655��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//������
		//������ : ���(SK), ����(CY)
		//���� �����ư��鼭 ���� ��������, ���� 1�� �Ǵ� 3�� ������ �� �ִ�.
		//������ ���� �������� ����� ������ �̱�� �ȴ�.
		
		//*** �� ����� �Ϻ��ϰ� ������ ���� ��, �̱�� �����??
		//��ٺ��� ����
		
		//�Ϻ��ϰ� ������ �ߴٴ� �� Ű����Ʈ��� ����
		//Ȧ�� ���� �������� ������
		//N�� Ȧ���� ����� �̱��, ¦���� �����̰� �̱�
		if(N % 2 == 1) {
			System.out.println("SK");
		}else {
			System.out.println("CY");
		}
		
		br.close();
	}

}

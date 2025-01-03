package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2455 {

	public static void main(String[] args) throws Exception{

		//2455�� ������ ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//���� �ȿ� ����� ���� ���� ���� ��� �� ���ϱ�
		//������ Ż ��, ���� ����� ��� ���� �Ŀ� ������ ź��.
		
		//4���� �������� ����.
		
		//������ ������ ���� ������ �����ϸ鼭 ����
		//1. ������ �� ��ȣ ������� �����Ѵ�.
		//2. ��߿����� ���� ��� ���� ���������� ź ��� ���� 0�̴�.
		//3. �� ������ ���� ������ �ִ� ������� �� ���� ����� ������ ���� ����.
		//4. ������ ������ �ִ� 10,000���̰�, ������ �ʰ��Ͽ� Ÿ�� ���� ����.
		
		StringTokenizer st = null;
		int eachNum = 0;	//�� ���������� Ÿ�� ���� ���� ���(��� ��)
		int maxNum = 0;		//ù ��° �������� eachNum�� maxNum�� ����, �� �������� ���ؼ� �ִ� ��� ���� ���ϱ�
		
		for(int i=0; i<4; i++) {
			String input = br.readLine();
			st = new StringTokenizer(input, " ");

			int getOff = Integer.parseInt(st.nextToken());
			int getOn = Integer.parseInt(st.nextToken());
			eachNum = eachNum + (getOn - getOff);
			maxNum = Math.max(maxNum, eachNum);
			//System.out.println("eachNum : " + eachNum);
			//System.out.println("maxNum : " + maxNum);
		}
		
		System.out.println(maxNum);
		br.close();
		
		//eachNum = eachNum - getOff + getOn => �� �κ��� �ٽ�
		//�� �������� ���ϴ� ����� ������
		//�� ���������� ����� +�ǳ� -�ǳĿ� ���� �����ؼ� ���ϴ� ����� ���� �� ����.
	}

}

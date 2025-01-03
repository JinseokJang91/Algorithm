package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2914 {

	public static void main(String[] args) throws Exception{
		
		//2914�� ���۱�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// �ڽ��� �ٹ��� ���ԵǾ��ִ� ���۱��� �ִ� ��ε��� ��հ�
		// = (â���� �ٹ��� ���ϵ� � ���ԵǾ� �ִ� ���۱��� �ִ� ��ε��� ����) / (�ٹ��� ���ϵ� ���� ����)
		// -> ��հ��� �׻� �ø��� �ؼ� ������ ������ �Ѵ�.
		
		//�־����� �� : �ٹ��� ���ϵǾ� �ִ� ���� ����, ��հ�
		//���ؾ��� �� : ��� �� ���� ���۱��� �ִ� ��ε����� ���ϱ�
		
		//���۱��� �ִ� ��ε��� ���� = �ٹ��� ���ϵ� ���� ���� x ��հ�
		//��� ��հ��� �ø� ó���� ���� -> ��հ��� 24�̸� 23.01�̾ �ø�ó���ؼ� 24�� ��
		//���۱��� �ִ� ��ε��� �ּ� ������ ���ؾ� �ϹǷ� ��հ����� 0.99�� ���� ���غ��� -> �� ������ �ø�ó�� �ϸ� �ּҰ�
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		double songs = Double.parseDouble(st.nextToken());
		double avg = Double.parseDouble(st.nextToken());
		
		avg -= 0.99;
		
		double melodies = songs * avg;
		double answer = Math.ceil(melodies);	//�ø� ó��
		
		System.out.println((int)answer);
		
		br.close();
	}

}

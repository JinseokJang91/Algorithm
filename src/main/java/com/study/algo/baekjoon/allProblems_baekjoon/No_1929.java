package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_1929 {

	public static void main(String[] args) throws Exception{
		
		//1929�� �Ҽ� ���ϱ�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String[] inputs = input.split(" ");
		int M = Integer.parseInt(inputs[0]);
		int N = Integer.parseInt(inputs[1]);
		
		/*
		for(int i=M; i<=N; i++) {
			int cnt = 0;
			for(int j=1; j<=i; j++) {
				//System.out.println(i + " % " + j + " = " + (i%j));
				if(i % j == 0) {
					cnt++;
				}
				if(cnt > 2) {
					break;
				}
			}
			//System.out.println("cnt : " + cnt);
			if(cnt == 2) {
				//System.out.println("�Ҽ� : " + i);
				System.out.println(i);
			}
		}
		*/ //�� ����� �ð��� �ʹ� ���� �ҿ��ϴ� ���(�ð��ʰ�)
		
		//�Ҽ��� ���� ���� �����佺�׳׽��� ü�� ����Ѵ�.
		//�����佺�׳׽��� ü
		//"�Ҽ��� �Ǵ� ���� ����� ����� ������ �Ҽ��� �ȴ�" ��� �����ϴ� �˰���
		//���� �����ϸ� ��������� 2, 3, 5, 7�� ����� ����� ���� ���� �Ҽ��̴�
		
		
		//��·�� �ڵ�� �����ϸ�
		boolean[] prime = new boolean[N+1]; //i(�ε���)���� �Ҽ��� ����� ���̹Ƿ� +1�� ����� ��
		
		//�Ҽ��� �� : false
		//i���� �Ҽ����� �Ǻ��� ���̹Ƿ� 0�� ����, 1�� �Ҽ��� �ƴϹǷ� ����
		prime[0] = true;
		prime[1] = true;
		
		//�Ҽ� ó��
		for(int i=2; i*i<=N; i++) {
			//System.out.println("(1)prime[" + i + "] : " + prime[i]);
			if(!prime[i]) {
				for(int j=i*i; j<=N; j+=i) {
					prime[j] = true;
					//System.out.println("(2)prime[" + j + "] : " + prime[j]);
				}
			}
		}
		
		//�Ҽ� ���
		for(int i=M; i<=N; i++) {
			if(!prime[i]) {
				//System.out.println("�Ҽ� : " + i);
				System.out.println(i);
			}
		}
		
		
		
		br.close();
	}

}

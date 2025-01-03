package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_10156 {

	public static void main(String[] args) throws Exception{

		//10156�� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//������ ���ڸ� ��µ�, ���� ���ڶ� ��� �θ�Բ� ���ڶ� ���� ����
		//�θ�Բ� �޾ƾ� �� ���� �׼��� ���
		//���� �� ���� ����, ����� ���� ����, ���� ������ ���� ���� �־���
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		int snackPrc = Integer.parseInt(st.nextToken());
		int snackAmt = Integer.parseInt(st.nextToken());
		int hisMoney = Integer.parseInt(st.nextToken());
		
		int snackTotal = snackPrc * snackAmt;
		if(snackTotal > hisMoney) {
			System.out.println(snackTotal - hisMoney);
		}else {
			System.out.println(0);
		}
		br.close();
	}

}

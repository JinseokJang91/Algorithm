package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_15727 {

	public static void main(String[] args) throws Exception {

		//15727�� ���������� �Ϸ��µ� ������ �������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//����� ������ �ΰ��� ã�� ���� ������.
		//����� 1�п� 1~5������ �Ÿ��� �̵��� �� �ִ�.
		//�ִ��� ���� ã�� ���, ��Ȯ�� �� �и��� ������ ã�� �� �ִ��� ���
		//���찡 �ּ� t�и��� ������ ã�� �� ���� ��, t �̻��� ���� ���� ������ ���
		
		//1�п� �ִ��� ���� �Ÿ��� �̵��ϴ°� ����
		//L�� 12�� �־����� 5,5,2�� �̵��ؼ� 3�� ���� �� ����
		
		int L = Integer.parseInt(br.readLine());
		
		int move = 5;
		int t = 0;
		while(move > 0) {
			
			if(L >= move) {
				if(L % move == 0) {
					t = L / move;
				}else {
					t = L / move + 1;
				}
				break;
			}else {
				move--;
			}
		}
		System.out.println("t : " + t);
		br.close();
	}

}

package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_14681 {

	public static void main(String[] args) throws Exception{
		//14681�� ��и� ����
		//x��� y��� : 1��и�
		//x���� y��� : 2��и�
		//x���� y���� : 3��и�
		//x��� y���� : 4��и�
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine();
		String input2 = br.readLine();
		
		int x = Integer.parseInt(input1);
		int y = Integer.parseInt(input2);
		
		//int answer = (x>0 && y>0) ? 1 : ((x<0 && y>0) ? 2 : ((x<0 && y<0) ? 3 : 4));
		//System.out.println(answer);
		
		if(x>0 && y>0) {
			System.out.println(1);
		}else if(x<0 && y>0) {
			System.out.println(2);
		}else if(x<0 && y<0) {
			System.out.println(3);
		}else {
			System.out.println(4);
		}
		
		//���׿����ڳ� ���ǹ��̳� �ӵ�, �޸� �� �� ���
	}
}

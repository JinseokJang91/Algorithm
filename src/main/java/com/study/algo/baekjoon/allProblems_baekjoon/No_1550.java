package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_1550 {

	public static void main(String[] args) throws Exception{

		//1550�� 16����
		//16���� : 0~9, A~F
		//16���� ���� A�̸� 10������ 10
		//16���� ���� AB�̸� 10������ 10 * 16^1 + 11 * 16^0 = 160 + 11 = 171
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		char[] jinsu16 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		
		int check = 0;
		for(int i=0; i<input.length(); i++) {
			char chk = input.charAt(i);
			if((chk >= '0' && chk <= '9') || (chk >= 'A' && chk <= 'F')) {
				check = 1;
			}else {
				check = 0;
				break;
			}
		}
		
		int total = 0;
		int index = 0;
		//16���� ���� üũ �� ����
		if(check == 1) {
			for(int i=input.length()-1; i>=0; i--) {
				char ch = input.charAt(i);
				int quot = 0;
				for(int j=0; j<jinsu16.length; j++) {
					if(ch == jinsu16[j]) {
						quot = j;
						break;
					}
				}
				
				int times = (int)Math.pow(16, index);
				//System.out.println("quot : " + quot);
				//System.out.println("times : " + times);
				total += quot * times;
				//System.out.println("total : " + total);
				//System.out.println("index : " + index);
				index++;
			}
			
		}else {
			System.out.println("16������ �ƴ� �ٸ� ���� �Է��߽��ϴ�.");
		}
		
		br.close();
	}

}

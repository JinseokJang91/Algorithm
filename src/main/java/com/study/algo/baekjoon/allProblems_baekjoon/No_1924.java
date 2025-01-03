package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1924 {

	public static void main(String[] args) throws Exception{
		
		//1124�� 2007��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//2007�� 1�� 1���� ������
		//2007�� x�� y���� ���� ����?
		
		//31�� : 1, 3, 5, 7, 8, 10, 12
		//30�� : 4, 6, 9, 11
		//28�� : 2 (���� �ƴ�)
		
		//�� ���� �´� �ϼ��� ���ؾ� �ϹǷ� 1~x-1�� ������ ��� �� �ϼ��� ���� �� ������ x���� �ش��ϴ� y�� ��ŭ ���ؼ� ������ �������
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		String[] day = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
		int totalDays = 0;
		int dayIdx = 0;
		
		if(x == 1) {
			dayIdx = (y - 1) % 7;
		}else {
			for(int i=1; i<x; i++) {
				totalDays += dayCnt(i);
			}
			totalDays += y;
			dayIdx = (totalDays - 1) % 7;
			System.out.println("total : " + totalDays);
		}
		System.out.println("dayIdx : " + dayIdx);
		System.out.println("���� ���� : " + day[dayIdx]);
		
		br.close();
		
	}
	
	public static int dayCnt(int month) {
		
		int days = 0;
		if(month == 1 || month == 3 || month == 5 || month == 7 ||
		   month == 8 || month == 10 || month == 12)
		{
			days = 31;
		}
		
		if(month == 4 || month == 6 || month == 9 || month == 11)
		{
			days = 30;
		}
		
		if(month == 2) 
		{
			days = 28;
		}
		
		return days;
	}

}

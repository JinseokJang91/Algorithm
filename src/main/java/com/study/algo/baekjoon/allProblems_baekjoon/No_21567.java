package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_21567 {

	public static void main(String[] args) throws Exception{
		//21567�� ������ ���� 2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//A x B x C ����� 0���� 9���� ������ ���ڰ� �� ���� �������� ���
		long A = Long.parseLong(br.readLine());
		long B = Long.parseLong(br.readLine());
		long C = Long.parseLong(br.readLine());
		
		long timesVal = A * B * C;
		//System.out.println("timesVal : " + timesVal);
		
		int[] useCntArr = new int[10];
		String strVal = String.valueOf(timesVal);
		for(int i=0; i<strVal.length(); i++) {
			int num = Integer.parseInt(String.valueOf(strVal.charAt(i)));
			//System.out.println("num : " + num);
			useCntArr[num]++;
			//System.out.println("useCntArr[num] : " + useCntArr[num]);
		}
		
		for(int i=0; i<useCntArr.length; i++) {
			System.out.println(useCntArr[i]);
		}
		
		br.close();
	}

}

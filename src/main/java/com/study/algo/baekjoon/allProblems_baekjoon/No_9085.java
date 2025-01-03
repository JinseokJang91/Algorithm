package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_9085 {

	public static void main(String[] args) throws Exception{

		//9085�� ���ϱ�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		int[] answer = new int[T];
		int ansIdx = 0;
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			String[] arr = new String[N];
			String input = br.readLine();
			arr = input.split(" ");
			int sum = 0;
			for(int j=0; j<arr.length; j++) {
				sum += Integer.parseInt(arr[j]);
			}
			answer[ansIdx] = sum;
			ansIdx++;
		}
		
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
		
		br.close();
	}

}

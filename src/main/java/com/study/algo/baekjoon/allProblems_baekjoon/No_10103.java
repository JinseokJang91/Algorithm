package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_10103 {

	public static void main(String[] args) throws Exception{

		//10103�� �ֻ��� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		//â���� ���, �ֻ��� ����, 100������ ����
		//���� ���ڰ� ���� ����� ����� �ֻ��� ���ڸ�ŭ ������ �Ҵ´�.
		StringTokenizer st = null;
		int cy = 100;
		int sd = 100;
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			st = new StringTokenizer(input, " ");
			int cyNum = Integer.parseInt(st.nextToken());
			int sdNum = Integer.parseInt(st.nextToken());
			if(cyNum > sdNum) {
				sd -= cyNum;
			}
			
			if(cyNum < sdNum) {
				cy -= sdNum;
			}
		}
		
		System.out.println(cy + "\n" + sd);
		br.close();
	}

}

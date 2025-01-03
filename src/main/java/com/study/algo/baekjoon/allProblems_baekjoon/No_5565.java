package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_5565 {

	public static void main(String[] args) throws Exception{
		
		//5565�� ������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cal = 0;
		for(int i=0; i<10; i++) {
			if(i == 0) {
				cal = Integer.parseInt(br.readLine());
			}else {
				cal -= Integer.parseInt(br.readLine());
			}
		}
		
		System.out.println(cal);
		br.close();
	}

}

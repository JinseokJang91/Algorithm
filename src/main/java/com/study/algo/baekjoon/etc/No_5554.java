package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_5554 {

	public static void main(String[] args) throws Exception{

		//5554번 심부름 가는 길
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int totalSeconds = 0;
		for(int i=0; i<4; i++) {
			int input = Integer.parseInt(br.readLine());
			totalSeconds += input;
		}

		int minutes = 0;
		int seconds = 0;

		minutes = totalSeconds / 60;
		seconds = totalSeconds % 60;
		System.out.println(minutes + "\n" + seconds);

		br.close();
	}

}

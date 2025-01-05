package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_10156 {

	public static void main(String[] args) throws Exception{

		//10156번 과자
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//동수가 과자를 사는데, 돈이 모자랄 경우 부모님께 모자란 돈을 받음
		//부모님께 받아야 할 돈의 액수를 출력
		//과자 한 개의 가격, 사려는 과자 개수, 현재 동수가 가진 돈이 주어짐
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

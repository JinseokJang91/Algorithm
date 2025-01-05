package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_10707 {

	public static void main(String[] args) throws Exception{

		//10707번 수도요금
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//X사 : 1리터당 A엔
		//Y사 : 기본요금 B엔. 사용량이 C리터 이하이면 기본요금만 청구. C리터 초과 시 기본요금 + 1리터당 D엔의 추가요금

		//한 달 사용량(리터)가 주어졌을 때 최소 수도요금 구하기
		//P가 주어졌을 때,
		//1. X사의 수도요금
		//2-1. Y사 상한 초과일 경우 : 기본요금 + 추가요금
		//2-2. Y사 상한 이하일 경우 : 기본요금
		//1과 2를 비교

		//X사 - 1리터당 요금 A
		int A = Integer.parseInt(br.readLine());

		//Y사 - 기본요금 B, 상한 C, 추가요금 D
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine());

		//한 달간 수도 사용량
		int P = Integer.parseInt(br.readLine());

		int X = P * A;
		int Y = 0;
		if(P > C) {
			Y = B + (P - C) * D;
		}else {
			Y = B;
		}

		System.out.println(Math.min(X, Y));
		br.close();
	}

}

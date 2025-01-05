package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2455 {

	public static void main(String[] args) throws Exception{

		//2455번 지능형 기차
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//기차 안에 사람이 가장 많을 때의 사람 수 구하기
		//기차에 탈 때, 내릴 사람이 모두 내린 후에 기차에 탄다.

		//4개의 정차역이 있음.

		//기차는 다음과 같은 조건을 만족하면서 운행
		//1. 기차는 역 번호 순서대로 운행한다.
		//2. 출발역에서 내린 사람 수와 종착역에서 탄 사람 수는 0이다.
		//3. 각 역에서 현재 기차에 있는 사람보다 더 많은 사람이 내리는 경우는 없다.
		//4. 기차의 정원은 최대 10,000명이고, 정원을 초과하여 타는 경우는 없다.

		StringTokenizer st = null;
		int eachNum = 0;	//각 정차역에서 타고 내린 후의 결과(사람 수)
		int maxNum = 0;		//첫 번째 정차역은 eachNum과 maxNum이 동일, 그 다음부턴 비교해서 최대 사람 수를 구하기

		for(int i=0; i<4; i++) {
			String input = br.readLine();
			st = new StringTokenizer(input, " ");

			int getOff = Integer.parseInt(st.nextToken());
			int getOn = Integer.parseInt(st.nextToken());
			eachNum = eachNum + (getOn - getOff);
			maxNum = Math.max(maxNum, eachNum);
			//System.out.println("eachNum : " + eachNum);
			//System.out.println("maxNum : " + maxNum);
		}

		System.out.println(maxNum);
		br.close();

		//eachNum = eachNum - getOff + getOn => 이 부분이 핵심
		//각 정차역을 구하는 방법도 좋지만
		//각 정차역에서 사람이 +되냐 -되냐에 따라 선택해서 더하는 방법도 있을 것 같다.
	}

}

package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_14606 {

	public static void main(String[] args) throws Exception{

		//14606번 피자 (Small)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//N개의 피자판이 하나의 탑처럼 놓여있다.
		//피자탑을 두 개의 피자탑으로 분리 -> 분리된 두 피자탑의 곱만큼 즐거움을 느낀다 -> 즐거움의 총합이 최대가 되는 값 구하기

		//높이가 N인 피자탑의 최대값을 구하려면 2로 나눠서 곱하는 수가 제일 큼(N이 8이면 4*4 = 16 이 제일 큰 값)
		//2로 나눠지지 않으면 소수점 기준으로 나눔 (N이 5이면 2.5가 되니 2, 3으로 나눔)
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		list.add(N);
		int funSum = 0;

		for(int i=0; i<list.size(); i++) {
			int height = list.get(i);
			if(height != 0) {
				//짝수인 경우, N을 반으로 나눈 값을 서로 곱한다.
				if(height % 2 == 0) {
					funSum += (height / 2) * (height / 2);
					list.set(i, 0); //처리된 피자탑은 0으로 처리
					if(height / 2 != 1) {
						list.add(height / 2);
						list.add(height / 2);
					}
					//홀수인 경우, N을 반으로 나눈 값의 소수점 기준 아래위 정수를 서로 곱한다.
				}else {
					int moreHigh = height / 2 + 1;
					funSum += (height / 2) * moreHigh;
					list.set(i, 0); //처리된 피자탑은 0으로 처리
					if(height / 2 != 1) {
						list.add(height / 2);
					}
					if(moreHigh != 1) {
						list.add(moreHigh);
					}
				}
			}
			//System.out.println("list : " + list);
			//System.out.println("funSum : " + funSum);
		}
		System.out.println(funSum);

		br.close();
	}

}

package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_15727 {

	public static void main(String[] args) throws Exception {

		//15727번 조별과제를 하려는데 조장이 사라졌다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//성우는 조장인 민건을 찾기 위해 떠난다.
		//성우는 1분에 1~5까지의 거리를 이동할 수 있다.
		//최대한 빨리 찾을 경우, 정확히 몇 분만에 조장을 찾을 수 있는지 출력
		//성우가 최소 t분만에 조장을 찾을 수 있을 때, t 이상의 가장 작은 정수를 출력

		//1분에 최대한 많은 거리를 이동하는게 좋음
		//L이 12로 주어지면 5,5,2로 이동해서 3을 구할 수 있음

		int L = Integer.parseInt(br.readLine());

		int move = 5;
		int t = 0;
		while(move > 0) {

			if(L >= move) {
				if(L % move == 0) {
					t = L / move;
				}else {
					t = L / move + 1;
				}
				break;
			}else {
				move--;
			}
		}
		System.out.println("t : " + t);
		br.close();
	}

}

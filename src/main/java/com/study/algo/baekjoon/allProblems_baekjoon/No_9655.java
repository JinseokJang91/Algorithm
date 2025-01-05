package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_9655 {

	public static void main(String[] args) throws Exception{

		//9655번
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		//돌게임
		//참여자 : 상근(SK), 찬영(CY)
		//턴을 번갈아가면서 돌을 가져가며, 돌은 1개 또는 3개 가져갈 수 있다.
		//마지막 돌을 가져가는 사람이 게임을 이기게 된다.

		//*** 두 사람이 완벽하게 게임을 했을 때, 이기는 사람은??
		//상근부터 시작

		//완벽하게 게임을 했다는 게 키포인트라고 생각
		//홀수 개씩 가져가기 때문에
		//N이 홀수면 상근이 이기고, 짝수면 찬영이가 이김
		if(N % 2 == 1) {
			System.out.println("SK");
		}else {
			System.out.println("CY");
		}

		br.close();
	}

}

package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1476 {

	public static void main(String[] args) throws Exception{

		//1476번 날짜 계산
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//준규가 사는 나라는 다른 방식의 연도를 사용
		//수 3개 사용 - 각각 지구, 태양, 달을 의미
		//1 <= E <= 15
		//1 <= S <= 28
		//1 <= M <= 19

		//1년은 1 1 1로 나타내고
		//16년은 1 16 16으로 나타낼 수 있다.

		//주어진 E S M 이 우리가 알고 있는 연도로 몇 년인지 구하기
		//예제에서 1 2 3 이 5266년인 이유는
		//계속 범위만큼 돌리고 돌리다가 1 2 3 이 되는 순간의 연도인 것

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		//E, S, M 값이 반복문을 돌리다 나오는 최종 값(세 개 다 일치해야 함)
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		//1년부터 시작
		int earth	= 1;
		int sun		= 1;
		int moon	= 1;
		int presentYear = 1;
		//각 범위 끝에 도달하면 다시 1로 만드는 처리를 해주면 됨

		if(earth == E && sun == S && moon == M) {
			System.out.println("초기값과 일치!!! (1 1 1)");
			presentYear = 1;
		}else {
			//System.out.println("else진입");
			while(true) {
				//System.out.println("while진입");

				//준규 나라 1년 후
				earth++;
				sun++;
				moon++;

				//우리 나라 1년 후
				presentYear++;

				//각 범위를 넘었다면 다시 1로 돌리기
				if(earth > 15) {
					earth = 1;
				}
				if(sun > 28) {
					sun = 1;
				}
				if(moon > 19) {
					moon = 1;
				}

				if(earth == E && sun == S && moon == M) {
					System.out.println("입력연도와 일치!!!");
					break;
				}
			}
		}

		System.out.println("presentYear : " + presentYear);

		br.close();
	}

}

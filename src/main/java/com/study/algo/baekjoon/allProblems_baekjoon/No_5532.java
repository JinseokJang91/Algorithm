package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_5532 {

	public static void main(String[] args) throws Exception{

		//5532번 방학 숙제
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//방학 : 총 L일
		//국어숙제 : 총 A페이지
		//수학숙제 : 총 B페이지
		//하루에 국어숙제 최대 : C페이지
		//하루에 수학숙제 최대 : D페이지

		//숙제를 하지 않고 놀 수 있는 최대 날의 수를 구하기

		int L = Integer.parseInt(br.readLine());
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine());

		//문제 예제를 보면 국어, 수학 각각 하루에 최대로 풀 수 있음
		//따라서 국어 또는 수학 중에 숙제를 하는데 최대로 걸리는 날의 수를 전체에서 빼면 된다.

		//System.out.println("최대 걸리는 일 수 : " + Math.max(A / C + 1, B / D + 1));
		int maxKor = 0;
		int maxMath = 0;
		if(A % C == 0) {
			maxKor = A / C;
		}else {
			maxKor = A / C + 1;
		}

		if(B % D == 0) {
			maxMath = B / D;
		}else {
			maxMath = B / D + 1;
		}

		int answer = L - Math.max(maxKor, maxMath);

		System.out.println(answer);
		br.close();
	}

}

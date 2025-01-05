package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_5086 {

	public static void main(String[] args) throws Exception{

		//5086번 배수와 약수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//관계 목록
		//1. 첫 번째 숫자가 두 번째 숫자의 약수이다.			-> factor	(약수)
		//2. 첫 번째 숫자가 두 번째 숫자의 배수이다.			-> multiple	(배수)
		//3. 첫 번째 숫자가 두 번째 숫자의 약수와 배수 모두 아니다.	-> neither	(둘 다 아님)

		//첫 번째 숫자 - a, 두 번째 숫자 - b일 경우
		//1. b % a = 0 이면 a는 b의 약수
		//2. a % b = 0 이면 a는 b의 배수

		StringTokenizer st = null;
		List<String> ansList = new ArrayList<String>();
		while(true) {

			String input = br.readLine();
			if(input.equals("0 0")) {
				break;
			}

			st = new StringTokenizer(input, " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if(b % a == 0) {
				ansList.add("factor");
			}else if(a % b == 0) {
				ansList.add("multiple");
			}else {
				ansList.add("neither");
			}
		}

		//System.out.println(ansList);
		for(int i=0; i<ansList.size(); i++) {
			System.out.println(ansList.get(i));
		}
		br.close();

	}

}

package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_2845 {

	public static void main(String[] args) throws Exception{

		//2845번 파티가 끝나고 난 뒤
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//첫째 줄 : 1m^2당 사람의 수 , 파티가 열렸던 곳의 넓이
		//둘째 줄 : 각 기사에 실려있는 참가자의 수(5개)

		String input1 = br.readLine();
		String input2 = br.readLine();

		StringTokenizer st1 = new StringTokenizer(input1, " ");
		StringTokenizer st2 = new StringTokenizer(input2, " ");

		int realCnt = Integer.parseInt(st1.nextToken()) * Integer.parseInt(st1.nextToken());
		List<Integer> list = new ArrayList<Integer>();
		while(st2.hasMoreTokens()) {
			list.add(Integer.parseInt(st2.nextToken()));
		}
		//System.out.println("realCnt : " + realCnt);
		//System.out.println("list : " + list);

		String answer = "";
		for(int i=0; i<list.size(); i++) {
			int cal = list.get(i) - realCnt;
			answer += cal + " ";
		}
		answer = answer.trim();
		System.out.println(answer);

		br.close();
	}

}

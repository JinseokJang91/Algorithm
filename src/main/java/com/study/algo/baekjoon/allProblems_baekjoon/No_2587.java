package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No_2587 {

	public static void main(String[] args) throws Exception{

		//2587번 대표값2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//평균과 중앙값(총 5개)
		//평균 : 주어진 모든 수의 합읠 수의 개수로 나눈 것
		//중앙값 : 가장 중앙에 놓인 값
		int total = 0;
		int middle = 0;
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<5; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(list);
		//System.out.println("list : " + list);

		for(int i=0; i<list.size(); i++) {
			total += list.get(i);
		}
		System.out.println(total / 5);
		System.out.println(list.get(list.size() / 2));

		br.close();
	}

}

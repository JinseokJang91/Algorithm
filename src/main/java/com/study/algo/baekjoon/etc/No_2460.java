package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class No_2460 {

	public static void main(String[] args) throws Exception{

		//2460번 지능형 기차 2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int passengers = 0;
		StringTokenizer st = null;
		List<Integer> list = new ArrayList<Integer>();

		for(int i=0; i<10; i++) {
			String input = br.readLine();
			st = new StringTokenizer(input, " ");
			int getOff = Integer.parseInt(st.nextToken());
			int getOn = Integer.parseInt(st.nextToken());
			passengers += getOn - getOff;
			list.add(passengers);
		}

		//System.out.println("list : " + list);
		Collections.sort(list, Comparator.reverseOrder());
		//System.out.println("정렬 후 list : " + list);
		System.out.println(list.get(0));

		br.close();
	}

}

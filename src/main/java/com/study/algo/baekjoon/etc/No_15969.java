package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No_15969 {

	public static void main(String[] args) throws Exception{

		//15969번 행복
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		List<Integer> list = new ArrayList<Integer>();

		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(list);
		//System.out.println("list :" + list);

		int highest = list.get(list.size() - 1);
		int lowest = list.get(0);
		//System.out.println("highest : " +  highest);
		//System.out.println("lowest : " + lowest);

		System.out.println(highest - lowest);

		br.close();
	}

}

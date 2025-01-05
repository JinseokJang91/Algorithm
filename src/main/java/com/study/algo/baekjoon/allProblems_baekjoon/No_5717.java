package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_5717 {

	public static void main(String[] args) throws Exception{

		//5717번 상근이의 친구들
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<Integer> list = new ArrayList<Integer>();
		StringTokenizer st = null;
		while(true) {
			String input = br.readLine();

			if(input.equals("0 0")) {
				break;
			}

			st = new StringTokenizer(input, " ");
			int men = Integer.parseInt(st.nextToken());
			int women  = Integer.parseInt(st.nextToken());

			list.add(men + women);
		}

		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}

		br.close();
	}

}

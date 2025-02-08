package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_25304 {

	public static void main(String[] args) throws Exception {

		//25304번 영수증
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = null;
		int X = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		int total = 0;
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			st = new StringTokenizer(input, " ");
			int price = Integer.parseInt(st.nextToken());
			int amount = Integer.parseInt(st.nextToken());
			total += price * amount;
		}
		//System.out.println("total : " + total);

		if(total == X) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}

		br.close();
	}

}

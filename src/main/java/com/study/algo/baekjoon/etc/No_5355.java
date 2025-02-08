package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_5355 {

	public static void main(String[] args) throws Exception{

		//5355번 화성 수학
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		List<String> list = new ArrayList<String>();

		for(int i=0; i<T; i++) {
			String input = br.readLine();
			st = new StringTokenizer(input, " ");
			int size = st.countTokens();
			double cal = 0;
			while(st.hasMoreTokens()) {
				if(size == st.countTokens()) {
					cal = Double.parseDouble(st.nextToken());
				}else {
					String str = st.nextToken();
					if(str.equals("@")) {
						cal *= 3;
					}
					if(str.equals("%")) {
						cal += 5;
					}
					if(str.equals("#")) {
						cal -= 7;
					}
				}
			}
			list.add(String.format("%.2f", cal));
		}

		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}

		br.close();
	}

}

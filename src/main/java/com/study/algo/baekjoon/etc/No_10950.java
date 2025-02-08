package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_10950 {

	public static void main(String[] args) throws Exception{

		//10950번 A+B-3
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<Integer> list = new ArrayList<Integer>();
		int len = Integer.parseInt(br.readLine());
		while(len > 0) {

			String input = br.readLine();
			String[] inputs = input.split(" ");
			int A = Integer.parseInt(inputs[0]);
			int B = Integer.parseInt(inputs[1]);
			list.add(A + B);

			len--;
		}

		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}

		br.close();
	}

}

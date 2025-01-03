package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_11022 {

	public static void main(String[] args) throws Exception{

		//11022�� A+B - 8
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> listA = new ArrayList<Integer>();
		List<Integer> listB = new ArrayList<Integer>();
		int len = Integer.parseInt(br.readLine());
		while(len > 0) {
			
			String input = br.readLine();
			String[] inputs = input.split(" ");
			int A = Integer.parseInt(inputs[0]);
			int B = Integer.parseInt(inputs[1]);
			list.add(A + B);
			listA.add(A);
			listB.add(B);
			
			len--;
		}
		
		for(int i=0; i<list.size(); i++) {
			System.out.println("Case #" + (i+1) + ": " + listA.get(i) + " + " + listB.get(i) + " = " + list.get(i));
		}
		
		br.close();

	}

}

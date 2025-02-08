package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_10984 {

	public static void main(String[] args) throws Exception{

		//10984번 내 학점을 구해줘
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st = null;
		List<String> list = new ArrayList<String>();

		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			int totGrade = 0;
			Double totGpa = 0.0; //GPA : 평점(Grade Point Average)
			for(int j=0; j<N; j++) {
				String input = br.readLine();
				st = new StringTokenizer(input, " ");
				int grade = Integer.parseInt(st.nextToken());
				totGrade += grade;
				totGpa += (Double.parseDouble(st.nextToken()) * grade);
			}
			list.add(totGrade + " " + Math.round((totGpa / totGrade) * 10) / 10.0);
			//소수점 표시는 String.format("%.Nf", 변수)로 하면 소수점 N자리 까지 표시할 수 있다.
		}
		System.out.println("list : " + list);

		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		br.close();
	}

}

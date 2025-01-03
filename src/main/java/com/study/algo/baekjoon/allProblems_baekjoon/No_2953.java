package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_2953 {

	public static void main(String[] args) throws Exception {

		//2953�� ���� �丮���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//�ټ� ���� �ٿ� �� �����ڰ� ���� �� ���� �� ������ �־�����.
		List<Integer> list = new ArrayList<Integer>();
		StringTokenizer st = null;
		for(int i=0; i<5; i++) {
			String input = br.readLine();
			st = new StringTokenizer(input, " ");
			int sum = 0;
			while(st.hasMoreTokens()) {
				sum += Integer.parseInt(st.nextToken());
			}
			list.add(sum);
		}
		//System.out.println("list : " + list);
		
		int winnerIdx = 0;
		int winnerScr = 0;
		int tmpIdx = 0;
		int tmpScr = 0;
		while(tmpIdx < list.size()) {
			tmpScr = list.get(tmpIdx);
			//System.out.println("tmp : " + tmp);
			if(winnerScr < tmpScr) {
				winnerIdx = tmpIdx;
				winnerScr = tmpScr;
			}
			//System.out.println("winnerScr : " + winnerScr);
			tmpIdx++;
		}
		
		System.out.println((winnerIdx + 1) + " " + winnerScr);
		br.close();
	}

}

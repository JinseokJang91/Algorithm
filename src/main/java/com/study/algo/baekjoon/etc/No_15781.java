package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No_15781 {

	public static void main(String[] args) throws Exception{

		//15781번 헬멧과 조끼
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String num = br.readLine();
		StringTokenizer st = new StringTokenizer(num, " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] helmets = new int[N];
		int[] vests = new int[M];

		String helmetVal = br.readLine();
		String vestVal = br.readLine();
		StringTokenizer st1 = new StringTokenizer(helmetVal, " ");
		StringTokenizer st2 = new StringTokenizer(vestVal, " ");

		int idx1 = 0;
		while(st1.hasMoreTokens()) {
			helmets[idx1] = Integer.parseInt(st1.nextToken());
			idx1++;
		}

		int idx2 = 0;
		while(st2.hasMoreTokens()) {
			vests[idx2] = Integer.parseInt(st2.nextToken());
			idx2++;
		}

		Arrays.sort(helmets);
		Arrays.sort(vests);

		for(int i=0; i<helmets.length; i++) {
			System.out.println(helmets[i]);
		}
		for(int i=0; i<vests.length; i++) {
			System.out.println(vests[i]);
		}

		System.out.println("결과 : " + (helmets[helmets.length-1] + vests[vests.length-1]));

		br.close();
	}

}

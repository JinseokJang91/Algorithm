package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_5596 {

	public static void main(String[] args) throws Exception{

		//5596�� ���� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String minkuk = br.readLine();
		String mansae = br.readLine();
		StringTokenizer st1 = new StringTokenizer(minkuk, " ");
		StringTokenizer st2 = new StringTokenizer(mansae, " ");
		
		int minkuk_score = 0;
		int mansae_score = 0;
		
		while(st1.hasMoreTokens()) {
			minkuk_score += Integer.parseInt(st1.nextToken());
		}
		
		while(st2.hasMoreTokens()) {
			mansae_score += Integer.parseInt(st2.nextToken());
		}
		
		//System.out.println("�α� ���� �� �� : " + minkuk_score);
		//System.out.println("���� ���� �� �� : " + mansae_score);
		
		if(minkuk_score == mansae_score) {
			System.out.println(minkuk_score);
		}else {
			System.out.println(Math.max(minkuk_score, mansae_score));
		}
		
		br.close();
	}

}
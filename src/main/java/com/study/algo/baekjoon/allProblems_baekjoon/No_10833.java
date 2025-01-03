package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_10833 {

	public static void main(String[] args) throws Exception{

		//10833�� ���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//N���� �б����� ����� �л����� �Ȱ��� �����ְ� ���� ��� ������ ���� ������
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		int totalRest = 0;
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			st = new StringTokenizer(input, " ");
			int students = Integer.parseInt(st.nextToken());
			int apples = Integer.parseInt(st.nextToken());
			
			//���� ����� ��� ������ �л� ���� ���� ������
			totalRest += apples % students;
			System.out.println("totalRest : " + totalRest);
		}
		
		System.out.println("���� ����� �� ���� : " + totalRest);
		br.close();
	}

}

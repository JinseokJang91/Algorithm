package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_5086 {

	public static void main(String[] args) throws Exception{

		//5086�� ����� ���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//���� ���
		//1. ù ��° ���ڰ� �� ��° ������ ����̴�.			-> factor	(���)
		//2. ù ��° ���ڰ� �� ��° ������ ����̴�.			-> multiple	(���)
		//3. ù ��° ���ڰ� �� ��° ������ ����� ��� ��� �ƴϴ�.	-> neither	(�� �� �ƴ�)
		
		//ù ��° ���� - a, �� ��° ���� - b�� ���
		//1. b % a = 0 �̸� a�� b�� ���
		//2. a % b = 0 �̸� a�� b�� ���
		
		StringTokenizer st = null;
		List<String> ansList = new ArrayList<String>();
		while(true) {
			
			String input = br.readLine();
			if(input.equals("0 0")) {
				break;
			}
			
			st = new StringTokenizer(input, " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(b % a == 0) {
				ansList.add("factor");
			}else if(a % b == 0) {
				ansList.add("multiple");
			}else {
				ansList.add("neither");
			}
		}
		
		//System.out.println(ansList);
		for(int i=0; i<ansList.size(); i++) {
			System.out.println(ansList.get(i));
		}
		br.close();
		
	}

}

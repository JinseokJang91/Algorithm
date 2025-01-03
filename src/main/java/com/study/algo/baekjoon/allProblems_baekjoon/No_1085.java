package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1085 {

	public static void main(String[] args) throws Exception{
		//1085�� ���簢������ Ż��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//�� �� �� (x,y) ���簢�� ���� �Ʒ� �������� (0,0) ������ �� �������� (w,h)
		//x,y ���� ���簢���� ��輱���� ���� �Ÿ��� �ּڰ�
		
		//x-0���� w-x�� ���ؼ� ���� ��
		//y-0���� h-y�� ���ؼ� ���� ��
		//�� ����� �߿� ���� ��
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int minX = Math.min(x-0, w-x);
		int minY = Math.min(y-0, h-y);
		System.out.println("minX : " + minX);
		System.out.println("minY : " + minY);
		
		int answer = Math.min(minX, minY);
		System.out.println("answer : " + answer);
		
		br.close();
	}

}

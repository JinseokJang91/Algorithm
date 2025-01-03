package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_2010 {

	public static void main(String[] args) throws Exception{

		//2010�� �÷���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<N; i++) {
			int plugs = Integer.parseInt(br.readLine());
			list.add(plugs);
		}
		
		//���� �÷��� 1��
		//N���� ��Ƽ��
		//�� ��Ƽ�� �� ����
		//�־��� �� ������ �� �ִ� ��ǻ�� �ִ� ����
		int maxPc = 0;
		for(int i=0; i<list.size(); i++) {
			if(i < list.size() - 1) {
				maxPc += list.get(i) - 1;
			}
			
			if(i == list.size() - 1) {
				maxPc += list.get(i);
			}
		}
		System.out.println("maxPc : " + maxPc);
		br.close();
	}

}

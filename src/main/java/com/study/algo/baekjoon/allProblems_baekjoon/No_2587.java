package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No_2587 {

	public static void main(String[] args) throws Exception{

		//2587�� ��ǥ��2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//��հ� �߾Ӱ�(�� 5��)
		//��� : �־��� ��� ���� ���� ���� ������ ���� ��
		//�߾Ӱ� : ���� �߾ӿ� ���� ��
		int total = 0;
		int middle = 0;
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<5; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);
		//System.out.println("list : " + list);
		
		for(int i=0; i<list.size(); i++) {
			total += list.get(i);
		}
		System.out.println(total / 5);
		System.out.println(list.get(list.size() / 2));
		
		br.close();
	}

}

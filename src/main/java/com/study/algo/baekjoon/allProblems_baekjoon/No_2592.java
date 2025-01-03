package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No_2592 {

	public static void main(String[] args) throws Exception{

		//2592�� ��ǥ��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//�־����� �ڿ����� 1,000���� ���� 10�� ���
		List<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		for(int i=0; i<10; i++) {
			int score = Integer.parseInt(br.readLine());
			sum += score;
			list.add(score);
		}
		System.out.println("list : " + list);
		
		//���
		int avg = sum / 10;
		
		Collections.sort(list);
		System.out.println("list(ASC) : " + list);
		
		//list ������������ ���� �� �����ε������� �����ε������� ���ؼ�
		//ī��Ʈ�� ����ϰ�, �ִ� ī��Ʈ�� �ش� ���� �����ϴ� ��� ���
		int idxVal = 0;
		int cnt = 1;
		int cntSave = 0;
		int modeVal = 0;
		for(int i=0; i<list.size(); i++) {
			idxVal = list.get(i);
			if(i + 1 < list.size()) {
				if(idxVal != list.get(i+1)) {
					if(cnt >= cntSave) {
						cntSave = cnt;
						modeVal = idxVal;
					}
					cnt = 1;
				}else {
					cnt++;
				}
				System.out.println("cnt : " + cnt);
				System.out.println("cntSave : " + cntSave);
				System.out.println("modeVal : " + modeVal);
			}			
		}
		//System.out.println("cntSave : " + cntSave);

		System.out.println(avg);
		System.out.println(modeVal);
		
		br.close();
	}

}

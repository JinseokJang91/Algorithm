package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_14606 {

	public static void main(String[] args) throws Exception{

		//14606�� ���� (Small)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//N���� �������� �ϳ��� žó�� �����ִ�.
		//����ž�� �� ���� ����ž���� �и� -> �и��� �� ����ž�� ����ŭ ��ſ��� ������ -> ��ſ��� ������ �ִ밡 �Ǵ� �� ���ϱ�
		
		//���̰� N�� ����ž�� �ִ밪�� ���Ϸ��� 2�� ������ ���ϴ� ���� ���� ŭ(N�� 8�̸� 4*4 = 16 �� ���� ū ��)
		//2�� �������� ������ �Ҽ��� �������� ���� (N�� 5�̸� 2.5�� �Ǵ� 2, 3���� ����)
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		list.add(N);
		int funSum = 0;
		
		for(int i=0; i<list.size(); i++) {
			int height = list.get(i);
			if(height != 0) {
				//¦���� ���, N�� ������ ���� ���� ���� ���Ѵ�.
				if(height % 2 == 0) {
					funSum += (height / 2) * (height / 2);
					list.set(i, 0); //ó���� ����ž�� 0���� ó��
					if(height / 2 != 1) {
						list.add(height / 2);
						list.add(height / 2);
					}
				//Ȧ���� ���, N�� ������ ���� ���� �Ҽ��� ���� �Ʒ��� ������ ���� ���Ѵ�.
				}else {
					int moreHigh = height / 2 + 1;
					funSum += (height / 2) * moreHigh;
					list.set(i, 0); //ó���� ����ž�� 0���� ó��
					if(height / 2 != 1) {
						list.add(height / 2);
					}
					if(moreHigh != 1) {
						list.add(moreHigh);
					}
				}
			}
			//System.out.println("list : " + list);
			//System.out.println("funSum : " + funSum);
		}
		System.out.println(funSum);
		
		br.close();
	}

}

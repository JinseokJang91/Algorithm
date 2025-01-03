package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_6359 {

	public static void main(String[] args) throws Exception{

		//6359�� ������ ���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//N���� ���� �Ϸķ� �þ ����
		//����� 1~N������� �������� ���ų� ���
		//1���� : 1,2,...,N-1,N �� OPEN
		//2���� : 2,4,...,N-2,N �� OPEN or CLOSE
		//...
		//N���� : N, N*2, ... , N*(N-1), N*N �� OPEN or CLOSE
		//���������� �� ���� �л����� ������ �� �ִ��� ���ϱ�
		
		//N�� 5�̸�
		//1���� : 1,2,3,4,5 OPEN
		//2���� : 2,4 CLOSE
		//3���� : 3 CLOSE
		//4���� : 4 OPEN
		//5���� : 5 CLOSE
		//���� : 1 OPEN, 2 CLOSE, 3 CLOSE, 4 OPEN, 5 CLOSE
		
		//N�� 6�̸�
		//1���� : 1,2,3,4,5,6 OPEN
		//2���� : 2,4,6 CLOSE
		//3���� : 3 CLOSE 6 OPEN
		//4���� : 4 OPEN
		//5���� : 5 CLOSE
		//6���� : 6 CLOSE
		//���� : 1 OPEN, 2 CLOSE, 3 CLOSE, 4 OPEN, 5 CLOSE
		
		//1~N������� 1~N�� ��ȣ�� ���� ������ ¦���� CLOSE, Ȧ���� OPEN
		//�Ǵ� 0,1�� �����ؼ� OPEN, CLOSE�� ���� �ݴ�� ����(1,0)
		List<Integer> list = null;
		List<Integer> result = new ArrayList<Integer>();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			list = new ArrayList<Integer>();
			int count = 0;
			
			//1����� ��ü OPEN
			for(int j=1; j<=N; j++) {
				list.add(0);
			}
			
			for(int j=2; j<=N; j++) {
				System.out.println("==== " + j + "���� ====");
				
				if(j == 1) {
					list.add(0);
				}else {
					int times = 1;
					while(j * times <= N) {
						if(list.get(j * times - 1) == 0) {
							list.set(j* times - 1, 1);
						}else {
							list.set(j * times - 1, 0);
						}
						times++;
					}
				}
			}
			
			for(int j=0; j<list.size(); j++) {
				if(list.get(j) == 0) {
					count++;
				}
			}
			
			System.out.println((i+1) + "��° " + "list : " + list);
			result.add(count);
		}

		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
		

		br.close();
		
	}

}

package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1476 {

	public static void main(String[] args) throws Exception{

		//1476�� ��¥ ���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//�ر԰� ��� ����� �ٸ� ����� ������ ���
		//�� 3�� ��� - ���� ����, �¾�, ���� �ǹ�
		//1 <= E <= 15
		//1 <= S <= 28
		//1 <= M <= 19
		
		//1���� 1 1 1�� ��Ÿ����
		//16���� 1 16 16���� ��Ÿ�� �� �ִ�.
		
		//�־��� E S M �� �츮�� �˰� �ִ� ������ �� ������ ���ϱ�
		//�������� 1 2 3 �� 5266���� ������
		//��� ������ŭ ������ �����ٰ� 1 2 3 �� �Ǵ� ������ ������ ��
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		//E, S, M ���� �ݺ����� ������ ������ ���� ��(�� �� �� ��ġ�ؾ� ��)
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//1����� ����
		int earth	= 1;
		int sun		= 1;
		int moon	= 1;
		int presentYear = 1;
		//�� ���� ���� �����ϸ� �ٽ� 1�� ����� ó���� ���ָ� ��
		
		if(earth == E && sun == S && moon == M) {
			System.out.println("�ʱⰪ�� ��ġ!!! (1 1 1)");
			presentYear = 1;
		}else {
			//System.out.println("else����");
			while(true) {
				//System.out.println("while����");
								
				//�ر� ���� 1�� ��
				earth++;
				sun++;
				moon++;
				
				//�츮 ���� 1�� ��
				presentYear++;
				
				//�� ������ �Ѿ��ٸ� �ٽ� 1�� ������
				if(earth > 15) {
					earth = 1;
				}
				if(sun > 28) {
					sun = 1;
				}
				if(moon > 19) {
					moon = 1;
				}
				
				if(earth == E && sun == S && moon == M) {
					System.out.println("�Է¿����� ��ġ!!!");
					break;
				}
			}
		}
		
		System.out.println("presentYear : " + presentYear);
		
		br.close();
	}

}

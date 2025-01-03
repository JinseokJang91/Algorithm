package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_1934 {

	public static void main(String[] args) throws Exception{

		//1934�� �ּҰ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		String[] inputs = new String[T];
		for(int i=0; i<T; i++) {
			inputs[i] = br.readLine();
		}
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<inputs.length; i++) {
			String[] temp = inputs[i].split(" ");
			int A = Integer.parseInt(temp[0]);
			int B = Integer.parseInt(temp[1]);
			
			//�ּҰ���� ���ϱ�
			//�ּҰ���� : �� ���� ����� �� �ߺ��� ������ ������ ��.. -> �� ���� ���ϰ� ����� ����� ������ ��(����� 2�� �������� ������ŭ üũ)
			//16, 20�̸� -> 16 : 1,2,2,2,2 / 20 : 1,2,2,5 -> 1,2,2�� �����̹Ƿ� 16*20�� ����� 320�� 1*2*2�� ������ ��
			//-> ��, �ּҰ������ �� ���� ���� �� ���� �ִ������� ���� ���� �ǹ�
			
			//�ִ����� ���ϱ�
			int share = 1;
			int maxComm = 0;
			while(true) {
				//�� �� �� ���� ���� �������� 1���� �ش� ������ ������Ű�鼭 �������� �ִ� ����� �� �� ����
				if(A % share == 0 && B % share == 0) {
					maxComm = share;
				}
				
				share++;
				if(share > Math.min(A, B)) {
					break;
				}
			}
			//System.out.println("�ִ����� : " + maxComm);
			//System.out.println("�ּҰ���� : " + (A*B) / maxComm);
			System.out.println((A*B) / maxComm);
		}
		
		br.close();
	}

}

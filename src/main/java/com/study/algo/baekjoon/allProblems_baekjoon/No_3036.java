package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_3036 {

	public static void main(String[] args) throws Exception{

		//3036�� ��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//ù° �� : ���� ���� N
		//��° �� : ������ŭ ���� ������
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		String[] rings = new String[N];
		rings = input.split(" ");
		
		int firstRing = Integer.parseInt(rings[0]);
		List<Integer> list = new ArrayList<Integer>();
		for(int i=1; i<rings.length; i++) {
			list.add(Integer.parseInt(rings[i]));
		}
		//System.out.println("firstRing : " + firstRing);
		//System.out.println("list : " + list);
		
		for(int i=0; i<list.size(); i++) {
			int nextRing = list.get(i);
			int share = 1; //���� ���� ���� ����
			int maxShare = 0; //�ִ������� ���� ����
			String fraction = "";
			while(true) {
				if((firstRing % share == 0) && (nextRing % share == 0)) {
					maxShare = share;
				}
				
				share++; //���� �� �� �� ���� ���� ������ ������ +1
				//�� �� �� ���� ������ �� ���� Ŀ���� �ݺ��� ��������
				if(share > Math.min(firstRing, nextRing)) {
					break;
				}
			}
			System.out.println("maxShare : " + maxShare);
			fraction = (firstRing / maxShare) + "/" + (nextRing / maxShare);
			System.out.println(fraction);
		}
		
		br.close();
		
		//ó�� ������ ������ ������ for�� �ۿ� �����߱� ����
		//while���� ��ġ�� �ٽ� �ʱ�ȭ�ؼ� �����ؾ� �ϴµ� for�� �ۿ� �����ϴ�
		//�ٲ� ���� �״�� ����Ǽ� �� ����..
		
		//�׸��� �ִ������� ���ϴ� ����� �� ����� �ִ� �� ����
	}

}

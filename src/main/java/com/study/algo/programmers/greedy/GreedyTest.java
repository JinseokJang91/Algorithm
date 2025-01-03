package com.study.algo.programmers.greedy;

import java.util.ArrayList;
import java.util.List;

public class GreedyTest {
	public int solution(String name) {
		// Ž���>���̽�ƽ
		//�� - ���� ���ĺ�
		//�� - ���� ���ĺ� (A���� �Ʒ������� �̵��ϸ� Z��)
		//�� - Ŀ���� �������� �̵� (ù ��° ��ġ���� �������� �̵��ϸ� ������ ���ڿ� Ŀ��)
		//�� - Ŀ���� ���������� �̵� (������ ��ġ���� ���������� �̵��ϸ� ù ��° ���ڿ� Ŀ��)
		
		//���ĺ��� �� 26��(A~Z : 65~90 , a~z : 97~122)

		int answer = 0;
		
		int check = 0;
		if(name.length()>=1 && name.length()<=20) {
			for(int i=0; i<name.length(); i++) {
				if(name.charAt(i)>='A' && name.charAt(i)<='Z') {
					check = 1;
				}else {
					check = 0;
					break;
				}
			}
		}
		
		// ���ڸ� ���� �� �ִ� ����� �Ʒ�,��
		// ���ϴ� ��ġ�� �̵��� �� �ִ� ����� ��,��
		
		//�� - name.charAt(i) - base.charAt(i)
		//�� - base.charAt(i) - name.charAt(i) + 26
		//���� �� �� �� ���ؼ� ���� �ŷ� ����

		//�� - Ŀ���� �������� �̵� (ù ��° ��ġ���� �������� �̵��ϸ� ������ ���ڿ� Ŀ��)
		//�� - Ŀ���� ���������� �̵� (������ ��ġ���� ���������� �̵��ϸ� ù ��° ���ڿ� Ŀ��) -> ������ ��ġ���� ���������� �̵��ؼ� ù ��°�� ���ư��� ���� ������?
		//ù ��° ��ġ������ ���ϸ� �� �� ����
		//���� ZANAAEB �̸� N �ε������� �·� �����̴°� �� Ƚ���� �����Ƿ� A�� �ƴ� ���� �� �ε������� �񱳰� �ʿ�
		
		//J - A �� 9, ���� Z, A�̸� Z - A = 25�ε� A���� �ϳ��� �������� Z�ϱ� +26?
		
		
		//�� û��
		//1. �� �ε����� ���ڸ� �����ϴ� ���� ���̽�ƽ�� �Ʒ����� �����̴� ��
		//2. ���� A�� �ƴ� �ε����� ã�� ���� ���̽�ƽ�� �¿�� �����̴� ��
		// ����, �Ʒ���/�¿� �� ���� ���� ������ ���
		// 1. �Ʒ��� : A�� �ƴ� �ε����� ����ؼ� �Ʒ��� ������ ���θ� ����
		// 2. �¿� : A�� �ƴ� �ε������� ���� �ε������� �¿� ������ ���ؼ� �ּڰ� ����
		// ���� : ZANAAAB�̸�
		//		Z���� N���� �̵� : �� 2, �� 5 �̹Ƿ� �� 2 ����
		//		N���� B���� �̵� : �� 4, �� 3 �̹Ƿ� �� 3 ����
		//		���� �����ϸ� 0, 2, 6 �ε������� ���� A�� �ƴ� ������
		//		��ü ���̰� 7�� ��
		//		��� �̵��ϴ� Ƚ���� ���Ϸ��� 2 - 0 / 6 - 2
		//		�·� �̵��ϴ� Ƚ���� ���Ϸ��� (7-2) + (0-0) = 7-(2-0) / (7-6) + (2-0) = 7-(6-2)
		if(check == 1) {
			char base = 'A';
			int sum = 0;
			name = "BBBAAAAB";
			List<String> notAList = new ArrayList<String>();
			for(int i=0; i<name.length(); i++) {
				if(name.charAt(i) != 'A') {
					notAList.add(String.valueOf(i));
				}
			}
			System.out.println("notAList: " + notAList);
			//System.out.println("gap: " + (Integer.valueOf(notAList.get(2))-Integer.valueOf(notAList.get(0))));
			/*
			for(int i=0; i<notAList.size(); i++) {
				if(i+1<notAList.size()) {
					int moveRight = notAList.get(i+1) - notAList.get(i);
					int moveLeft = (name.length() - (notAList.get(i+1) - notAList.get(i)));
					System.out.println(moveRight + " / " + moveLeft);
					if(moveRight > moveLeft) {
						sum += moveLeft;
					}else {
						sum += moveRight;
					}
				}
			}
			System.out.println("sum : " + sum);*/
			//�� ���� BAAAABB�� ��� �� ���� B�� �̵��� ��
			//0��° �ε������� 5��° �ε��� B�� �̵�(�·� 2��) -> 5��° �ε������� 6��° �ε��� B�� �̵�(��� 1��)
			//�� ����� ���̰�
			//0��° �ε������� 6��° �ε��� B�� �̵�(�·� 1��) -> 6��° �ε������� 5��° �ε��� B�� �̵�(�·� 1��)
			//��� �� �ּ� Ƚ���� ���ϴ� ����� �����Ƿ� Ʋ�� ���̶�� �� �� �ִ�.
			//(BBBAAAAB�� ���õ� ���� -> �ּ� 8������ �̵� ����) => ���� 1��, ���� 2��, ���� 1��
			System.out.println("======================");

			//���ڿ� ������ �¿�� ������ �� A�� �ƴ� ���ڸ� ������ ���, �׶������� Ƚ���� ���غ���
			//���� �ε������� ������ �� �ܰ踶�� �¿� ��� -> ���� �ε��������� ���� �ε����� �̵��� �� Ƚ���� ���� ��찡 ����, �� �������ʹ� ���� ��찡 ������ ������(���� �ε��� +1�ǹǷ�)
			//�� �ܰ��� �ε����� ���� �ܰ迡�� �����ؾ���
			//notAList: [0, 1, 2, 7]�� ��
			List<Integer> cases = new ArrayList<Integer>();
			int totalCases = (int)Math.pow(2, notAList.size()-1);
			System.out.println("totalCases : "+totalCases);
			int firstMoveRight = Integer.parseInt(notAList.get(1)) - Integer.parseInt(notAList.get(0));
			int cursorMove = Integer.parseInt(notAList.get(0)) - Integer.parseInt(notAList.get(notAList.size()-1));
			int firstMoveLeft = (cursorMove < 0) ? (cursorMove+name.length()) : (cursorMove);
			System.out.println("ù ���� �̵� : " + firstMoveRight);
			System.out.println("ù ���� �̵� : " + firstMoveLeft);
			System.out.println("cursor : " + cursorMove);
			if(firstMoveRight == firstMoveLeft) {
				System.out.println("!!!!" + notAList);
				List<String> list1 = new ArrayList<String>();
				list1 = notAList.subList(0, notAList.size());
				List<String> list2 = new ArrayList<String>();
				list2 = notAList.subList(0, notAList.size());
				System.out.println("list1 : " + list1);
				System.out.println("list2 : " + list2);
				
				int rightResult = calRight(1, list2);
				System.out.println("!!!!" + notAList);
				int leftResult = calLeft(notAList.size()-1, list1);
			}
			
			
			int moveRight = 0;
			int moveLeft = 0;
			int index = 0;
			while(cases.size() == totalCases) {
				
				
				break;
				
			}
			/*
			System.out.println("======================");			
			
			
			for(int i=0; i<name.length(); i++) {
				if(name.charAt(i) != base) {
					int moveUpper = name.charAt(i) - base;
					int moveLower = 26 - (name.charAt(i) - base);
					System.out.println((name.charAt(i) - base) + " / " + (base - name.charAt(i) + 26));
					if(moveUpper > moveLower) {
						sum += moveLower;
						System.out.println("## : " + sum);
					}else{
						sum += moveUpper;
						System.out.println("## : " + sum);
					}
				}
			}
			System.out.println("sum : " + sum);
			*/
		}
		return answer;
	}
	
	public int calLeft(int after1, List<String> list1) {
		while(true) {
			System.out.println("**************�� ���*****************");
			System.out.println("after : " + after1);
			System.out.println("list : " + list1);
			list1.set(0, "#");
			int moveLeft = 0;
			
			while(true) {
				int sharp = 0;
				for(int i=0; i<list1.size(); i++) {
					if(list1.get(i).equals("#")) {
						sharp++;
					}
				}
				if(sharp == list1.size() - 1) {
					break;
				}
				
				int left = after1;
				if(left-1 > 0) { //�·� �̵� �� �·� �� ���
					if(!list1.get(left-1).equals("#")) {
						moveLeft = Integer.parseInt(list1.get(left));
						list1.set(left, "#");
						break;
					}else {
						left--;
					}
				}else {						//�·� �̵� �� �� ���������� �� ���
					left = list1.size()-1;
					if(!list1.get(left-1).equals("#")) {
						moveLeft = Integer.parseInt(list1.get(left));
						list1.set(left, "#");
						break;
					}else {
						left--;
					}
				}
			}

			System.out.println("�� : " + moveLeft);
			break;
			
		}
		return 0;
	}
	
	public int calRight(int after2, List<String> list2) {
		while(true) {
			System.out.println("**************�� ���*****************");
			System.out.println("after : " + after2);
			System.out.println("list : " + list2);
			list2.set(0, "#");
			int moveRight = 0;
			
			while(true) {
				int sharp = 0;
				for(int i=0; i<list2.size(); i++) {
					if(list2.get(i).equals("#")) {
						sharp++;
					}
				}
				if(sharp == list2.size() - 1) {
					break;
				}
				int right = after2;
				
				if(right+1 < list2.size()) { //��� �̵� �� ��� �� ���
					if(!list2.get(right+1).equals("#")) {
						moveRight = Integer.parseInt(list2.get(right));
						System.out.println("Ȯ�� : " + moveRight);
						list2.set(right, "#");
						System.out.println("Ȯ�� : " + right);
						break;
					}else {
						right++;
					}
				}else {						//��� �̵� �� �� ù ������ �� ���
					right = 0;
					if(!list2.get(right+1).equals("#")) {
						moveRight = Integer.parseInt(list2.get(right));
						list2.set(right, "#");
						break;
					}else {
						right++;
					}
				}
			}

			System.out.println("�� : " + moveRight);
			break;
			
		}
		return 0;
	}
}

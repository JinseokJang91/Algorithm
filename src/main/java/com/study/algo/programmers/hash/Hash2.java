package com.study.algo.programmers.hash;

import java.util.Arrays;

public class Hash2 {

	//�ؽ�>��ȭ��ȣ ���
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] phone_book = {"119", "97674223", "1195524421"};
		//String[] phone_book = {"123", "456", "789"};
		//String[] phone_book = {"12", "123", "1235", "567", "88"};
		
		boolean answer = true;
		//System.out.println(phone_book[1].substring(0,phone_book[0].length()));
		//���ѻ���
		//1. phone_book�� length : 1 �̻� 1,000,000 ����
		//2. �� ��ȭ��ȣ�� length :  1 �̻� 20 ����
		int check = 0;
		String compare = "";
		if(phone_book.length>=1 && phone_book.length<=1000000) {
			for(int i=0; i<phone_book.length; i++) {
				if(phone_book[i].length() >=1 && phone_book[i].length() <= 20) {
					check = 1;
				}
			}
		}
		Arrays.sort(phone_book);
		for(int i=0; i<phone_book.length; i++) {
			System.out.print("#"+phone_book[i]);
		}
		System.out.println();
		
		if(check == 1) {
			for(int i=0; i<phone_book.length; i++) {
				if(i+1<phone_book.length) {
					if(phone_book[i].length() < phone_book[i+1].length()) {
						compare = phone_book[i+1].substring(0, phone_book[i].length());
						System.out.println(i + " - " + (i+1) + "/compare : " + compare);
						if(phone_book[i].equals(compare)) {
							answer = false;
							break;
						}
					}else if(phone_book[i].length() > phone_book[i+1].length()) {
						compare = phone_book[i].substring(0, phone_book[i+1].length());
						System.out.println(i + " - " + (i+1) + "/compare : " + compare);
						if(phone_book[i+1].equals(compare)) {
							answer = false;
							break;
						}
					}else {
						if(phone_book[i].equals(phone_book[i+1])) {
							answer = false;
							break;
						}
					}
				}
			}
		}
		
		System.out.println("answer : " + answer);
		
		//���� for���� ���� �ʰ� ���� for���� ���� ����
		//Arrays.sort�� �̿��� �����ϸ� ���λ簡 ����Ǵ� �� ������� ������
		//���� �ϳ��ϳ� ���� �ʿ� ���� �յڸ� ���ϸ� �Ǳ� ������ ���� for�� ���
		
		
		/*
		 * for(int j=0; j<phone_book.length; j++) {
					if(i != j) {
						if(phone_book[i].length() < phone_book[j].length()) {
							compare = phone_book[j].substring(0, phone_book[i].length());
							System.out.println(i + " - " + j + "/compare : " + compare);
							if(phone_book[i].equals(compare)) {
								answer = false;
								result = 1;
								break;
							}
						}else if(phone_book[i].length() > phone_book[j].length()) {
							compare = phone_book[i].substring(0, phone_book[j].length());
							System.out.println(i + " - " + j + "/compare : " + compare);
							if(phone_book[j].equals(compare)) {
								answer = false;
								result = 1;
								break;
							}
						}else {
							if(phone_book[i].equals(phone_book[j])) {
								answer = false;
								result = 1;
								break;
							}
						}
					}
				}
		 * 
		 * */
		
	}

}

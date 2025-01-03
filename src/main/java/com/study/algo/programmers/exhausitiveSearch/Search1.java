package com.study.algo.programmers.exhausitiveSearch;

import java.util.ArrayList;

public class Search1{

	//����Ž��>���ǰ��
	public int[] solution(int[] answers) {
		return null;
	}
	
	public static void main(String[] args) {

		//���� ����
		//1. ������ �ִ� 10,000 ������ ����
		//2. ������ ������ 1,2,3,4,5 �� �ϳ�
		//3. ���� ���� ������ ���� ����� ������ ���, return�ϴ� ���� �������� ����
		int[] answers = {1,2,3,4,5,3,2,4,5,3,1,2,3,4,5};
		
		int[] answer = {};
		ArrayList<Integer> answerList = new ArrayList<Integer>();
		
		//1�� ������ = 1,2,3,4,5 �ݺ�
		//2�� ������ = 2,1,2,3,2,4,2,5 �ݺ�
		//3�� ������ = 3,3,1,1,2,2,4,4,5,5 �ݺ�
		int[] first = {1,2,3,4,5};
		int[] second = {2,1,2,3,2,4,2,5};
		int[] third = {3,3,1,1,2,2,4,4,5,5};
		
		ArrayList firstAnsw = new ArrayList();
		ArrayList secondAnsw = new ArrayList();
		ArrayList thirdAnsw = new ArrayList();

		if(answers.length <= 10000) {//���� ���� 1
			for(int i=0; i<answers.length; i++) {//���� ���� 2
				if(answers[i] > 5 || answers[i] < 1) {
					System.out.println("���� Ż��");
					return;
					//return null;
				}
			}
			
			//x�� �� ������ �������� ���� �߻� -> ���� ����ؼ� �������� 0�� ���� 0�� �ƴ� ���� ������ ����
			//int x = 0;//ArrayList�� 1,2,3�� �������� �迭�� �ݺ������� �ֱ����� ����ϴ� ����
			//	-->	������ �ַ��� �ߴµ� x�� Ŀ������ �ҿ��� �������� ������(answers�� 15�� ���̸� ���� ���� 3, �ű⼭ -1�� �ص� 10�� �Ǳ� ������ Ʋ��)
			//		�׳� �������� �ٷ� ó���ϴ� ����� ����Ʈ����.
			for(int i=0; i<answers.length; i++) {
				
				if(answers.length >= first.length) {
					if(i<first.length) {
						firstAnsw.add(first[i]);
					}else {
						firstAnsw.add(first[i%first.length]);
						/*
						x = answers.length/first.length;
						if(answers.length%first.length ==0) {
							firstAnsw.add(first[i-first.length*(x-1)]);
						}else {
							firstAnsw.add(first[i-first.length*(x)]);
						}*/
					}
					
				}else {
					firstAnsw.add(first[i]);
				}
				
				if(answers.length >= second.length) {
					if(i<second.length) {
						secondAnsw.add(second[i]);
					}else {
						secondAnsw.add(second[i%second.length]);
					}
					
				}else {
					secondAnsw.add(second[i]);
				}
				
				if(answers.length >= third.length) {
					if(i<third.length) {
						thirdAnsw.add(third[i]);
					}else {
						thirdAnsw.add(third[i%third.length]);
					}
					
				}else {
					thirdAnsw.add(third[i]);
				}
			}
			
		}

		System.out.println("firstAnsw : " + firstAnsw);
		System.out.println("secondAnsw : " + secondAnsw);
		System.out.println("thirdAnsw : " + thirdAnsw);
		
		int firstCnt = 0;
		int secondCnt = 0;
		int thirdCnt = 0;
		for(int i=0; i<answers.length; i++) {
			
			if(answers[i] == (int)firstAnsw.get(i)) {
				firstCnt++;
			}
			
			if(answers[i] == (int)secondAnsw.get(i)) {
				secondCnt++;
			}
			
			if(answers[i] == (int)thirdAnsw.get(i)) {
				thirdCnt++;
			}
		}
		
		System.out.println("firstCnt : " + firstCnt);
		System.out.println("secondCnt : " + secondCnt);
		System.out.println("thirdCnt : " + thirdCnt);
		
		//������ ���� ���� ������� �����ϱ� ���� �ڵ�(������ ��쵵 ����)
		if(firstCnt>secondCnt) {
			if(firstCnt>thirdCnt) {
				answerList.add(1);
			}else if(firstCnt == thirdCnt) {
				answerList.add(1);
				answerList.add(3);
			}else {
				answerList.add(3);
			}
		}else if(firstCnt == secondCnt){
			if(firstCnt>thirdCnt) {
				answerList.add(1);
				answerList.add(2);
			}else if(firstCnt == thirdCnt) {
				answerList.add(1);
				answerList.add(2);
				answerList.add(3);
			}else {
				answerList.add(3);
			}
		}else {
			if(secondCnt>thirdCnt) {
				answerList.add(2);
			}else if(secondCnt == thirdCnt) {
				answerList.add(2);
				answerList.add(3);
			}else {
				answerList.add(3);
			}
		}
		
		//System.out.println(answer.length);
		
		answer = answerList.stream().mapToInt(i->i).toArray();
		//stream API ��� (https://jeanette.tistory.com/155)
		//answerList.stream().mapToInt(i->i).toArray() �Ǵ�
		//answerList.stream().mapToInt(Integer::intValue).toArray()
		
		System.out.println("answerList : " + answerList);
		/*
		for(int i=0; i<answerList.size(); i++) {
			answer[i] = answerList.get(i);
		}*/
		
		System.out.println("answer�迭 �ּҰ� : "+answer);
		System.out.print("���� �� : ");
		for(int i=0; i<answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}

}

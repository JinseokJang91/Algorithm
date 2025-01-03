package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_2775 {

	public static void main(String[] args) throws Exception{
		
		//2775�� �γ�ȸ���� ���׾�
		/*
		 * a���� bȣ�� ����� �ڽ��� �Ʒ�(a-1)���� 1ȣ���� bȣ���� ������� ���� �ո�ŭ ������� ������ ��ƾ� �Ѵ�.
		 * ����Ʈ�� 0������ �ְ� �� ���� 1ȣ���� �����ϸ�, 0���� iȣ���� i���� ���.
		 * �־����� ���� k, n : k - ��, n - ȣ
		 * */
		
		/*
		 * ...
		 * 2�� : 1ȣ(1��)	2ȣ(1+3��)	3ȣ(1+3+6��)	5ȣ(1+3+6+10��)	5ȣ(1+3+6+10+15��)	... Nȣ
		 * 1�� : 1ȣ(1��)	2ȣ(1+2��)	3ȣ(1+2+3��)	4ȣ(1+2+3+4��)	5ȣ(1+2+3+4+5��)		... Nȣ(1+2+...+N��)
		 * 0�� : 1ȣ(1��) 	2ȣ(2��) 		3ȣ(3��) 		4ȣ(4��)			5ȣ(5��)				... Nȣ(N��)
		
		 * k���� nȣ�� �ִ� ���ֹ� ���� ����Ϸ���
		 * 
		 * */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer> answer = new ArrayList<Integer>();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			int residents = getResidentsCnt(k, n);
			answer.add(residents);
		}
		
		for(int i=0; i<answer.size(); i++) {
			System.out.println(answer.get(i));
		}
		
		br.close();
	}
	
	public static int getResidentsCnt(int floor, int room) {
		
		//List<Integer> nthRoom = new ArrayList<Integer>();
		
		List<Integer> downFloor = new ArrayList<Integer>();	//�Ʒ��� ȣ�� �� ������ ��
		List<Integer> tempFloor = new ArrayList<Integer>(); //�ش��� ������ �� ��� �� �Ʒ��� ����Ʈ�� �ֱ� ���� �ӽ� ����Ʈ
		int nthRoom = 0; //�� ȣ���� ������ ��
		
		for(int i=0; i<room; i++) {
			downFloor.add(i + 1);
		}

		for(int i=0; i<floor; i++) {
			nthRoom = 0; //�� ���� ȣ�� �� ������ ���� ����ؾ� �ϹǷ� �ʱ�ȭ
			for(int j=1; j<=room; j++) {
				nthRoom += downFloor.get(j - 1);
				//System.out.println("nthRoom : " + nthRoom);
				tempFloor.add(nthRoom);
			}
			
			//���� ���� �ö󰡸� �Ʒ����� ������ ����� ���� �ǹǷ�
			//�ӽø���Ʈ(�ش��� ������ ���)�� �Ʒ��� ����Ʈ�� ��� ���� ����
			//1. �Ʒ��� ����Ʈ clear
			//2. �ӽ� ����Ʈ�� �Ʒ��� ����Ʈ�� �ű�(for�� �Ǵ� .addAll �Լ� ���)
			//3. �ӽ� ����Ʈ clear(���� �� ��� ����� ��� ����)
			downFloor.clear();
			
			/* [ ������� ]
			
			//downFloor = tempFloor;	
			//�ܼ��ϰ� '='�� �̿��� ��ƺ����� ������, clear�ϸ� ���� ����Ʈ�� ������� ���� �߻���
			//���� �˻��� �غ������� ������ ã�µ��� ����..
			//�׷��� ȥ�� ����غ� ���
			//tempFloor.set(0, 9999); //�� �׽�Ʈ �غ�
			
			//-> .set�� �̿��� tempFloor�� 0��° �ε����� �ٲ���� �� �ű� ����Ʈ(downFloor)�� �����ϰ� ��Ÿ���� ����� Ȯ������
			//���� '='�� ������� �� downFloor�� tempFloor�� ���� �Űܰ��� ���� �ƴ϶� tempFloor�� downFloor�� ���� ����Ʈ(Like �ֹ����)�� �ȴٴ� ������ ������ �� ����(Ȯ��ġ�� ����)
			//�׷��� ������ downFloor = tempFloor;�� �����ϰ�, � ����Ʈ�� �����͸� �ٲٵ� �� �ٿ� ������ �ɰŶ�� ����
			//downFloor.set(0, 9999); //�� �׽�Ʈ �غ� ���
			//downFloor�� �����͸� �ٲ������� tempFloor�� �����Ͱ� �����ϰ� �ٲ� ���� Ȯ���� �� �־���
			
			//��� :	List A�� '='�� ����ؼ� List B�� �����͸� ������ �����ϳ�
			//		�ܼ��� �����Ͱ� �Űܰ��� ���� �ƴ�, A�� B�� ���� �Ǹ�, B�� A�� ���� �Ǹ� ��, ��ȣ ���� �� �ȴ�.
			
			*/
			
//			for(int j=0; j<tempFloor.size(); j++) {
//				downFloor.add(tempFloor.get(j));
//			}
			downFloor.addAll(tempFloor);
			tempFloor.clear();
			
			//System.out.println("tempFloor : " + tempFloor);
			//System.out.println("downFloor : " + downFloor);
		}
		
		return nthRoom;
	}
}

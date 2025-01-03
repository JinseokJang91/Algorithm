package com.study.algo.programmers.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Greedy1 {

	//Ž���>ü����
	public static void main(String[] args) {
		
		//�ٷ� �չ�ȣ�� �л��̳�, �ٷ� �޹�ȣ�� �л����Ը� ü������ ������ �� �ִ�.
		//��ü �л��� �� n, �������� �л����� ��ȣ�� ��� �迭 lost, ������ ü������ ������ �л����� ��ȣ�� ��� �迭 reserve
		//ü�������� ���� �� �ִ� �л��� �ִ��� return
		
		//���� ����
		//1. n�� 2 �̻� 30 ����
		//2. lost�� length�� 1 �̻� n ����, �ߺ��Ǵ� ��ȣ ����
		//3. reserve�� length�� 1 �̻� n ����, �ߺ��Ǵ� ��ȣ ����
		//4. reserve�� ����ִ� �л��� �ٸ� �л����� ü������ ������ �� ����
		//5. reserve�� ����ִ� �л��� lost�� ������� �� ����, �̷� ��� �ٸ� �л����� ü������ ������ �� ����
		
		//�׽�Ʈ ���̽� 1
		int n = 20;
		int[] lost = {6,4,5,2,1,10};
		int[] reserve = {5,8,12,4,2,6};
		/*
		if((n>=2 && n<=30) && (lost.length>=1 && lost.length<=n) && (reserve.length>=1 && reserve.length<=n)) {
			System.out.println("---���� ���� 1,2,3 ����");
			
			List<Integer> lostList = new ArrayList<Integer>();
			List<Integer> reserveList = new ArrayList<Integer>();
			
			//removeAll�� ����ϱ� ���� ���� ��� ����Ʈ
			List<Integer> lostList2 = new ArrayList<Integer>();
			List<Integer> reserveList2 = new ArrayList<Integer>();
			
			for(int i=0; i<lost.length; i++) {
				lostList.add(lost[i]);
				lostList2.add(lost[i]);
			}
			for(int i=0; i<reserve.length; i++) {
				reserveList.add(reserve[i]);
				reserveList2.add(reserve[i]);
			}
			System.out.println("lostList : " + lostList);
			System.out.println("reserveList : " + reserveList);
			
			//ü������ ������ �� �ִ� ������ lost�� �ִ� ��ȣ�� �� �Ǵ� �޹�ȣ�� reserve�� �ִ� ���
			//lost�� �ִ� ��ȣ�� reserve�� �ű� �� n - lost.length
			//��, n - ü������ ������ �л� �� �̴�.			
			//��, lost�� reserve �� �ٿ� �ش�Ǵ� �л��� ��츦 ����
			//���������� reserve�� �ű�� HashSet�� ����ؼ� �ߺ� �������� --> n���� lost�� �����ؼ� �ߺ� ���Ű� �ǹ� ������(���߿� �ٸ� ������ ����غ���)
			
			//removeAll�� ����ؼ� lost�� reserve �� �ٿ� �ش�Ǵ� �л��� ����Ʈ���� ����
			lostList.removeAll(reserveList2);
			reserveList.removeAll(lostList2);
			//�񱳱� ����Ʈ ���θ� ����
			lostList2.clear();
			reserveList2.clear();
			//�ߺ� ���ŵ� ����Ʈ�� �ٽ� ����
			if(!lostList.isEmpty() && !reserveList.isEmpty()) {
				lostList2.addAll(lostList);
				reserveList2.addAll(reserveList);
				
				for(int i=0; i<lostList.size(); i++) {
					System.out.println("���� ���� Ȯ�� : " + reserveList.contains(lostList.get(i)));
					if(!lostList2.isEmpty() && !reserveList.isEmpty()) {
						if((reserveList.contains(lostList.get(i)-1))) {
							System.out.println("�ִ�1");
							System.out.println(lostList.get(i));
							lostList2.remove(lostList.get(i));
							reserveList.remove(Integer.valueOf(lostList.get(i)-1));//remove(Object O)�̱� ������ Integer ��üȭ ������
						}else if((reserveList.contains(lostList.get(i)+1))) {
							System.out.println("�ִ�2");
							System.out.println(lostList.get(i));
							lostList2.remove(lostList.get(i));
							reserveList.remove(Integer.valueOf(lostList.get(i)+1));
						}
					}
					
					
					//for(int j=0; j<reserveList.size(); j++) {
					//	if(!lostList.isEmpty() && !reserveList.isEmpty()) {
					//		//�� �� ��ȣ�� ���ؼ� ���� �� �ִ��� Ȯ��
					//		if((lostList.get(i)-1 == reserveList.get(j)) || (lostList.get(i)+1 == reserveList.get(j))) {
					//			System.out.println(lostList.get(i) + "�� �л��� " + reserveList.get(j) + "�� �л����� ���� �� �ִ�");
					//			lostList.remove(i);
					//			reserveList.remove(j);
					//		}
					//	}
					//}
				}
			}
			
			System.out.println("lostList : " + lostList);
			System.out.println("reserveList : " + reserveList);
			System.out.println("lostList2 : " + lostList2);
			System.out.println("reserveList2 : " + reserveList2);
			
			
			
			//HashSet �̿��ؼ� �ߺ� �����ϱ�(https://hianna.tistory.com/582)
			//Set<Integer> reserveSet = new HashSet<Integer>(reserveList);
			//List<Integer> finalList = new ArrayList<Integer>(reserveSet);
			
			System.out.println("lostList : " + lostList);
			System.out.println("lostList2 : " + lostList2);
			System.out.println("reserveList : " + reserveList);
			System.out.println("reserveList2 : " + reserveList2);
			//System.out.println("reserveSet : " + reserveSet);
			//System.out.println("finalList : " + finalList);
			
			System.out.println("return�� : " + n + " - " + lostList2.size() + " = " + (n-lostList2.size()));
			
			//�ٽ� ����
			//1. �ߺ� ���Ŵ� HashSet �̿��ؼ� �� �� ����
			// - ArrayList�� Set���� �Ű�ٰ� �ٽ� ArrayList�� �ű�� ��(77����)
			//2. removeAll �޼ҵ�
			// - https://ddolcat.tistory.com/513
			
		}*/
		
        if((n>=2 && n<=30) && (lost.length>=1 && lost.length<=n) && (reserve.length>=1 && reserve.length<=n)) {
			
			List<Integer> lostList = new ArrayList<Integer>();
			List<Integer> reserveList = new ArrayList<Integer>();
			
			//removeAll�� ����ϱ� ���� ���� ��� ����Ʈ
			List<Integer> lostList2 = new ArrayList<Integer>();
			List<Integer> reserveList2 = new ArrayList<Integer>();
			
			Arrays.sort(lost);
			Arrays.sort(reserve);
			
			for(int i=0; i<lost.length; i++) {
				lostList.add(lost[i]);
				lostList2.add(lost[i]);
			}
			for(int i=0; i<reserve.length; i++) {
				reserveList.add(reserve[i]);
				reserveList2.add(reserve[i]);
			}
			
			System.out.println("lostList : " + lostList);
			System.out.println("reserveList : " + reserveList);
			System.out.println("lostList2 : " + lostList2);
			System.out.println("reserveList2 : " + reserveList2);
			System.out.println("=========================================");
			
			//removeAll�� ����ؼ� lost�� reserve �� �ٿ� �ش�Ǵ� �л�(���� ü������ ������ �ְ�, ������ ���� �л�, �� �ڱⲨ�� �ִ� �л�)�� ����Ʈ���� ����
			lostList.removeAll(reserveList2);
			reserveList.removeAll(lostList2);
			System.out.println("lostList : " + lostList);
			System.out.println("reserveList : " + reserveList);
			System.out.println("lostList2 : " + lostList2);
			System.out.println("reserveList2 : " + reserveList2);
			System.out.println("=========================================");
			
			
			//�񱳱� ����Ʈ ���θ� ����
			lostList2.clear();
			reserveList2.clear();
			System.out.println("lostList : " + lostList);
			System.out.println("reserveList : " + reserveList);
			System.out.println("lostList2 : " + lostList2);
			System.out.println("reserveList2 : " + reserveList2);
			System.out.println("=========================================");
			
			//�ߺ� ���ŵ� ����Ʈ�� �ٽ� ����
            lostList2.addAll(lostList);
            reserveList2.addAll(reserveList);
            System.out.println("lostList : " + lostList);
			System.out.println("reserveList : " + reserveList);
			System.out.println("lostList2 : " + lostList2);
			System.out.println("reserveList2 : " + reserveList2);
			System.out.println("=========================================");

			//�չ�ȣ �Ǵ� �޹�ȣ�� �ش��ϴ� �л��� �־ ü������ ���� �� ������ ���� �л��� ��ȣ�� ������ �л��� ��ȣ�� ����
            for(int i=0; i<lostList.size(); i++) {
                if(!lostList2.isEmpty() && !reserveList2.isEmpty()) {
                    if((reserveList2.contains(lostList.get(i)-1))) {
                        lostList2.remove(lostList.get(i));
                        reserveList2.remove(Integer.valueOf(lostList.get(i)-1));
                    }else if((reserveList2.contains(lostList.get(i)+1))) {
                        lostList2.remove(lostList.get(i));
                        reserveList2.remove(Integer.valueOf(lostList.get(i)+1));
                    }
                }
		    }
            
			

			int answer = n - lostList2.size();
			System.out.println("lostList : " + lostList);
			System.out.println("reserveList : " + reserveList);
			System.out.println("lostList2 : " + lostList2);
			System.out.println("reserveList2 : " + reserveList2);
			System.out.println("answer : " + answer);
			
		}
	}

}

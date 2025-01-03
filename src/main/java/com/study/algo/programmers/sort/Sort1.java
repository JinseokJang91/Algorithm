package com.study.algo.programmers.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sort1{

	//����>K��° ��
	public static void main(String[] args) {
		
		/* ���� ��ȹ��>N���� ǥ��
		//�־����� �� N, number
		int N = 5;
		int number = 12;
		
		//���� ����
		//1. N�� 1 �̻� 9 ���� => 1 <= N <= 9
		//2. number�� 1 �̻� 32,000 ���� => 1 <= number <= 32000
		//3. ���Ŀ��� ��ȣ�� ��Ģ���길 ����, ������ ���꿡�� �������� ���� => (55+(5/5)+(5/5))/5�ϸ� 57/5�� 11�ϰ� ������ 2�ε� �������� ���� => �������� ������ ������ ���ʿ� �ʿ����� ������
		//4. �ּڰ�(���Ƚ��)�� 8���� ũ�� -1�� return
		
		int answer = 0;
		
		String a = "" + N + N;
		System.out.println(a);
		Integer.parseInt(a);
		System.out.println(a);
		
		//������ Stringȭ�ؼ� index�� ����?
		//N���� �����°� 2�� �̻��̸� ��ȣ�� ���� �� ����
		//���ϱ�� number�� N���� ������ ������ �� �����ҵ�
		*/
		
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		
		int[] answer = {};
		
		//���� ����
		//1. 1 <= array�� length <= 100
		//2. 1 <= array[i] <= 100
		//3. 1 <= commmands�� length <= 50
		//4. commands[i].length = 3
		
		List<Integer> list = new ArrayList<Integer>();
		
		List<Integer> answList = new ArrayList<Integer>();
		
		int check = 0;
		
		if((array.length>=1 && array.length<=100) && (commands.length>=1 && commands.length<=50)) {
			for(int i=0; i<array.length; i++) {
				if(array[i]>=1 && array[i]<=100) {
					check = 1;
					list.add(array[i]);
				}
			}
			
			System.out.println("list : " + list);
			System.out.println();
			
			if(check == 1) {
				for(int j=0; j<commands.length; j++) {
					if(commands[j].length == 3) {
						
						//list.subList(commands[j][0]-1, commands[j][1]);
						System.out.println("## : " + list.subList(commands[j][0]-1, commands[j][1]));
						List<Integer> subList = new ArrayList<Integer>(list.subList(commands[j][0]-1, commands[j][1]));
						System.out.println("subList : " + subList);
						subList.sort(Comparator.naturalOrder());
						System.out.println("���� : " + subList);
						System.out.println("�ش� �ε����� ���� : " + subList.get(commands[j][2]-1));
						
						answList.add(subList.get(commands[j][2]-1));
						System.out.println();
					}
				}
				
			}
			
			System.out.println("answList : " + answList);
		}
		
		answer = answList.stream().mapToInt(i->i).toArray();
		
		//��Ÿ ������� List �Ⱦ��� �迭������, Arrays.copyOfRange�� Ȱ�� ����(�迭 ����)
		
	}

}

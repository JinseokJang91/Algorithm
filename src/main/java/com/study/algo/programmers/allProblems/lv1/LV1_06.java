package com.study.algo.programmers.allProblems.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LV1_06 {

	public static void main(String[] args) {
		
		Solution6 sol = new Solution6();
		int[] numbers = {2, 1, 3, 4, 1};

		sol.solution(numbers);
	}

}

class Solution6 {
    public int[] solution(int[] numbers) {
        
    	//���� �ڵ� ç���� ����1>�� �� �̾Ƽ� ���ϱ�
    	int[] answer = {};
        
        int check = 0;
        if(numbers.length >= 2 && numbers.length <= 100) {
        	for(int i=0; i<numbers.length; i++) {
        		if(numbers[i] >= 0 && numbers[i] <= 100) {
        			check = 1;
        		}else {
        			check = 0;
        			break;
        		}
        	}
        }
        
        if(check == 1) {
        	
        	List<Integer> list = new ArrayList<Integer>();
        	
        	for(int i=0; i<numbers.length; i++) {
        		for(int j=0; j<numbers.length; j++) {
        			if(i != j) {
        				int sum = numbers[i] + numbers[j];
        				if(!list.contains(sum)) {
        					list.add(sum);
        				}
        			}
        		}
        	}
        	
        	System.out.println("list : " + list);
        	
        	list.sort(Comparator.naturalOrder());
        	
        	
        	System.out.println("list : " + list);
        	
        	answer = new int[list.size()];
        	for(int i=0; i<answer.length; i++) {
        		answer[i] = list.get(i);
        	}
        	/*
        	//�Ʒ��� ���� ������ε� ���� ����
        	Arrays.sort(answer);
        		
        	
        	for(int i=0; i<answer.length; i++) {
        		System.out.print(answer[i] + " ");
        	}
        	*/
        	
        	//***�������***
        	//String �迭�� ���������� ��� Arrays.sort(answer, Collections.reverseOrder());
        	//�� ����ϴµ�, �� ������ ��� int�迭�̹Ƿ� �ش���� ����.
        	//int�� �迭 ���������� Arrays.stream(answer).mapToInt(i -> i).toArray();
        	//�̷� ������ ¥�� �ϴµ� �װͺ��ٴ� �׳� temp���� ����ؼ� ��ü���ִ� ���� �´� �� ����.
        }
        
        return answer;
    }
}
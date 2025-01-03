package com.study.algo.programmers.allProblems.lv1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LV1_22 {

	public static void main(String[] args) {
		SolutionLV1_22 sol = new SolutionLV1_22();
		String s = "Zbcdefg";
		String answer = sol.solution(s);
		System.out.println("answer : " + answer);
	}

}

class SolutionLV1_22 {
    public String solution(String s) {
    	
    	//�������� > ���ڿ� ������������ ��ġ�ϱ�
        String answer = "";
        
        //�ҹ��ڰ� �빮�ں��� ū ������ ����
        //���ڸ� ū �ͺ��� ���� ������ ����
        char[] arr = new char[s.length()];
        arr = s.toCharArray();
        
        //���α׷��ӽ� ���� 2~5��
        List<Character> list = new ArrayList<Character>();
        for(int i=0; i<arr.length; i++) {
        	list.add(arr[i]);
        }
        
        list.sort(Comparator.reverseOrder());
        System.out.println("list : " + list);
        
        for(int i=0; i<list.size(); i++) {
        	answer += list.get(i);
        }
        
        /*//�������� -> ���α׷��ӽ� ���� ó�� �ӵ� 10�� - �ټ� ��ȿ������
        for(int i=0; i<arr.length; i++) {
        	for(int j=i; j<arr.length; j++) {
        		if(arr[j] > arr[i]) {
        			char temp = arr[j];
        			arr[j] = arr[i];
        			arr[i] = temp;
        		}
        	}
        }
        
        for(int i=0; i<arr.length; i++) {
        	System.out.printf("%c", arr[i]);
        }System.out.println();
        
        for(int i=0; i<arr.length; i++) {
        	answer += arr[i];
        }
        */
        
        return answer;
    }
}
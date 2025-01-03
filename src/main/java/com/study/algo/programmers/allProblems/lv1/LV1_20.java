package com.study.algo.programmers.allProblems.lv1;

public class LV1_20 {

	public static void main(String[] args) {
		SolutionLV1_20 sol = new SolutionLV1_20();
		int a = 3;
		int b = 5;
		long answer = sol.solution(a, b);
		System.out.println("answer : " + answer);
	}

}

class SolutionLV1_20 {
    public long solution(int a, int b) {
        
    	//�������� > �� ���� ������ ��
    	long answer = 0;
        
    	/*
        if(a == b) {
        	answer = a;
        }else if(a > b) {
        	for(int i = b; i <= a; i++) {
        		answer += i;
        	}
        }else {
        	for(int i = a; i <= b; i++) {
        		answer += i;
        	}
        }
        */
    	
    	//�Ʒ� �ڵ尡 �� ���������� ���� ����� ������ �� �� ����
    	if(a == b) {
    		answer = a;
    	}else {
    		for(int i = Math.min(a, b); i <= Math.max(a, b); i++) {
    			answer += i;
    		}
    	}
        
        
        return answer;
    }
}
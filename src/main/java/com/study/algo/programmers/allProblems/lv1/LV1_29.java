package com.study.algo.programmers.allProblems.lv1;

public class LV1_29 {

	public static void main(String[] args) {
		SolutionLV1_29 sol = new SolutionLV1_29();
		int num = 626331;
		int answer = sol.solution(num);
		System.out.println("answer : " + answer);

	}

}

class SolutionLV1_29 {
    public int solution(int num) {
    	//�������� > �ݶ��� ����
        int answer = 0;
        
        //�־��� ���� 1�� �� ������ �۾� �ݺ�
        //1. �Էµ� ���� ¦����� 2�� ����
        //2. �Էµ� ���� Ȧ����� 3�� ���ϰ� 1�� ����
        //num�� 1�̻� 8,000,000 �̸��� ���� -> int�� ������ ���� �����ؾ� ��
        
        int count = 0;
        
        if(num == 1) {
        	answer = 0;
        	return answer;
        }
        long overNum = (long)num;
        
        while(true) {
        	if(overNum % 2 == 0) {
        		overNum /= 2;
        	}else {
        		overNum = overNum * 3 + 1;
        	}
        	count++;
        	//System.out.println("num : " + overNum);
        	//System.out.println("count : " + count);
        	
        	if(count >= 500) {
        		answer = -1;
        		break;
        	}
        	
        	if(overNum == 1) {
        		answer = count;
        		break;
        	}
        	
        }
        
        return answer;
    }
}
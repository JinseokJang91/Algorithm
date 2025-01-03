package com.study.algo.programmers.allProblems.lv1;

public class LV1_10 {

	public static void main(String[] args) {
		SolutionLV1_10 sol = new SolutionLV1_10();
		int n = 10;
		int answer = sol.solution(n);
		System.out.println("answer : " + answer);
	}

}

class SolutionLV1_10 {
    public int solution(int n) {
        int answer = 0;
        
        //���� �ڵ� ç���� ����3 > �������� 1�� �Ǵ� �� ã��
        if(n >= 3 && n <= 1000000) {
        	//n�� x�� ���� �������� 1�� �ǵ��� �ϴ� ���� ���� �ڿ��� x�� return
        	//n % x = 1 �� �Ǵ� ���� ���� �ڿ���
        	//�������� 1�� �Ƿ��� x�� ������ n���� 1�̻� ���� ����
        	
        	for(int i=1; i<n; i++) {
        		if(n % i == 1) {
        			System.out.println("i : " + i);
        			answer = i;
        			break; //���� ���� ���� ���ϴ� �ű� ������ break�Ἥ �ٷ� �������´�.
        		}
        	}
        }
        
        return answer;
    }
}
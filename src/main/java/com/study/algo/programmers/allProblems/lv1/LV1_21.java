package com.study.algo.programmers.allProblems.lv1;

public class LV1_21 {

	public static void main(String[] args) {
		SolutionLV1_21 sol = new SolutionLV1_21();
		int price = 3;
		int money = 20;
		int count = 4;
		long answer = sol.solution(price, money, count);
		System.out.println("answer : " + answer);
	}
	
}

class SolutionLV1_21 {
    public long solution(int price, int money, int count) {
    	
    	// ��Ŭ�� ç���� > ������ �ݾ� ����ϱ�
        long answer = -1;
        
        // ���̱ⱸ�� N�� ° �̿��Ѵٸ� ���� �̿���� N�踦 �޴´�.
        // ���� �̿�� : 3
        // ������ �ִ� �� : 20
        // �̿� Ƚ�� : 4
        // 3 + 6 + 9 + 12 = 30
        
        //�׽�Ʈ 18���� 4���ΰ� Ʋ�� ������
        //price�� money�� ����ϸ� ���� ��������� Ŀ�� �� �ֱ� ������
        //sum �� gap�� int�� �ƴ� long������ ����
        long sum = 0;
        for(int i=1; i<=count; i++) {
        	sum += price*i;
        	System.out.println("sum : " + sum);
        }
        
        
        long gap =  sum - money;
        if(gap > 0 ) {
        	answer = gap;
        }else {
        	answer = 0;
        }
        

        return answer;
    }
}

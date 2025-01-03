package com.study.algo.programmers.allProblems.lv1;

import java.util.ArrayList;
import java.util.List;

public class LV1_16 {

	public static void main(String[] args) {
		SolutionLV1_16 sol = new SolutionLV1_16();
		int n = 45;
		//int n = 125;
		//int n = 1;
		int answer = sol.solution(n);
		System.out.println("answer : " + answer);

	}

}

class SolutionLV1_16 {
    public int solution(int n) {
        
    	//���� �ڵ� ç���� ����1 > 3���� ������
    	int answer = 0;
        
        //�ڿ��� n(10����)�� 3�������� ǥ�� �� 3������ �յ� ���� ��Ų ���� 10�������� ǥ��
    	//n�� 45��, 45 -> 1200 -> 0021 -> 7
    	//n�� 125��, 125 -> 11122 -> 22111 -> 229
    	
    	// �����ϸ�,
    	// 1. n�� 3�������� ǥ��
    	// 2. 3���� ���ڸ� ������
    	// 3. �ٽ� 10�������� ��Ÿ����
    	
    	// n�� 1 �̻� 1��(100,000,000) ������ �ڿ���
    	
    	// * 3�������� ��Ÿ����
    	// - 3���� �� �ڸ����� 0~2���� �����ϴ�. (2������ 0,1�� ��Ÿ���� ��ó��)
    	//	 1200 �̸� 3^3 * 1 + 3^2 * 2 + 3^1 * 0 + 3^0 * 0 = 27 + 18 = 45
    	// - 45/3=15..0 -> 15/3=5..0 -> 5/3=1..2 ===> ������ �� + �������� �� = 1 + 2 + 0 + 0
    	// - 125/3=41..2 -> 41/3=13..2 -> 13/3=4..1 -> 4/3=1..1 ===> 1 + 1 + 1 + 2 + 2
    	
    	// 3�������� �ٲ� ���� �������� List�� �־��� ���� �� �ڸ����� 3�������� ����ؼ� ����� ����
    	List<Integer> reverse = new ArrayList<Integer>();
    	
    	if(n < 3) { //n�� 3���� ������ 3���� ǥ�� �� 0���� ��Ÿ���Ƿ� ������ ����� 0, ���� n���� �״�� ����
    		return n;
    	}else {
    		reverse = ternaryScale(n);
        	int result = 0;
        	System.out.println("math : " + Math.pow(3, 3));
        	for(int i=0; i<reverse.size(); i++) {
        		result += ((int)Math.pow(3, reverse.size()- 1 - i)) * reverse.get(i);
        		System.out.println("result : " + result);
        	}
        	answer = result;
        	
            return answer;
    	}
    	
    	//�ٸ� ����� Ǯ��
    	//Integer.parseInt("1200", 3) -> parseInt�� ���� ǥ���� �����ϴ�. 1200�� 3������ ��ȯ�Ѵٴ� ��
    	//System.out.println("### : " + Integer.parseInt("1200", 3));
    }
    
    public List<Integer> ternaryScale(int n) {
    	
    	List<Integer> reverse = new ArrayList<Integer>();
    	int rest = 0;
    	int shareResult = n;
    	int lastShare = 0;
    	while(shareResult >= 3) {
    		
    		rest = shareResult % 3;
    		shareResult /= 3;
    		reverse.add(rest);
    		System.out.println("rest : " + rest);
    		System.out.println("shareResult : " + shareResult);
    		if(shareResult < 3) {
    			lastShare = shareResult;
    			reverse.add(lastShare);
    			break;
    		}
    	}
    	
    	System.out.println("lastShare : " + lastShare);
    	System.out.println("result : " + reverse);
    	
    	return reverse;
    }
}

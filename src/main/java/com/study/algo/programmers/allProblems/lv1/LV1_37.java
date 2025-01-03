package com.study.algo.programmers.allProblems.lv1;

public class LV1_37 {

	public static void main(String[] args) {
		SolutionLV1_37 sol = new SolutionLV1_37();
		String s = "1234";
		boolean answer = sol.solution(s);
		System.out.println("answer : " + answer);

	}

}

class SolutionLV1_37 {
    public boolean solution(String s) /*throws Exception*/{
        //�������� > ���ڿ� �ٷ�� �⺻
    	boolean answer = true;
        
        //���ڿ� s�� ���̰� 4 Ȥ�� 6�̰�, ���ڷθ� ����
    	
    	if(s.length() == 4 || s.length() == 6) {
    		for(int i=0; i<s.length(); i++) {
    			if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
    				answer = true;
    			}else {
    				answer = false;
    				break;
    			}
    		}
    	}else {
    		answer = false;
    	}
    	
    	/*
    	if(s.length() == 4 || s.length() == 6) {
    		try {
    			int a = Integer.parseInt(s);
    			answer = true;
    		} catch(NumberFormatException e) {
    			System.out.println("���ܹ߻�");
    			throw e;
    		}
    	}
        System.out.println(Integer.parseInt(s));
        */
    	
        return answer;
    }
}
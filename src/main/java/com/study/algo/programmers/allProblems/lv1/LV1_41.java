package com.study.algo.programmers.allProblems.lv1;

public class LV1_41 {

	public static void main(String[] args) {
		SolutionLV1_41 sol = new SolutionLV1_41();
		//String s = "pPoooyY";
		String s = "Pyy";
		boolean answer = sol.solution(s);
		System.out.println("answer : " + answer);
	}

}

class SolutionLV1_41 {
    boolean solution(String s) {
        //�������� > ���ڿ� �� p�� y�� ����
    	boolean answer = true;

    	int pCnt = 0;
    	int yCnt = 0;
        for(int i=0; i<s.length(); i++) {
        	if(s.charAt(i) == 'p' || s.charAt(i) == 'P') {
        		pCnt++;
        	}
        	
        	if(s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
        		yCnt++;
        	}
        }
        
        if(pCnt == yCnt) {
        	answer = true;
        }else {
        	answer = false;
        }
        
        //count�� �ϳ��� �ؼ� �ϳ��� +, �ϳ��� -�� �ϴ� ��ĵ� ����
        //toLowerCase() �Ǵ� toUpperCase()�� ����� ������ �ϳ��� ���̴� ��ĵ� ����

        return answer;
    }
}
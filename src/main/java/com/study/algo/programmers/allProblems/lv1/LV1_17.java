package com.study.algo.programmers.allProblems.lv1;

public class LV1_17 {

	public static void main(String[] args) {
		SolutionLV1_17 sol = new SolutionLV1_17();
		String s = "abcd";
		String answer = sol.solution(s);
		System.out.println("answer : " + answer);

	}

}

class SolutionLV1_17 {
    public String solution(String s) {
    	
    	//�������� > ��� ���� ��������
        String answer = "";
        
        //�ܾ��� ���̰� Ȧ����� ��� �� ���ڸ� ��ȯ
        //�ܾ��� ���̰� ¦����� ��� �� ���ڸ� ��ȯ
        StringBuilder sb = new StringBuilder();
        
        int length = s.length();
        int oddIdx = 0;
        int evenIdx1 = 0;
        int evenIdx2 = 0;
        
        if(length % 2 == 1) {
        	oddIdx = length / 2;
        	//answer += s.charAt(oddIdx);
        	sb.append(s.charAt(oddIdx));
        }else {
        	evenIdx2 = length / 2;
        	evenIdx1 = evenIdx2 - 1;
        	
        	//answer += s.charAt(evenIdx1);
        	//answer += s.charAt(evenIdx2);
        	sb.append(s.charAt(evenIdx1));
        	sb.append(s.charAt(evenIdx2));
        }
        System.out.println("sb : " + sb);
        answer = sb.toString();
        
        //answer += �ϴ� �ͺ��� StringBuilder�� �ξ� ������.
        //answer += �� 10��ms, StringBuilder�� 0.0��ms ����
        
        return answer;
    }
}
package com.study.algo.programmers.allProblems.lv1;

public class LV1_35 {

	public static void main(String[] args) {
		SolutionLV1_35 sol = new SolutionLV1_35();
		int n = 4;
		String answer = sol.solution(n);
		System.out.println("answer : " + answer);
	}

}

class SolutionLV1_35 {
    public String solution(int n) {
        
    	//�������� > ���ڼ��ڼ��ڼ��ڼ����ڼ�?
    	String answer = "";
        
        /*
        for(int i=1; i<=n; i++){
            if(i%2 == 1){
                answer += "��";
            }else{
                answer += "��";
            }
        }
        */
        //System.out.println("answer : " + answer);
        
    	//�Ʒ� ����� �ξ� ����
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            if(i%2 == 1){
                sb.append("��");
            }else{
            	sb.append("��");
            }
        }
        System.out.println("sb : " + sb.toString());
        
        return answer;
    }
}
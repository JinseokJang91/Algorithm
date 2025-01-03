package com.study.algo.programmers.allProblems.lv1;

public class LV1_31 {

	public static void main(String[] args) {
		SolutionLV1_31 sol = new SolutionLV1_31();
		long n = 121;
		long answer = sol.solution(n);
		System.out.println("answer : " + answer);
	}

}

class SolutionLV1_31 {
    public long solution(long n) {
        //�������� > ���� ������ �Ǻ�
    	long answer = 0;
        
        //n�� � ���� ���� x�� �������� �ƴ��� �Ǵ�
    	//true �̸� x+1�� ������ ����
    	//false �̸� -1�� ����
    	
    	//Math.sqrt(a) ��Ʈa ���� ���ϴ� ��
    	//Math.pow(a,b)�� a^b�� ���ϴ� ��
    	//System.out.println(Math.pow(11, 2));
    	//System.out.println(Math.sqrt(143));
    	//System.out.println((long)Math.sqrt(143) - Math.sqrt(143));
    	
    	//Math.sqrt�� double���̹Ƿ� �Ҽ����� �����ϴ� ���(ex) 143)�� �޸�
    	//longŸ������ �ٲ� ���� �Ҽ����� ���ŵ� ����� ������ ������
    	//�� ���� ���̸� ���ؼ� 0�� �ƴϸ� �Ҽ����� �����Ѵٰ� ������ �� ����
    	//�Ҽ����� �����ϴ� ���� n�� � ���� ���� ������ �ƴ϶�� ���̱� ������ �������� Ȱ���غ���
    	//longŸ�� - doubleŸ���� ����� double�� ������ ���� �Ƹ� double�� ������ �� Ŀ���ϵ�
    	double gap = (long)Math.sqrt(n) - Math.sqrt(n);
        System.out.println("gap : " + gap + ", 0�ΰ�? : " + (gap==0));
        if(gap == 0) {
        	long root = (long)Math.sqrt(n);
        	answer = (long)Math.pow(root+1, 2);
        }else {
        	answer = -1;
        }
        
    	
        return answer;
    }
}
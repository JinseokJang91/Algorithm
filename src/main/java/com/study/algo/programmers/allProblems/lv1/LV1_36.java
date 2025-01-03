package com.study.algo.programmers.allProblems.lv1;

public class LV1_36 {

	public static void main(String[] args) {
		SolutionLV1_36 sol = new SolutionLV1_36();
		String s = "-1234";
		int answer = sol.solution(s);
		System.out.println("answer : " + answer);
	}

}

class SolutionLV1_36 {
    public int solution(String s) {
        
    	//�������� > ���ڿ��� ������ �ٲٱ�
    	int answer = 0;
        
    	//�տ� ��ȣ(+,-)�� �پ substring�̳� indexOf�� String �޼ҵ�� ó������� �Ѵٰ� ������ �� ������
    	//+,- ��ȣ�� �پ��־ �ٷ� parse�� �Ǵ� ���� Ȯ���� �� �ִ� ����
    	//�� �̷� ������ parse�� ���� �ʰ� �˰������� Ǯ��� �������� ������ �� �ִ� �����̱⵵ ��
    	answer = Integer.parseInt(s);
    	
    	//parseInt�� ���� �ʴ´ٸ� ( ���� ��� ������ #�� +��ȣ, @�� -��ȣ�� �����ض�� ������ ���� �� �ֱ� ������)

    	//�����ڵ� ���� Ȯ��
    	char a = '7'; // 48~57 -> 0~9
    	System.out.println("a : " + (a - '1'));
    	
    	int result = cal(s);
    	System.out.println("result : " + result);
        
        return answer;
    }
    
    public int cal(String s) {
    	
    	int digit = 0;				//�ڸ���
    	int value = 0;				//���Ұ�
    	int sum = 0;				//���� �����
    	char mark = s.charAt(0);	//�� ���ڸ� Ȯ��
    	
    	//��ȣ�� �ִ� ���
    	if(mark < '1' || mark > '9') {
    		for(int i=s.length()-1; i>0; i--) {
        		char c = s.charAt(i);
        		value = c - '0';
        		//System.out.println("plus : " + plus * ((int)Math.pow(10, digit)));
        		sum += value * ((int)Math.pow(10, digit));
        		digit++;
        	}
    	//��ȣ�� ���� ���
    	}else {
    		for(int i=s.length()-1; i>=0; i--) {
        		char c = s.charAt(i);
        		value = c - '0';
        		sum += value * ((int)Math.pow(10, digit));
        		digit++;
        	}
    	}
    	
    	//��ȣ�� -�� ��� ������ ����� ���� -1�� ������(�������� s���� 1�̻� 5�����̰�, 0���� �������� �ʱ� ������ 0�� ����)
    	if(mark == '-') {
    		sum *= -1;
    	}
    	
    	return sum;
    }
}
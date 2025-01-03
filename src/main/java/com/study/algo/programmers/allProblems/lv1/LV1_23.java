package com.study.algo.programmers.allProblems.lv1;

public class LV1_23 {

	public static void main(String[] args) {
		SolutionLV1_23 sol = new SolutionLV1_23();
		int x = -4;
		int n = 2;
		long[] answer = sol.solution(x, n);
		for(int i=0; i<answer.length; i++) {
			System.out.printf("%d ", answer[i]);
		}System.out.println();

	}

}

class SolutionLV1_23 {
    public long[] solution(int x, int n) {
    	
    	//�������� > x��ŭ ������ �ִ�  n���� ����
        long[] answer = {};
        
        answer = new long[n];
        for(int i=1; i<=n; i++) {
        	answer[i-1] = (long) x * i;
        }
        // (long) x * i �ؾߵǴ� ����
        // (long) (x * i) �� �ϸ� (x * i)�� int�� ���� �Ŀ� long Ÿ������ �ٲٴ� ���̰�,
        // (long) x * i �� �ϸ� x�� longŸ������ �ٲ� �Ŀ� i�� ���ǹǷ� ������� long�� �ȴ�.
        
        
        return answer;
    }
}
package com.study.algo.programmers.exhausitiveSearch;

import java.util.ArrayList;
import java.util.List;

public class Search3 {

	public static void main(String[] args) {
		
		SolutionSearch3 sol = new SolutionSearch3();
		int brown = 24;
		int yellow = 24;
		int[] answer = sol.solution(brown, yellow);
		
		// ��� ���
		System.out.print("answer : ");
		for(int i=0; i<answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
		System.out.println();
		
	}

}

class SolutionSearch3 {
    public int[] solution(int brown, int yellow) {
    	
    	// ���� Ž�� > ī��
        int[] answer = new int[2];
        
        int check = 0;
        if((brown >= 8 && brown <= 5000)
        	&& (yellow >= 1 && yellow <= 2000000))
        {
        	check = 1;
        }
        
        if(check == 1) {
        	
        	
        	// brown�� ī���� �׵θ� 1���� ������ �ش���
        	/* �׵θ� ���̴� (���� + ����) * 2 - 4 -> 4�� ��ġ�� �κ��� �簢�� �� �������� �ش��ϴ� �����̱� ����
        	 * ���ø� ���캸��
        	 * [4, 3] -> (4+3)*2 - 4 = 10
        	 * [3, 3] -> (3+3)*2 - 4 = 8
        	 * [8, 6] -> (8+6)*2 - 4 = 24
        	 * ��, �־����� ���� brown, yellow �̰� answer �迭(����, ����)�� ���ؾ� �ϹǷ�
        	 * answer�� [x, y]�� �� brown = (x+y)*2 - 4 �� �ȴ�.
        	 * yellow�� ����*���ο��� brown������ŭ ���� �ǹǷ� yellow = (x*y) - brown
        	 * ���ؾ� �ϴ� ���� x, y
        	 * - ���� ���� : ���� >= ����
        	*/
        	
        	/* x*y = brown + yellow
        	 * �߿� üũ - brown�� yellow�� ���ΰ� �ִ��� �Ǵ�
        	 * -> brown = (x+y)*2 - 4 ���� Ȯ��
        	 * */
        	
        	/* brown + yellow ��, �簢���� ���̴� answer[0] * answer[1] �̴�.
        	 * �簢���� ���̴� brown + yellow ��, �簢�� ������ ����� �̷�� ����.
        	 * ���� ���, brown�� 10, yellow�� 2�� �� �簢���� ���̴� 12�̹Ƿ� 
        	 * 12�� ����� 1,2,3,4,6,12 �� �� ���� ���� 12�� �Ǵ� x,y �߿� brown = (x+y) * 2 -4 �� �����ϴ� x,y�� ã���� �ȴ�.
        	 * �׷� x,y ����Ʈ�� 12,1 / 6,2 / 4,3 �� ������ ����
        	 * �� ���� (x+y) * 2 - 4�� �����غ���
        	 * (12+1) * 2 - 4 = 22
        	 * (6+2) * 2 - 4 = 12
        	 * (4+3) * 2 - 4 = 10  ->  brown���� ����
        	 * 
        	 * �׷� �ܰ躰�� �����ϸ�
        	 * 1. brown + yellow�� ����� ���Ѵ�.
        	 * 2. ����� �� �� ���� ���� brown + yellow ���� ������ x, y�� ���Ѵ�.
        	 * 3. ���� x, y�� brown = (x+y) * 2 - 4 �� �����ϴ��� Ȯ���Ѵ�.
        	 * */
        	List<Integer> list = new ArrayList<Integer>();
        	
        	//1. ��� list�� ����
        	int sum = brown + yellow;
        	for(int i=1; i<=sum; i++) {
        		if(sum % i == 0) {
        			list.add(i);
        		}
        	}
        	
        	//2. ��� �� �� ���� ���ϴµ�, ���� ������ �ϳ��� ���� ���ϸ� ��(Ȧ���� ���� �ش� ���� �ι� ���ϸ� �� -> 1, 5, 25�� ��� 5*5=25)
        	for(int i=0; i<list.size(); i++) {
        		int x = list.get(list.size()-1-i);
        		int y = list.get(i);
        		//System.out.println(x + "*" + y + "=" + x*y);
        		//���ΰ� ���κ��� ũ�ų� �����Ƿ�
        		if(x >= y && x * y == sum) {
        			System.out.println("���� ���� �Ÿ� ����� ��");
        			System.out.println(x + "*" + y + "=" + x*y);
        			if((x + y ) * 2 - 4 == brown) {
        				System.out.println("���� ���ϱ� -> " + x + "*" + y + "=" + x*y);
        				answer[0] = x;
        				answer[1] = y;
        			}
        			
        		}
        	}
        	
        	
        	
        }
        
        return answer;
    }
}
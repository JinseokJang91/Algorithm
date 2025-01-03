package com.study.algo.programmers.allProblems.lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LV1_15 {

	public static void main(String[] args) {
		SolutionLV1_15 sol = new SolutionLV1_15();
		//int[][] sizes = {{60, 50},{30, 70},{60, 30},{80, 40}};
		//int[][] sizes = {{10, 7},{12, 3},{8, 15},{14, 7},{5, 15}};
		int[][] sizes = {{14, 4},{19, 6},{6, 16},{18, 7},{7, 11}};
		int answer = sol.solution(sizes);
		System.out.println("answer : " + answer);

	}

}

class SolutionLV1_15 {
    public int solution(int[][] sizes) {
    	
    	//��Ŭ�� ç����  > �ּ� ���簢��
        int answer = 0;
        
        //���� ���� ���� ���� ���� ���ϱ�
        //���η� ������ �����ϴ� ����� ����ؾ� ��
        
        // �����ϰ� �����غ���
        // ����, ���� ���̰� ����ִ� �迭����
        // ����, ���� ���ο� ������� 
        // �� �� �� ū ���� �ش��ϴ� ���� �� ���� ū ��
        // �׸��� �� ���� ���� ���� �ش��ϴ� ���� �� ���� ū ���� ���ϸ�
        // �ڿ������� ����ȭ�� ���� ũ�⸦ ���� �� �ִ�.
        
        //���� ���, ������ ���� 1����
        //60, 50 -> 60�� ū �� / 50�� ���� ��
        //30, 70 -> 70�� ū �� / 30�� ���� ��
        //60, 30 -> 60�� ū �� / 30�� ���� ��
        //80, 40 -> 80�� ū �� / 40�� ���� ��
        
        //�����ϸ�
        //ū �� ����Ʈ : 60, 70, 60, 80
        //���� �� ����Ʈ : 50, 30, 30, 40
        //���� ū �� ����Ʈ���� 80, ���� �� ����Ʈ���� 50�� ������ �ȴ�.
        
        List<Integer> bigVal = new ArrayList<Integer>();
        List<Integer> smallVal = new ArrayList<Integer>();
        
        for(int i=0; i<sizes.length; i++) {
        	int width = sizes[i][0];
        	int height = sizes[i][1];
        	
        	if(width > height) {
        		bigVal.add(width);
        		smallVal.add(height);
        	}else {
        		bigVal.add(height);
        		smallVal.add(width);
        	}
        }
        System.out.println("bigVal : " + bigVal);
        System.out.println("smallVal : " + smallVal);
        
        //�������� ����
        Collections.sort(bigVal, Comparator.reverseOrder());
        Collections.sort(smallVal, Comparator.reverseOrder());
        
        System.out.println("bigVal : " + bigVal);
        System.out.println("smallVal : " + smallVal);
        
        answer = bigVal.get(0) * smallVal.get(0);
        
        return answer;
    }
}

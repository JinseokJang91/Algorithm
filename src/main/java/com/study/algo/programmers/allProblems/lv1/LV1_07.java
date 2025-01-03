package com.study.algo.programmers.allProblems.lv1;

import java.util.ArrayList;
import java.util.List;

public class LV1_07 {

	public static void main(String[] args) {
		
		int a = 1;
		int b = 1;
		//int a = 1;
		//int b = 7;
		SolutionLV1_7 sol = new SolutionLV1_7();
		String answer = sol.solution(a, b);
		System.out.println("answer : " + answer);
	}

}

class SolutionLV1_7 {
    public String solution(int a, int b) {
        
    	//�������� > 2016��
    	String answer = "";
        
    	//2016���� ����(2�� 29�ϱ��� ����)
    	//������ ������
    	//1. 4�� ������ ��������.
    	//2. 4�� ������ �������� 100���� ������ �������� �ʴ´�. -> 2100���� ���
    	//3. 4�� ������ �������� 100���� ������ �������� �ʰų�  400���� ������ ��������. -> 2000���� ����
    	
    	//2016�� 1�� 1���� �ݿ���
    	//1,3,5,7,8,10,12���� 31�ϱ���
    	//4,6,9,11���� 30�ϱ���
    	//2���� 29�ϱ���(����)
    	
    	//������ ���ϴ� ���̴� �� �ϼ��� ���ؼ� 7�� ���� �������� ã���� �� �� ����.
    	
    	//�� ���� �迭�̳� ����Ʈ�� ��Ƴ��� ����� �� ���
    	
    	int[] arr1 = {1, 3, 5, 7, 8, 10, 12};
    	int[] arr2 = {4, 6, 9, 11};
    	int[] arr3 = {2};
    	String[] dayNames = 
    		{
    			"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"
    		};
    	
    	List<Integer> thirtyOne = new ArrayList<Integer>();
    	List<Integer> thirty = new ArrayList<Integer>();
    	List<Integer> twentyEight = new ArrayList<Integer>();
    	
    	for(int i=0; i<arr1.length; i++) {
    		thirtyOne.add(arr1[i]);
    	}
    	for(int i=0; i<arr2.length; i++) {
    		thirty.add(arr2[i]);
    	}
    	for(int i=0; i<arr3.length; i++) {
    		twentyEight.add(arr3[i]);
    	}
    	System.out.println("31 : " + thirtyOne);
    	System.out.println("30 : " + thirty);
    	System.out.println("29 : " + twentyEight);
    	
    	int totalDayCnt = 0;
    	
    	if(a>1) {
    		for(int i=1; i<a; i++) {
        		if(thirtyOne.contains(i)) {
        			System.out.println(i + "���� 31��");
        			totalDayCnt += 31;
        		}else if(thirty.contains(i)) {
        			System.out.println(i + "���� 30��");
        			totalDayCnt += 30;
        		}else if(twentyEight.contains(i)){
        			System.out.println(i + "���� 29��");
        			totalDayCnt += 29;
        		}
        	}
    		totalDayCnt += b-1;
    	}else {
    		totalDayCnt = b-1;;
    	}
    	
    	System.out.println("totalDayCnt : " + totalDayCnt);
    	
    	int dayIndex = totalDayCnt%7;
    	System.out.println("dayName : " + dayIndex);
    	
    	answer = dayNames[dayIndex];
    	
    	/* ��ų üũ �׽�Ʈ���� Ǭ ����
        int[] arr1 = {1, 3, 5, 7, 8, 10, 12};
        int[] arr2 = {4, 6, 9, 11};
        String[] dayArr = {
          "FRI", "SAT", "SUN", "MON","TUE", "WED", "THU"
        };

        //������ 2�� 29�ϱ��� �ִ� ��
        //List�� 31��, 30�� �ش��ϴ� �� �迭 ���� ��´�.
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        for(int i=0; i<arr1.length; i++){
            list1.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++){
            list2.add(arr2[i]);
        }

        int dayCnt = 0;
        //�ϴ� 1�� a ���� ������ for�� �����鼭 �� ���� �� ���� ���Ѵ�.
        for(int i=1; i<a; i++){
            if(list1.contains(i)){
                //System.out.println(i + "�� if ");
                dayCnt += 31;
            } else if(list2.contains(i)){
                //System.out.println(i + "�� else if ");
                dayCnt += 30;
            } else{
                //System.out.println(i + "�� else ");
                dayCnt += 29;
            }
        }

        dayCnt += b-1;
        int dayIdx = dayCnt%7;

        //System.out.println("dayCnt : " + dayCnt);
        //System.out.println("dayIdx : " + dayIdx);
        //System.out.println("ans : " + dayArr[dayIdx]);
        answer = dayArr[dayIdx];    	
    	*/
    	
        return answer;
    }
}
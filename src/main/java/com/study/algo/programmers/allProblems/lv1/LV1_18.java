package com.study.algo.programmers.allProblems.lv1;

import java.util.ArrayList;
import java.util.List;

public class LV1_18 {

	public static void main(String[] args) {
		SolutionLV1_18 sol = new SolutionLV1_18();
		int[] arr = {1,1,3,3,0,1,1};
		//int[]arr = {4,4,4,3,3};
		int[] answer = {};
		answer = sol.solution(arr);
		for(int i=0; i<answer.length; i++) {
			System.out.printf("%d ", answer[i]);
		}System.out.println();

	}

}

class SolutionLV1_18 {
    public int[] solution(int []arr) {
        
    	//�������� > ���� ���ڴ� �Ⱦ�
    	int[] answer = {};
        
        //�� �迭���� �������� ��Ÿ���� ���ڴ� �ϳ��� ����� ���� ����
    	//�׸��� �迭 arr�� ���ҵ��� ������ �����ؾ� �Ѵ�.
    	//1,1,3,3,0,1,1 �̸� 1,3,0,1�� ����
    	
    	//List�� ����ؼ� ���� �ε��� 0 ���� �־��ְ�
    	//i���� i+1���� ���ؼ� ���� ���� ���� ������ list�� �־��ش�.
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(arr[0]);
    	for(int i=0; i<arr.length; i++) {
    		if(i+1 < arr.length) {
    			if(arr[i] != arr[i+1]) {
    				list.add(arr[i+1]);
    			}
    		}
    	}
    	
    	System.out.println("list : " + list);
    	answer = new int[list.size()];
    	for(int i=0; i<answer.length; i++) {
    		answer[i] = list.get(i);
    	}
    	
    	/* ���ǰ� ��ġ���� �����Ƿ� Set�� ������� ���ҵ� - ���ӵ� ���ڸ� �����ϱ� ����
    	Set<Integer> set = new HashSet<Integer>();
    	for(int i=0; i<arr.length; i++) {
    		set.add(arr[i]);
    		System.out.println("arr[i] : " + arr[i]);
    	}
    	System.out.println("set : " + set);
    	//############################################################
    	//HashSet�� �ڵ� ������ ���� �������� 4,4,4,3,3�� �־��� �� 3,4�� ��µǴ� ������
    	//���Ŀ� ���ؼ��� �ƴ϶� key���� HashSet�� ���̺��� ũ�Ⱓ�� &������ �����ϱ� �����̴�.
    	//���� ��� 1,17,3,3,2��� �� �� HashSet�� ������ 1,17,2,3���� ��µȴ�. 1�� 17�� ���� ���̺� �ε����� ������ �ֱ� ����

    	Iterator<Integer> iter = set.iterator();
    	answer = new int[set.size()];
    	int index = 0;
    	
    	while(iter.hasNext()) {
    		answer[index] = iter.next();
    		index++;
    	}
    	*/

        return answer;
    }
}
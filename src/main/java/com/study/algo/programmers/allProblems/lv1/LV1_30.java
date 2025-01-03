package com.study.algo.programmers.allProblems.lv1;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LV1_30 {

	public static void main(String[] args) {
		SolutionLV1_30 sol = new SolutionLV1_30();
		int[] arr = {10};
		int[] answer = sol.solution(arr);
		for(int i=0; i<answer.length; i++) {
			System.out.printf("%d ", answer[i]);
		}System.out.println();

	}

}

class SolutionLV1_30 {
    public int[] solution(int[] arr) {
    	//�������� > ���� ���� �� �����ϱ�
        int[] answer = {};
        
        //�迭���� ���� ���� ���� ������ �迭�� ����
        //���� ���� ���� ������ �迭�� �� �迭�� ��� -1�� ä���� ����
        
        //�������
        //1. PriorityQueue�� �̿��� �ּҰ��� ã�� �� list�� �ּҰ��� ������ ���� �ִ´�.
        //2. list���� �ٽ� answer�迭�� �־��ش�.
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        //Queue<Integer> heap = new PriorityQueue<Integer>();
        for(Integer find : arr) {
        	heap.add(find);
        	//System.out.println("find : " + find);
        }
        //System.out.println("heap : " + heap);
        //System.out.println("�ּҰ� : " + heap.poll());
        int minVal = heap.poll();
        
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<arr.length; i++) {
        	if(arr[i] != minVal) {
        		list.add(arr[i]);
        	}
        }
        System.out.println("list : " + list);
        
        if(!list.isEmpty()) {
        	answer = new int[list.size()];
            for(int i=0; i<answer.length; i++) {
            	answer[i] = list.get(i);
            }
        }else {
        	answer = new int[1];
        	answer[0] = -1;
        }
        
        return answer;
    }
}
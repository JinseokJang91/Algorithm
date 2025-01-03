package com.study.algo.programmers.allProblems.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class LV1_08 {

	public static void main(String[] args) {
		SolutionLV1_8 sol = new SolutionLV1_8();
		//int[] nums = {3,1,2,3};
		//int[] nums = {3,3,3,2,2,2};
		int[] nums = {3,3,3,2,2,4};
		int answer = sol.solution(nums);
		System.out.println("answer : " + answer);

	}

}

class SolutionLV1_8 {
    public int solution(int[] nums) {
        
    	//�ڵ��׽�Ʈ ���� > ã�ƶ� ���α׷��� �������� > ���ϸ�
    	int answer = 0;
        
        int check = 0;
        if(nums.length >= 1 && nums.length <= 10000 && nums.length%2 == 0) {
        	for(int i=0; i<nums.length; i++) {
        		if(nums[i] >= 1 && nums[i] <= 200000) {
        			check = 1;
        		}else {
        			check = 0;
        			break;
        		}
        	}
        }
        
        if(check == 1) {
        	// N������ ���ϸ� �߿��� N/2���� ���� ������ �� �ִ�.
        	// �ִ��� �پ��� ������ ���ϸ��� ���� �Ѵ�.
        	// N/2������ ���ϸ��� �����ϴ� ��� ��, ���� ���� ������ ���ϸ��� �����ϴ� ����� ã��, �׶��� ���ϸ� ���� ��ȣ�� ������ return
        	
        	int N = nums.length / 2;
        	
        	//1. HashMap�� ����ؼ� �迭�� �ִ� ���ϸ� ��ȣ�� �� ��ȣ�� ������ �־��
        	// ó������ HashMap�� �Ἥ �ߺ��Ǵ� ����ŭ value���� �߰��ؼ� �ϳ��� �������� �ߴµ�
        	// �����غ��� �׷� �ʿ䰡 ������. ���� ���� ��Ե� ���ϸ� �ذ� �Ǵ� ������
        	// ����� while������ iter.next()�� �� ���� ������ while���� 4�� ���ư���. �� �׷����� ��Ȯ�� �𸣰���
        	// �Ƹ��� hasNext�� true�� �� ���� �� next()���� ������ �� �����ϱ� iter.next()�� ���� �� ���� �������� �� ����
        	// ���� ���̳ĸ� while������ �� �� �� �� �� �ȿ��� iter.next()�� �� �� ���� ���� ������ ���� �� �� �������°� �ƴ϶� �� ���� ���� ������
        	// �׷��� iter.next()�� �����ϸ� hasNext()�� �°� �� ���� ����ؾ� �ϰ� �� ���� ����ؾ� �ϴ� �� ����.
        	HashMap<Integer, Integer> pocketmon = new HashMap<Integer, Integer>();
        	for(int i=0; i<nums.length; i++) {
        		if(!pocketmon.containsKey(nums[i])) {
        			pocketmon.put(nums[i], 1);
        		}else {
        			pocketmon.put(nums[i], pocketmon.get(nums[i]) + 1);
        		}
        	}
        	System.out.println("pocketmon : " + pocketmon);
        	
        	Iterator<Entry<Integer, Integer>> iter = pocketmon.entrySet().iterator();
        	
        	int count = 0;
        	
        	while(iter.hasNext()) {
        		System.out.println("while��");
        		
        		//�Ʒ� if�� �ּ�ó�� �ϰ� iter.next()�� �� ���� ���� NoSuchElementException �߻���
        		//System.out.println(iter.next());
        		//System.out.println(iter.next());
        		
        		if(iter.next() != null) {
        			if(count < N) {
            			count++;
            		}else {
            			break;
            		}
        		}
        	}
        	System.out.println("count : " + count);
        	answer = count;
        	
        	//2. List�� ���ϸ� ���� ���� �ִ´�(�ߺ� ����)
        	//(1)->	���� ���� N���� ������ �ִ� �������� list�� ũ�Ⱑ ��.
        	//		�׸��� ���� N�� ���� ���� ���ϸ� �ִ� �� �߿� �ƹ��ų� ������ ��
        	//(2)->	���� ���� N���� ũ�ų� ������ �ִ� �������� N�� ��.
        	//		���� ���� N���� ������ ������ �ִ� �� �� �ִ� ���� N�̱� ������ ���� �ٸ� � ������ ���ٰ� �ϴ��� N�� ���� �� ����
        	List<Integer> list = new ArrayList<Integer>();
        	for(int i=0; i<nums.length; i++) {
        		if(!list.contains(nums[i])) {
        			list.add(nums[i]);
        		}
        	}
        	System.out.println("list : " + list);
        	
        	if(list.size() < N) {
        		answer = list.size();
        	}else {
        		answer = N;
        	}
        	
        	//3. �迭�� ������ ���ϱ� -> �̰� �� �� ������ ������(���α׷��ӽ��� ������ ��)
        	int cnt = 1; //�ּ� �� ���� ������ ���ϸ����� �̷���� �����Ƿ�
        	Arrays.sort(nums);
        	for(int i=0; i<nums.length; i++) {
        		if(i+1 < nums.length) {
        			if(nums[i] != nums[i+1]) {
        				System.out.println(nums[i] + "�� " + nums[i+1]);
        				cnt++;
        			}
        		}
        	}
        	System.out.println("cnt : " + cnt);
        	
        	if(cnt < N) {
        		answer = cnt;
        	}else {
        		answer = N;
        	}
        	
        	//4. Set �̿��غ��� -> �̰� ���� ������ ����
        	Set<Integer> set = new HashSet<Integer>();
        	for(int i=0; i<nums.length; i++) {
        		set.add(nums[i]);
        	}
        	System.out.println("set : " + set);
        	int setSize = set.size();
        	if(setSize < N) {
        		answer = setSize;
        	}else {
        		answer = N;
        	}
        	
        }
        
        return answer;
    }
}
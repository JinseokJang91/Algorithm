package com.study.algo.programmers.heap;

import java.util.PriorityQueue;

public class Heap1 {

	public static void main(String[] args) {
		
		SolutionHeap1 sol = new SolutionHeap1();
		//int[] scoville = {1, 2, 3, 9, 10, 12};
		//int[] scoville = {1, 1, 1, 1, 2, 2};
		int[] scoville = {2, 1, 4};
		//int[] scoville = {1, 1};
		int K = 7;
		int answer = sol.solution(scoville, K);
		System.out.println("answer : " + answer);
	}

}

class SolutionHeap1 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        //������ ��� ���ں� ������ ���̱�
        //���� ������ ���ں� ���� = ���� ���� ���� ������ ���ں� ���� + (�� ��°�� ���� ���� ������ ���ں� ���� * 2)
        //��� ������ ���ں� ������ K�̻����� ����� ���� ����� �ϴ� �ּ� Ƚ���� return
        
        int check = 0;
        if((scoville.length >= 2 && scoville.length <= 1000000) && (K >= 0 && K <= 1000000000)) {
        	for(int i=0; i<scoville.length; i++) {
        		if(scoville[i] >= 0 && scoville[i] <= 1000000) {
        			check = 1;
        		}else {
        			check = 0;
        			break;
        		}
        	}
        }
        
        if(check == 1) {
        	//���� ���� ���� ���İ� �� ��°�� ���� ���� ������ �����ؾ� �ϴ�
        	//scoville �迭�� �������� �����ϰ� �ϴ� �տ��� �� ���� ��� ����� -> �ݷʰ� ������ �� ����
        	
        	/*
        	Arrays.sort(scoville);
        	List<Integer> list = new ArrayList<Integer>();

        	for(int i=0; i<scoville.length; i++) {
        		list.add(scoville[i]);
        	}*/
        	
        	//System.out.println("list : " + list);
        	
        	//ArrayList ���� ���
        	//1. list.sort()
        	//	�������� : list.sort(Comparator.naturalOrder());
        	//	�������� : list.sort(Comparator.reverseOrder());
        	//2. Collections.sort()
        	//	�������� : Collections.sort(list);
        	//  �������� : Collections.sort(list, Collections.reverseOrder());
        	
        	// ���� ��� int[] scoville = {1, 1, 1, 1, 2, 2}; �̸�
        	// �տ��� �ΰ��� ��� ���� �������� �����ϸ�
        	// 1, 1, 2, 2, 3
        	// 2, 2, 3, 3
        	// 3, 3, 6
        	// 6, 9 �� �ż� �ᱹ -1�� ��ȯ�ؾ� �Ѵ�.
        	
        	// �ٵ� �տ��� �ΰ��� �ƴ϶�(���� ���� ���� - �������� ����)
        	// 5, 1, 1, 1, 2 - 1, 1, 1, 2, 5	-> 1, 2�� ����
        	// 7, 1, 1, 2 - 1, 1, 2, 7			-> 1, 5�� ����
        	// 5, 1, 7 - 1, 5, 7				-> 1, 2�� ����
        	// 11, 7 - 7, 11					-> 1, 5�� ����
        	
        	// �� ��°�� ���� ���� ���Ŀ� ���ϱ� 2�� �ϱ� ������ �ּ������� Ƚ���� ���Ϸ���
        	// �ִ��� ū ���� 2�� ���ϰ� ���� ���� ���� ��ġ�°� �̻������� ������
        	// ���� �߿� 7 �̸��� �� �� ���� ū ���� ���� ���� ���� ���ĺ���
        	
        	PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        	for(Integer rate : scoville) {
        		heap.add(rate);
        		System.out.println("rate : " + rate);
        	}
        	System.out.println("���� heap : " + heap);
        	/*
        	System.out.println("heap : " + heap);
        	System.out.println("peek : " + heap.peek());
        	System.out.println("poll : " + heap.poll());
        	System.out.println("poll : " + heap.poll());
        	System.out.println("poll : " + heap.poll());
        	System.out.println("poll : " + heap.poll());
        	System.out.println("heap : " + heap);
        	*/

        	//ArrayList�� ���Ϸ��� �غ��ϱ� ȿ������ ������ ����
        	//PriorityQueue�� ����ؼ� Ǯ��� ��
        	
        	//�켱 PriorityQueue��ü�� �迭�� �� ���� �־��ָ� �ּҰ����� �ڵ����� ������ ��
        	//heap�̶�� ������ �����ߴٰ� �����ϸ�
        	//heap.poll()�޼ҵ�� �ּҰ����� ���ʴ�� �ϳ��� ������ �޼ҵ�. �� ���� heap���� remove��
        	//heap.peek()�޼ҵ�� ��Ʈ��(�ּҰ�)�� �������� �޼ҵ�. �� ���� �ܼ� ��ȸ�� �ؿ��� ��. remove�ȵ�
        	
        	//�������� ���� ���� ���� ���İ� �� ��°�� ���� ���� ������ ����ؾ� �ϱ� ������
        	//heap���� poll() �޼ҵ带 ����� ���ʴ�� �� �� ���� ������ ����� �ڿ� �ٽ� �־��ִ� ������ �ݺ��ϸ� �ȴ�.
        	
        	//���ں� ������ K�̻����� ������� �ּ� �� ���� ������ ���ƾ� �ϹǷ� heap.size()�� 1�� �Ǵ� ������ �������� �����Ѵ�.
        	
        	// �ڡڡڡڡ������� ��
        	// heap.peek()�� K�̻��� �Ǵ� ���� = ��� ������ ���ں� ������ K�̻��� �Ǵ� ���� �̱� ������
        	// else������ break�� �־ �ݺ����� ������������ �Ѵ�.
        	
        	// -->	break�� �� �־ ���� ����� �Ǳ�� �Ѵ�. (while���� ����� �Ǵµ� ���� �ٸ� �����̴�. ��Ȯ�� ������ �𸣰ڴ�. )
        	// 		�ٵ� ��Ŭ�������� �ɰ��� ���� �ɸ���
        	// 		���α׷��ӽ����� �ܼ� �ڵ� ������ ������ �ð� �ʰ��� �ߴ°� ���� ��𼱰� �ð��� ��ƸԴ´ٴ� �ǵ�
        	// 		�Ƹ��� heap.size()�� 2��� ġ�� whle���� ���� heap.peek()�� K�̻��̸� �۾��� ���� ���ϱ� ������
        	// 		�ٽ� while���� �������� ���ư��� ��? ������ ���ǹ�(else��)�� �Ἥ �� �ݺ����� ���������� �ؾ� �ϴ� �� ����!!!
        	
        	int count = 0;
        	int min1 = 0;
        	int min2 = 0;
        	int scovilleRate = 0;
        	while(heap.size() > 1) { //!heap.isEmpty()�� �� ���� ����. �� size�� 1�� ���� ����ؼ� �ڵ带 �߰��ؾ���
        		if(heap.peek() < K) {
        			min1 = heap.poll();
        			min2 = heap.poll();
    				scovilleRate = calRate(min1, min2);
            		heap.add(scovilleRate);
            		count++;
            		System.out.println("heap : " + heap);
        		}else {
        			break;
        		}
        	}
        	System.out.println("count : " + count);
        	if(heap.peek() < K) {
        		answer = -1;
        	}else {
        		answer = count;
        	}
        }
        
        return answer;
    }
    
    //���ں� ���� ����ϴ� �޼ҵ�
    public int calRate(int min1, int min2) {
    	
    	int calResult = min1 + (min2 * 2);
    	
    	return calResult;
    }
    
}
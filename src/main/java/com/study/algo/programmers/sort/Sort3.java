package com.study.algo.programmers.sort;

import java.util.Arrays;

public class Sort3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SolutionSort3 sol = new SolutionSort3();
		int[] citations = {3, 0, 6, 1, 5};
		//int[] citations = {10, 3, 4, 8, 5};
		//int[] citations = {25, 8, 5, 3, 3};
		//int[] citations = {2, 1, 6, 9, 7};
		sol.solution(citations);
		
		Solution33 sol2 = new Solution33();
		sol2.solution(citations);
	}

}

class SolutionSort3 {
    public int solution(int[] citations) {
        
    	//�ڵ� �׽�Ʈ ���� > ���� > H-Index
    	int answer = 0;
        
        //[H-Index�� �����ڰ� ��ǥ�� �� n�� ��, h�� �̻� �ο�� ���� h�� �̻�], ������ ���� h�� ���� �ο�Ǿ��� ��
    	//h�� �ִ�
    	//[3, 0, 6, 1, 5] �� �� �迭�� length�� ��ǥ�� ���� ����
    	//�������� �迭���� �� [6, 5, 3, 1, 0]�̰� ���⼭ H-Index�� ã�ƺ���
    	//6, 5, 3�� ���캸�� 3�� �̻� �ο�� ���� 3���� ���� �� �� ����. ���� h�� 3�̹Ƿ�  H-Index�� 3
    	int check = 0;
    	if(citations.length >= 1 && citations.length <= 1000) {
    		for(int i=0; i<citations.length; i++) {
    			if(citations[i] >= 0 && citations[i] <= 10000) {
    				check = 1;
    			}else {
    				check = 0;
    				break;
    			}
    		}
    	}
    	
    	if(check == 1) {
    		System.out.println("üũ Ȯ��");
    		quickSort(citations, 0, citations.length-1);

    		for(int i=0; i<citations.length; i++) {
    			System.out.print(citations[i] + " ");
    		}
    		System.out.println();
    		
    		/*
    		int index = 0;
    		System.out.println(index >= citations.length);
    		while(index < citations.length) {
    			System.out.println("Ȯ��");
    			int count = 0;
    			for(int i=0; i<citations.length; i++) {
    				if(citations[i] >= citations[index]) {
    					System.out.println("count : " + count);
    					count++;
    				}
    			}
    			
    			if(count == citations[index]) {
    				break;
    			}else {
    				index++;
    			}
    		}
    		answer = citations[index];
    		*/
    		
    		//�����غ��� ���������� �߱� ������ ������ ���� �ʿ䰡 ����
    		//�������� �߱� ������ � i�� �ε��� ���� ���� �ε��� ������ ������ �ο��Ѱ���
    		//���� h�� �̻� �ο�� ���� h�� �̻�, �׸��� ������ ���� h�� ���� �ο��̶�� ����
    		//��, �̻�� ������ ��踦 ã���� �ȴٴ� ���̴�.
    		//�׷��� hIndex�� �ο�� ���� ī��Ʈ�ϰ�, citations[i]�� hIndex���� �۾����� ������ ã�Ƽ� ����ϸ� ��
    		int hIndex = 0;
    		for(int i=0; i<citations.length; i++) {
    			hIndex++;
    			System.out.println("citations[i] : " + citations[i]);
    			System.out.println("hIndex : " + hIndex);
    			if(citations[i] < hIndex) {
    				hIndex--;
    				break;
    			}
    		}
    		answer = hIndex;
    		System.out.println("answer : " + answer);
    	}
    	
        return answer;
    }
    
    public void quickSort(int[] data, int start, int end) {
    	
    	if(start >= end) {
    		return;
    	}
    	
    	int pivot = start;
    	int i = start + 1;
    	int j = end;
    	int temp;
    	
    	while(i <= j) {
    		while(i <= end && data[i] >= data[pivot]) {
    			i++;
    		}
    		
    		while(data[j] <= data[pivot] && j > start) {
    			j--;
    		}
    		
    		if(i > j) {
    			temp = data[j];
    			data[j] = data[pivot];
    			data[pivot] = temp;
    		}else {
    			temp = data[j];
    			data[j] = data[i];
    			data[i] = temp;
    		}
    	}
    	
    	quickSort(data, start, j-1);
    	quickSort(data, j+1, end);
    	
    }
	/* �ٸ� ����� Ǯ��
	  //sort ����ؼ� �������� �����ϰ�
	  //index �������� for�� ������ �����
	  //Math.min(a,b)�� a,b�߿� �� ���� ���� ��ȯ
	  //���� citations[i]�� citations.length - i �߿�  �� ���� ���� ��ȯ
	  
	  //[0,1,3,5,6]���� �������� ���ĵǾ��� ��
	  //6,(5-4) -> 5,(5-3) -> 3,(5-2) -> 1,(5-1) -> 0,(5-0) �̴ϱ�
	  //�ּҰ��� 1, 2, 3, 1, 0 �� ����
	  //�׷� ������� max < min�̸� max�� min���� �����ϹǷ�
	  //0 < 1 �̹Ƿ� max = 1
	  //1 < 2 �̹Ƿ� max = 2
	  //2 < 3 �̹Ƿ� max = 3
	  //3 < 2 �� false �̹Ƿ� ���⼭ ���̻� max���� ������ ����. ���� max�� 3
	  //������ ���� �� �Ŷ� ����ѵ� �� �� �����ϰ� ǥ���� �� �ϴ�.
	  
	  Arrays.sort(citations);
	
	  int max = 0;
	  for(int i = citations.length-1; i > -1; i--){
	      int min = (int)Math.min(citations[i], citations.length - i);
	      if(max < min) max = min;
	  }
	
	  return max;
	*/
}

class Solution33 {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            int min = (int)Math.min(citations[i], citations.length - i);
            System.out.println("��ȭ Ȯ�� : " + (int)Math.min(citations[i], citations.length - i));
            if(max < min) max = min;
        }
        
        System.out.println("max : " + max);
        return max;
    }
}

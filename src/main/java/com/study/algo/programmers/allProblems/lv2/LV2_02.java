package com.study.algo.programmers.allProblems.lv2;

import java.util.ArrayList;
import java.util.List;

public class LV2_02 {

	public static void main(String[] args) {
		SolutionLV2_02 sol = new SolutionLV2_02();
		int[][] arr1 = {{2, 3, 2},{4, 2, 4},{3, 1, 4}};
		int[][] arr2 = {{5, 4},{2, 4},{3, 1}};
		int[][] answer = sol.solution(arr1, arr2);
		for(int i=0; i<answer.length; i++) {
			for(int j=0; j<answer[i].length; j++) {
				System.out.printf("%d ", answer[i][j]);
			}
			System.out.println();
		}System.out.println();
		

	}

}

class SolutionLV2_02 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        //�������� > ����� ����
    	int[][] answer = {};
        
        //[2, 3, 2]   [5, 4, 3] 
    	//[4, 2, 4] x [2, 4, 1]
    	//[3, 1, 4]   [3, 1, 1]
        
    	/* =========================================================================================================
    	//[22, 22, 11] �� (2*5 + 3*2 + 2*3), (2*4 + 3*4 + 2*1), (2*3 + 3*1 + 2*1)
    	//����� ���� arr1�� ��� arr2�� ���� ���ϴ� ���̹Ƿ�
    	//2,3,2 �� �ε��� 0~2�� �ش��ϴ� �� 5,2,3/4,4,1/3,1,1 �� ���ϸ� �ȴ�.
    	//�� arr1�� ���ϴ� �� ���� ����(���� ����)�� arr2�� ���ϴ� �� ���� ������ ������ ������ �����ϴ�.    	
    	
    	//���� 2�� �����ϸ�
    	//ù ��° �ݺ����� arr1[0][0~2] �� arr2[0~2][0]�� ���ϰ� �Ǵ� ��
    	
    	//���� 1�� �����غ���
    	//arr1[0][0]*arr2[0][0] + arr1[0][1]*arr2[1][0], arr1[0][0]*arr2[0][1] + arr1[0][1]*arr2[1][1] -> 15, 15
    	//arr1[1][0]*arr2[0][0] + arr1[1][1]*arr2[1][0], arr1[1][0]*arr2[0][1] + arr1[1][1]*arr2[1][1] -> 15, 15
    	//arr1[2][0]*arr2[0][0] + arr1[2][1]*arr2[1][0], arr1[2][0]*arr2[0][1] + arr1[2][1]*arr2[1][1] -> 15, 15
    	
    	//[1, 4]   3 | 3
    	//[3, 2] x 3 | 3
    	//[4, 1]   
    	
    	//arr1[i][j]�� �״��, arr2[j][x]�� j�� ������� ����ϸ� ��
    	//��, x�� ���� 1�� ���� 0 �� ��, 1 �� �� �׸��� �ٽ� 0 �� ��, 1 �� ��.. �� ���� �����̱� ������
    	//arr2�� length�� count�� ��� index�� �ʱ�ȭ���ִ� ������� �ϸ� ���� �� ����
    	========================================================================================================= */
    	
    	//### ���⼭���� Ǯ��!!! ���� ��� ����
    	//arr2�� �����ϸ� ���� ������?
    	//[2, 3, 2]   	[5, 4]      [5, 2, 3]
    	//[4, 2, 4] x 	[2, 4] ---> [4, 4, 1] �� �ٲٴ� ���� --> ����� [22,22],[36,28],[29,20]
    	//[3, 1, 4]   	[3, 1]
    	
    	//1. arr3�� ������ ����� ���� �迭 ũ��� ����
    	int[][] arr3 = new int[arr2[0].length][arr2.length];

    	//2. arr2�� �����ؼ� arr3�� ����
    	for(int i=0; i<arr2[0].length; i++) {
    		for(int j=0; j<arr2.length; j++) {
    			arr3[i][j] = arr2[j][i];
    		}
    	}
    	
    	for(int i=0; i<arr3.length; i++) {
    		for(int j=0; j<arr3[i].length; j++) {
    			System.out.printf("%d ", arr3[i][j]);
    		}
    		System.out.println();
    	}System.out.println("==================");
    	
    	//3. 3�� for���� ����� ����� �� ����� List�� �����
    	List<Integer> list = new ArrayList<Integer>();
    	for(int i=0; i<arr1.length; i++) {			//i = 0, 1, 2
    		for(int j=0; j<arr3.length; j++) {	//j = 0, 1
    			int result = 0;
    			for(int k=0; k<arr1[0].length; k++) {
    				System.out.println(arr1[i][k]*arr3[j][k]);
    				result += arr1[i][k]*arr3[j][k];
    			}
    			list.add(result);
    			System.out.println("result : " + result);
    		}
    	}
    	System.out.println("list : " + list);
    	
    	//4. answer�� list���� ���ʴ�� ����
    	int index = 0;
    	answer = new int[arr1.length][arr2[0].length];
    	for(int i=0; i<answer.length; i++) {
    		for(int j=0; j<answer[i].length; j++) {
    			answer[i][j] = list.get(index++);
    		}
    	}
    	
    	
        return answer;
    }
}
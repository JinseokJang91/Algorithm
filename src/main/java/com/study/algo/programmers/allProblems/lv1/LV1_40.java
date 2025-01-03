package com.study.algo.programmers.allProblems.lv1;

import java.util.ArrayList;
import java.util.List;

public class LV1_40 {

	public static void main(String[] args) {
		SolutionLV1_40 sol = new SolutionLV1_40();
		String s = "a B z Y";
		int n = 4;
		String answer = sol.solution(s, n);
		System.out.println("answer : " + answer);
	}

}

class SolutionLV1_40 {
    public String solution(String s, int n) {
    	
    	//�������� > ���� ��ȣ
        String answer = "";
        
        //s�� n��ŭ �о�� ��ȣȭ ���
        //AB�� 1��ŭ �и� BC
        //z�� 1��ŭ �и� a
        //aBz�� 4��ŭ �и� eFd
        
        //A-Z : 65-90
        //a-z : 97-122
        char[] arr = s.toCharArray();
        
        /*
        for(int i=0; i<arr.length; i++) {
        	//n��ŭ �о ��
        	int x = (int)arr[i] + n;
        	//�� ���ĺ��� A-Z�� ���
        	if(arr[i] >= 'A' && arr[i] <= 'Z') {
        		if(x > 90) {
        			arr[i] = (char)(x - 90 + 65 - 1);
        		}else {
        			arr[i] = (char) x;
        		}
        	}
        	//�� ���ĺ��� a-z�� ���
        	if(arr[i] >= 'a' && arr[i] <= 'z') {
        		if(x > 122) {
        			arr[i] = (char)(x - 122 + 97 - 1);
        		}else {
        			arr[i] = (char) x;
        		}
        	}
        }
        
        for(int i=0; i<arr.length; i++) {
        	answer += arr[i];
        }
        */
        
        List<Character> list = new ArrayList<Character>();
        for(int i=0; i<arr.length; i++) {
        	int x = (int)arr[i] + n;
        	//�� ���ĺ��� A-Z�� ���
        	if(arr[i] >= 'A' && arr[i] <= 'Z') {
        		if(x > 90) {
        			list.add((char)(x - 90 + 65 - 1));
        		}else {
        			list.add((char) x);
        		}
        	}
        	//�� ���ĺ��� a-z�� ���
        	if(arr[i] >= 'a' && arr[i] <= 'z') {
        		if(x > 122) {
        			list.add((char)(x - 122 + 97 - 1));
        		}else {
        			list.add((char) x);
        		}
        	}
        	//������ ���
        	if(arr[i] == ' ') {
        		list.add(' ');
        	}
        }
        
        for(int i=0; i<list.size(); i++) {
        	answer += list.get(i);
        }
        
        //�ּ�ó�� �س��� �迭 ����� ���� 9ms ����
        //List ���� 1.3ms����
        
        return answer;
    }
}
package com.study.algo.programmers.exhausitiveSearch;

import java.util.ArrayList;
import java.util.List;

public class Search2 {

	public static void main(String[] args) {
		
		SolutionSearch2 sol = new SolutionSearch2();
		String numbers = "123";
		int answer = sol.solution(numbers);
		System.out.println("answer : " + answer);

	}

}

class SolutionSearch2 {
	
	private List<Integer> list = new ArrayList<Integer>();

    public int solution(String numbers) {
        //���� Ž�� > �Ҽ� ã��
    	int answer = 0;
        
    	int check = 0;
    	if(numbers.length() >= 1 && numbers.length() <= 7) {
    		for(int i=0; i<numbers.length(); i++) {
    			if(numbers.charAt(i) >= '0' && numbers.charAt(i) <= '9') {
    				check = 1;
    			}else {
    				check = 0;
    				break;
    			}
    		}
    	}
    	
    	if(check == 1) {
    		/*
    		String[] numArr = numbers.split("");

    		int totalCases = 0;
        	for(int i=1; i<=numArr.length; i++) {
        		totalCases += pactorial(numArr.length, i);
        	}
        	System.out.println("�� ����� �� : " + totalCases);
        	*/
        	
        	findCase("", numbers);
        	
        	int count = 0;
        	for(int i=0; i<list.size(); i++) {
        		if(chkNum(list.get(i))) {
        			count++;
        		}
        	}
        	
        	//answer = list.size();
        	answer = count;

        	System.out.println("list : " + list);
        	
        	String a = "abc";
        	System.out.println("a : " + a);
        	a.substring(1, 2);
        	System.out.println("a : " + a);
    	}

        return answer;
    }
    
    public void findCase(String str, String numbers) {
    	
    	//�Ҽ� �Ǻ��� solution �޼ҵ忡�� �������ָ� �ӵ��� �� �� ������("011"�� �� 01���� �˻��ϰ� �ż�? ��Ȯ���� �𸣰ڴ�.)
    	System.out.println("�޼ҵ� ����!");
    	//System.out.println("str�� : " + str);
    	if(!str.equals("")) {
    		if(!list.contains(Integer.valueOf(str))) {
   				list.add(Integer.valueOf(str));
    		}
    	}
    	
    	for(int i=0; i<numbers.length(); i++) {
    		System.out.println("üũi : " + i);
    		System.out.println("üũstr : " + str);
    		System.out.println("üũ numbers.charAt(i) : " + numbers.charAt(i));
    		System.out.println("����Ʈ ���� - str + numbers.charAt(i) : " + str + numbers.charAt(i));
    		System.out.println("numbers.substring(0, i) : " + numbers.substring(0, i));
    		System.out.println("numbers.substring(i+1) : " + numbers.substring(i+1));
    		findCase(str + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i+1));
    		
    	}
    	//substring(a, b)�� ���ڿ��� a�ε������� b���� �ε������� �ڸ��°�
    	//substring(c)�� ���ڿ��� c�ε������� ���������� �������� ��
    	/*
    	�޼ҵ� ����!
			üũi : 0
			üũstr : 
			üũ numbers.charAt(i) : 1
			����Ʈ ���� - str + numbers.charAt(i) : 1
			numbers.substring(0, i) : 
			numbers.substring(i+1) : 23
			
		�޼ҵ� ����!
			üũi : 0
			üũstr : 1
			üũ numbers.charAt(i) : 2 -> ���⼭ numbers.charAt(i)�� 2�� �Ǵ� ������ 
										 �տ��� numbers.substring(0, i) + numbers.substring(i+1)�� ���� numbers���� �ٲ���� ����
										 findCase(str, numbers)���� str���� "1"�� ����, numbers�� "23"�� ���� 
										 �ٽ� �޼ҵ带 �����ϴ� ���̱� ������ numbers.charAt(i), �� numbers.charAt(0) ���� 2�� �Ǵ� ���̴�.
			����Ʈ ���� - str + numbers.charAt(i) : 12 -> 
			numbers.substring(0, i) : 
			numbers.substring(i+1) : 3
    	 * */
    }
    
    public boolean chkNum(int num) {
    	
    	//�Ҽ� ���ϴ� ����� �����佺�׳׽��� ü ��� ���� �ִ�.
    	
    	//int num = Integer.parseInt(str);
    	int count = 0;
    	for(int i=1; i<=num; i++) {
    		if(num%i == 0) {
    			count++;
    		}
    	}
    	
    	if(count == 2) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    //1,7 �̸� 1, 7, 17, 71
	//1,2,3 �̸� 1, 2, 3, 12, 13, 21, 23, 31, 32, 123, 132, 213, 231, 312, 321
	//3P1 + 3P2 + 3P3 => 3!/(3-1)! + 3!/(3-2)! + 3!/(3-3)! => 6/2 + 6/1 + 6/1 => 3 + 6 + 6 = 15
    
    //�Լ��� 1�� �ѱ�� 1, 12, 13, 123, 132
    /*
    public void findCases(int i, String index, String str, String[] numArr) {
    	
    	System.out.println("�޼ҵ� ��� ����? : " + ++count);
    	System.out.println("�޼ҵ� ������ �� index : " + index);
    	//12�� ������ �ٽ� �޼ҵ� �����ϸ� 1,2�� �ɷ�����
    	//12�� �����ϸ� findCases(0~2, "12", numArr)
    	if(i >= arrLen) {
    		System.out.println("i�� : " + i);
    		return;
    	}
    	String a = "";
    	//index = "" + i;
    	for(int j=0; j<arrLen; j++) {
    		System.out.println("j�� : " + j);
    		//if(i != j) {
    		if(i != j && !index.contains(String.valueOf(j))) {
    			a = str + numArr[j];
    			index += j;
    			System.out.println("a : " + a);
    			System.out.println("index : " + index);
    			if(chkNum(a)) {
        			if(!list.contains(a)) {
        				list.add(a);
        			}
        		}//System.out.println("j��" + j + "�� �� : "+index.contains(String.valueOf(j)));
    			
    		}
    		//findCases(i+1, a, numArr);
    		
    	}
    	if(index.length() == arrLen) {
    		System.out.println("�޼ҵ� �ٽ� ȣ��!!!");
    		System.out.println(index.substring(0, index.length()-1));
    		index = index.substring(0, index.length()-1);
    		findCases(i, index, a, numArr);
    	}
    	
    	//
    	//ó���� str�� i=0�� ���ϱ� numArr[0]�� 1
    	//i=0, j=0 - x
    	//j = 1�� �� 1 + 2 = 12
    		//j=0 a=12 -> 123�� ��µǾ���� �̶� index���� 01, j=2�� ��ħ �׷� a�� 12 + 3 = 123�� ��
    			//
    	//j = 2�� �� 1 + 3 = 13
 
    }
    */
    
    //���丮���ϱ�
    public int pactorial(int n, int m) {
    	
    	int result = 1;
    	int x = 1; int y = 1;
    	
    	for(int i=n; i>0; i--) {
    		x *= i;
    	}
    	
    	for(int j=n-m; j>0; j--) {
    		if(j != 0)
    		y *= j;
    	}
    	result = x/y;
    	
    	System.out.println("result : " + result);
    	
    	return result;
    }
}
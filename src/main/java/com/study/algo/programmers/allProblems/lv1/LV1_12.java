package com.study.algo.programmers.allProblems.lv1;

public class LV1_12 {

	public static void main(String[] args) {
		SolutionLV1_12 sol = new SolutionLV1_12();
		
		//String new_id = "...!@BaT#*..y.abcdefgh.jklm.asdasd";
		String new_id = "abcdefghijklmn.p";
		
		String answer = sol.solution(new_id);
		System.out.println("answer : " + answer);
		
	}

}

class SolutionLV1_12 {
    public String solution(String new_id) {
    	
    	//2021 KAKAO BLIND RECRUITMENT > �ű� ���̵� ��õ
        String answer = "";
        
        //���̵� ���� : 3�� �̻� 15�� ����
        
        // ���ο� ���̵� ��õ���ִ� �ܰ�
        // 1. ��� �빮�ڸ� �����Ǵ� �ҹ��ڷ� ġȯ
        // 2. ���ĺ� �ҹ���, ����, ����(-), ����(_), ��ħǥ(.)�� ������ ��� ���� ����
        // 3. ��ħǥ(.)�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ(.)�� ġȯ
        // 4. ��ħǥ(.)�� ó���̳� ���� ��ġ �Ѵٸ� ����
        // 5. �� ���ڿ��̶�� a�� ����
        // 6. ���̰� 16�� �̻��̸� ù 15�� ���ڸ� ������ ������ ���ڵ� ��� ����, ���� �� ��ħǥ(.)�� ���� ��ġ�Ѵٸ� ���� ��ġ�� ��ħǥ ����
        // 7. ���̰� 2�� ���϶��, ������ ���ڸ� ���̰� 3�� �� ������ �ݺ�
        String id = "";
        id = firstStep(new_id);
        id = secondStep(id);
        id = thirdStep(id);
        id = fourthStep(id);
        id = fifthStep(id);
        id = sixthStep(id);
        id = seventhStep(id);
        answer = id;
        
        return answer;
    }
    
    public String firstStep(String id) {
    	id = id.toLowerCase();
    	System.out.println("1�ܰ� : " + id);
    	return id;
    }
    
    public String secondStep(String id) {
    	//���ĺ� �ҹ��� : 97 ~ 122
    	String temp = "";
    	for(int i=0; i<id.length(); i++) {
    		char ch = id.charAt(i);
    		if((ch >= 97 && ch <= 122) || (ch >= '0' && ch <= '9')
    			|| (ch == '-') || (ch == '_') || (ch == '.')) {
    			temp += ch;
    		}
    	}
    	System.out.println("2�ܰ� : " + temp);
    	return temp;
    }
    
    public String thirdStep(String id) {

    	while(true) {
    		if(id.contains("..")) {
    			//System.out.println(".. �����ϰ�����");
    			id = id.replace("..", ".");
    			//System.out.println("id : " + id);
    		}else {
    			//System.out.println(".. ���� �� ��");
    			break;
    		}
    	}
    	System.out.println("3�ܰ� : " + id);
    	
    	return id;
    }
    
    public String fourthStep(String id) {
    	
    	//substring(���� �ε���, �� �ε���) : ���� �ε������� �� �ε��� �������� �ڸ�
    	//indexOf(".") : ��ħǥ(.)�� ó�� ��Ÿ���� �ε��� ��ȯ
    	if(id.startsWith(".")) {
    		id = id.substring(id.indexOf(".")+1);
    	}
    	
    	if(id.endsWith(".")) {
    		id = id.substring(0, id.length()-1);
    		//System.out.println("id : " + id);
    	}
    	System.out.println("4�ܰ� : " + id);
    	
    	return id;
    }
    
    public String fifthStep(String id) {
    	
    	if(id.isEmpty()) {
    		id = "a";
    	}
    	System.out.println("5�ܰ� : " + id);
    	return id;
    }
    
    public String sixthStep(String id) {
    	//15�� ���ڸ� ������� 0~14 �ε����� ����� ��
    	if(id.length() >= 16) {
    		//System.out.println("Ȯ��");
    		id = id.substring(0, 15);
    		//System.out.println("id1 : " + id);
    		if(id.endsWith(".")) {
    			id = id.substring(0, id.length()-1);
    			//System.out.println("id2 : " + id);
    		}
    	}
    	System.out.println("6�ܰ� : " + id);
    	
    	return id;
    }
    
    public String seventhStep(String id) {
    	while(id.length() <= 2) {
    		id += id.charAt(id.length()-1);
    		//System.out.println("id : " + id);
    		
    		if(id.length() > 2) {
    			//System.out.println("3�̻� �ϼ�");
    			break;
    		}
    	}
    	System.out.println("7�ܰ� : " + id);
    	return id;
    }
}
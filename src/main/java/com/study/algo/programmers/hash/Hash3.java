package com.study.algo.programmers.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Hash3 {

	public static void main(String[] args) {
		
		//String[][] clothes = {{"yellow_hat","headgear"},{"blue_sunglasses","eyewear"},{"green_turban","headgear"}};
		//String[][] clothes = {{"crow_mask","face"},{"blue_sunglasses","face"},{"smoky_makeup","face"}};
		String[][] clothes = {{"a","face"},{"aa","face"},{"b","upper"}, {"c","bottom"}};
		
		//��������
		//1. �ǻ��� �� = clothes.length�� 1�̻� 30 ����
		//2. ���� �̸��� ���� �ǻ��� �������� ����
		//3. clothes�� ��� ���Ҵ� ���ڿ��� �̷����
		//4. ��� ���ڿ��� ���̴� 1 �̻� 20 ������ �ڿ���, ���ĺ� �ҹ��� �Ǵ� '_'
		//5. �Ϸ翡 �ּ� �� ���� �ǻ��� ����

		SolutionHash3 sol = new SolutionHash3();
		
		int answer = sol.solution(clothes);

	}

}

class SolutionHash3 {
    public int solution(String[][] clothes) {
        
    	//�ؽ� > ����
    	int answer = 0;
        
    	int check = 0;
    	if(clothes.length >= 1 && clothes.length <= 30) {
    		for(int i=0; i<clothes.length; i++) {
    			if((clothes[i][0].length() >= 1 && clothes[i][0].length() <= 20)
    				&&(clothes[i][1].length() >= 1 && clothes[i][1].length() <= 20)) {
    				for(int j=0; j<clothes[i][0].length(); j++) {
    					if((clothes[i][0].charAt(j) < 97 || clothes[i][0].charAt(j) > 122) && (clothes[i][0].charAt(j) != '_')) {
    						System.out.println("üũ Ȯ��1");
    						check = 1;
    					}
    				}
    				for(int j=0; j<clothes[i][1].length(); j++) {
    					if((clothes[i][1].charAt(j) < 97 || clothes[i][1].charAt(j) > 122) && (clothes[i][1].charAt(j) != '_')) {
    						System.out.println("üũ Ȯ��2");
    						check = 1;
    					}
    				}
    			}
    		}
    	}
    	System.out.println("check : " + check);
    	if(check == 0) {
    		// clothes�� �ǻ��� �̸�, �ǻ��� ������ �̷���� �����Ƿ� HashMap�� ����Ѵٸ�
        	// key���� �ǻ��� ����, value���� �ǻ��� �̸��� �־ �ذ��ϴ� ���� ���ƺ���
        	// �⺻������ clothes�� ���̸�ŭ ����� ���� ��� ������
        	// clothes = {{"yellow_hat","headgear"},{"blue_sunglasses","eyewear"},{"green_turban","headgear"}} �� ��� 5����
        	// �⺻������ 3������ ����� ���� ��� ����
        	// �׷��⶧���� �߰����� ����� ���� ������ 1���� ŭ
        	// clothes = {{"crow_mask","face"},{"blue_sunglasses","face"},{"smoky_makeup","face"}} �� ��� 3����
        	// ��� ������ ���� ������ �⺻���� ����� ���� 3������ ���ƾ� ��
        	// �׷����� �⺻ ����� ���� ���� ����, HashMap�� ���ʴ�� put�� �� Map�� size�� +1 �� ���� üũ�ϸ� ��
        	
        	// �����ϸ�,
        	// 1. clothes�� ���� = �⺻ ����� ���� ���Ѵ�.
        	// 2. �߰����� ����� ���� map�� ũ�Ⱑ ������ 1���� Ŭ ���̴�.
        	// 3. HashMap�� ������� put�ϸ� (1) map�� ũ�Ⱑ +1 �ǰų� (2) value���� �ٲ�� ����� ���� +1 �Ѵ�.
    		// 4. �����ϸ�
    				//(1) map�� ũ�Ⱑ +1 �ȴ� -> containsKey(key)�� false�̴�. -> ����� �� ����
    				//(2) value���� �ٲ�� -> containsKey(key)�� true�̰� containsValue(value)�� false��. -> ����� �� ����
    		
    		// �ݷ�,
    		// clothes = {{"a","face"},{"aa","face"},{"b","upper"}, {"c","bottom"}} �� ���
    		// �� 11������ ����� ���� ���´�.
    		// ���� ���ÿ� ���ؼ� �����غ��� (x -> ���Դ� ���)
    		// (1) clothes = {{"yellow_hat","headgear"},{"blue_sunglasses","eyewear"},{"green_turban","headgear"}}
    		// headgear -> x , yellow_hat , green_turban 3���� ����� ��
    		// eyewear -> x , blue_sunglasses 2���� ����� ��
    		// (2) clothes = {{"crow_mask","face"},{"blue_sunglasses","face"},{"smoky_makeup","face"}}
    		// face -> x, crow_mask, blue_sunglasses, smoky_makeup -> 4���� ����� ��
    		// (3) clothes = {{"a","face"},{"aa","face"},{"b","upper"}, {"c","bottom"}}
    		// face -> x, a, aa
    		// upper -> x, b
    		// bottom -> x, c
    		
    		// �����غ��� �������� �ּ� �� ���� �ǻ��� �Դ´ٰ� ������ ������ ���� �� ����� ���� ���� �Ϳ��� -1�� ���� ���̴�.
    		// (1) (3 * 2) - 1 = 5
    		// (2) 4 - 1 = 3
    		// (3) (3 * 2 * 2) - 1 = 11
    		
    		// �̰��� HashMap���� �� key���� ����� ���� ����ؼ� ���ϸ� �� ���ϴ�.
    		// �����ϸ�, HashMap�� �� ���� �����ؼ� �ϳ��� ����� ��(int)�� ����ش�.
    		// 1. HashMap�� put�� �� �� containsKey�� �̿��ؼ� ���ο� ������ �ٸ� HashMap�� �⺻ ����� �� 2���� �߰�(�Դ�, ���Դ�)
    		// 2. containsValue�� �̿��ؼ� ���ο� �̸��̸� �ش� key���� �̿��ؼ� value���� +1�� ���ش�.
            // 3. HashMap value������ ��� �����ְ� �������� -1�� ���ش�.
    		
    		HashMap<String, String> map = new HashMap<String, String>();
    		HashMap<String, Integer> resultMap = new HashMap<String, Integer>();
    		for(int i=0; i<clothes.length; i++) {
    			// key�� �������� �ʴ� ��� - ���ο� ����
    			if((!map.containsKey(clothes[i][1]))) {
    				map.put(clothes[i][1], clothes[i][0]);
    				resultMap.put(clothes[i][1], 2); // ���ο� key�� �߰��� �� �⺻������ ���Դ� ���, �Դ� ��� �� ���� ����� ���� ����
    				
    			}
    			// key�� �����ϰ� value���� �ٸ� ��� - ���ο� �̸�
    			if(map.containsKey(clothes[i][1]) && !map.containsValue(clothes[i][0])) {
    				map.put(clothes[i][1], clothes[i][0]);
    				resultMap.put(clothes[i][1], resultMap.get(clothes[i][1]) + 1);
    			}
    		}
    		
    		//HashMap ��� ���(key, value�� ���ϱ�)
    		//1. Entry ��ü ���
    		int result = 1; // �� ����� ��
    		for(Entry<String, Integer> entry : resultMap.entrySet()) {
    			result *= entry.getValue();
    		}
    		
    		//2. Iterator ��ü ���
    		int result2 = 1;
    		//int result3 = 1;
    		Iterator<Entry<String, Integer>> iter = resultMap.entrySet().iterator();
    		while(iter.hasNext()) {
    			result2 *= iter.next().getValue();
    			//�Ǵ� �Ʒ��� ���� ���
    			//Map.Entry<String, Integer> ent = iter.next();
    			//result3 *= ent.getValue();
    		}
    		
    		System.out.println("map : " + map);
    		System.out.println("resultMap : " + resultMap);
    		System.out.println("result : " + result);
    		System.out.println("result2 : " + result2);
    		//System.out.println("result3 : " + result3);
    		
    		answer = result - 1; // �ƹ��͵� ���Դ� ��� �� ������ ���ܽ��Ѿ� ��
    		System.out.println("���� : " + answer);
    	}
    	
        
    	
        
        return answer;
    }
}
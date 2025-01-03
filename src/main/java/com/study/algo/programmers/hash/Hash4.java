package com.study.algo.programmers.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class Hash4 {

	public static void main(String[] args) {
		SolutionHash4 sol = new SolutionHash4();
		String[] genres = {"classic", "pop", "classic", "classic", "classic", "classic", "pop"};
		int[] plays = {500, 800, 800, 600, 150, 800, 2500};
		int[] answer = sol.solution(genres, plays);
		

	}

}

class SolutionHash4 {
    public int[] solution(String[] genres, int[] plays) {
        
    	// �ؽ� > ����Ʈ�ٹ�
    	int[] answer = {};
        
    	// �帣 ���� ���� ���� ����� �뷡�� �� � ��� ����Ʈ �ٹ��� �߽��Ѵ�.
    	// �帣 ���� �� � ������ ���� �帣�� ���� ���� �ϳ����̸� �ϳ��� ����
    	
        // answer �迭�� �뷡�� �����ϴ� ����
    	// 1. ���� �뷡�� ���� ����� �帣�� ���� ���� -> ���� �帣(genres)�� ��� Ƚ��(plays)�� ��ģ ���� ���� ���� ��
        // 2. �帣 ������ ���� ����� �뷡�� ���� ���� -> ���� ��� classic�� 2�� �ְ�, play Ƚ���� ���� 500, 1000 �̸� 1000���� ����
    	// 3. �帣 ������ ��� Ƚ���� ���� �뷡 �߿����� ���� ��ȣ�� ���� �뷡�� ���� ���� -> ���� ��� classic�� 2��, playȽ���� ���� 300, 300�̸�, genres���� �ε����� �� ���� �ͺ��� ����
    	
    	int check = 0;
    	if((genres.length >= 1 && genres.length <= 10000) 
    		&& (plays.length >= 1 && plays.length <= 10000)
    		&& (genres.length == plays.length)) {
    		check = 1;
    	}
    	
    	if(check == 1) {
    		//�ؽøʿ� �� �帣���� ����� Ƚ���� ���ؼ� key-value�� ������ � �帣�� ���� ���� ����Ǿ����� �� �� ����
    		//�� �帣���� ���Ƚ���� ���� ������� �ε����� �� ���� �˾ƾ� ��(���Ƚ���� ���� ��쿡�� �ε����� ���ؾ� ��)
    		//�ؽø� value���� ��� Ƚ���� ���� ������� �ε����� �ְų� �ƴϸ� ��� Ƚ�� ��ü�� �־�� �ϴµ� �ε����� �ִ°� �� �� ���ƺ���
    		
    		// 1. �켱 totalMap�� �� �帣 ���� ��� Ƚ���� ��� ���� ���� �ִ´�.
    		HashMap<String, Integer> totalMap = new HashMap<String, Integer>();
    		for(int i=0; i<genres.length; i++) {
    			if(!totalMap.containsKey(genres[i])) {
    				totalMap.put(genres[i], plays[i]);
    			}else {
    				totalMap.put(genres[i], totalMap.get(genres[i]) + plays[i]);
    			}
    		}
    		System.out.println("totalMap : " + totalMap);
    		
    		// 2. indexMap���� �� �帣 �� �ε��� ���� �޸�(,)�� ����� �����ؼ� �ִ´�.
    		HashMap<String, String> indexMap = new HashMap<String, String>();
    		for(int i=0; i<genres.length; i++) {
    			if(!indexMap.containsKey(genres[i])) {
    				indexMap.put(genres[i], ""+i);
    			}else {
    				//System.out.println("Integer.valueOf(indexMap.get(genres[i])) : " + Integer.valueOf(indexMap.get(genres[i])));
    				indexMap.put(genres[i], indexMap.get(genres[i])+ "," + i);
    			}
    		}
    		System.out.println("indexMap : " + indexMap);
    		
    		// 3. �޸��� ������ �ε��� ���� �̿��� plays���� ���Ƚ���� ���� ������� ���ϵ�, ���� ���� �ε����� �� ���� ���� ���Ѵ�.
    		Iterator<Entry<String, String>> iter = indexMap.entrySet().iterator();
    		while(iter.hasNext()) {
    			
    			String[] indexTemp = iter.next().getValue().split(",");
    			for(int i=0; i<indexTemp.length; i++) {
    				System.out.print(indexTemp[i] + " - ");
    				System.out.print(plays[Integer.valueOf(indexTemp[i])] + " ");
    			}
    			System.out.println();
    			List<Integer> list = new ArrayList<Integer>();
    			//System.out.println("Math.max : "  + Math.max(2, 2));
    			int maxPlay = 0;
    			int maxIndex = 0;
    			for(int i=0; i<indexTemp.length; i++) {
    				if(maxPlay < plays[Integer.valueOf(indexTemp[i])]) {
    					maxPlay = plays[Integer.valueOf(indexTemp[i])];
    					maxIndex = Integer.valueOf(indexTemp[i]);
    				}
    				
    				if(maxPlay == plays[Integer.valueOf(indexTemp[i])]) {
    					if(maxIndex > Integer.valueOf(indexTemp[i])) {
    						maxIndex = Integer.valueOf(indexTemp[i]);
    					}
    				}
    			}
    			System.out.println("maxPlay : " + maxPlay);
    			System.out.println("maxIndex : " + maxIndex);
    			
    			
    			/*
    			List<Integer> list = new ArrayList<Integer>();
    			String s = iter.next().getKey();
    			for(int i=0; i<genres.length; i++) {
    				if(s.equals(genres[i])) {
    					
    					list.add(plays[i]);
    				}
    			}
    			*/
    			
    			/*
    			Collections.sort(list, Comparator.reverseOrder());
    			System.out.println("list : " + list);
    			if(list.size() > 1) {
    				// �� ��° while������ list�� ���� [800, 800, 500, 400]���� ���ĵƴٰ� �ϰ� ���� �ε����� 1,4,3,2��� �����ϸ�
    				// 1,4�� �����ؾ���
    				// ���� [800, 800, 800, 800, 400]�̰� �ε����� 3,1,2,0,4��� �ϸ�
    				// 0,1�� �����ؾ���
    				// ���� [800, 500, 500, 500, 400]�̰� �ε����� 1,3,2,0,5��� �ϸ�
    				// 0,1�� �����ؾ���
    				int a = list.get(0);
    				int b = list.get(1);
    				int index1 = 0;
    				int index2 = 0;
    				int compare = 0;
    				for(int i=0; i<plays.length; i++) {
    					//a�� b���� ū ��� -> [800, 500, 500, 400]
    					//b�� ���� ���� �ִ��� Ȯ���ϰ�, �ִٸ� �ε����� ���ؾ���
    					if(a != b) {
    						for(int j=2; j<list.size(); j++) {
    							//0,1 �� ���� ��� Ƚ���� ���ٸ� �ε����� ��
    							if(list.get(j) == b) {
    								
    							}
    						}
    					}else {
    						
    					}
    					
    					
    					
    					
    					if(b == plays[i]) {
    						//a, b�� ���� ��� Ƚ��(index1�� �� i���� b ���ǿ� ��ġ�ϴ� i�� ��)�� ��� b�� �� ���� �ε��� ����
    						if(index1 != i) {
    							//b ��� Ƚ���� ���� �ε����� �� ���� �ƴ� ��� ���� �ε��� �� ����
    							compare = i;
    							if()
    						}
    					}
    					
    				}
    			}
    			*/
    		}
    		
    	}
    	
    	
        return answer;
    }
}
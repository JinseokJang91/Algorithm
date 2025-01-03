package com.study.algo.programmers.hash;

import java.util.HashMap;
import java.util.Iterator;

public class Hash1_2{

	//�ؽ�>�������� ���� ����
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String[] participant = {"mislav", "stanko", "stanko","stanko", "mislav", "ana", "mislav", "mislav"};
		//String[] completion = {"mislav","stanko", "ana", "mislav", "stanko", "mislav", "mislav"};
		
		String[] participant = {"mislav", "stanko","stanko", "stanko","mislav", "ana"};
		String[] completion = {"mislav", "stanko", "ana", "stanko","mislav"};
		
		//String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		//String[] completion = {"josipa", "filipa", "marina", "nikola"};
		
		String answer = "";
		
		//HashMap�� contaninsKey, remove �޼ҵ带 �̿�
		//participant�� completion�� key-value �����δ� ���� �� �����Ƿ�
		//participant ���� key�� ���� �� completion���� ���ؾ���
		//��� key�� �ߺ��� �ȵǹǷ� ���������� ��� �߰������� ó���������
		
		int check = 0;
		
		//1-1. ������ ��⿡ ������ ������ ���� 1�� �̻� 100,000�� ����
		if(participant.length >= 1 && participant.length <= 100000) {
			//1-2. completion�� ���� = participant�� ���� - 1
			if(completion.length + 1 == participant.length) {				
				for(int i=0; i<participant.length; i++) {
					//1-3-1. �������� �̸��� 1�� �̻� 20�� ����
					if((participant[i].length() >= 1 && participant[i].length() <= 20)) {						
						for(int j=0; j<participant[i].length(); j++) {
							//1-3-2. �������� �̸��� ���ĺ� �ҹ���
							if(participant[i].charAt(j) >= 97 && participant[i].charAt(j) <= 122) {
								check = 0;
							}else {
								check = 1;
							}
						}
					}
				}
				
			}
		}
		
		//2. ���
		if(check == 0) {
			//(1) ���������� ���� ���
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			//HashMap�� key������ �־ �ߺ����� ���� ������ ������
			for(int i=0; i<participant.length; i++) {
				if(!map.containsKey(participant[i])) {
					map.put(participant[i], 0);
				}else {
					//���������� ������ �ߺ� ī��Ʈ�ؼ� value������ ����
					map.replace(participant[i], ((int)map.get(participant[i]))+1);
				}
			}
			//key�� �ߺ����� �����Ƿ� �ܼ��� key�� ���ؼ� ����
			for(int i=0; i<completion.length; i++) {
				if(((int)map.get(completion[i])) == 0) {
					map.remove(completion[i]);
				}else {
					System.out.println(map.get(completion[i]));
					map.replace(completion[i], ((int)map.get(completion[i]))-1);
				}
				
			}
			
			System.out.println(map);
			//System.out.println("==========================");
			answer=map.keySet().iterator().next();
			//���������� ���� ���� �ᱹ �� ���� �����͸��� HashMap�� ����
			
			
			//�� �Ʒ� ������ HashMap�� 2�� �Ἥ ������ ��ܰ� ������ ����� ���� �ؽøʿ� �־ ���Ϸ��� �� ��
			//�ߺ� üũ�� ī��Ʈ�ؼ� ī��Ʈ�� �ٸ� key���� �������� ���� ����̹Ƿ� �׷��� �Ϸ��� ������
			//�������� �� �����ϰ� ó���� �� �־ �Ʒ� ������ �ּ�ó��
			
			/*
			if(!map.isEmpty()) {
				System.out.println(map.keySet().iterator().next());
				answer=map.keySet().iterator().next();
			}else {
				//�׷��� ���� ���(�������� �� ������ ����� ������ �� ���)���� �ٽ� ������ ����� �����ؼ� �������� ��
				for(int i=0; i<participant.length; i++) {
					if(!map.containsKey(participant[i])) {
						map.put(participant[i], 0);
					}else {
						map.replace(participant[i], ((int)map.get(participant[i]))+1);
					}
				}
				System.out.println(map);
				//������ ���(�ߺ� ī��Ʈ)�� �ٸ� HashMap�� ������ �� �ؽø��� value���� ��
				HashMap<String, Integer> map2 = new HashMap<String, Integer>();
				for(int i=0; i<completion.length; i++) {
					if(!map2.containsKey(completion[i])) {
						map2.put(completion[i], 0);
					}else {
						map2.replace(completion[i], ((int)map2.get(completion[i]))+1);
					}
				}
				System.out.println(map2);
				
				Iterator<String> iter = map.keySet().iterator();
				Iterator<String> iter2 = map2.keySet().iterator();
				
				while(iter.hasNext()) {
					String key = iter.next();
					String key2 = iter2.next();

					if(map.get(key) != map2.get(key2)) {
						answer = key;
						break;
					}
				}
				
			}*/
			System.out.println(answer);
		}
		
		
		
		//�� �Ʒ� ������ HashMap�� �����ϱ� ���� ���� ��ϵ�
		
		/*
		HashMap<String[], String[]> map = new HashMap<String[], String[]>();
		
		
		map.put(completion, participant);
		
		Iterator<Entry<String[], String[]>> iter = map.entrySet().iterator();
		
		while(iter.hasNext()) {
			Map.Entry<String[], String[]> entry = iter.next();
			System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());
		}
		System.out.println("========================================");
		
		Iterator<String[]> iter2 = map.keySet().iterator();
		while(iter2.hasNext()) {
			String[] key = iter2.next();
			System.out.println("Key : " + key + ", Value : " + map.get(key));
		}
		*/
		
		/*
		HashMap<String[], String[]> map = new HashMap<String[], String[]>();
		
		map.put(participant, completion);
		
		for(Map.Entry<String[], String[]> e : map.entrySet()) {
			System.out.println(map.c);
			System.out.println("Key : " + e.getKey() + ", Value : " + e.getValue());
			System.out.println(map.containsKey(e.getKey()));
			for(int i=0; i<e.getKey().length; i++) {
				for(int j=0; j<e.getValue().length; j++) {
					//System.out.println("Key : " + e.getKey()[i] + ", Value : " + e.getValue()[j]);
					if(e.getKey()[i].equals(e.getValue()[j])) {
						//System.out.println(e.getKey()[i]);
					}else {
						//System.out.println("##"+e.getKey()[i]);
					}
				}
			}
		}
		
		HashMap<String, String> map2 = new HashMap<String, String>();
		
		for(String e : participant) {

		}
		
		for(int i=0; i<participant.length; i++) {
			//map2.put(participant[i], completion[i]);
		}
		*/
		
	}

}

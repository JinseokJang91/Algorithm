package com.study.algo.algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Hash {

	public static void main(String[] args) {
		
		// HashMap : key, value ������ ������ Entry��ü�� �����ϴ� �ڷ� ����
		HashMap<String, String> map = new HashMap<String, String>();
		
		// ���� ���
		HashMap<String, String> map1 = new HashMap<>(); // Ÿ�� �Ķ���� ������ ����
		HashMap<String, String> map2 = new HashMap<>(10, 0.7f); // �ʱ��� (Capacity, load factor) ���� ����
																// List�� add�ϸ� ������� +1������, Map�� +2�ǹǷ� �޸� ���� ���̱� ����
																// ũ�⸦ ������ �� �ִٸ� �������ִ� ���� ����
		HashMap<String, String> map3 = new HashMap<String, String>(10, 0.7f) {{
			put("a", "b");
			put("c", "d");
		}};	//�ʱⰪ�� ����� ���ÿ� �������� �� ����
		
		// ������ ó��
		// 1. �߰�
		map.put("a", "b");
		// 2. ����
		map.remove("a"); //������ key������ ����
		map.clear(); //��ü ����
		
		// 3. ���
		map.put("a", "test1");
		map.put("a", "test0");	// key�� �ߺ� �ȵ�. ���� ���߿� �����ϴ� value���� ��
		map.put("c", "test3");
		map.put("b", "test2");
		map.put("d", "test3");	// value�� �ߺ� ����
		// (1) �ܼ� ���
		System.out.println("(1) �ܼ� ��� : " + map + "\n");
		// (2) entrySet() Ȱ��
		System.out.println("(2) entrySet() Ȱ��");
		for(Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry); // key=value ���·� ���
			System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
		}System.out.println();
		// (3) KeySet() Ȱ�� -> key���� �ʿ��� �� ����ϰ�, ���� ���� �����͸� ó���ؾ� �� ���� entrySet()�� ����ϴ� ���� ����
		System.out.println("(3) KeySet() Ȱ��");
		for(String s : map.keySet()) {
			System.out.println("key : " + s + ", value : " + map.get(s)); // ket Ȱ���� ���
		}System.out.println();
		// (4) Iterator ���
		System.out.println("(4) Iterator Ȱ��");
		Iterator<Entry<String, String>> iter = map.entrySet().iterator();
		while(iter.hasNext()) {
			Entry<String, String> entry = iter.next();
			System.out.println(entry); // key=value ���·� ���
			System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
		}System.out.println();
		
		//System.out.println(map.values().stream().sorted());
	}

}

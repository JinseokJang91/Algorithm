package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class No_5543 {

	public static void main(String[] args) throws Exception{
		
		//5543�� ��ٳ���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//�ܹ���, ���� ���� �ϳ��� ��� ��Ʈ�� �����ϸ� �տ��� -50�� ����
		//�ܹ��Ŵ� 3����, ����� 2����

		
		//1��° ���
		int sangduk = Integer.parseInt(br.readLine());
		int joongduk = Integer.parseInt(br.readLine());
		int haduk = Integer.parseInt(br.readLine());

		int coke = Integer.parseInt(br.readLine());
		int sprite = Integer.parseInt(br.readLine());

		//#1��° ���
		
		/*
		int minBurger = Math.min(sangduk, joongduk);
		if(minBurger > haduk) {
			minBurger = haduk;
		}
		int minDrink = Math.min(coke, sprite);
		//System.out.println("minBurger : " + minBurger);
		//System.out.println("minDrink : " + minDrink);
		int setPrice = minBurger + minDrink - 50;
		System.out.println(setPrice);
		*/
		
		//*********************************************************
		/* �Ʒ� ���׿����� ������ ������ �������� Ȯ���غ����� �ƴ�
		if((sangduk >= 100 && sangduk <= 2000) &&
		   (joongduk >= 100 && joongduk <= 2000) &&
		   (haduk >= 100 && haduk <= 2000) &&
		   (coke >= 100 && coke <= 2000) &&
		   (sprite >= 100 && sprite <= 2000))
		*/

		//#2��° ���
		
		//���� : �ε�ȣ�� "<=" �� ���� ���� 2(1,2��° ���� ������ ������)���� ������
		//�ε�ȣ�� "<" �� �ᵵ ������. �ٸ� �׽�Ʈ���̽��� �ʿ�
		//���� ���̽��� �����غ��� ���׿����ڸ� �߸� �����
		//->	���� ���Ű� 30, 100, 20�� �־����� �ϴ�����(20)�� �������(30)���� ������ �������� �ұ��ϰ�
		//		�������(30)�� ���õǴ� ����� ��Ÿ��
		//-> 	���� ���׿����ڸ� �� �ٷ� ������ ���ų�, �� �ٷ� ������ ���� �ϴ����� ���� ���ϴ°� ����
		//(1) �� �ٷ� ����
		int minBurger = sangduk < joongduk ? (sangduk < haduk ? sangduk : haduk) : (joongduk < haduk ? joongduk : haduk);
		//(2) �� �ٷ� ��������
		//int minBurger = sangduk < joongduk ? sangduk : joongduk;
		//minBurger = minBurger < haduk ? minBurger : haduk;
		
		int minDrink = coke < sprite ? coke : sprite;
		int setPrice = minBurger + minDrink - 50;
		System.out.println("minBurger : " + minBurger);
		System.out.println("minDrink : " + minDrink);
		System.out.println(setPrice);
		//*********************************************************
		
		
		/*
		//#3��° ��� - List�� sort ���
		
		List<Integer> burgers = new ArrayList<Integer>();
		List<Integer> drinks = new ArrayList<Integer>();
		for(int i=0; i<5; i++) {	
			int menu = Integer.parseInt(br.readLine());
			if(i < 3) {
				burgers.add(menu);
			}else {
				drinks.add(menu);
			}
		}
		//System.out.println("burgers : " + burgers);
		//System.out.println("drinks : " + drinks);
		
		Collections.sort(burgers, Comparator.naturalOrder());
		Collections.sort(drinks, Comparator.naturalOrder());
		
		//System.out.println("burgers(����) : " + burgers);
		//System.out.println("drinks(����) : " + drinks);
		
		int setPrice = burgers.get(0) + drinks.get(0) - 50;
		System.out.println(setPrice);
		*/
		
		br.close();
	}

}

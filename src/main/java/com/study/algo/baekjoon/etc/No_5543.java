package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_5543 {

	public static void main(String[] args) throws Exception{

		//5543번 상근날드
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//햄버거, 음료 각각 하나씩 골라 세트로 구매하면 합에서 -50원 할인
		//햄버거는 3종류, 음료는 2종류


		//1번째 방법
		int sangduk = Integer.parseInt(br.readLine());
		int joongduk = Integer.parseInt(br.readLine());
		int haduk = Integer.parseInt(br.readLine());

		int coke = Integer.parseInt(br.readLine());
		int sprite = Integer.parseInt(br.readLine());

		//#1번째 방법

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
		/* 아래 삼항연산자 에러가 조건이 문제인지 확인해봤으나 아님
		if((sangduk >= 100 && sangduk <= 2000) &&
		   (joongduk >= 100 && joongduk <= 2000) &&
		   (haduk >= 100 && haduk <= 2000) &&
		   (coke >= 100 && coke <= 2000) &&
		   (sprite >= 100 && sprite <= 2000))
		*/

		//#2번째 방법

		//참고 : 부등호를 "<=" 를 쓰면 예제 2(1,2번째 버거 가격이 같으면)에서 오류남
		//부등호를 "<" 로 써도 에러남. 다른 테스트케이스가 필요
		//여러 케이스를 대입해보니 삼항연산자를 잘못 사용함
		//->	만약 버거가 30, 100, 20이 주어지면 하덕버거(20)가 상덕버거(30)보다 가격이 작음에도 불구하고
		//		상덕버거(30)이 선택되는 결과를 나타냄
		//-> 	따라서 삼항연산자를 두 줄로 나눠서 쓰거나, 한 줄로 쓰려면 각각 하덕버거 값과 비교하는게 맞음
		//(1) 한 줄로 쓰기
		int minBurger = sangduk < joongduk ? (sangduk < haduk ? sangduk : haduk) : (joongduk < haduk ? joongduk : haduk);
		//(2) 두 줄로 나눠쓰기
		//int minBurger = sangduk < joongduk ? sangduk : joongduk;
		//minBurger = minBurger < haduk ? minBurger : haduk;

		int minDrink = coke < sprite ? coke : sprite;
		int setPrice = minBurger + minDrink - 50;
		System.out.println("minBurger : " + minBurger);
		System.out.println("minDrink : " + minDrink);
		System.out.println(setPrice);
		//*********************************************************


		/*
		//#3번째 방법 - List의 sort 사용

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

		//System.out.println("burgers(정렬) : " + burgers);
		//System.out.println("drinks(정렬) : " + drinks);
		
		int setPrice = burgers.get(0) + drinks.get(0) - 50;
		System.out.println(setPrice);
		*/

		br.close();
	}

}

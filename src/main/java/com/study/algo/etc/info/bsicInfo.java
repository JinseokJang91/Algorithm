package com.study.algo.etc.info;

public class bsicInfo {

	public static void main(String[] args) {

		// void 메소드 return 테스트
		System.out.println("Start!!!");
		String rTest = "abc";
		//String rTest = "def";

		returnTest(rTest);

		nextStepTest();

		System.out.println("End!!!");
	}

	public static void returnTest(String rTest) {
		if("abc".equals(rTest)) {
			return;
		}

		System.out.println("I'm in returnTest");
	}

	public static void nextStepTest() {
		System.out.println("I'm in nextStepTest");
	}
}

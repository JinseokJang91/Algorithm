package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2914 {

	public static void main(String[] args) throws Exception{

		//2914번 저작권
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 자신의 앨범에 포함되어있는 저작권이 있는 멜로디의 평균값
		// = (창영이 앨범에 수록된 곡에 포함되어 있는 저작권이 있는 멜로디의 개수) / (앨범에 수록된 곡의 개수)
		// -> 평균값은 항상 올림을 해서 정수로 만들어야 한다.

		//주어지는 값 : 앨범에 수록되어 있는 곡의 개수, 평균값
		//구해야할 값 : 적어도 몇 곡의 저작권이 있는 멜로디인지 구하기

		//저작권이 있는 멜로디의 개수 = 앨범에 수록된 곡의 개수 x 평균값
		//대신 평균값은 올림 처리한 정수 -> 평균값이 24이면 23.01이어도 올림처리해서 24가 됨
		//저작권이 있는 멜로디의 최소 개수를 구해야 하므로 평균값에서 0.99를 빼서 곱해보자 -> 그 값에서 올림처리 하면 최소값

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		double songs = Double.parseDouble(st.nextToken());
		double avg = Double.parseDouble(st.nextToken());

		avg -= 0.99;

		double melodies = songs * avg;
		double answer = Math.ceil(melodies);	//올림 처리

		System.out.println((int)answer);

		br.close();
	}

}

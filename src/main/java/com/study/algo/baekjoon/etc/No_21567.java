package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_21567 {

	public static void main(String[] args) throws Exception{
		//21567번 숫자의 개수 2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//A x B x C 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지 출력
		long A = Long.parseLong(br.readLine());
		long B = Long.parseLong(br.readLine());
		long C = Long.parseLong(br.readLine());

		long timesVal = A * B * C;
		//System.out.println("timesVal : " + timesVal);

		int[] useCntArr = new int[10];
		String strVal = String.valueOf(timesVal);
		for(int i=0; i<strVal.length(); i++) {
			int num = Integer.parseInt(String.valueOf(strVal.charAt(i)));
			//System.out.println("num : " + num);
			useCntArr[num]++;
			//System.out.println("useCntArr[num] : " + useCntArr[num]);
		}

		for(int i=0; i<useCntArr.length; i++) {
			System.out.println(useCntArr[i]);
		}

		br.close();
	}

}

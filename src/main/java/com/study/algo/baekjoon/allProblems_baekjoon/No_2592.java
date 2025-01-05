package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No_2592 {

	public static void main(String[] args) throws Exception{

		//2592번 대표값
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//주어지는 자연수는 1,000보다 작은 10의 배수
		List<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		for(int i=0; i<10; i++) {
			int score = Integer.parseInt(br.readLine());
			sum += score;
			list.add(score);
		}
		System.out.println("list : " + list);

		//평균
		int avg = sum / 10;

		Collections.sort(list);
		System.out.println("list(ASC) : " + list);

		//list 오름차순으로 정렬 후 현재인덱스값과 다음인덱스값을 비교해서
		//카운트를 계산하고, 최대 카운트와 해당 값을 저장하는 방법 사용
		int idxVal = 0;
		int cnt = 1;
		int cntSave = 0;
		int modeVal = 0;
		for(int i=0; i<list.size(); i++) {
			idxVal = list.get(i);
			if(i + 1 < list.size()) {
				if(idxVal != list.get(i+1)) {
					if(cnt >= cntSave) {
						cntSave = cnt;
						modeVal = idxVal;
					}
					cnt = 1;
				}else {
					cnt++;
				}
				System.out.println("cnt : " + cnt);
				System.out.println("cntSave : " + cntSave);
				System.out.println("modeVal : " + modeVal);
			}
		}
		//System.out.println("cntSave : " + cntSave);

		System.out.println(avg);
		System.out.println(modeVal);

		br.close();
	}

}

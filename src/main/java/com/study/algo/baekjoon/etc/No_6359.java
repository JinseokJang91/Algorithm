package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_6359 {

	public static void main(String[] args) throws Exception{

		//6359번 만취한 상범
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//N개의 방이 일렬로 늘어선 감옥
		//상범은 1~N라운드까지 감옥문을 열거나 잠금
		//1라운드 : 1,2,...,N-1,N 방 OPEN
		//2라운드 : 2,4,...,N-2,N 방 OPEN or CLOSE
		//...
		//N라운드 : N, N*2, ... , N*(N-1), N*N 방 OPEN or CLOSE
		//최종적으로 몇 명의 학생들이 도주할 수 있는지 구하기

		//N이 5이면
		//1라운드 : 1,2,3,4,5 OPEN
		//2라운드 : 2,4 CLOSE
		//3라운드 : 3 CLOSE
		//4라운드 : 4 OPEN
		//5라운드 : 5 CLOSE
		//최종 : 1 OPEN, 2 CLOSE, 3 CLOSE, 4 OPEN, 5 CLOSE

		//N이 6이면
		//1라운드 : 1,2,3,4,5,6 OPEN
		//2라운드 : 2,4,6 CLOSE
		//3라운드 : 3 CLOSE 6 OPEN
		//4라운드 : 4 OPEN
		//5라운드 : 5 CLOSE
		//6라운드 : 6 CLOSE
		//최종 : 1 OPEN, 2 CLOSE, 3 CLOSE, 4 OPEN, 5 CLOSE

		//1~N라운드까지 1~N각 번호의 누적 개수가 짝수면 CLOSE, 홀수면 OPEN
		//또는 0,1로 구분해서 OPEN, CLOSE를 각각 반대로 설정(1,0)
		List<Integer> list = null;
		List<Integer> result = new ArrayList<Integer>();

		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			list = new ArrayList<Integer>();
			int count = 0;

			//1라운드는 전체 OPEN
			for(int j=1; j<=N; j++) {
				list.add(0);
			}

			for(int j=2; j<=N; j++) {
				System.out.println("==== " + j + "라운드 ====");

				if(j == 1) {
					list.add(0);
				}else {
					int times = 1;
					while(j * times <= N) {
						if(list.get(j * times - 1) == 0) {
							list.set(j* times - 1, 1);
						}else {
							list.set(j * times - 1, 0);
						}
						times++;
					}
				}
			}

			for(int j=0; j<list.size(); j++) {
				if(list.get(j) == 0) {
					count++;
				}
			}

			System.out.println((i+1) + "번째 " + "list : " + list);
			result.add(count);
		}

		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}


		br.close();

	}

}

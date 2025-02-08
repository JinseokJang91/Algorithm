package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_3036 {

	public static void main(String[] args) throws Exception{

		//3036번 링
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//첫째 줄 : 링의 개수 N
		//둘째 줄 : 개수만큼 링의 반지름
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		String[] rings = new String[N];
		rings = input.split(" ");

		int firstRing = Integer.parseInt(rings[0]);
		List<Integer> list = new ArrayList<Integer>();
		for(int i=1; i<rings.length; i++) {
			list.add(Integer.parseInt(rings[i]));
		}
		//System.out.println("firstRing : " + firstRing);
		//System.out.println("list : " + list);

		for(int i=0; i<list.size(); i++) {
			int nextRing = list.get(i);
			int share = 1; //나눌 몫을 담을 변수
			int maxShare = 0; //최대공약수를 담을 변수
			String fraction = "";
			while(true) {
				if((firstRing % share == 0) && (nextRing % share == 0)) {
					maxShare = share;
				}

				share++; //몫을 두 수 중 작은 수랑 같아질 때까지 +1
				//두 수 중 작은 수보다 몫 값이 커지면 반복문 빠져나감
				if(share > Math.min(firstRing, nextRing)) {
					break;
				}
			}
			System.out.println("maxShare : " + maxShare);
			fraction = (firstRing / maxShare) + "/" + (nextRing / maxShare);
			System.out.println(fraction);
		}

		br.close();

		//처음 에러난 이유는 변수를 for문 밖에 설정했기 때문
		//while문을 거치고 다시 초기화해서 시작해야 하는데 for문 밖에 설정하니
		//바뀐 값이 그대로 적용되서 들어간 문제..

		//그리고 최대공약수를 구하는 방법이 더 쉬운게 있는 것 같음
	}

}

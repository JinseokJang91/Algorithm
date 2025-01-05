package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class No_1026 {

	public static void main(String[] args) throws Exception{
		//1026번 보물
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int len = Integer.parseInt(br.readLine());
		String inputA = br.readLine();
		String inputB = br.readLine();
		List<Integer> listA = new ArrayList<Integer>();
		List<Integer> listB = new ArrayList<Integer>();

		StringTokenizer stA = new StringTokenizer(inputA, " ");
		StringTokenizer stB = new StringTokenizer(inputB, " ");

		for(int i=0; i<len; i++) {
			listA.add(Integer.parseInt(stA.nextToken()));
			listB.add(Integer.parseInt(stB.nextToken()));
		}

		//S = A[0] x B[0] + ... + A[N-1] x B[N-1]
		//S값을 최소로 만들기 위한 A의 수만 재배열
		//A배열만 재배열 가능하지만 결과값만 출력하면 되므로
		//B에서 내림차순, A에서 오름차순으로 재배열해서 곱한 것과 다르지 않음
		Collections.sort(listA, Comparator.naturalOrder());
		Collections.sort(listB, Comparator.reverseOrder());
		System.out.println("listA : " + listA);
		System.out.println("listB : " + listB);

		int S = 0;
		for(int i=0; i<len; i++) {
			S += listA.get(i) * listB.get(i);
		}
		System.out.println("S : " + S);

		br.close();

	}

}

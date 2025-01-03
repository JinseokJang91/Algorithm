package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_5063 {

	public static void main(String[] args) throws Exception{

		//5063�� TGN
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		
		//r : ���� ���� �ʾ��� ���� ����
		//e : ���� ���� ���� ����
		//c : ���� ���
		//[���� ���� ���� ���� - ���� ���]�� [���� ���� �ʾ��� ���� ����]�� ��
		
		//���� �ؾ� �ϸ� 				"advertise"			-> e-c > r
		//���� �ص� ������ ���̰� ���ٸ� 	"does not matter"	-> e-c = r
		//���� ���� �ʾƾ� �ϸ� 			"do not advertise"	-> e-c < r
		
		List<String> list = new ArrayList<String>();
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			st = new StringTokenizer(input, " ");
			int r = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(e-c > r) {
				list.add("advertise");
			}else if(e-c < r) {
				list.add("do not advertise");
			}else {
				list.add("does not matter");
			}
		}
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		br.close();
	}

}

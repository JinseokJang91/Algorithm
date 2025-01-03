package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_10951 {

	public static void main(String[] args) throws Exception{

		//10951�� A+B-4
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder result = new StringBuilder();
		StringTokenizer st = null;
		String input = null;
		
		while((input = br.readLine()) != null) {			
			st = new StringTokenizer(input, " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			result.append(A + B).append("\n");
		}
		
		System.out.println(result);
		
		br.close();
		
		//< �Է��� ��� �ؾ� ���� ���� ã�ƺ� ���� >
		//EOF(End Of File) : �����Ͱ� ���̻� �������� ������ �ǹ�
		//EOF�� �Է¿��� ��Ÿ���� ���ؼ��� ������� Ctrl + Z, �������� Ctrl + D�� �����ָ� �ȴٰ� ��

	}

}

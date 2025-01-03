package com.study.algo.programmers.allProblems.lv1;

import java.util.Scanner;

public class LV1_09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        //System.out.println(a + b);
        
        //�������� > ���簢�� �����

        //������ ���̰� n, ������ ���̰� m�� �� (*) ���簢�� ���¸� ���
        
        if((a >= 1 && a <= 1000) && (b >= 1 && b <= 1000))
        
        for(int i=0; i<b; i++) {
        	for(int j=0; j<a; j++) {
        		System.out.print("*");
        	}
        	System.out.println();
        }
	}

}

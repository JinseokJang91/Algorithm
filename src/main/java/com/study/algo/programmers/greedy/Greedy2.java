package com.study.algo.programmers.greedy;

import java.util.ArrayList;
import java.util.List;

public class Greedy2 {

	public static void main(String[] args) {
		// Ž���>���̽�ƽ
		//�� - ���� ���ĺ�
		//�� - ���� ���ĺ� (A���� �Ʒ������� �̵��ϸ� Z��)
		//�� - Ŀ���� �������� �̵� (ù ��° ��ġ���� �������� �̵��ϸ� ������ ���ڿ� Ŀ��)
		//�� - Ŀ���� ���������� �̵� (������ ��ġ���� ���������� �̵��ϸ� ù ��° ���ڿ� Ŀ��)
		
		//���ĺ��� �� 26��(A~Z : 65~90 , a~z : 97~122)
		String name = "BAAAABB";

		GreedyTest gt = new GreedyTest();
		int result = gt.solution(name);
		System.out.println("result : " + result);
		
	}

}

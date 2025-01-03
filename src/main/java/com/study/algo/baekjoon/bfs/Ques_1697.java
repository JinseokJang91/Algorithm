package com.study.algo.baekjoon.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ques_1697 {

	//���� : https://www.acmicpc.net/workbook/view/9379
	//Ǯ�� : https://smartpro.tistory.com/18
	static int N;
	static int K;
	static int[] visited = new int[100001];
	
	
	public static void main(String[] args) {
		
		//���� ����
		//1. 0 <= N <= 100,000
		//2. 0 <= K <= 100,000
		//X-1 �Ǵ� X+1 �Ǵ� 2*X

		
		//Scanner ��� �Ʒ��� ���� ��� ����
		/* 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String[] inputs = input.split(" ");
		
		N = Integer.valueOf(inputs[0]);
		K = Integer.valueOf(inputs[1]);
		*/
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		sc.nextLine();

		
		int result = bfs(N);
		System.out.println(result);
		sc.close();
	}
	
	private static int bfs(int node) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		//node : ������ ó�� ��ġ
		queue.add(node);
		int index = node;
		int n = 0;
		visited[index] = 1;
		
		while(queue.isEmpty() == false){ //!queue.isEmpty() �ε� ǥ�� ����
			
			n = queue.poll();	//queue.remove()�ε� ��� ������.
								//remove()�� poll()�� �������� remove()�� Queue�� Empty�� �� Exception�� ��ȯ, poll()�� null�� ��ȯ��
			
			if(n == K) {
				return visited[n]-1;
			}
			
			if(n-1 >= 0 && visited[n-1] == 0) {
				visited[n-1] = visited[n] + 1;
				queue.add(n-1);
			}
			
			if(n+1 <= 100000 && visited[n+1] == 0) {
				visited[n+1] = visited[n] + 1;
				queue.add(n+1);
			}
			
			if(2*n <= 100000 && visited[2*n] == 0) {
				visited[2*n] = visited[n] + 1;
				queue.add(2*n);
			}
			
		}
		
		return -1;
		
	}

}

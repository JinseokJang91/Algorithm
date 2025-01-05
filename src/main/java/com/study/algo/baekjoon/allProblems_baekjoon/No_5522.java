package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_5522 {

	public static void main(String[] args) throws Exception {
		//5522번 카드 게임
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int sum = 0;
		for(int i=0; i<5; i++) {
			sum += Integer.parseInt(br.readLine());
		}

		System.out.println(sum);
		br.close();
	}

}

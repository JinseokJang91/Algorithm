package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_10886 {

	public static void main(String[] args) throws Exception{

		//10886번 0 = not cute / 1 = cute
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		if(N % 2 == 1) {

			int result = 0;
			for(int i=0; i<N; i++) {
				String input = br.readLine();
				if(input.equals("1")) {
					result++;
				}
				if(input.equals("0")) {
					result--;
				}
			}

			if(result > 0) {
				System.out.println("Junhee is cute!");
			}

			if(result < 0) {
				System.out.println("Junhee is not cute!");
			}
		}
		br.close();
	}

}

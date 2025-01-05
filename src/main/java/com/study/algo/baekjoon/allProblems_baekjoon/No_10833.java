package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_10833 {

	public static void main(String[] args) throws Exception{

		//10833번 사과
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//N개의 학교에서 사과를 학생에게 똑같이 나눠주고 남은 사과 개수의 합을 구하자
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = null;
		int totalRest = 0;
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			st = new StringTokenizer(input, " ");
			int students = Integer.parseInt(st.nextToken());
			int apples = Integer.parseInt(st.nextToken());

			//남는 사과는 사과 개수를 학생 수로 나눈 나머지
			totalRest += apples % students;
			System.out.println("totalRest : " + totalRest);
		}

		System.out.println("남는 사과의 총 개수 : " + totalRest);
		br.close();
	}

}

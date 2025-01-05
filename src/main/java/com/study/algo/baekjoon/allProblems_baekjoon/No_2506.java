package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_2506 {

	public static void main(String[] args) throws Exception{

		//2506번 점수계산
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");

		List<Integer> list = new ArrayList<Integer>();
		while(st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		System.out.println("list : " + list);

		int totalScore = 0;
		int score = 0;
		for(int i=0; i<list.size(); i++) {
			score++;
			if(list.get(i) == 0) {
				score = 0;
			}
			totalScore += score;
			System.out.println("score : " + score);
			System.out.println("totalScore : " + totalScore);
		}

		br.close();
	}

}

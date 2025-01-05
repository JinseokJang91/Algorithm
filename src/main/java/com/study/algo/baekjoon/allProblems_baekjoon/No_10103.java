package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_10103 {

	public static void main(String[] args) throws Exception{

		//10103번 주사위 게임
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		//창영과 상덕, 주사위 게임, 100점에서 시작
		//낮은 숫자가 나온 사람은 상대편 주사위 숫자만큼 점수를 잃는다.
		StringTokenizer st = null;
		int cy = 100;
		int sd = 100;
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			st = new StringTokenizer(input, " ");
			int cyNum = Integer.parseInt(st.nextToken());
			int sdNum = Integer.parseInt(st.nextToken());
			if(cyNum > sdNum) {
				sd -= cyNum;
			}

			if(cyNum < sdNum) {
				cy -= sdNum;
			}
		}

		System.out.println(cy + "\n" + sd);
		br.close();
	}

}

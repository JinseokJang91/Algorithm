package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1085 {

	public static void main(String[] args) throws Exception{
		//1085번 직사각형에서 탈출
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//한 수 는 (x,y) 직사각형 왼쪽 아래 꼭짓점은 (0,0) 오른쪽 위 꼭짓점은 (w,h)
		//x,y 에서 직사각형의 경계선까지 가는 거리의 최솟값

		//x-0값과 w-x값 비교해서 작은 값
		//y-0값과 h-y값 비교해서 작은 값
		//두 결과값 중에 작은 값

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int minX = Math.min(x-0, w-x);
		int minY = Math.min(y-0, h-y);
		System.out.println("minX : " + minX);
		System.out.println("minY : " + minY);

		int answer = Math.min(minX, minY);
		System.out.println("answer : " + answer);

		br.close();
	}

}

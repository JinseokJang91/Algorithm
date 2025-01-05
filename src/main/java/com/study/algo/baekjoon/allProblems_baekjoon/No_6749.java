package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_6749 {

	public static void main(String[] args) throws Exception{

		//6749번 Next in line
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int youngest = Integer.parseInt(br.readLine());
		int middle = Integer.parseInt(br.readLine());
		int oldest = middle + (middle - youngest);
		System.out.println(oldest);


		br.close();
	}

}

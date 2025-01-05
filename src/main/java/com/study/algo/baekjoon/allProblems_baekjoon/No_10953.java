package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_10953 {

	public static void main(String[] args) throws Exception{
		//10953번
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<T; i++) {
			String input = br.readLine();
			st = new StringTokenizer(input, ",");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list.add(A + B);
		}
		//System.out.println("list : " + list);

		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}

		br.close();
	}

}

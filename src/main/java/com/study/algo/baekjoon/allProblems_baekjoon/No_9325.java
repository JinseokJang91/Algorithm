package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_9325 {

	public static void main(String[] args) throws Exception{

		//9325번 얼마?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//첫 줄 : 테스트케이스 수 t

		//각 첫 줄 : 자동차 가격 s
		//각 둘째 줄 : 옵션 개수 n
		//		ㄴ 아래 : 옵션 개수(p) 및 가격(q)
		int t = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		StringTokenizer st = null;


		for(int i=0; i<t; i++) {
			int s = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int optTot = 0;

			if(n != 0) {
				for(int j=0; j<n; j++) {
					String opt = br.readLine();
					st = new StringTokenizer(opt, " ");
					int optCnt = Integer.parseInt(st.nextToken());
					int optPrc = Integer.parseInt(st.nextToken());
					optTot += optCnt * optPrc;
				}

				list.add(s + optTot);
			}else {
				list.add(s);
			}
		}

		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}

		br.close();
	}

}

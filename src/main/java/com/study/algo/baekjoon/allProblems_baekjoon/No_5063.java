package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_5063 {

	public static void main(String[] args) throws Exception{

		//5063번 TGN
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = null;

		//r : 광고를 하지 않았을 때의 수익
		//e : 광고를 했을 때의 수익
		//c : 광고 비용
		//[광고를 했을 때의 수익 - 광고 비용]과 [광고를 하지 않았을 때의 수익]을 비교

		//광고를 해야 하면 				"advertise"			-> e-c > r
		//광고를 해도 수익의 차이가 없다면 	"does not matter"	-> e-c = r
		//광고를 하지 않아야 하면 			"do not advertise"	-> e-c < r

		List<String> list = new ArrayList<String>();
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			st = new StringTokenizer(input, " ");
			int r = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(e-c > r) {
				list.add("advertise");
			}else if(e-c < r) {
				list.add("do not advertise");
			}else {
				list.add("does not matter");
			}
		}

		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}

		br.close();
	}

}

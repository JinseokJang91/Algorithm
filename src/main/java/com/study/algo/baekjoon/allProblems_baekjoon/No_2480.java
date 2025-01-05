package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class No_2480 {

	public static void main(String[] args) throws Exception{

		//2480번 주사위 세 개
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		int num3 = Integer.parseInt(st.nextToken());

		Set<Integer> set = new HashSet<Integer>();
//		set.add(num1);
//		set.add(num2);
//		set.add(num3);

		//set에 add하면서 false가 나는 값을 찾음(중복이 있는 값)
		boolean chk1 = set.add(num1);
		boolean chk2 = set.add(num2);
		boolean chk3 = set.add(num3);

		int dupNum = 0;		//중복된 수
		int maxNum = Math.max(num1, num2) > num3 ? Math.max(num1, num2) : num3 ;

		if(!chk1) {
			dupNum = num1;
		}
		if(!chk2) {
			dupNum = num2;
		}
		if(!chk3) {
			dupNum = num3;
		}
		//System.out.println(set.add(num1));
		//System.out.println(set.add(num2));
		//System.out.println(set.add(num3));
		System.out.println("set : " + set);
		System.out.println("dupNum : " + dupNum);
		System.out.println("maxNum : " + maxNum);

		int prizeMoney = 0;	//상금


		if(dupNum != 0) {
			if(set.size() == 2) {
				prizeMoney = 1000 + dupNum * 100;
			}

			if(set.size() == 1) {
				prizeMoney = 10000 + dupNum * 1000;
			}
		}else {
			prizeMoney = maxNum * 100;
		}

		System.out.println("prizeMoney : " + prizeMoney);
		br.close();
	}

}

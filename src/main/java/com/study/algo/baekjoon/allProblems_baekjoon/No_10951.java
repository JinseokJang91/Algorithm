package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_10951 {

	public static void main(String[] args) throws Exception{

		//10951번 A+B-4
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder result = new StringBuilder();
		StringTokenizer st = null;
		String input = null;

		while((input = br.readLine()) != null) {
			st = new StringTokenizer(input, " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			result.append(A + B).append("\n");
		}

		System.out.println(result);

		br.close();

		//< 입력을 어떻게 해야 할지 몰라서 찾아본 내용 >
		//EOF(End Of File) : 데이터가 더이상 존재하지 않음을 의미
		//EOF를 입력에서 나타내기 위해서는 윈도우는 Ctrl + Z, 리눅스는 Ctrl + D를 눌러주면 된다고 함

	}

}

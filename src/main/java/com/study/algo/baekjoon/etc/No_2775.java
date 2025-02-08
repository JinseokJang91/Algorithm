package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_2775 {

	public static void main(String[] args) throws Exception{

		//2775번 부녀회장이 될테야
		/*
		 * a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다.
		 * 아파트는 0층부터 있고 각 층은 1호부터 존재하며, 0층의 i호에는 i명이 산다.
		 * 주어지는 값은 k, n : k - 층, n - 호
		 * */

		/*
		 * ...
		 * 2층 : 1호(1명)	2호(1+3명)	3호(1+3+6명)	5호(1+3+6+10명)	5호(1+3+6+10+15명)	... N호
		 * 1층 : 1호(1명)	2호(1+2명)	3호(1+2+3명)	4호(1+2+3+4명)	5호(1+2+3+4+5명)		... N호(1+2+...+N명)
		 * 0층 : 1호(1명) 	2호(2명) 		3호(3명) 		4호(4명)			5호(5명)				... N호(N명)

		 * k층의 n호에 있는 거주민 수를 출력하려면
		 *
		 * */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<Integer> answer = new ArrayList<Integer>();

		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());

			int residents = getResidentsCnt(k, n);
			answer.add(residents);
		}

		for(int i=0; i<answer.size(); i++) {
			System.out.println(answer.get(i));
		}

		br.close();
	}

	public static int getResidentsCnt(int floor, int room) {

		//List<Integer> nthRoom = new ArrayList<Integer>();

		List<Integer> downFloor = new ArrayList<Integer>();	//아래층 호수 별 거주자 수
		List<Integer> tempFloor = new ArrayList<Integer>(); //해당층 거주자 수 계산 후 아래층 리스트에 넣기 위한 임시 리스트
		int nthRoom = 0; //각 호수의 거주자 수

		for(int i=0; i<room; i++) {
			downFloor.add(i + 1);
		}

		for(int i=0; i<floor; i++) {
			nthRoom = 0; //층 별로 호수 별 거주자 수를 계산해야 하므로 초기화
			for(int j=1; j<=room; j++) {
				nthRoom += downFloor.get(j - 1);
				//System.out.println("nthRoom : " + nthRoom);
				tempFloor.add(nthRoom);
			}

			//다음 층에 올라가면 아래층이 위에서 계산한 층이 되므로
			//임시리스트(해당층 정보가 담긴)를 아래층 리스트에 담기 위한 과정
			//1. 아래층 리스트 clear
			//2. 임시 리스트를 아래층 리스트로 옮김(for문 또는 .addAll 함수 사용)
			//3. 임시 리스트 clear(다음 층 계산 결과를 담기 위해)
			downFloor.clear();

			/* [ 참고사항 ]

			//downFloor = tempFloor;
			//단순하게 '='를 이용해 담아보려고 했으나, clear하면 담은 리스트도 사라져서 에러 발생함
			//구글 검색을 해보았으나 이유를 찾는데는 실패..
			//그래서 혼자 고민해본 결과
			//tempFloor.set(0, 9999); //로 테스트 해봄

			//-> .set을 이용해 tempFloor의 0번째 인덱스를 바꿔봤을 때 옮긴 리스트(downFloor)도 동일하게 나타나는 결과를 확인했음
			//따라서 '='를 사용했을 때 downFloor에 tempFloor의 값이 옮겨가는 것이 아니라 tempFloor와 downFloor가 동일 리스트(Like 쌍방과실)가 된다는 것으로 이해할 수 있음(확실치는 않음)
			//그렇기 때문에 downFloor = tempFloor;를 선언하고, 어떤 리스트의 데이터를 바꾸든 둘 다에 적용이 될거라고 예상
			//downFloor.set(0, 9999); //로 테스트 해본 결과
			//downFloor의 데이터를 바꿨음에도 tempFloor의 데이터가 동일하게 바뀐 것을 확인할 수 있었음

			//결론 :	List A에 '='로 사용해서 List B의 데이터를 삽입은 가능하나
			//		단순히 데이터가 옮겨가는 것이 아닌, A가 B에 대한 권리, B가 A에 대한 권리 즉, 상호 동일 시 된다.
			
			*/

//			for(int j=0; j<tempFloor.size(); j++) {
//				downFloor.add(tempFloor.get(j));
//			}
			downFloor.addAll(tempFloor);
			tempFloor.clear();

			//System.out.println("tempFloor : " + tempFloor);
			//System.out.println("downFloor : " + downFloor);
		}

		return nthRoom;
	}
}

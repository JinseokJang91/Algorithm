package etc.lotto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class getLottoNumber {

	public static void main(String[] args) {

		List<TreeSet<Integer>> lottoList = new ArrayList<>();


		System.out.println("=====================================");
		System.out.println("금주 로또 구매번호");
		for(int i = 0; i < 5; i++) {
			TreeSet<Integer> lottoSet = new TreeSet<Integer>();

			while(true) {
				int lottoNum = (int)(Math.random() * 45 + 1);

				//System.out.println("lottoNum : " + lottoNum);
				lottoSet.add(lottoNum);

				if(lottoSet.size() == 6) {
					break;
				}
			}
			System.out.println((i + 1) + " 번 : " + lottoSet);

			lottoList.add(lottoSet);
		}
		System.out.println("=====================================");

		List<String> lottoResult = null;
		try {
			System.out.println("금주 로또 결과");
			lottoResult = lottoResult(lottoList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		for(String result : lottoResult) {
			System.out.println(result);
		}
		System.out.println("=====================================");
	}

	public static List<String> lottoResult(List<TreeSet<Integer>> lottoList) throws Exception {
		TreeSet<Integer> winLottoSet = new TreeSet<Integer>();
		winLottoSet.add(6);
		winLottoSet.add(11);
		winLottoSet.add(16);
		winLottoSet.add(19);
		winLottoSet.add(21);
		winLottoSet.add(32);

		List<List<String>> lottoMatchList = new ArrayList<List<String>>();

		for(TreeSet<Integer> lottoSet : lottoList) {
			Iterator<Integer> lottoIter = lottoSet.iterator();
			Iterator<Integer> winLottoIter = winLottoSet.iterator();

			List<String> matchList  = new ArrayList<String>();

			while(lottoIter.hasNext()) {
				int lottoNum = lottoIter.next();
				int winLottoNum = winLottoIter.next();

				if(lottoNum == winLottoNum) {
					matchList.add("당첨");
				} else {
					matchList.add("낙첨");
				}
			}

			lottoMatchList.add(matchList);
		}

		List<String> myLottoResultList = new ArrayList<String>();

		for(int i = 0; i < lottoMatchList.size(); i ++) {
			List<String> matchList = lottoMatchList.get(i);
			String result = "";
			int grade = 0;
			String prizeMoney = "";

			int winCnt  = (int) matchList.stream().filter(a -> a.equals("당첨")).count();
			int loseCnt = (int) matchList.stream().filter(a -> !a.equals("당첨")).count();

			switch(winCnt) {
				/* TODO java 상위버전 설치 */
//			case 3 -> grade = 5;
//			case 4 -> grade = 4;
//			case 5 -> grade = 3;
//			/* TODO 2등 case */
//			case 6 -> grade = 1;

				case 3 : grade = 5; break;
				case 4 : grade = 4; break;
				case 5 : grade = 3; break;
				case 6 : grade = 1; break;
			}

			switch(grade) {
				case 5  : prizeMoney = "5,000원"; break;
				case 4  : prizeMoney = "50,000원"; break;
				case 3  : prizeMoney = "백만원 대"; break;
				case 1  : prizeMoney = "억 대"; break;
				default : prizeMoney = "없음"; break;
			}

			if(winCnt + loseCnt != 6) {
				throw new Exception();
			}

			result = (i + 1) + " 번 : " + "당첨금 - " + prizeMoney + " [ 당첨 - " + winCnt + " , 낙첨 - " + loseCnt + " ]";
			myLottoResultList.add(result);

			// TODO 2등 여부도 확인
		}

		return myLottoResultList;
	}
}

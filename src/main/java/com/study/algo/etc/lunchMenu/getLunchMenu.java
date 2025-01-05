package etc.lunchMenu;

import java.io.BufferedReader;
import java.io.FileReader;

public class getLunchMenu {

	public static void main(String[] args) throws Exception{

		String path = System.getProperty("user.dir") + "\\src\\TIL\\lunchMenu\\lunchMenuList.txt";

		// 1. txt파일 크기 구하기
		BufferedReader lineCntRead = new BufferedReader(new FileReader(path));

		int txtFileLines = 0;

		while(lineCntRead.readLine() != null) {
			txtFileLines++;
		}

		// 2. 랜덤 라인 설정
		int randomLine1 = (int)(Math.random() * txtFileLines);
		int randomLine2 = (int)(Math.random() * txtFileLines);

		int lineNum = 0;
		String read = "";
		String lunchMenu1 = "";
		String lunchMenu2 = "";
		lineCntRead.close();

		// 3. 해당 라인 메뉴 추출
		BufferedReader reader = new BufferedReader(new FileReader(path));

		while((read = reader.readLine()) != null) {
			if(lineNum == randomLine1) {
				lunchMenu1 = read;
			}

			if(lineNum == randomLine2) {
				lunchMenu2 = read;
			}
			lineNum++;
		}
		System.out.println("오늘의 점심 메뉴1 : " + lunchMenu1);
		System.out.println("오늘의 점심 메뉴2 : " + lunchMenu2);

		reader.close();
	}

}

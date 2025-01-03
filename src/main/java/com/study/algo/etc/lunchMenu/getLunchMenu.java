package com.study.algo.etc.lunchMenu;

import java.io.BufferedReader;
import java.io.FileReader;

public class getLunchMenu {

	public static void main(String[] args) throws Exception{

		String path = System.getProperty("user.dir") + "\\src\\TIL\\lunchMenu\\lunchMenuList.txt";
		
		// 1. txt���� ũ�� ���ϱ�
		BufferedReader lineCntRead = new BufferedReader(new FileReader(path));
		
		int txtFileLines = 0;
		
		while(lineCntRead.readLine() != null) {
			txtFileLines++;
		}
		
		// 2. ���� ���� ����
		int randomLine1 = (int)(Math.random() * txtFileLines);
		int randomLine2 = (int)(Math.random() * txtFileLines);
		
		int lineNum = 0;
		String read = "";
		String lunchMenu1 = "";
		String lunchMenu2 = "";
		lineCntRead.close();
		
		// 3. �ش� ���� �޴� ����
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
		System.out.println("������ ���� �޴�1 : " + lunchMenu1);
		System.out.println("������ ���� �޴�2 : " + lunchMenu2);
		
		reader.close();
	}

}

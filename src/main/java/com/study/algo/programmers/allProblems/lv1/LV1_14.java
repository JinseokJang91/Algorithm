package com.study.algo.programmers.allProblems.lv1;

public class LV1_14 {

	public static void main(String[] args) {
		SolutionLV1_14 sol = new SolutionLV1_14();
		//int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		//int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		String hand = "right";
		//String hand = "left";
		String answer = sol.solution(numbers, hand);
		System.out.println("answer : " + answer);

	}

}

class SolutionLV1_14 {
    public String solution(int[] numbers, String hand) {
    	
    	//2020 īī�� ���Ͻ� > Ű�е� ������
        String answer = "";
        
        int check = 0;
        if(numbers.length >= 1 && numbers.length <= 1000) {
        	for(int i=0; i<numbers.length; i++) {
        		if(numbers[i] >= 0 && numbers[i] <= 9) {
        			check = 1;
        		}else {
        			check = 0;
        			break;
        		}
        	}
        }
        
        if(check == 1) {
        	//  1	2	3
            //	4	5	6
            //	7	8	9
            //	*	0	#
            
            // 1,4,7�� �޼� ����
            // 3,6,9�� ������ ����
            // 2,5,8,0�� �� �����հ��� �� �� ����� ��ġ�� �ִ� ��.
            // ��, �Ÿ��� ������ ����������, �޼����� ���ο� ���� �Ǻ�
        	
        	// ������ �迭 �̿��ؼ� ��ǥ���� ���ϸ� �Ÿ��� �� �� ����
        	// 1,4,7�� ������ �޼��̰�, 3,6,9�� ������ ������
        	// ���� 2,5,8,0�� ��츸 ����ϸ� ��
        	// �� ���� ��ġ�� ���� ���� �ʿ�
        	//int[][] numArr = {{1,2,3},{4,5,6},{7,8,9},{0,0,0}};
        	int lx = 3;
        	int ly = 0;
        	int rx = 3;
        	int ry = 2;
        	int mx = 0;
        	int my = 0;
        	int lGap = 0;
        	int rGap = 0;
        	
        	for(int i=0; i<numbers.length; i++) {
        		//�޼� ����
        		if(numbers[i] == 1) {
        			//System.out.println("1�� ��");
        			lx = 0;
        			ly = 0;
        			answer += "L";
        			System.out.println("answer : " + answer);
        		}
				if(numbers[i] == 4) {
					//System.out.println("4�� ��");
					lx = 1;
        			ly = 0;
        			answer += "L";
        			System.out.println("answer : " + answer);
				}
				if(numbers[i] == 7) {
					System.out.println("7�� ��");
					lx = 2;
        			ly = 0;
        			answer += "L";
        			System.out.println("answer : " + answer);
				}
				//������ ����
				if(numbers[i] == 3) {
        			//System.out.println("3�� ��");
        			rx = 0;
        			ry = 2;
        			answer += "R";
        			System.out.println("answer : " + answer);
        		}
				if(numbers[i] == 6) {
					//System.out.println("6�� ��");
					rx = 1;
        			ry = 2;
        			answer += "R";
        			System.out.println("answer : " + answer);
				}
				if(numbers[i] == 9) {
					//System.out.println("9�� ��");
					rx = 2;
        			ry = 2;
        			answer += "R";
        			System.out.println("answer : " + answer);
				}
				
				//�߰� ��ȣ
				if(numbers[i] == 2) {
					System.out.println("2�� ��");
					mx = 0;
					my = 1;
					lGap = Math.abs(mx-lx) + Math.abs(my-ly);
					rGap = Math.abs(mx-rx) + Math.abs(my-ry);
					System.out.println("lGap : " + lGap);
					System.out.println("rGap : " + rGap);
					if(lGap < rGap) {
						lx = mx;
						ly = my;
						answer += "L";
						//System.out.println("�޼��� �� ����� �� : " + answer);
					}else if(rGap < lGap){
						rx = mx;
						ry = my;
						answer += "R";
						//System.out.println("�������� �� ����� �� : " + answer);
					}else {
						if(hand.equals("left")) {
							//System.out.println("�Ÿ� ���� �޼������� ��");
							lx = mx;
							ly = my;
							answer += "L";
						}else {
							//System.out.println("�Ÿ� ���� ������������ ��");
							rx = mx;
							ry = my;
							answer += "R";
						}
					}
					System.out.println("answer : " + answer);
				}
				
				if(numbers[i] == 5) {
					//System.out.println("2�� ��");
					mx = 1;
					my = 1;
					lGap = Math.abs(mx-lx) + Math.abs(my-ly);
					rGap = Math.abs(mx-rx) + Math.abs(my-ry);
					System.out.println("lGap : " + lGap);
					System.out.println("rGap : " + rGap);
					if(lGap < rGap) {
						lx = mx;
						ly = my;
						answer += "L";
						//System.out.println("�޼��� �� ����� �� : " + answer);
					}else if(rGap < lGap){
						rx = mx;
						ry = my;
						answer += "R";
						//System.out.println("�������� �� ����� �� : " + answer);
					}else {
						if(hand.equals("left")) {
							//System.out.println("�Ÿ� ���� �޼������� ��");
							lx = mx;
							ly = my;
							answer += "L";
						}else {
							//System.out.println("�Ÿ� ���� ������������ ��");
							rx = mx;
							ry = my;
							answer += "R";
						}
					}
					System.out.println("answer : " + answer);
				}
				
				if(numbers[i] == 8) {
					System.out.println("8�� ��");
					mx = 2;
					my = 1;
					lGap = Math.abs(mx-lx) + Math.abs(my-ly);
					rGap = Math.abs(mx-rx) + Math.abs(my-ry);
					System.out.println("lGap : " + lGap);
					System.out.println("rGap : " + rGap);
					if(lGap < rGap) {
						lx = mx;
						ly = my;
						answer += "L";
						//System.out.println("�޼��� �� ����� �� : " + answer);
					}else if(rGap < lGap){
						rx = mx;
						ry = my;
						answer += "R";
						//System.out.println("�������� �� ����� �� : " + answer);
					}else {
						if(hand.equals("left")) {
							//System.out.println("�Ÿ� ���� �޼������� ��");
							lx = mx;
							ly = my;
							answer += "L";
						}else {
							//System.out.println("�Ÿ� ���� ������������ ��");
							rx = mx;
							ry = my;
							answer += "R";
						}
					}
					System.out.println("answer : " + answer);
				}
				
				if(numbers[i] == 0) {
					System.out.println("0�� ��");
					mx = 3;
					my = 1;
					lGap = Math.abs(mx-lx) + Math.abs(my-ly);
					rGap = Math.abs(mx-rx) + Math.abs(my-ry);
					System.out.println("lGap : " + lGap);
					System.out.println("rGap : " + rGap);
					if(lGap < rGap) {
						lx = mx;
						ly = my;
						answer += "L";
						//System.out.println("�޼��� �� ����� �� : " + answer);
					}else if(rGap < lGap){
						rx = mx;
						ry = my;
						answer += "R";
						//System.out.println("�������� �� ����� �� : " + answer);
					}else {
						if(hand.equals("left")) {
							//System.out.println("�Ÿ� ���� �޼������� ��");
							lx = mx;
							ly = my;
							answer += "L";
						}else {
							//System.out.println("�Ÿ� ���� ������������ ��");
							rx = mx;
							ry = my;
							answer += "R";
						}
					}
					System.out.println("answer : " + answer);
				}
        	}	
        }

        return answer;
    }
}

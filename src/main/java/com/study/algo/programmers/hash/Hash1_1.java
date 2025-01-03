package com.study.algo.programmers.hash;

public class Hash1_1 {

	//�ؽ�>�������� ���� ����
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//�ҹ��ڴ� 97~122
		char test1 = 122;
		//System.out.println(test1);
		
		
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};

		String answer = "";
		
		
		//1. ���ѻ��� üũ
		int check = 0;
		
		//1-1. ������ ��⿡ ������ ������ ���� 1�� �̻� 100,000�� ����
		if(participant.length >= 1 && participant.length <= 100000) {
			//1-2. completion�� ���� = participant�� ���� - 1
			if(completion.length + 1 == participant.length) {				
				for(int i=0; i<participant.length; i++) {
					//1-3-1. �������� �̸��� 1�� �̻� 20�� ����
					if((participant[i].length() >= 1 && participant[i].length() <= 20)) {						
						for(int j=0; j<participant[i].length(); j++) {
							//1-3-2. �������� �̸��� ���ĺ� �ҹ���
							if(participant[i].charAt(j) >= 97 && participant[i].charAt(j) <= 122) {
								check = 0;
							}else {
								check = 1;
							}
						}
					}
				}
				
			}
		}
		
		//2. ����� ��������(for�� ���)
		if(check == 0) {			
			for(int i=0; i<participant.length; i++) {
				
				for(int k=0; k<completion.length; k++) {
					if(participant[i].equals(completion[k])) {
						participant[i] = "";
						completion[k] = "";
					}
				}
				if(!(participant[i].equals(""))) {
					answer = participant[i];
					break;
				}
			}
		}
		
		//2. ���ѻ��� ���� �� �������� üũ
		// --> �� �Ʒ� ������ ���������� �ִ� ���� ���� ��츦 ������ ���ε�
		// --> �غ��� ������ �����ε� ��� ���� �����ϴ� ���ؼ� �������� �ּ�ó����
		
		/*
		if(check == 0) {
			
			int sameCheck = 0;
			//2-1. �������� üũ
			
			for(int i=0; i<participant.length; i++) {
				for(int j=1; j<participant.length; j++) {
					if(participant[i].equals(participant[j])) {
						sameCheck = 0;
					}else {
						sameCheck = 1;
					}
				}
			}
			
			//2-2. ���������� �ִ� ��� -> ����� ��������
			if(sameCheck == 0) {
				for(int i=0; i<participant.length; i++) {
					
					for(int k=0; k<completion.length; k++) {
						if(participant[i].equals(completion[k])) {
							participant[i] = "";
							completion[k] = "";
						}
					}
					if(!(participant[i].equals(""))) {
						answer = participant[i];
						break;
					}
				}
			//2-3. ���������� ���� ��� -> count���� �̿�
			}else {
				for(int i=0; i<participant.length; i++) {
					int count = 0;
					
					for(int k=0; k<completion.length; k++) {
						if(!(participant[i].equals(completion[k]))) {
							count++;
							if(count == completion.length) {
								answer = participant[i];
							}
						}
					}
				}
			}
		}*/
		
		System.out.println(answer);
	}

}

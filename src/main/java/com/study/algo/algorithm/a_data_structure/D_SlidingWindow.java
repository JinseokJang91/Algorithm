package com.study.algo.algorithm.a_data_structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D_SlidingWindow {
    private static int[] chkArr;
    private static int[] curArr;
    private static int chkCnt;
    private static int result;

    public static void main(String[] args) throws Exception {
        // 슬라이딩 윈도우

        // 백준 12891번 DNA 비밀번호
        // A, C, G, T로 구성

        // 1. 시간복잡도 측정
        // P와 S 최대 길이가 1,000,000이므로 O(n)으로 문제 해결

        // 2. 슈도코드 작성
        // S(문자열 크기), P(부분 문자열의 크기) 입력 받기
        // A(문자열 데이터) 입력 받기
        // 비밀번호 체크 배열 chkArr 선언하기
        // 현재 상태를 저장할 배열 curArr 선언
        // 몇 개나 충족했는지 카운트할 chkCnt 선언(A, C, G, T 중 몇 개를 충족했는지, 4가 되면 유효한 비밀번호로 판단)
        // A, C, G, T 중 필요 개수가 0이면 chkCnt++ (0은 항상 충족이므로)
        // P 범위만큼 S 배열에 적용하여 유효한 비밀번호인지 판단하기
        // for(i를 P에서 S까지 반복)
        // {
        //   j 선언(i - P)
        // }

        // 3. 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] A = br.readLine().toCharArray();
        chkCnt = 0;
        chkArr = new int[4];
        curArr = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            chkArr[i] = Integer.parseInt(st.nextToken());
            if(chkArr[i] == 0) {
                chkCnt++;
            }
        }

        for(int i = 0; i < P; i++) {
            add(A[i]);
        }

        if(chkCnt == 4) result++;

        // 슬라이딩 윈도우(왼쪽 끝이 i, 오른쪽 끝이 j)
        for(int j = P; j < S; j++) {
            int i = j - P;

            add(A[j]);
            remove(A[i]);
            if(chkCnt == 4) result++;
        }

        bw.write("" + result);

        br.close();
        bw.close();
    }

    private static void add(char c) {
        switch(c) {
            case 'A'-> {
                curArr[0]++;
                if(curArr[0] == chkArr[0]) chkCnt++;
            }
            case 'C'-> {
                curArr[1]++;
                if(curArr[1] == chkArr[1]) chkCnt++;
            }
            case 'G'-> {
                curArr[2]++;
                if(curArr[2] == chkArr[2]) chkCnt++;
            }
            case 'T'-> {
                curArr[3]++;
                if(curArr[3] == chkArr[3]) chkCnt++;
            }
        }
    }

    private static void remove(char c) {
        switch(c) {
            case 'A'-> {
                if(curArr[0] == chkArr[0]) chkCnt--;
                curArr[0]--;
            }
            case 'C'-> {
                if(curArr[1] == chkArr[1]) chkCnt--;
                curArr[1]--;
            }
            case 'G'-> {
                if(curArr[2] == chkArr[2]) chkCnt--;
                curArr[2]--;
            }
            case 'T'-> {
                if(curArr[3] == chkArr[3]) chkCnt--;
                curArr[3]--;
            }
        }
    }
}

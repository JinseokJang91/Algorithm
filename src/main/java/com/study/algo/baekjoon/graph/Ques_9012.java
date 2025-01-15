package com.study.algo.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ques_9012 {
    public static void main(String[] args) throws IOException {
        // 한 쌍의 괄호기호 "()" 문자열 : 기본 VPS
        // x, y : "()" 일 때, (x)와 xy 둘 다 VPS

        // 1. 좌우 개수 합이 일치하지 않으면 VPS가 아님
        // 2. 좌와 개수 합이 일치해도 올바른 형태 "()"가 아니면 VPS가 아님

        // 1번 : 합 개수 비교
        // 2번 : 합 개수 일치 시, "("는 +1, ")"는 -1 식으로 진행 (반드시 좌괄호가 먼저 나와야 감싸는 형태인 "()"가 됨)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        String[][] vpsArr = new String[T][50]; // 문자열 길이 : 2 이상 50 이하
        for(int i = 0; i < T; i++) {
            String[] vpsLine = br.readLine().split("");
            vpsArr[i] = vpsLine;
        }

        String[] result = new String[T];

        // 1. 좌우 개수 합 체크
        for(int i = 0; i < vpsArr.length; i++) {
            int left = (int) Arrays.stream(vpsArr[i]).filter("("::equals).count();
            int right = (int) Arrays.stream(vpsArr[i]).filter(")"::equals).count();

            if(left != right) {
                result[i] = "NO";
            } else {
                int vpsChkCnt = 0;
                for(String s : vpsArr[i]) {
                    if("(".equals(s)) {
                        vpsChkCnt++;
                    } else if(")".equals(s)) {
                        vpsChkCnt--;
                    }

                    if(vpsChkCnt < 0) {
                        break;
                    }
                }

                if(vpsChkCnt < 0) {
                    result[i] = "NO";
                } else {
                    result[i] = "YES";
                }
            }
        }

        for(String s : result) {
            System.out.println(s);
        }

        br.close();
    }
}

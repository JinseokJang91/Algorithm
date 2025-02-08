package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ques_5597 {
    public static void main(String[] args) throws IOException {
        // 30명 (출석번호 1 ~ 30)
        // 과제 제출 : 28 명
        // 과제 미제출 : 2 명
        // 2 명 출석번호 오름차순 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] submits = new int[31];
        int[] notSubmits = new int[2];
        int notSubmitCount = 0;

        for(int i = 0; i < 28; i++) {
            // 출석번호 == 배열 index 동일화
            int studentNumber = Integer.parseInt(br.readLine());
            submits[studentNumber] = studentNumber;
        }

        for(int i = 1; i <= 30; i++) {
            if(notSubmitCount > 2) {
                break;
            }

            if(submits[i] == 0) {
                System.out.println(" i : " + i);
                notSubmits[notSubmitCount] = i;
                notSubmitCount++;
            }
        }

        System.out.println(Math.min(notSubmits[0], notSubmits[1]));
        System.out.println(Math.max(notSubmits[0], notSubmits[1]));

        br.close();
    }
}

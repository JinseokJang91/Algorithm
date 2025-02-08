package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ques_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 한수 : 양의 정수 X의 각 자리가 등차수열을 이루는 수
        // e.g. 123, 135, 210, 321 등

        // N : 1000보다 작거나 같은 자연수
        //     => 1000은 한수가 아니므로 1~999만 판단하면 됨

        int N = Integer.parseInt(br.readLine());

        // 1~99는 모두 한수 (각 자리를 나눠봐야 두 자리라 비교군이 한 개)
        // e.g. 17 : 6씩 증가하는 등차수열, 86 : 2씩 감소하는 듣차수열
        // c.f. 100 이상부터는 세 자리라 각 자리 수간 비교 필요

        int hansooCnt = 0;

        for(int i = 1; i <= N; i++) {
            if(i > 999) continue;

            if(i < 100) {
                hansooCnt++;
            } else {
                String num = String.valueOf(i);
                String[] numArr = num.split("");
                int num1 = Integer.parseInt(numArr[0]);
                int num2 = Integer.parseInt(numArr[1]);
                int num3 = Integer.parseInt(numArr[2]);

                int num1num2Gap = num2 - num1;
                int num2num3Gap = num3 - num2;

                if(num1num2Gap == num2num3Gap) {
                    //System.out.println("num : " + num);
                    hansooCnt++;
                }
            }
        }

        System.out.println("result : " + hansooCnt);

        br.close();
    }
}

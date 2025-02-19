package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class Math_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input : 식
        // 식은 0~9, +, - 로 이루어져있고 처음과 마지막은 숫자
        // 수는 0으로 시작할 수 있음
        // 괄호를 적절히 쳐서 최소값 출력

        // - 값 뒤 + 값들의 합이 음수가 되어야 함
        // e.g. 55-50+40 => 55-(50+40)
        // - 뒤부터 괄호 시작, - 나오면 괄호 종료 또는 마지막 숫자면 괄호 종료

        String format = br.readLine();

        // 1. 식에 "-"가 포함된 경우
        // 2. 식에 "-"가 포함되지 않는 경우

        int result = 0;
        if(format.contains("-")) {
            int plusSum = 0;
            int minusSum = 0;
            StringTokenizer tokens = new StringTokenizer(format, "-", true); // - 포함 토큰 리턴

            while(tokens.hasMoreTokens()) {
                String token = tokens.nextToken();

                if(token.equals("-")) {
                    // - 이면 다음 토큰 합 계산 후 minus 합에 더하기
                    minusSum += calculate(tokens.nextToken());
                } else {
                    // - 이 아니면 토큰 합 계산 후 plus 합에 더하기
                    plusSum += calculate(token);
                }
            }

            result = plusSum - minusSum;
        } else {
            int plusSum = 0;
            StringTokenizer tokens = new StringTokenizer(format, "+");

            while(tokens.hasMoreTokens()) {
                plusSum += Integer.parseInt(tokens.nextToken());
            }

            result = plusSum;
        }

        bw.write("" + result);

        br.close();
        bw.close();
    }

    private static int calculate(String token) {
        if(token.contains("+")) {
            StringTokenizer plusTokens = new StringTokenizer(token, "+");

            int plusTokenSum = 0;
            while(plusTokens.hasMoreTokens()) {
                plusTokenSum += Integer.parseInt(plusTokens.nextToken());
            }

            return plusTokenSum;
        } else {
            return Integer.parseInt(token);
        }
    }
}

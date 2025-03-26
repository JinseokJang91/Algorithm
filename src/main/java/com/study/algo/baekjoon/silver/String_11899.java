package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class String_11899 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 괄호가 열린 후, 괄호가 닫힐 때 열린 괄호와 닫힌 괄호의 개수가 같아야 함.

        String[] inputs = br.readLine().split("");

        int incorrectBracketCount = 0;
        int bracketCalculate = 0;
        for(String bracket : inputs) {
            // 괄호가 열리지 않은 상태인 경우
            if(bracketCalculate == 0) {
                if(")".equals(bracket)) {
                    // 올바르지 않은 괄호(닫힌 괄호) 등장 시 따로 카운팅
                    incorrectBracketCount++;
                } else if("(".equals(bracket)) {
                    // 열린 괄호 등장 시 + 1
                    bracketCalculate++;
                }
            // 괄호가 열려있는 상태인 경우
            } else {
                if(")".equals(bracket)) {
                    // 닫힌 괄호 등장 시 - 1
                    // 결과가 0이되면 다시 올바르지 않은 괄호 체크부터 시작됨
                    bracketCalculate--;
                } else if("(".equals(bracket)) {
                    // 열린 괄호 등장 시 + 1
                    bracketCalculate++;
                }
            }
        }

//        System.out.println("incorrectBracketCount = " + incorrectBracketCount);
//        System.out.println("bracketCalculate = " + bracketCalculate);

        bw.write("" + (incorrectBracketCount + bracketCalculate));

        bw.flush();
        bw.close();
        br.close();
    }
}

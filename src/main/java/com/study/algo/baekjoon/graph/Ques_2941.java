package com.study.algo.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ques_2941 {
    static int count = 0; // 크로아티아 알파벳 카운트
    static String input;
    static String[] croatiaAlphabets = new String[] {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) throws IOException {
        /*
        * 크로아티아 알파벳 6개
        * c=
        * c-
        * dz=
        * d-
        * lj
        * nj
        * s=
        * z=
        * */

        // 크로아티아 알파벳 외에는 한 글자씩 세기
        // "dz="와 "z="만 유의해서 체크 => "dz=" 먼저 체크
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();

        for(String alpha : croatiaAlphabets) {
            dfsRecursive(alpha);
        }

        System.out.println(count + input.replace("#", "").length());

        br.close();
    }

    private static void dfsRecursive(String alpha) {
        // 제시된 크로아티아 알파벳을 포함하고 있지 않으면 return
        if(!input.contains(alpha)) {
            return;
        }

        // 크로아티아 알파벳 카운트 ++
        count++;
        // 입력값에 포함된 첫 번째 크로아티아 알파벳을 "#"으로 치환 (방문 표시)
        // => 입력값에 특정 크로아티아 알파벳이 여러 개 있는 케이스가 존재하므로 첫 번째만 치환
        input = input.replaceFirst(alpha, "#"); // # : visited

        dfsRecursive(alpha);
    }
}

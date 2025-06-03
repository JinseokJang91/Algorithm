package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Implementation_1251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 주어진 단어를 임의로 세 개의 작은 단어로 나눈 후 각 단어를 뒤집은 후 합친다.
        // 처리 결과 중 사전 순으로 가장 앞서는 단어를 출력

        // 단어에 포함된 알파벳 중 사전 순으로 앞서는 단어를 최대한 앞에 위치 시켜야 함
        // e.g. mobitel => b, e가 사전 순으로 앞서는 알파벳
        // mob | ite | l 로 자른 뒤 뒤집으면 bom | eti | l
        // 결과는 bometil

        String input = br.readLine();
        List<String> words = new ArrayList<>();

        for(int i = 1; i < input.length(); i++) {
            for(int j = i + 1; j < input.length(); j++) {
                words.add(getReverseWord(input, i, j));
            }
        }
        words.sort(Comparator.naturalOrder());

        bw.write(words.get(0));
        bw.flush();
        bw.close();
        br.close();
    }

    private static String getReverseWord(String word, int idx1, int idx2) {
        StringBuilder word1 = new StringBuilder(word.substring(0, idx1));
        StringBuilder word2 = new StringBuilder(word.substring(idx1, idx2));
        StringBuilder word3 = new StringBuilder(word.substring(idx2));

        return word1.reverse().append(word2.reverse()).append(word3.reverse()).toString();
    }
}

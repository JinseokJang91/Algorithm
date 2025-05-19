package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.*;

public class DataStructure_1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 가장 많이 팔린 책의 제목 출력
        // => Map : 책 이름, 카운트
        // => List : 사전순 정렬

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> bookMap = new HashMap<>();
        int max = 0;

        for(int i = 0; i < N; i++) {
            String bookName = br.readLine();
            bookMap.put(bookName, bookMap.getOrDefault(bookName, 0) + 1);
            max = Math.max(max, bookMap.get(bookName));
        }

        List<String> bookList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : bookMap.entrySet()) {
            if(entry.getValue() == max) {
                bookList.add(entry.getKey());
            }
        }

        bookList.sort(Comparator.naturalOrder());

        bw.write(bookList.get(0));

        bw.flush();
        bw.close();
        br.close();
    }
}

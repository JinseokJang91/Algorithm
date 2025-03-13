package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.*;

public class Math_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // headgear - hat, turban, (안입음)
        // eyewear - sunglasses, (안입음)
        // headgear 에서 하나 추출 => 3C1 = 3*2*1 / 2*1 = 3
        // eyewear 에서 하나 추출 => 2C1 = 2*1 / 1 = 2
        // headgear (안입음), eyewear (안입음) 케이스 1가지 빼야함
        // 6 - 1 = 5

        int T = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < T; i++) {
            Map<String, String> items = new HashMap<>();
            int n = Integer.parseInt(br.readLine());

            for(int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String cloth_name = st.nextToken();
                String cloth_kind = st.nextToken();

                items.put(cloth_kind, items.get(cloth_kind) != null ? items.get(cloth_kind) + "," + cloth_name : cloth_name);
            }

            int cases = getCases(items);

            result.append(cases).append("\n");
        }

        bw.write(result.toString());

        br.close();
        bw.close();
    }

    public static int getCases(Map<String, String> items) {
        int cases = 1;

        for(String key : items.keySet()) {
            String[] names = items.get(key).split(",");

            cases *= (names.length + 1);
        }

        return cases - 1; // 둘 다 (안입음) 케이스 빼야 함
    }
}

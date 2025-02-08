package com.study.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch_1920 {
    static int[] nArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        nArr = new int[N];
        StringTokenizer nSt = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(nSt.nextToken());
        }

        Arrays.sort(nArr); // 오름차순 정렬

        int M = Integer.parseInt(br.readLine());
        StringTokenizer mSt = new StringTokenizer(br.readLine(), " ");
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < M; i++) {
            if(binarySearch(Integer.parseInt(mSt.nextToken())) >= 0) {
                result.append(1).append("\n");
            } else {
                result.append(0).append("\n");
            }
        }
        System.out.println(result);

        br.close();
    }

    private static int binarySearch(int num) {
        int leftIdx = 0; // 왼쪽에서 오른쪽으로 이동하는 인덱스 (첫인덱스)
        int rightIdx = nArr.length - 1; // 오른쪽에서 왼쪽으로 이동하는 인덱스 (끝인덱스)

        while(leftIdx <= rightIdx) {
            int middleIdx = (leftIdx + rightIdx) / 2;

            if(num < nArr[middleIdx]) {
                // 찾으려는 값이 중간값보다 작으면 끝인덱스를 중간인덱스 -1로 변경 후 재검색
                rightIdx = middleIdx - 1;
            } else if(num > nArr[middleIdx]) {
                // 찾으려는 값이 중간값보다 크면 첫인덱스를 중간인덱스 +1로 변경 후 재검색
                leftIdx = middleIdx + 1;
            } else {
                // 값을 찾으면 해당 인덱스 리턴
                return middleIdx;
            }
        }

        // 찾으려는 값과 일치하는 인덱스가 존재하지 않으면 -1 리턴
        return -1;
    }
}

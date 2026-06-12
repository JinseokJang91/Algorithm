package com.study.algo.algorithm.b_sort;

import java.io.*;
import java.util.StringTokenizer;

public class C_InsertionSort {
    public static void main(String[] args) throws IOException {
        // 삽입 정렬
        // 이미 정렬된 데이터 범위에 정렬되지 않은 데이터를 적절한 위치에 삽입시켜 정렬하는 방식

        // 백준 11399번 ATM
        // 오름차순으로 정렬하면 시간의 합이 최솟값임

        // 1. 슈도코드 작성
        // 사람의 수 N 입력 받기
        // 각 사람의 돈 인출 시간을 입력 받고 배열 times 에 삽입하기
        // 누적 시간의 합 변수 totalTime 초기화
        // for(1 ~ N-1 까지 증가)
        // {
        //    선택한 데이터 값 targetTime 변수에 times[i] 삽입
        //    for(i-1 ~ 0 까지 감소 + times[j] > targetTime) // targetTime이 비교값보다 작은 경우에만 shift 작업 진행 가능
        //    {
        //       times[j + 1] = times[j] // 삽입 위치를 찾았으므로 해당 인덱스 값을 오른쪽으로 shift
        //    }
        //    times[j] = targetTime // 삽입 위치에 targetTime 삽입
        // }
        // 배열 합 계산
        // 오름차순이므로 0 ~ N-1까지 차례대로 합을 누적시킨다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] times = new int[N];

        for(int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N; i++) {
            int targetTime = times[i];
            int insertIndex = i;

            for(int j = i - 1; j >= 0 && times[j] > targetTime; j--) {
                times[j + 1] = times[j];
                insertIndex = j;
            }
            times[insertIndex] = targetTime;

            // 배열 변화 확인
//            for(int k : times) {
//                System.out.print(k + " ");
//            }
//            System.out.println();
        }

        int minTimeSum = 0;
        int length = N;
        for(int i = 0; i < N; i++) {
            // 만약 정렬 결과(예제)가 1 2 3 3 4 이면,
            // 시간의 합은 1x5 + 2x4 + 3x3 + 3x2 + 4x1 로 나타낼 수 있음
            int sum = length-- * times[i];
            minTimeSum += sum;
        }

        bw.write("" + minTimeSum);
        br.close();
        bw.close();
    }
}

package com.study.algo.programmers.allProblems.lv2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LV2_04 {
    public static void main(String[] args) throws Exception {
        // 투 포인터

        // 백준 1940번 주몽의 명령
        // N의 최대 범위가 15,000이므로 O(nlogn) 시간복잡도 사용 가능

        // 1. 풀이
        // (1) 오름차순 정렬 -> 정렬은 nlogn 시간복잡도
        // (2) 투포인터 사용

        // 2. 슈도코드 작성
        // N(재료 개수), M(갑옷이 되는 번호) 저장
        // for(N만큼 반복)
        // { 재료 배열 저장하기 }
        // 재료 배열 정렬하기
        // 인덱스 i, 인덱스 j, 카운트 count 선언하기
        // while(i < j)
        // {
        //   if(재료 합 < M) 작은 번호 재료를 한 칸 위로 변경
        //   else if(재료 합 > M) 큰 번호 재료를 한 칸 아래로 변경
        //   else if(재료 합 == M) 갑옷 완성(카운트 증가), 양쪽 index 변경(max는 한 칸 아래, min은 한 칸 위로)
        // }

        // 3. 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int i = 0;
        int j = N - 1;
        int count = 0;
        while(i < j) {
            int sum = nums[i] + nums[j];
            if(sum == M) {
                count++;
                i++;
                j--;
            } else if(sum > M) {
                j--;
            } else {
                i++;
            }
        }

        bw.write("" + count);
        br.close();
        bw.close();
    }
}

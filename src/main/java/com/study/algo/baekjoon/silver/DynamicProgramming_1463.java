package com.study.algo.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicProgramming_1463 {
    static int N;
    static int[] calculations;

    public static void main(String[] args) throws IOException {
        // 1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
        // 2. X가 2로 나누어 떨어지면, 2로 나눈다.
        // 3. 1을 뺀다.

        // 정수 N이 주어지면 위 세 개의 연산을 적절히 활용해 1을 만들어야 한다.
        // 연산을 사용하는 횟수의 최솟값 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 10의 경우
        // 10 > 5 > 4 > 2 > 1
        // 10 > 9 > 3 > 1
        // 10 > 9 > 8 > 4 > 2 > 1
        // => 즉, 세 개의 연산 중 각 시점마다 적절한 방법을 선택해야 함 (빼기보다 나누기가 우선이 아님)

        // N 이라는 수가 주어질 때 N의 최소 연산 수는 N-1, N/2, N/3 각각의 (최소 연산 수 + 1) 과 같다.
        // 6을 예로 들면
        // (1) 6-1 : 5의 최소 연산 수는 5 > 4 > 2 > 1 로 3번의 연산을 거침 => 결론은 4
        // (2) 6/2 : 3의 최소 연산 수는 3 > 1 로 1번의 연산을 거침 => 결론은 2
        // (3) 6/3 : 2의 최소 연산 수는 2 > 1 로 1번의 연산을 거침 => 결론은 2

        // 각각의 최소 연산 수 비교는
        // (1), (2), (3) 결과값이 5 > 3 > 2 이므로 작은 수를 만들기 위해 (1) -> (2) -> (3) 순서로 진행되어야 함

        calculations = new int[N + 1]; // N을 인덱스로 표시하기 위해 +1

        if(N < 2) {
            System.out.println(0);
        } else {
            for(int i = 2; i <= N; i++) {
                // e.g. 예시는 ":"로 표시 (N이 6일 때)
                // 1. N - 1
                //    : (5의 최소연산수 + 1)
                calculations[i] = calculations[i - 1] + 1;
                // 2. N / 2 (N % 2 == 0)
                //    : {1에서 구한 (5의 최소연산수 + 1)과 (3의 최소연산수 + 1) 중 최소값}
                calculations[i] = i % 2 == 0 ? Math.min(calculations[i], calculations[i / 2] + 1) : calculations[i];
                // 3. N / 3 (N % 3 == 0)
                //    : [2에서 구한 {1에서 구한 (5의 최소연산수 + 1)과 (3의 최소연산수 + 1) 중 최소값}과 (2의 최소연산수 + 1) 중 최소값]
                calculations[i] = i % 3 == 0 ? Math.min(calculations[i], calculations[i / 3] + 1) : calculations[i];
            }

            System.out.println(calculations[N]);
        }

        br.close();
    }
}

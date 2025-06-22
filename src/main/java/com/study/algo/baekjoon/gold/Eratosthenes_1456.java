package com.study.algo.baekjoon.gold;

import java.io.*;
import java.util.StringTokenizer;

public class Eratosthenes_1456 {
    private static long A;
    private static long B;
    private static boolean[] isPrimeNumber;
    private static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 거의 소수 : 어떤 수가 소수의 N제곱 (N >= 2)
        // A보다 크거나 같고, B보다 작거나 같은 거의 소수 개수 구하기

        StringTokenizer st  = new StringTokenizer(br.readLine(), " ");
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        int limit = (int) Math.sqrt(B);
        isPrimeNumber = new boolean[limit + 1];
        for(int i = 2; i <= limit; i++) {
            isPrimeNumber[i] = true;
        }

        checkPrimeNumberTrueFalse();

        countAlmostPrimeNumbers();

        bw.write("" + count);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void checkPrimeNumberTrueFalse() {
        for(int i = 2; i < isPrimeNumber.length; i++) {
            // i가 소수가 아니면 다음 i 확인
            if(!isPrimeNumber[i]) {
                continue;
            }

            // i가 소수이면 i의 배수는 소수가 아님 처리(false)
            // => 초기에 나오는 2, 3, ... 이 소수이기 때문에 바로 필터링 처리
            for(int j = i * 2; j < isPrimeNumber.length; j += i) {
                isPrimeNumber[j] = false;
            }
        }
    }

    private static void countAlmostPrimeNumbers() {
        for(int i = 2; i < isPrimeNumber.length; i++) {
            if(isPrimeNumber[i]) {
                int pow = 2; // 2제곱부터 시작
                while(true) {
                    long powNum = (long) Math.pow(i, pow);
                    if(powNum >= A && powNum <= B) {
                        count++;
                        pow++;
                    } else {
                        if(powNum < B) {
                            pow++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }
}

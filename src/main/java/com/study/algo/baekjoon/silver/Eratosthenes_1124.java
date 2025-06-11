package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Eratosthenes_1124 {
    private static List<Integer> primeNumbers;
    private static boolean[] isPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 언더프라임 : 어떤 수 X를 소인수분해하여 구한 소수의 목록의 길이가 소수이면, 그 수를 언더프라임이라고 함
        // 두 정수 A, B가 주어졌을 때, A보다 크거나 같고, B보다 작거나 같은 정수 중에서 언더프라임인 것의 개수를 구하기

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        primeNumbers = new ArrayList<>();
        isPrime = new boolean[100001]; // list.contains 쓰면 성능 저하되서 시간 초과 발생. 배열에 소수 여부 따로 저장
        for(int i = 2; i <= B; i++) {
            primeNumbers.add(i);
        }

        makePrimeNumbers(0);

        int result = 0;
        for(int i = A; i <= B; i++) {
            int count = countPrimeNumber(i);
            boolean isPrimeNumber = checkCountIsPrimeNumber(count);

            if(isPrimeNumber) result++;
        }

        bw.write("" + result);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void makePrimeNumbers(int startIdx) {
        if(startIdx == primeNumbers.size() - 1) {
            return;
        }

        int primeNumber = primeNumbers.get(startIdx);
        isPrime[primeNumber] = true;

        for(int i = startIdx + 1; i < primeNumbers.size(); i++) {
            if(primeNumbers.get(i) % primeNumber == 0) {
                primeNumbers.remove(i);
            }
        }

        makePrimeNumbers(startIdx + 1);
    }

    private static int countPrimeNumber(int number) {
        int idx = 0;
        int count = 0;
        while(idx < primeNumbers.size()) {
            if(number % primeNumbers.get(idx) == 0) {
                number /= primeNumbers.get(idx);
                count++;
            } else {
                if(isPrime[number]) {
                    count++;
                    break;
                } else {
                    idx++;
                }
            }

            if(isPrime[number]) {
                count++;
                break;
            }
        }

        return count;
    }

    private static boolean checkCountIsPrimeNumber(int count) {
        return isPrime[count];
    }
}

package com.study.algo.baekjoon.gold;

import java.io.*;
import java.util.StringTokenizer;

public class DynamicProgramming_1082 {
    private static int N;
    private static int M;
    private static Integer[] P;
    private static StringBuilder biggestRoomNumber;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        biggestRoomNumber = new StringBuilder();

        // N : 판매하는 숫자 0 ~ N-1
        // P0, P1, ... , Pn : 각 숫자의 가격
        // M : 주어진 돈

        // M원을 최대로 사용해서 만들 수 있는 가장 큰 방 번호 구하기

        N = Integer.parseInt(br.readLine());
        P = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        // 인덱스
        // 가진 돈
        findBiggestRoomNumber();

        bw.write(biggestRoomNumber.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    private static void findBiggestRoomNumber() {
        // 가장 큰 방 번호는 자릿수가 많을수록 커짐
        // => 자릿수는 가장 작은 가격으로 살 수 있는 번호의 개수
        // => 단, 첫 번째 번호는 0보다 큰 숫자여야 함 (0 숫자에 달려있는 가격은 제외해서 생각해야 함)

        int cheapestRoomAmount = 51;
        int cheapestRoomNumber = 11;
        for(int i = 1; i < N; i++) {
            if(P[i] < cheapestRoomAmount) {
                cheapestRoomAmount = P[i];
                cheapestRoomNumber = i;
            }
        }

        if(M < cheapestRoomAmount) {
            biggestRoomNumber.append("0");
            return;
        }

        int digit = P[0] > cheapestRoomAmount ? M / cheapestRoomAmount : (M - cheapestRoomAmount) / P[0] + 1;

        int[] tmpRoomNumbers = new int[digit];
        int tmpMoney = 0;
        if(P[0] < cheapestRoomAmount) {
            tmpRoomNumbers[0] = cheapestRoomNumber;
            tmpMoney += cheapestRoomAmount;

            for(int i = 1; i < digit; i++) {
                tmpRoomNumbers[i] = 0;
                tmpMoney += P[0];
            }
        } else {
            for(int i = 0; i < digit; i++) {
                tmpRoomNumbers[i] = cheapestRoomNumber;
                tmpMoney += cheapestRoomAmount;
            }
        }

        for(int i = 0; i < tmpRoomNumbers.length; i++) {
            int idx = tmpRoomNumbers[i];
            for(int j = P.length - 1; j >= 0; j--) {
                tmpMoney -= P[idx];

                if(tmpMoney + P[j] <= M && tmpRoomNumbers[i] < j) {
                    tmpMoney += P[j];
                    tmpRoomNumbers[i] = j;
                    break;
                } else {
                    tmpMoney += P[idx];
                }
            }
        }

        for(int i : tmpRoomNumbers) {
            biggestRoomNumber.append(i);
        }
    }
}

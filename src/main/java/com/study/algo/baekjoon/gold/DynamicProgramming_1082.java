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

        int cheapestRoomAmount = 51; // 1 <= M <= 50
        int cheapestRoomNumber = 11; // 1 <= N <= 10
        for(int i = 1; i < N; i++) {
            // 방 번호 0 제외하고 가장 저렴한 숫자 찾기
            if(P[i] < cheapestRoomAmount) {
                cheapestRoomAmount = P[i];
                cheapestRoomNumber = i;
            }
        }

        if(M < cheapestRoomAmount) {
            // 방 번호 0 제외한 숫자 중 가장 저렴한 숫자의 가격이 가진 돈보다 크면 방 번호는 0만 가능
            biggestRoomNumber.append("0");
            return;
        }

        // 방 번호 0 가격 > 그외 가장 저렴한 숫자 가격 => 방 번호 최대 자릿수 : 가진 돈 / 가장 저렴한 숫자 가격
        // 방 번호 0 가격 <= 그외 가장 저렴한 숫자 가격 => 방 번호 최대 자릿수 : (가진 돈 - 가장 저렴한 숫자 가격) / 방 번호 0 가격 + 1
        // => + 1 이 붙는 이유는 0이 맨 앞자리에 올 수 없기 때문 (cheapestRoomNumber 제일 앞자리 고정, 위 식은 그외 나머지 자릿수를 구하는 식)
        int digit = P[0] > cheapestRoomAmount ? M / cheapestRoomAmount : (M - cheapestRoomAmount) / P[0] + 1;

        int[] tmpRoomNumbers = new int[digit]; // 임시 방 번호
        int tmpMoney = 0; // 임시 총 사용 금액

        // [CASE 1] 방 번호 0 가격 < 그외 가장 저렴한 숫자 가격
        // => 맨 앞자리 제외하고 0으로 세팅
        if(P[0] < cheapestRoomAmount) {
            tmpRoomNumbers[0] = cheapestRoomNumber;
            tmpMoney += cheapestRoomAmount;

            for(int i = 1; i < digit; i++) {
                tmpRoomNumbers[i] = 0;
                tmpMoney += P[0];
            }
        // [CASE 2] 방 번호 0 가격 >= 그외 가장 저렴한 숫자 가격
        // => 그외 가장 저렴한 숫자로 세팅 (최대 방 번호를 구하는 것이므로 0으로 세팅 필요없음)
        } else {
            for(int i = 0; i < digit; i++) {
                tmpRoomNumbers[i] = cheapestRoomNumber;
                tmpMoney += cheapestRoomAmount;
            }
        }

        // 첫째 자리부터 다른 방 번호로 교체 가능한 지 가격 비교
        // => 첫째 자리가 가장 큰 자릿수 숫자이므로 첫째 자리부터 비교해야 함
        // => 방 번호는 큰 숫자부터 가격 비교하면 되므로 역순으로 조회
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

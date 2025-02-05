package com.study.algo.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ques_1436 {
    static List<String> resultList;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 종말의 수 : 6이 적어도 3개 이상 연속으로 들어가는 수
        // N번째 영화의 제목에 들어가는 수 출력
        N = Integer.parseInt(br.readLine());

        /* 브루트포스 */

        //sol1();

        sol2();

        br.close();
    }

    public static void sol1() {
        // 666이 제일 작은 수 => 666부터 시작
        int theEndNumber = 666;
        int cnt = 0;

        resultList = new ArrayList<>();

        while(N != cnt) {
            theEndNumber++;

            String endNumberToString = String.valueOf(theEndNumber);

            if(endNumberToString.contains("666")) {
                cnt++;
                resultList.add(String.valueOf(theEndNumber));
            }
        }

        System.out.println(resultList);
        System.out.println(theEndNumber - 1);
    }

    public static void sol2() {
        // 다른 해결방법 정리 : https://st-lab.tistory.com/103

        // 순서대로 나열해보자.
        // 4자리 : 1666, 2666, 3666, 4666, 5666, 6660, 6661, ... , 6669, 7666, ...
        // 5자리 : 10666, 11666, 12666, 13666, 14666, 15666, 16660, 16661, ... , 16669, 17666, ...
        // 5자리 : 60666, 61666, 62666, 63666, 64666, 65666, 66600, 66601, ... , 66659, 66660, ...

        // 어떻게 처리할 지 순서로 나타내보자.
        // 1666 -> 2666 -> 3666 -> ... -> 6660 인 시점에 반복문을 통해 0~9까지 count 증가
        // 이후에는 똑같이 7666 -> 8666 -> 9666 -> 10666 -> ... -> 66600 인 시점에 반복문을 통해 0~99까지 count 증가

        // 선수 자릿수만 생각해서 나열해보자.
        // 1 -> 2 -> 3 -> ... -> 6 인 시점에 반복문 실행 (크기 10)
        // 9 -> 10 -> ... -> 66 인 시점에 반복문 실행 (크기 100)

        // 이와 같이 선수 자릿수(pre_digit)의 케이스 별로 조건 처리!!! (여기선 7자리까지만 체크하고 있음)

        // [조건 별 정리]
        // 5번 - 일반 케이스 : 1_666, 2_666, 22_666, 24_666 등
        // 4번 - 선수 자릿수를 10으로 나눈 나머지가 6으로 끝나는 케이스 : 6_660, 16_663, 26_669 등
        // => 선수자릿수 * 1000 + (크기 10 반복문을 통해 돌리다 N번째 값 추출)
        // 3번 - 선수 자릿수를 100으로 나눈 나머지가 66으로 끝나는 케이스 : 66_600, 166_600, 266_623 등
        // => 선수자릿수 * 1000 + (크기 100 반복문을 통해 돌리다 N번째 값 추출)
        // 2번 - 선수 자릿수를 1000으로 나눈 나머지가 666으로 끝나는 케이스 : 666_000, 1666_004, 2666_797 등
        // => 선수자릿수 * 1000 + (크기 1000 반복문을 통해 돌리다 N번째 값 추출)
        // 1번 - 선수 자릿수를 10000으로 나눈 나머지를 10으로 나눈 몫이 666인 케이스 (단, 선수 자릿수는 6으로 끝나지 않아야 함)
        //       : 6661_123, 6669_003, 6664_445 등 (단, 6666_123은 불가)
        // => 제약조건의 필터링을 위해 선수 자릿수를 10으로 나눈 나머지가 6이 아니어야 한다는 조건 추가
        // => => 선수자릿수 * 1000 + (크기 1000 반복문을 통해 돌리다 N번째 값 추출)

        if(N > 1) {
            sol2_detail(N);
        } else {
            System.out.println(666);
        }
    }

    public static void sol2_detail(int n) {
        int count = 1; // 666을 이미 셌기 때문에 1로 세팅
        int prev_digit = 0; // 선수 자릿수
        int num = 0; // 선수 자릿수를 제외한 나머지 뒷자릿수

        while(true) {
            // 1. 선수 자릿수가 X...666X 이면서 X...6666 이 아닐 경우 (ex. 6660_000, 6660_001, ...)
            if (((prev_digit % 10000) / 10) == 666 && prev_digit % 10 != 6) {
                for (int i = 0; i < 1000; i++) {
                    if (count == n) {
                        System.out.print(prev_digit * 1000 + num);
                        return;
                    }
                    num++;
                    count++;
                }
                prev_digit++;
            }

            // 2. 선수 자릿수가 X...666 일 경우 (ex. 666_000, 1666_004, ...)
            else if (prev_digit % 1000 == 666) {
                num = 0;
                for (int i = 0; i < 1000; i++) {

                    if (count == n) {
                        System.out.print(prev_digit * 1000 + num);
                        return;
                    }
                    count++;
                    num++;
                }
                prev_digit++;
            }

            // 3. 선수 자릿수가 X...66 일 경우 (ex. 66_600, 166_600, ...)
            else if (prev_digit % 100 == 66) {
                num = 600;
                for (int i = 0; i < 100; i++) {
                    if (count == n) {
                        System.out.print(prev_digit * 1000 + num);
                        return;
                    }
                    count++;
                    num++;
                }
                prev_digit++;

            }


            // 4. 선수 자릿수가 X...6 일 경우 (ex. 6_660, 16_663, ...)
            else if (prev_digit % 10 == 6) {
                num = 660;
                for (int i = 0; i < 10; i++) {
                    if (count == n) {
                        System.out.print(prev_digit * 1000 + num);
                        return;
                    }
                    num++;
                    count++;
                }
                prev_digit++;
            }

            // 5. 그 외의 경우 (ex. 241_666, 23_666 ...)
            else {
                num = 666;
                if (count == n) {
                    System.out.print(prev_digit * 1000 + num);
                    return;
                }
                count++;
                prev_digit++;
            }
        }
    }
}

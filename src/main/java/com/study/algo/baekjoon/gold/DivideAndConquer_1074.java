package com.study.algo.baekjoon.gold;

import java.io.*;
import java.util.StringTokenizer;

public class DivideAndConquer_1074 {
    static int N;
    static int r;
    static int c;
    static int count;
    static int x;
    static int y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // N = 3일 때, 아래와 같이 4사분면으로 나뉨
        // 0  1  4  5  │ 16 17 20 21
        // 2  3  6  7  │ 18 19 22 23
        // 8  9  12 13 │ 24 25 28 29
        // 10 11 14 15 │ 26 27 30 31
        // ────────────│────────────
        // 32 33 36 37 │ 48 49 52 53
        // 34 35 38 39 │ 50 51 54 55
        // 40 41 44 45 │ 56 57 60 61
        // 42 43 46 47 │ 58 59 62 63

        // 이거를 크~~게
        // 1사분면 │ 2사분면
        // ───────│───────
        // 3사분면 │ 4사분면
        // 으로 나누어졌다고 생각하자.

        // ----------------------------------

        // N = 2일 때, 아래와 같이 4사분면으로 나뉨
        // 0  1  │ 4  5
        // 2  3  │ 6  7
        // ──────│───────
        // 8  9  │ 12 13
        // 10 11 │ 14 15

        // 이것도 크~게
        // 1사분면 │ 2사분면
        // ───────│───────
        // 3사분면 │ 4사분면
        // 으로 나누어졌다고 생각하자.

        // ----------------------------------

        // N = 1일 때, 아래와 같이 4사분면으로 나뉨
        // 0 │ 1
        // ──│──
        // 2 │ 3

        // 이것도
        // 1사분면 │ 2사분면
        // ───────│───────
        // 3사분면 │ 4사분면
        // 으로 나누어졌다고 생각하자.

        // ----------------------------------

        // sol)
        // 1. N이 주어지면 2^N-1 크기로 사분면이 나뉘므로 시작은 2^N-1 부터 시작한다.
        // 2. 좌표가 위치하는 사분면을 찾는다.
        //      1사분면이면 0
        //      2사분면이면 1
        //      3사분면이면 2
        //      4사분면이면 3
        //      카운트는 주어진 사각형의 [가로 x 세로 x 사분면 별 숫자]를 더한다.
        // 3. 사각형 크기를 줄인다. (단, 줄였을 때 1이면 마지막으로 사분면 위치를 찾고 카운트를 더한 후 리턴한다.)
        //      1이 나올 때까지 2번을 반복한다.

        // (참고)
        // [가로 x 세로 x 사분면 별 숫자] 식이 나오는 이유
        // N = 2일 때, 각 사분면의 시작 번호를 보면 0, 4,  8,  12 => (2^N * 2^N * 각 사분면 별 번호)
        // N = 3일 때, 각 사분면의 시작 번호를 보면 0, 16, 32, 48 => (2^N * 2^N * 각 사분면 별 번호)

        divideAndConquer((int)Math.pow(2, N - 1), r, c);
        // 2의 지수승, x좌표, y좌표

        bw.write("" + count);

        br.close();
        bw.close();
    }

    private static void divideAndConquer(int squareLength, int row, int col) {
        // 1. 1사분면에 위치
        if(row < x + squareLength && col < y + squareLength) {
            count += squareLength * squareLength * 0;
        // 2. 2사분면에 위치
        } else if(row < x + squareLength && col >= y + squareLength) {
            count += squareLength * squareLength * 1;

            // 2사분면으로 이동해서 다시 진행해야 하므로 중심 좌표를 더한다.
            y += squareLength;
        // 3. 3사분면에 위치
        } else if(row >= x + squareLength && col < y + squareLength) {
            count += squareLength * squareLength * 2;

            // 3사분면으로 이동해서 다시 진행해야 하므로 중심 좌표를 더한다.
            x += squareLength;
        // 4. 4사분면에 위치
        } else if(row >= x + squareLength && col >= y + squareLength) {
            count += squareLength * squareLength * 3;

            // 4사분면으로 이동해서 다시 진행해야 하므로 중심 좌표를 더한다.
            x += squareLength;
            y += squareLength;
        }

        if(squareLength > 1) {
            divideAndConquer(squareLength / 2, row, col);
        }
    }
}

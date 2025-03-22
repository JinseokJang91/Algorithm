package com.study.algo.baekjoon.gold;

import java.io.*;
import java.util.StringTokenizer;

public class Geometry_11758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 기하학 알고리즘 CCW(CounterClockWise)
        // 벡터의 외적 활용 (P1:A, P2:B, P3:C 가정)
        // A -> B -> C 순서로 발생하므로 벡터는 아래와 같이 생성
        // ------------------
        // ->  ->
        // AB  BC
        // ------------------
        // => 벡터 AB와 벡터 BC 외적 진행 (양수 : 반시계, 음수 : 시계, 0 : 일직선)

        // e.g. 예제 1 (1,1), (5,5), (7,3)
        // 벡터 AB : (5-1, 5-1) = (4, 4)
        // 벡터 BC : (7-5, 3-5) = (2, -2)
        // 벡터 AB X 벡터 BC
        // | a b | => | (x2-x1) (y2-y1) | => | 4  4 |
        // | c d |    | (x3-x2) (y3-y2) |    | 2 -2 |
        // => a*d - b*c = (y3-y2)*(x2-x1) - (x3-x2)*(y2-y1) = 4*-2 - 4*2 = -16

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        P p1 = new P(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine(), " ");
        P p2 = new P(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine(), " ");
        P p3 = new P(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        // 공식 : (y3-y2)*(x2-x1) - (x3-x2)*(y2-y1)
        int result = (p3.y - p2.y) * (p2.x - p1.x) - (p3.x - p2.x) * (p2.y - p1.y);

        if(result > 0) {
            bw.write("1");
        } else if(result < 0) {
            bw.write("-1");
        } else {
            bw.write("0");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class P {
        private final int x;
        private final int y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "P{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}

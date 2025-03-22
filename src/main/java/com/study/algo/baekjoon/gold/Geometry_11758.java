package com.study.algo.baekjoon.gold;

import java.io.*;
import java.util.StringTokenizer;

public class Geometry_11758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2차원 평면 위 좌표 P1, P2, P3를 이은 선분의 방향 : 시계(-1), 반시계(1), 일직선(0)
        // P1(x1,y1), P2(x2,y2), P3(x3,y3)이라 가정하면
        // P1, P2 간 변화인 dy/dx = y2-y1 / x2-x1 임
        // P3가 dy/dx를 사용해서 구했을 때 도출되는 값이면 일직선

        // 1. 일직선
        // (1) x1 = x2 = x3
        // (2) y1 = y2 = y3
        // (3) dy/dx 적용 시 도출 가능값
        // 2. 시계 (기본 형태는 8가지, 세부 방향 나누면 케이스 별 3가지 => 총 24가지)
        // (1) y2 - y1 > 0 && x2 - x1 = 0 >>> x3 - x2 > 0
        // (2) y2 - y1 > 0 && x2 - x1 > 0 >>> x3 - x2 > 0 또는 y3 - y2 < 0
        // (3) y2 - y1 = 0 && x2 - x1 > 0 >>> y3 - y2 < 0
        // (4) y2 - y1 < 0 && x2 - x1 > 0 >>> x3 - x2 < 0 또는 y3 - y2 < 0
        // (5) y2 - y1 < 0 && x2 - x1 = 0 >>> x3 - x2 < 0
        // (6) y2 - y1 = 0 && x2 - x1 < 0 >>> y3 - y2 > 0
        // (7) y2 - y1 < 0 && x2 - x1 < 0 >>> x3 - x2 < 0 또는 y3 - y2 > 0
        // (8) y2 - y1 > 0 && x2 - x1 < 0 >>> x3 - x2 > 0 또는 y3 - y2 > 0
        // 3. 반시계
        // (1) y2 - y1 > 0 && x2 - x1 = 0 >>> x3 - x2 < 0
        // (2) y2 - y1 > 0 && x2 - x1 > 0 >>> x3 - x2 < 0 또는 y3 - y2 > 0
        // (3) y2 - y1 = 0 && x2 - x1 > 0 >>> y3 - y2 > 0
        // (4) y2 - y1 < 0 && x2 - x1 > 0 >>> x3 - x2 > 0 또는 y3 - y2 > 0
        // (5) y2 - y1 < 0 && x2 - x1 = 0 >>> x3 - x2 > 0
        // (6) y2 - y1 = 0 && x2 - x1 < 0 >>> y3 - y2 < 0
        // (7) y2 - y1 < 0 && x2 - x1 < 0 >>> x3 - x2 > 0 또는 y3 - y2 < 0
        // (8) y2 - y1 > 0 && x2 - x1 < 0 >>> x3 - x2 < 0 또는 y3 - y2 < 0
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        P P1 = new P(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine(), " ");
        P P2 = new P(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine(), " ");
        P P3 = new P(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        System.out.println("P1 = " + P1);
        System.out.println("P2 = " + P2);
        System.out.println("P3 = " + P3);

        boolean isStraightLine = checkStraightLine(P1, P2, P3);
        boolean isClockwise = checkClockwise(P1, P2, P3);
        boolean isCounterClockwise = checkCounterClockwise(P1, P2, P3);
        System.out.println("isStraightLine = " + isStraightLine);
        System.out.println("isClockwise = " + isClockwise);
        System.out.println("isCounterClockwise = " + isCounterClockwise);

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean checkCounterClockwise(P p1, P p2, P p3) {
        // (1) y2 - y1 > 0 && x2 - x1 = 0 >>> x3 - x2 < 0
        if(p2.y - p1.y > 0 && p2.x - p1.x == 0) {
            if(p3.x - p2.x < 0) {
                return true;
            }
        }
        // (2) y2 - y1 > 0 && x2 - x1 > 0 >>> x3 - x2 < 0 또는 y3 - y2 > 0
        else if(p2.y - p1.y > 0 && p2.x - p1.x > 0) {
            if(p3.x - p2.x < 0 || p3.y - p2.y > 0) {
                return true;
            }
        }
        // (3) y2 - y1 = 0 && x2 - x1 > 0 >>> y3 - y2 > 0
        else if(p2.y - p1.y == 0 && p2.x - p1.x > 0) {
            if(p3.y - p2.y > 0) {
                return true;
            }
        }
        // (4) y2 - y1 < 0 && x2 - x1 > 0 >>> x3 - x2 > 0 또는 y3 - y2 > 0
        else if(p2.y - p1.y < 0 && p2.x - p1.x > 0) {
            if(p3.x - p2.x > 0 || p3.y - p2.y > 0) {
                return true;
            }
        }
        // (5) y2 - y1 < 0 && x2 - x1 = 0 >>> x3 - x2 > 0
        else if(p2.y - p1.y < 0 && p2.x - p1.x == 0) {
            if(p3.x - p2.x > 0) {
                return true;
            }
        }
        // (6) y2 - y1 = 0 && x2 - x1 < 0 >>> y3 - y2 < 0
        else if(p2.y - p1.y == 0 && p2.x - p1.x < 0) {
            if(p3.y - p2.y < 0) {
                return true;
            }
        }
        // (7) y2 - y1 < 0 && x2 - x1 < 0 >>> x3 - x2 > 0 또는 y3 - y2 < 0
        else if(p2.y - p1.y < 0 && p2.x - p1.x < 0) {
            if(p3.x - p2.x > 0 || p3.y - p2.y < 0) {
                return true;
            }
        }
        // (8) y2 - y1 > 0 && x2 - x1 < 0 >>> x3 - x2 < 0 또는 y3 - y2 < 0
        else if(p2.y - p1.y > 0 && p2.x - p1.x < 0) {
            if(p3.x - p2.x < 0 || p3.y - p2.y < 0) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkClockwise(P p1, P p2, P p3) {
        // (1) y2 - y1 > 0 && x2 - x1 = 0 >>> x3 - x2 > 0
        if(p2.y - p1.y > 0 && p2.x - p1.x == 0) {
            if(p3.x - p2.x > 0) {
                return true;
            }
        }
        // (2) y2 - y1 > 0 && x2 - x1 > 0 >>> x3 - x2 > 0 또는 y3 - y2 < 0
        else if(p2.y - p1.y > 0 && p2.x - p1.x > 0) {
            if(p3.x - p2.x > 0 || p3.y - p2.y < 0) {
                return true;
            }
        }
        // (3) y2 - y1 = 0 && x2 - x1 > 0 >>> y3 - y2 < 0
        else if(p2.y - p1.y == 0 && p2.x - p1.x > 0) {
            if(p3.y - p2.y < 0) {
                return true;
            }
        }
        // (4) y2 - y1 < 0 && x2 - x1 > 0 >>> x3 - x2 < 0 또는 y3 - y2 < 0
        else if(p2.y - p1.y < 0 && p2.x - p1.x > 0) {
            if(p3.x - p2.x < 0 || p3.y - p2.y < 0) {
                return true;
            }
        }
        // (5) y2 - y1 < 0 && x2 - x1 = 0 >>> x3 - x2 < 0
        else if(p2.y - p1.y < 0 && p2.x - p1.x == 0) {
            if(p3.x - p2.x < 0) {
                return true;
            }
        }
        // (6) y2 - y1 = 0 && x2 - x1 < 0 >>> y3 - y2 > 0
        else if(p2.y - p1.y == 0 && p2.x - p1.x < 0) {
            if(p3.y - p2.y > 0) {
                return true;
            }
        }
        // (7) y2 - y1 < 0 && x2 - x1 < 0 >>> x3 - x2 < 0 또는 y3 - y2 > 0
        else if(p2.y - p1.y < 0 && p2.x - p1.x < 0) {
            if(p3.x - p2.x < 0 || p3.y - p2.y > 0) {
                return true;
            }
        }
        // (8) y2 - y1 > 0 && x2 - x1 < 0 >>> x3 - x2 > 0 또는 y3 - y2 > 0
        else if(p2.y - p1.y > 0 && p2.x - p1.x < 0) {
            if(p3.x - p2.x > 0 || p3.y - p2.y > 0) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkStraightLine(P p1, P p2, P p3) {
        if(p1.x == p2.x && p2.x == p3.x) {
            // 1. x1 = x2 = x3
            return true;
        } else if(p1.y == p2.y && p2.y == p3.y) {
            // 2. y1 = y2 = y3
            return true;
        } else {
            // 3. dy/dx 도출
            int dydx = p2.y - p1.y / p2.x - p1.x;
            int p3_y = p2.y + (p3.x - p2.x) * dydx;

            if(p3_y == p3.y) {
                return true;
            }
        }

        return false;
    }

    static class P {
        private int x;
        private int y;

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

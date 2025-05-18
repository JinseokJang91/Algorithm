package com.study.algo.baekjoon.silver;

import java.io.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.StringTokenizer;

public class Implementation_1340 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input : Month DD, YYYY HH:MM
        // 이번 해가 몇 %가 지났는지 출력
        /*
        Date, LocalDateTime => Long 변환
        LocalDateTime now = LocalDateTime.now();
        Date date = new Date();
        System.out.println("date = " + date.getTime());
        System.out.println("ldt = " + now.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        */

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        double result = 0.0d;

        String monthInput = st.nextToken();
        int month = getMonth(monthInput);


        if(month > 0) {
            String dayInput = st.nextToken();
            int day = Integer.parseInt(dayInput.substring(0, dayInput.length() - 1));
            int year = Integer.parseInt(st.nextToken());
            String[] timeInput = st.nextToken().split(":");
            int hour = Integer.parseInt(timeInput[0]);
            int minute = Integer.parseInt(timeInput[1]);

            //System.out.println(year + "년 " + month + "월 " + day + "일 " + hour + "시 " + minute + " 분");

            boolean isLeapYear = checkLeapYear(year);

            LocalDateTime present = LocalDateTime.of(year, month, day, hour, minute); // 현재 시점
            long presentTime = ((present.getDayOfYear() - 1) * 24 * 60) + (hour * 60) + minute;
            long wholeTime = isLeapYear ? 366 * 24 * 60 : 365 * 24 * 60;

            // (현재 시점 - 이번년도 시작시점) / (다음년도 시작시점 - 이번년도 시작시점) * 100
            result = (double) presentTime / wholeTime * 100.0;
        }

        bw.write("" + result);
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getMonth(String input) {
        int month = 0;
        switch (input) {
            case "January" : month = 1; break;
            case "February" : month = 2; break;
            case "March" : month = 3; break;
            case "April" : month = 4; break;
            case "May" : month = 5; break;
            case "June" : month = 6; break;
            case "July" : month = 7; break;
            case "August" : month = 8; break;
            case "September" : month = 9; break;
            case "October" : month = 10; break;
            case "November" : month = 11; break;
            case "December" : month = 12; break;
            default : break;
        }

        return month;
    }

    private static boolean checkLeapYear(int year) {
        if(year % 4 == 0) {
            if(year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        }

        return false;
    }
}

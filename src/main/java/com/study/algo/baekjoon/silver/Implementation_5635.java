package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Implementation_5635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<Person> persons = new ArrayList<>();

        // 주어지는 정보 : 이름 일 월 년도
        // 가장 나이가 적은 사람의 이름, 가장 나이가 많은 사람의 이름 출력

        StringTokenizer st = null;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            persons.add(new Person(name, day, month, year));
        }

        // 년도 기준으로 오름차순 정렬 (년도는 작을수록 나이가 많음)
        Collections.sort(persons, (o1, o2) -> o1.year - o2.year);

        int oldestYear = persons.get(0).year;
        int youngestYear = persons.get(persons.size() - 1).year;

        // 동일년도 존재 케이스 고려
        List<Person> oldPersons = persons.stream().filter(s -> s.year == oldestYear).collect(Collectors.toList());
        List<Person> youngPersons = persons.stream().filter(s -> s.year == youngestYear).collect(Collectors.toList());

        // 1. 나이가 가장 적은 사람
        if(youngPersons.size() == 1) {
            // 동일년도가 혼자면 바로 출력
            result.append(youngPersons.get(0).name).append("\n");
        } else {
            // 동일년도가 둘 이상이면 월 => 일 순으로 비교
            int youngestMonth = youngPersons.get(0).month;
            int youngestDay = youngPersons.get(0).day;
            String youngestPersonName = youngPersons.get(0).name;
            for(int i = 1; i < youngPersons.size(); i++) {
                if(youngPersons.get(i).month > youngestMonth) {
                    youngestMonth = youngPersons.get(i).month;
                    youngestPersonName = youngPersons.get(i).name;
                } else if(youngPersons.get(i).month == youngestMonth) {
                    if(youngPersons.get(i).day > youngestDay) {
                        youngestDay = youngPersons.get(i).day;
                        youngestPersonName = youngPersons.get(i).name;
                    }
                }
            }

            result.append(youngestPersonName).append("\n");
        }

        // 2. 나이가 가장 많은 사람
        if(oldPersons.size() == 1) {
            // 동일년도가 혼자면 바로 출력
            result.append(oldPersons.get(0).name).append("\n");
        } else {
            // 동일년도가 둘 이상이면 월 => 일 순으로 비교
            int oldestMonth = oldPersons.get(0).month;
            int oldestDay = oldPersons.get(0).day;
            String oldestPersonName = oldPersons.get(0).name;
            for(int i = 1; i < oldPersons.size(); i++) {
                if(oldPersons.get(i).month < oldestMonth) {
                    oldestMonth = oldPersons.get(i).month;
                    oldestDay = oldPersons.get(i).day;
                    oldestPersonName = oldPersons.get(i).name;
                } else if(oldPersons.get(i).month == oldestMonth) {
                    if(oldPersons.get(i).day < oldestDay) {
                        oldestDay = oldPersons.get(i).day;
                        oldestPersonName = oldPersons.get(i).name;
                    }
                }
            }

            result.append(oldestPersonName).append("\n");
        }

        bw.write(result.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static class Person {
        private final String name;
        private final int day;
        private final int month;
        private final int year;

        public Person(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }

        // 로직 확인용
//        @Override
//        public String toString() {
//            return "Person{" +
//                    "name='" + name + '\'' +
//                    ", day=" + day +
//                    ", month=" + month +
//                    ", year=" + year +
//                    '}';
//        }
    }
}

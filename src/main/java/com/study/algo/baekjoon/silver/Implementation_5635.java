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

        StringTokenizer st = null;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            persons.add(new Person(name, day, month, year));
        }

        Collections.sort(persons, (o1, o2) -> o1.year - o2.year);

        int oldestYear = persons.get(0).year;
        int youngestYear = persons.get(persons.size() - 1).year;

        List<Person> oldPersons = persons.stream().filter(s -> s.year == oldestYear).collect(Collectors.toList());
        List<Person> youngPersons = persons.stream().filter(s -> s.year == youngestYear).collect(Collectors.toList());

        System.out.println("youngPersons = " + youngPersons);
        System.out.println("oldPersons = " + oldPersons);

        if(youngPersons.size() == 1) {
            result.append(youngPersons.get(0).name).append("\n");
        } else {
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

        if(oldPersons.size() == 1) {
            result.append(oldPersons.get(0).name).append("\n");
        } else {
            int oldestMonth = oldPersons.get(0).month;
            int oldestDay = oldPersons.get(0).day;
            String oldestPersonName = oldPersons.get(0).name;
            for(int i = 1; i < oldPersons.size(); i++) {
                if(oldPersons.get(i).month < oldestMonth) {
                    oldestMonth = oldPersons.get(i).month;
                    oldestPersonName = oldPersons.get(i).name;
                } else if(oldPersons.get(i).month == oldestMonth) {
                    System.out.println("비교대상 = " + oldPersons.get(i).name);
                    System.out.println("이전 = " + oldestPersonName);
                    System.out.println(">> = " + oldPersons.get(i).day);
                    System.out.println(">> = " + oldestDay);
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
        private String name;
        private int day;
        private int month;
        private int year;

        public Person(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", day=" + day +
                    ", month=" + month +
                    ", year=" + year +
                    '}';
        }
    }
}

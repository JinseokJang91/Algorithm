package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Ques_10814 {
    static int N;
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Member[] members = new Member[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            members[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(members, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return o1.age - o2.age; // 오름차순
            }
        });

        for(Member member : members) {
            sb = new StringBuilder();
            System.out.println(sb.append(member.age).append(" ").append(member.name).toString());
        }

        br.close();
    }

    public static class Member {
        int age;
        String name;

        // 오버로딩 생성자
        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}

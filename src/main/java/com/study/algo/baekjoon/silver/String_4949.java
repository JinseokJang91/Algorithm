package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.Stack;

public class String_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();

        String input = "";
        do {
            input = br.readLine();

            if(".".equals(input)) {
                break;
            }

            boolean isBalanced = checkInputString(input);

            if(isBalanced) {
                result.append("yes").append("\n");
            } else {
                result.append("no").append("\n");
            }
        } while(true);

        bw.write(result.toString());

        br.close();
        bw.close();
    }

    private static boolean checkInputString(String input) {
        // 소괄호(x), 대괄호(y) 따로 계산
        // 괄호 아스키코드
        // ( : 40, ) : 41, [ : 91, ] : 93

        // 괄호가 닫힐 때 => 스택에 마지막으로 넣은 열린 괄호의 종류가 같아야 함
        // ( ) => 일치
        // ( [ ) ] => 불일치

        Stack<String> brackets = new Stack<>();

        for(int i = 0; i < input.length(); i++) {
            switch(input.charAt(i)) {
                case 40 :
                    brackets.push("(");
                    break;
                case 41 :
                    if(!brackets.isEmpty() && "(".equals(brackets.peek())) {
                        brackets.pop();
                    } else {
                        // 불일치 시 종료
                        return false;
                    }
                    break;
                case 91 :
                    brackets.push("[");
                    break;
                case 93 :
                    if(!brackets.isEmpty() && "[".equals(brackets.peek())) {
                        brackets.pop();
                    } else {
                        // 불일치 시 종료
                        return false;
                    }
                    break;
                default :
                    break;
            }
        }

        return brackets.isEmpty();
    }
}

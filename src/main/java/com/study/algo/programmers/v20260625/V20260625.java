package com.study.algo.programmers.v20260625;

public class V20260625 {
    public static void main(String[] args) {
        // 😏 반복과 복습은 최고의 공부

        // --------------------------------------------
        // 1. toCharArray()
        // --------------------------------------------
        String str1 = "abc";
        char[] chArr1 = str1.toCharArray(); // ['a', 'b', 'c']

        // --------------------------------------------
        // 2. 아스키코드
        // --------------------------------------------
        // ⭐ 알파벳 대문자 A~Z: 65~90 | 소문자 a~z: 97~122
        char ch1 = 'A';
        System.out.println("ch1 = " + (int)ch1);

        // --------------------------------------------
        // 3. Character 자료형
        // --------------------------------------------
        char ch2 = 'A';
        char ch3 = 'B';
        // 3-1. char + char = int
        //char ch4 = ch2 + ch3; // ❌ 컴파일 에러: int+int 연산으로 자동 형변환
        int i1 = ch2 + ch3; // ⭕
        char ch5 = (char)(ch2 + ch3); // ⭕ 강제 형변환
        // 3-2. char + int = int
        // char ch6 = ch2 + 32; // ❌ 컴파일 에러: int+int 연산으로 자동 형변환
        char ch7 = (char)(ch2 + 32); // ⭕ 강제 형변환
        System.out.println("ch7 = " + ch7); // 'A' -> 'a'
        char ch8 = 'A';
        ch8 += 32; // ⭕ 컴파일러가 강제 형변환 시켜줌 -> ch8 = (char)(ch8 + 32)
        System.out.println("ch8 = " + ch8);
        // 3-3. char -> int 바꾸고 싶을 때
        // ⭐ 참고로 아스키코드는 유니코드에 포함임(자바에서 계산 시에는 유니코드로 적용됨)
        char ch9 = '3';
        int i2 = ch9 - '0'; // 51 - 48 (유니코드로 계산)
        System.out.println("i2 = " + i2); // 3

        // 💡 자바에서 int보다 작은 타입(byte, short, char)끼리 이항 연산(+, - 등)을 하면
        //     자바는 두 피연산자를 모두 int 타입으로 자동 형변환한 뒤 계산
        // 💡 자바에서는 더 큰 타입을 작은 타입에 그냥 넣을 수 없음
        //     int: 4바이트, char: 2바이트
        long l1 = ch2 + ch3; // 이건 가능 (int -> long)

        // --------------------------------------------
        // 4. int 범위
        // --------------------------------------------
        // ⭐ -2^31 ~ 2^31-1 : -21억~+21억
        int maxInteger = Integer.MAX_VALUE;
        int minInteger = Integer.MIN_VALUE;
        System.out.println("maxInteger = " + maxInteger);
        System.out.println("minInteger = " + minInteger);

        // --------------------------------------------
        // 5. 정규식 특수문자 사용하기
        // --------------------------------------------
        // 5-1. 대괄호 감싸기
        // 대상: *, +, $, |
        //str1 = str1.replaceAll("*", "A"); // ❌ Dangling quantifier
        str1 = str1.replaceAll("[*]", "A"); // ⭕
        // 5-2. \\ 추가하기
        // 대상: ^, (, ), {, }, [, ]
        //str1 = str1.replaceAll("(", "A"); // ❌ ')' expected
        str1 = str1.replaceAll("\\(", "A"); // ⭕

        // --------------------------------------------
        // 5. 특수문자 출력하기
        // --------------------------------------------
        // 대상: ", \
        System.out.println("출력 : '"); // 작은 따옴표는 가능
        System.out.println("출력 : \"");
        System.out.println("출력 : \\");
    }
}

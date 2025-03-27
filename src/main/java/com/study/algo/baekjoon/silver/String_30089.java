package com.study.algo.baekjoon.silver;

import java.io.*;

public class String_30089 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        // 문자 S와 뒤집은 S'를 비교
        // e.g. BANANA
        // B A N A N A
        //           A N A N A B => 일치 (한 글자는 무조건 겹치긴 함)

        // B A N A N A
        //         A N A N A B => 일치하지 않음 (다음 위치로 이동)

        // B A N A N A
        //       A N A N A B => 일치

        // B A N A N A
        //     A N A N A B => 불일치

        // B A N A N A
        //   A N A N A B => 일치 (정답)

        // B A N A N A
        // A N A N A B => 불일치

        // 위 순서를 거꾸로 하는게 더 좋을듯 함

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < T; i++) {
            String S = br.readLine();
            String[] sArr = S.split("");

            String[] arr1 = new String[sArr.length]; // 순서대로 담을 배열
            String[] arr2 = new String[sArr.length]; // 역순서대로 담을 배열

            for(int j = 0; j < sArr.length; j++) {
                arr1[j] = sArr[j];
                arr2[j] = sArr[sArr.length -(j + 1)];
            }

            result.append(S); // S 문자열을 먼저 담는다

            int idxCnt = 0; // 인덱스 카운트 (시작값이 바뀌기 때문에 결과적으로 총량은 갈수록 줄어듬)
            int startIdx = 0; // 최종적으로 비교값이 동일한 부분을 남길 인덱스
            int basicIdx = 0; // 기본 배열 인덱스, 여기선 순서대로 담은 arr1의 배열을 탐색하기 위한 인덱스
            int changeIdx = 0; // 변화시킬 배열 인덱스, 여기선 비교 대상인 arr2의 배열을 탐색하기 위한 인덱스
            while(true) {
                // 배열 마지막 인덱스 도달 시 종료
                // 마지막 인덱스에 도달했다는 것은 배열 간 동일한 부분을 찾아서 종료한다는 뜻
                if(idxCnt == sArr.length) {
                    break;
                }

                // 비교값이 같으면 다음 인덱스 비교를 위해 이동
                if(arr1[changeIdx].equals(arr2[basicIdx])) {
                    idxCnt++;
                    changeIdx++;
                    basicIdx++;
                // 비교값이 다르면 시작 인덱스를 바꿔 다시 순차적 비교
                } else {
                    startIdx++;
                    idxCnt = startIdx;
                    changeIdx = startIdx;
                    basicIdx = 0;
                }
            }

            for(int j = arr2.length - startIdx; j < arr2.length; j++) {
                result.append(arr2[j]);
            }
            result.append("\n");
        }

        bw.write(result.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}

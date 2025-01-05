package programmers.allProblems.lv1;

public class LV1_28 {

    public static void main(String[] args) {

        //연습문제 > 짝수와 홀수
        String answer = "";
        int num = 3;

        //0은 짝수로 취급
        if(num % 2 == 0){
            answer = "Even";
        }else{
            answer = "Odd";
        }

        System.out.println("answer : " + answer);

    }

}

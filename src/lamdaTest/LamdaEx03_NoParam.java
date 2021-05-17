package lamdaTest;

import java.util.Random;

//매개변수가 없는 람다식
interface Generator {
    int rand();
}

public class LamdaEx03_NoParam {

    public static void main(String[] args) {
        Generator gen = () -> {
            Random rand = new Random();
            return rand.nextInt(50);
        };
        // 매개변수가 없는 람다식
        // => 매개변수를 표현하는 소괄호 ( ) 를 비워준다.
        // => 그러나 둘이상의 문장으로 구성된 람다식은 반드시 중괄호로 감싸야 됨.
        System.out.println(gen.rand());
    } // main
} // class

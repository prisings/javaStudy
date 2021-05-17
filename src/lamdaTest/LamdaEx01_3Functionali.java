package lamdaTest;

@FunctionalInterface
// 이를 적용한 인터페이스는 한개의 추상메소드만을 선언할수있다.
interface Value {
    int num(int a, int b);
    // String myString(int a, int b);
} // interface

class Plus {
    public void valTest(Value value) {
        int number = value.num(5, 10); // num 메서드의 처리내용은 구현이 안되어 있음
        System.out.println("number is " + number);
    }
} // class

public class LamdaEx01_3Functionali {

    public static void main(String[] args) {

        // Test1. 람다식 사용 X, 익명클래스
        System.out.println("** Test1. 람다식 사용 X, 익명클래스 **");
        Plus plus = new Plus();

        // plus.std(value);
        // 매개변수 value 부분을 익명 클래스로 구현
        plus.valTest(new Value() {  // interface Value 의 구현체를 익명 클래스로 구현
            public int num(int a, int b) {
                System.out.println("int a : " + a);
                System.out.println("int b : " + b);
                return a + b;
            }
        });
        // Test2. 람다식 사용 O
        System.out.println("** Test2. 람다식 사용  **");
        Plus plusLam = new Plus();
        // plus.std(value);
        // 매개변수 value 부분을 람다식으로 구현
        plusLam.valTest((a,b) -> {
            System.out.println("int a : " + a);
            System.out.println("int b : " + b);
            return a*b;
        });

    } // main

} // class

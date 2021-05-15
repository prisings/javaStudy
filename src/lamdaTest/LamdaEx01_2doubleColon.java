package lamdaTest;

import java.util.ArrayList;
import java.util.List;

// ** 메서드 참조  람다식 ::
// :: ( double conlon operator , 정식 명칭은 method reference )
// => 람다를 더 간결하게 표현하는 문법.
// => 메소드를 참조해서 매개변수의 정보 및 리턴 타입을 미리 알아내
//    람다식에서 사용하는 매개변수를 생략하는 방식의 표현법.
// => 대상::메소드 가 있다면, 대상에서 메소드의 정보를 추출하여
//    람다식 처럼 익명 구현객체를 생성하는것으로 참조하는 메소드의 매개변수를 생략할 수 있음.
// => https://myhappyman.tistory.com/65
public class LamdaEx01_2doubleColon {

    public static void main(String[] args) {
        // 1) 단순 반복문 출력
        List<String> names = new ArrayList<String>();
        names.add("Matilda");
        names.add("Leon");
        names.add("Naples");
        names.add("Harry Potter");
        names.add("Iron Man");
        System.out.println("** 1) 단순 반복문 출력 **");
        for(int i=0; i<names.size(); i++) {
            System.out.println(names.get(i));
        }

        // 2) forEach 메서드를 이용해 Lamda 적용
        System.out.println("** 2) forEach 메서드를 이용해 Lamda 적용 **");
        names.forEach(d-> System.out.println(d));

        // 3) 메소드 참조(::) 적용
        System.out.println("** 3) 메소드 참조(::) 적용 **");
        names.forEach(System.out::println);

    } // main

} // class

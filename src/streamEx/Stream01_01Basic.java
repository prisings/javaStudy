package streamEx;
import java.util.Arrays;
import java.util.stream.IntStream;

// ** IntStream interface
// => BaseStream -> IntStream

// ** IntStream 생성
// => interface 로써 스트림을 사용하려는 대상 (배열, 컬렉션)에 의해 생성됨
// => 배열, 컬렉션에는 스트림을 생성하는 stream() 메서드가 정의 되어있고,
//    stream() 메서드의 return Type 은 IntStream 
//    즉, 스트림을 반환함.

// ** IntStream 의 메서드
// => 각종 연산을 할수있는 다양한 메서드 제공 
//    filter(), sum() ....

class Stream01_01Basic {
    public static void main(String[] args) {
    	int[] ar = {1, 2, 3, 4, 5};
    	
        IntStream stm1 = Arrays.stream(ar);
        // => 배열 ar 에 저장된 데이터를 대상으로한 스트림 stm1 인스턴스 생성. 
        //    stm1은 ar의 데이터를 중간연산, 최종연산 등을 할수있는 스트림 구조로 배치된 복사본.

        // 중간파이프 (중간연산) : 홀수만 선택
        IntStream stm2 = stm1.filter(n -> n%2 == 1);

        // 최종파이프 (최종연산)
        int sum = stm2.sum();
        System.out.println("** 최종연산 결과1 = "+sum);
        
        // ** 한문장으로 처리
        // => 스트림 생성후 사용하는 중간연산 메서드들의 return Type 은
        //    모두 IntStream 이므로 계속 연결해서 사용가능
        int tot = Arrays.stream(ar)
                .filter(n -> n%2 == 1)
                .sum();
        System.out.println("** 최종연산 결과2 = "+tot);
        
        // ** stream() 메서드는
        // => Type별로 다양하게 OverLoad 되어있다.
        double[] ds = {1.1, 2.2, 3.3, 4.4, 5.5};
        
        Arrays.stream(ds)  // 배열전체를 대상으로
           .forEach(d -> System.out.print(d + "\t"));
        System.out.println();

        Arrays.stream(ds, 1, 4) 
        // 배열의 일부분을 대상으로 :  인덱스 1 부터 4 까지
           .forEach(d -> System.out.print(d + "\t"));
        System.out.println();
        
    } // main
} // class
package streamEx;
import java.util.Arrays;
import java.util.stream.Stream;

class Stream01_02String {
    public static void main(String[] args) {
    	
        String[] names = {"YOON", "LEE", "PARK"};
        
        // 스트림 생성
        Stream<String> stm = Arrays.stream(names);
        // 최종 연산 진행
        stm.forEach(s -> System.out.println(s));
        
        // ** 한문장으로 처리
        Arrays.stream(names)
        .forEach(s -> System.out.println(s));
    } //main
} //class
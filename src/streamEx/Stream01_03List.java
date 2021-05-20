package streamEx;
import java.util.List;
import java.util.Arrays;

class Stream01_03List {
    public static void main(String[] args) {
        
    	// 배열을 이용해서 초기값을 넣은 List 생성
        List<String> list = Arrays.asList("Korea", "Robot", "AI","그린컴퓨터");
        
        list.stream()
          .forEach(s -> System.out.print(s + "\t"));

        System.out.println();
    } // main
} // class
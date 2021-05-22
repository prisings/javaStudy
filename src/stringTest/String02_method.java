package stringTest;

public class String02_method {

	public static void main(String[] args) {
		String name = new String() ;
		name = "홍길동";
		String city = new String("~~~SeoulinKorea~~~") ;
		String country = "    I Love Korea    " ;
		
		System.out.printf("charAt => %c\n", city.charAt(0)) ; 
		// => 성별 : idno.charAt(7)
		System.out.printf("length => %d , name length= %d\n", city.length(),name.length()) ;
		// length : 한글의 경우 글자수
		System.out.printf("indexOf => %d\n", city.indexOf('e')) ;  // 처음 'e'
		System.out.printf("lastIndexOf => %d\n", city.lastIndexOf('e')) ; // last 'e'
		System.out.printf("substring => %s\n", city.substring(2,5)) ; // 2<= , <5
		// 연습1 : 아래 경로에서 화일명을 추출하고 추출한  화일명을 출력 하세요~~~
		// => D:\MTest\MyWork\Java02\src\day0109\test.java
		String url="D:\\MTest\\MyWork\\Java02\\src\\day0109\\test.java" ;
		// => 제일 마지막에 나오는 경로기호(\\) 바로 다음 알파벳 부터 끝까지 읽어내면 화일명
		int i = url.lastIndexOf('\\') ;
		System.out.printf("화일명 추출 하기 => %s\n", url.substring(i+1));
		//System.out.printf("화일명 추출 하기 => %s\n", url.substring((url.lastIndexOf('\\')+1)));
		
		// 연습2 => city 에서 substring 으로 Korea 추출해서 출력하기
		//System.out.printf("Korea 추출 하기 => %s\n", city.substring(city.lastIndexOf('K')));
		System.out.printf("Korea 추출 하기 => %s\n", city.substring(city.indexOf('K'),(city.indexOf('K')+5)));
		
		// trim : 앞,뒤 공백 제거 : 해당 변수의 값 자체가 달라지지는 않음
		System.out.printf("trim => %s\n", country.trim());
		System.out.printf("country => %s\n", country);
		country = country.trim();
		System.out.printf("country => %s\n", country);
		// ==================================================
		
		name = new String();
		name = "홍길동";
		city = new String("~~~SeoulinKorea~~~");
		country = "    I Love Korea    ";

		System.out.printf("* trim =>~~%s~~\n", country.trim());
		System.out.printf("* toLowerCase =>%s, %s\n", city.toLowerCase(), city);
		System.out.printf("* toUpperCase =>%s, %s\n", city.toUpperCase(), city);
		System.out.printf("* replace1 =>%s, %s\n", city.replace('e', 'h'), city);
		System.out.printf("* replace2 =>%s, %s\n", city.replace("Seoul", "Pari"), city);
		System.out.printf("* replace3 =>%s, %s\n", name.replace('홍', '김'), name);
		// split :문자열을 잘라 배열에 담아줌
		String s1 = "Hong,Gil, , , Dong";
		String[] data = s1.split(","); // 배열 초기화 완료
		
		for (int ii = 0; ii < data.length; ii++) {
			System.out.printf("data[%d]=%s\n", ii, data[ii]);
		} // for

		// String => integer 변환 : Integer.parseInt
		String one = "123";
		int ione = Integer.parseInt(one);
		System.out.println(" I am integer => " + ione++);
		System.out.println(" I am integer ++ => " + ione);

		// integer => String 변환 : int 뒤에 + ""
		String str = (ione + "");
		System.out.println(" I am String  => " + str);

// 3. 비교
		// compareTo
		String abc = "abc";
		System.out.println(" result1 =>" + abc.compareTo("abc"));
		System.out.println(" result2 =>" + abc.compareTo("ab"));
		System.out.println(" result3 =>" + abc.compareTo("a"));
		System.out.println(" result4 =>" + abc.compareTo("bc"));
		System.out.println(" result5 =>" + abc.compareTo("c"));
		System.out.println(" result6 =>" + abc.compareTo("abcabc"));
		System.out.println(" result7 =>" + abc.compareTo("abcabcd"));
		
		
		

	}

}

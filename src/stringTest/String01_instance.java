package stringTest;

public class String01_instance {
	
	public static void main(String[] args) {
		String s1="Banana" ;
		String s2="Apple" ;
		String s3=new String("Banana");
		
		if (s1==s2) 
			 System.out.println("** s1 과 s2 는 동일 인스턴스(주소) 이다");
		else System.out.println("** s1 과 s2 는 다른 인스턴스(주소) 이다");
		
		if (s1==s3) 
			 System.out.println("** s1 과 s3 는 동일 인스턴스(주소) 이다");
		else System.out.println("** s1 과 s3 는 다른 인스턴스(주소) 이다");
		
		s3="Apple" ;
		if (s2==s3) 
			 System.out.println("** s2 과 s3 는 동일 인스턴스(주소) 이다");
		else System.out.println("** s2 과 s3 는 다른 인스턴스(주소) 이다");
		
		s3="Hello Java String !!!" ;
		System.out.println("Length s3 => "+s3.length()); 
		System.out.println("Length Apple => "+"Apple".length()); 
		s3="한글의 길이는 어떻게 될까요 !!!" ;  // 한글자가 1
		System.out.println("한글 Length s3 => "+s3.length()); 
		
		s1="100";   s2 = "200"; int n=123;
		System.out.println("add Test => "+s1+s2+n); 
		
	} //main
} // class

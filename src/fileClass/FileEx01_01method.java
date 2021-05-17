package fileClass;
import java.io.*;
//자바의 정석 915 P
//File 인스턴스를 생성하고 메서드를 이용하여 파일의 경로와 구분자 등 출력.  
class FileEx01_01method {
	public static void main(String[] args) throws IOException 	{
		// D:\MTest\MyWork\Java02\src\fileClass
		File f = new File("D:\\MTest\\MyWork\\Java02\\src\\fileClass\\FileEx01_01method.java");
		String fileName = f.getName();
		int pos = fileName.lastIndexOf(".");

		System.out.println("경로를 제외한 파일이름 - " + f.getName());
		System.out.println("확장자를 제외한 파일이름 - " + fileName.substring(0,pos));
		System.out.println("확장자 - " + fileName.substring(pos+1));

		System.out.println("경로를 포함한 파일이름 - "		+ f.getPath());
		System.out.println("파일의 절대경로        - "	+ f.getAbsolutePath());
		System.out.println("파일의 정규경로        - "	+ f.getCanonicalPath());
		// Canonical : (성경이)정본에 속하는 , (문학작품이)고전적인
		// => 일반적 사용시에는 둘다 파일의 절대경로를 반환해 주지만,
		//    경로에 .(현재 디렉토리)과 ..(상위 디렉토리)를 사용할 경우 결과값이 달라짐
		//    ppt 4p 참고
		
		System.out.println("파일이 속해 있는 디렉토리 - "	+ f.getParent());
		System.out.println();
		System.out.println("File.pathSeparator - "		+ File.pathSeparator);
		System.out.println("File.pathSeparatorChar - "  + File.pathSeparatorChar);
		System.out.println("File.separator - "		+ File.separator);
		// separator는 OS에 따른 구분자로 표시됨 
		System.out.println("File.separatorChar - "	+ File.separatorChar);
		System.out.println();
		// ** https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
		System.out.println("user.dir=" + System.getProperty("user.dir"));
		// user.dir : 현재 프로그램이 실행중인 디렉토리를 알려주는 속성값
		System.out.println("user.home=" + System.getProperty("user.home"));
		System.out.println("user.name=" + System.getProperty("user.name"));
		System.out.println("sun.boot.class.path=" + System.getProperty("sun.boot.class.path"));
		// sun.boot.class.path : 기본적인 경로들을 설정해서 가지고 있는 속성값
	}
}
package fileIO;
import java.io.*;

//** 문자 스트림
//=> 화일 만들기 와 메모장 내용 출력하기 

class IOEx04_FileRW02 {
	public static void main(String[] args) throws IOException {
		
		Writer out=new FileWriter("test.txt");
		//Reader in=new FileReader("test.txt");
		Reader in=new FileReader("text.txt");
		String s = "꿈에 미치면 신화가 된다";
		try {
            out.write(s); 	 // 문자열은 write()로 출력 가능
            out.append('.'); // 문자 추가
            out.flush();
            
            int c;
            while ((c = in.read()) != -1) {
                   System.out.print((char)c);
            }
		} finally {
			if (in != null) { in.close(); }
            if (out != null) { out.close(); }
            System.out.println("\n** FileReader & FileWriter Test2 종료 **");
		} // finally
	} //main
} //class
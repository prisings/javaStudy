package fileIO;
import java.io.*;

// ** InputStream, OutputStream 1
// => 1Byte씩 처리
// => ppt 18-19p
class IOEx01_01FileStream {
	public static void main(String[] args) throws IOException {
		
		// ** 생성순서 주의 : RunTime 오류 발생 
		// 1) 파일 대상의  출력스트림 생성
		// => "data.txt" : 현재 실행중인 프로젝트 내에 생성됨
        OutputStream out = new FileOutputStream("data.txt");
        // 2) 파일 대상의  입력스트림 생성
        // => InputStream 은 read 스트림이므로 "data.txt" 파일이 존재해야 생성됨
        //    java.io.FileNotFoundException: data.txt (지정된 파일을 찾을 수 없습니다)
        InputStream in = new FileInputStream("data.txt");
        
        try {
        	int num ;
        	// write(int i) : 4Byte int 형 정수의 하위 8bit(1Byte)만 전달
            for(int i=0;i <10; i++) {
                out.write(i);
            } // for
            
            // read() : 1Byte를 읽어서 int 타입으로 return , 읽을값이 없으면 -1 반환  
            while ((num = in.read()) != -1) {
                System.out.print(num+" ");
            } // while
           
         //  }catch(IOException e) { e.printStackTrace();  
         // => throws 대신 catch 블럭 작성해도 됨 
            
        } finally {
        	// 스트림 소멸
            if (in != null) { in.close(); }
            if (out != null) { out.close(); }
        } // finally
    } //main
} //class
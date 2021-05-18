package fileIO;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// ** InputStream, OutputStream 2
// => Byte Stream 이지만 byte 배열을 이용해서 처리속도 높이기
// => ppt 18-19p
class IOEx01_02FileStreamBuf {
	public static void main(String[] args) throws IOException {
        
        InputStream in = new FileInputStream("d:\\MTest\\sql001.sql");
        OutputStream out = new FileOutputStream("d:\\MTest\\sql001Copy.sql");

        try {
        	// byte 타입의 배열을 만들어 1024 Byte씩 처리하도록 함 
            byte buf[] = new byte[1024];
            int len;

            while(true) {
            	// read(byte[] buf)
            	// => buf크기 만큼 읽어 buf 에 저장하고 읽은 byte수를 반환
            	// => 다 읽으면 -1 반환
                len = in.read(buf);             
                if(len == -1) break;   
                out.write(buf);
            } // while
        }catch(IOException e) {
            e.printStackTrace();       
        }finally {
        	// 스트림 소멸
            if (in != null) { in.close(); }
            if (out != null) { out.close(); }
            System.out.println("** File Copy 종료 **");
        } // finally //catch
    } //main
} //class
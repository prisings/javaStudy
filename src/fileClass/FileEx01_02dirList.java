package fileClass;
import java.io.*;
//지정한 폴더에 포함된 파일과 디렉토리 목록 표시하기.
//=> FileEx1 의 user.dir 의 결과를 이용하여 Run Configurations 로 Test
//	  -> D:\MTest\MyWork\Java02, D:\MTest\MyWork
class FileEx01_02dirList {
	public static void main(String[] args) {
		
		if(args.length != 1) {
			System.out.println("** 경로 또는 화일명을 입력하지 않았습니다. **");
			System.exit(0);  // return 과 동일
		}

//		File f = new File("D:\\MTest\\MyWork\\Java02");
		File f = new File(args[0]);
		
		// exists() : 파일의 존재여부
		// isDirectory() : 디렉토리 인지 확인
		// isFile() : 파일인지 확인
		// 정석 918~919 p 표 참고
		if(!f.exists() || !f.isDirectory()) {
			System.out.println("** 유효하지 않은 디렉토리입니다. **");
			System.exit(0); // 종료, return 과 동일
		} 
		// listFiles() : 폴더의 파일목록을 File 배열로 반환 
		File[] files = f.listFiles();

		for(int i=0; i < files.length; i++) {
			String fileName = files[i].getName();
			System.out.print(files[i].isDirectory() ? "["+fileName+"]" : fileName);
			
			if(files[i].isDirectory())
				System.out.println("\t\tDIR");
			else
				System.out.println("\t\tFILE");
		}
	} // main
}

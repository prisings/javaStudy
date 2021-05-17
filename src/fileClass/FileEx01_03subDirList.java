package fileClass;
import java.io.*;
import java.util.ArrayList;
// 지정한 폴더에 포함된 파일과 폴더 목록, 서브폴더의 파일과 폴더 모두  표시하기.
// => FileEx1 의 user.dir 의 결과를 이용하여 Run Configurations 로 Test
//	  -> D:\MTest\MyWork\Java02\src, D:\MTest\MyWork
class FileEx01_03subDirList {
	static int totalFiles = 0;
	static int totalDirs = 0;

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("** 경로 또는 화일명을 입력하지 않았습니다. **");
			//System.exit(0);
			return;
		}

		File dir = new File(args[0]);

		if(!dir.exists() || !dir.isDirectory()) {
			System.out.println("** 유효하지 않은 디렉토리입니다. **");
			//System.exit(0);
			return;
		} 

		printFileList(dir);

		System.out.println();
		System.out.println("총 " + totalFiles + "개의 파일");
		System.out.println("총 " + totalDirs + "개의 디렉토리");
	} // main
	
	// printFileList
	// => 파일과 폴더 목록을 출력하는메서드 
	// => 재귀호출(recursive call) 이용
	public static void printFileList(File dir) {
		System.out.println(dir.getAbsolutePath()+" 디렉토리");
		// getAbsolutePath() : 파일의 절대경로를 String 으로 반환
		// => 정석 915 p 메서드 표 참고
		File[] files = dir.listFiles();

		//** sub Directory 갯수 확인용도
		ArrayList<String> subDir = new ArrayList<String>();

		for(int i=0; i < files.length; i++) {
			String filename = files[i].getName();

			if(files[i].isDirectory()) {
				filename = "[" + filename + "]";
				subDir.add(i+"");
			}
			System.out.println(filename);
		}

		int dirNum  = subDir.size();
		int fileNum = files.length - dirNum;

		totalFiles += fileNum;
		totalDirs  += dirNum;

		System.out.println(fileNum + "개의 파일, " + dirNum + "개의 디렉토리");
		System.out.println();

		for(int i=0; i < subDir.size(); i++) {
			int index = Integer.parseInt((String)subDir.get(i));
			printFileList(files[index]);
		}
	} // printFileList
} // class

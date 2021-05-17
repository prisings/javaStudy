package fileClass;
import java.io.File;

public class FileEx02_01mkDir {

	public static void listDirectory(File dir) {
		System.out.println("-----" + dir.getPath() + "의 서브 리스트 입니다.-----");
		
		File[] subFiles = dir.listFiles(); 
		// 디렉토리에 포함된 파일과 디렉토리 이름의 리스트 얻기
		// => 만약 존재하지 않는 디렉토리를 사용하면 java.lang.NullPointerException: Cannot read .....
		for(int i=0; i<subFiles.length; i++) { // subFiles 배열의 각 File에 대해 루프
			File f = subFiles[i];
			long t = f.lastModified(); // 마지막으로 수정된 시간
			System.out.print(f.getName());
			System.out.print(f.isFile()?"\t파일":"\t디렉터리");
			System.out.print("\t파일 크기: " + f.length()); // 파일 크기
			System.out.printf("\t수정한 시간: %tb %td %ta %tT\n",t, t, t, t); //포맷 출력
		}		
	}
	
	public static void main(String[] args) {
		// ** system.ini Information 출력
		File f1 = new File("c:\\windows\\system.ini");
		System.out.println(f1.getPath() + ", " + f1.getParent() + ", " + f1.getName());		

		String res="";
		if(f1.isFile()) res = "파일"; // 파일 타입이면
		else if(f1.isDirectory()) res = "디렉토리"; // 디렉토리 타입이면
		System.out.println(f1.getPath() + "은 " + res + "입니다.");

		// ** mkdir
		File f2 = new File("d:/MTest/MyWork/ccc_ccc"); // 새로 만들고자 하는 디렉터리
		if(!f2.exists()) { // f2 디렉터리가 존재하는지 검사
			f2.mkdir(); // 존재하지 않으면 디렉토리 생성
		}
		// aaa_aaa 를 만들려는 d:/MTest/MyWork/ 가 없으면 
		// => 오류 발생하지 않고 f2.mkdir() 로 폴더만 만들어지지 않고 정상 진행됨.
		// => listDirectory 메서드에서 dir.listFiles() 등으로 구체적으로 목록을 읽어올때
		//    경로가 존재하지 않으면 NullPointerException 발생
		
		listDirectory(new File("d:\\MTest\\MyWork"));  // d:\\MTest\\MyWork 의 목록 출력
		f2.renameTo(new File("d:/MTest/MyWork/ddd_ddd")); // aaa_aaa -> bbb_bbb 로 이름 변경
		listDirectory(new File("d:\\MTest\\MyWork")); // bbb_bbb 로 변경한 후 리스트 출력
	} //main
} //class
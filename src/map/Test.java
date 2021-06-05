package map;

import java.util.HashMap;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		
		HashMap<String, String> map =new HashMap<String, String> ();
		map.put("key", "whatthehell");
		map.put("test", "test map");
		
		
		//map.remove("key"); 키값이 key인 값 제거
		//map.clear(); 모든 값 제거
		
		System.out.println(map); //전체 출력 
		System.out.println(map.get("key"));//key값 key의 value얻기 : whatthehell 
		
		
		
	}

}

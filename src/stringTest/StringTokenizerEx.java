package stringTest;

import java.util.StringTokenizer;

class StringTokenizerEx {
	// 문자열의 토큰 구분
	public static void main(String[] args) {
		StringTokenizer st1 = new StringTokenizer("PM:08:45", ":");

		while (st1.hasMoreTokens())
			System.out.print(st1.nextToken() + ' ');
		System.out.println();

		// 둘 이상의 구분자, 공백도 구분자에 포함 가능
		StringTokenizer st2 = new StringTokenizer("12 + 36 - 8 / 2 = 44", "+-/= ");

		while (st2.hasMoreTokens())
			System.out.print(st2.nextToken() + ' ');
		System.out.println();
	} // main
} // class
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_25501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			isPalindrome(word, 0, word.length() - 1, 0);
		}
	}
	
	public static void isPalindrome(String word, int l, int r, int idx) {
		idx += 1;
		if (l >= r) {
			System.out.println(1 + " " + idx);
		} else if (word.charAt(l) != word.charAt(r)) {
			System.out.println(0 + " " + idx);
		} else {
			l++; 
			r--;
			isPalindrome(word, l, r, idx);
		}
	}
}

package BOJ;

import java.util.Scanner;

public class BOJ_12891 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int s = sc.nextInt();
		int p = sc.nextInt();
		sc.nextLine();
		String dna = sc.nextLine();
		int arr[] = new int[4];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int lp = 0, rp = p - 1, cnt = 0;
		
		for (int i = 0; i < p; i++) {
			if (dna.charAt(i) == 'A') {
				arr[0]--;
			} else if (dna.charAt(i) == 'C') {
				arr[1]--;
			} else if (dna.charAt(i) == 'G') {
				arr[2]--;
			} else if (dna.charAt(i) == 'T') {
				arr[3]--;
			}
		}
		
		while (rp <= s-1) {
			if (dna.charAt(rp) == 'A') {
				arr[0]--;
			} else if (dna.charAt(rp) == 'C') {
				arr[1]--;
			} else if (dna.charAt(rp) == 'G') {
				arr[2]--;
			} else if (dna.charAt(rp) == 'T') {
				arr[3]--;
			}
			
			cnt++;
			
			for (int i = 0; i < 4; i++) {
				if (arr[i] > 0) {
					cnt--;
					break;
				}
			}
			
			if (dna.charAt(lp) == 'A') {
				arr[0]++;
			} else if (dna.charAt(lp) == 'C') {
				arr[1]++;
			} else if (dna.charAt(lp) == 'G') {
				arr[2]++;
			} else if (dna.charAt(lp) == 'T') {
				arr[3]++;
			}
			
			
			lp++;
			rp++;
		}
		System.out.println(cnt);
	}
}

package BOJ;

import java.util.Scanner;

public class BOJ2018 {

	public static void main(String[] args) {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int lp = 1, rp = 1, cnt = 0, sum = 1;
		
		while (lp <= rp) {
			if (sum < n) {
				rp += 1;
				sum += rp;
			} else if (sum > n) {
				sum -= lp;
				lp += 1;
			} else {
				cnt += 1;
				rp += 1;
				sum += rp;
			}
		}
		System.out.println(cnt);
	}

}

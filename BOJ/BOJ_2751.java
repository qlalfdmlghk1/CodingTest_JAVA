package BOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_2751 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List lists = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			lists.add(num);
		}
		Collections.sort(lists);
		for (int i = 0; i < n; i++) {
			System.out.println(lists.get(i));
		}
	}

}
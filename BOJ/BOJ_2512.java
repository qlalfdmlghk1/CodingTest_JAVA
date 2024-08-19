package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2512 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
//        int n = Integer.parseInt(br.readLine());
        
//        int[] moneys = new int[n];
//        st = new StringTokenizer(br.readLine());
        
//        for (int i = 0; i < n; i++) {
//            moneys[i] = Integer.parseInt(st.nextToken());
//        }
        
//        int m = Integer.parseInt(br.readLine());
				
		// 첫 번째 줄에서 n 값을 읽어옴
        int n = Integer.parseInt(br.readLine());
        
        // 두 번째 줄에서 moneys 배열을 채움
        int[] moneys = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            moneys[i] = Integer.parseInt(st.nextToken());
        }
        
        // 세 번째 줄에서 m 값을 읽어옴
        int m = Integer.parseInt(br.readLine());
        
		Arrays.sort(moneys);
		int start = 0;
		int end = moneys[n-1];
		int result = 0;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			int total = 0;
			for (int i : moneys) {
				if (i > mid) {
					total += mid;
				} else {
					total += i;
				}
			}
			
			if (total <= m) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(result);
	}
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717 {
	static int M, N, a, b, c;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());  // 원소의 마지막 수
		M = Integer.parseInt(st.nextToken());  // 연산의 개수
		
		parents = new int[N+1];
		
		make();
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine().trim());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if (a == 0) union(b,c);
			else if (a == 1) {
				if (parents[findSet(b)] == parents[findSet(c)]) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}  // main 끝
	
	static void make() {
		for (int i = 0; i < N+1; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if (a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) return false;  // 이미 합쳐져 있음
		else {
			if (aRoot < bRoot) parents[bRoot] = aRoot;
			else parents[aRoot] = bRoot;
			return true;
		}
	}

}

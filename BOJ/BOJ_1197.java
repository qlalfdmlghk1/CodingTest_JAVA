package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1197 {
	static int V,E,a,b,c;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim());
		V = Integer.parseInt(st.nextToken());  // 정점 수
		E = Integer.parseInt(st.nextToken());  // 간선 수
		
		for (int v = 0; v < V; v++) {
			st = new StringTokenizer(br.readLine().trim());
			a = Integer.parseInt(st.nextToken());  // 정점1
			b = Integer.parseInt(st.nextToken());  // 정점2
			c = Integer.parseInt(st.nextToken());  // 가중치
		}
		
	}

}

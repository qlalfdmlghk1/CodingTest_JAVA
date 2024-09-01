package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1647 {
	static int N, M, a, b, c;
	static int[] parents;
	
	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int weight;
		
		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	static void make() {
		for (int i = 0; i < N+1; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if (a == parents[a]) return a;
		else return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) return false;
		else {
			if (aRoot < bRoot) parents[bRoot] = aRoot;
			else parents[aRoot] = bRoot;
			return true;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());  // 집의 개수
		M = Integer.parseInt(st.nextToken());  // 길의 개수
		
		parents = new int[N+1];
		make();
		
		Edge[] edges = new Edge[M];  // 간선 배열 초기화
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine().trim());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			edges[m] = new Edge(a,b,c);
		}
		Arrays.sort(edges);
		int cnt = 0, cost = 0;  // 간선 수와 총 비용 초기화
		for (Edge edge: edges) {
			if (union(edge.start, edge.end)) {  // 간선 연결 시도
				cnt++;
				cost += edge.weight;    // 연결된 간선의 가중치를 비용에 추가
				if (cnt == N-2) break;  // 마지막 정점이 가장 길기 때문에 마지막 길 제외하고 연결
			}
		}
		System.out.println(cost);
	}
}

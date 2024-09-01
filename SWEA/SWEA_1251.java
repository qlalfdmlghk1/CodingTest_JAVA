package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1251 {
	static int T, N;
	static double E;
	static int[] parents, X, Y;
	static List<Edge> edgeList;
	
	static class Edge implements Comparable<Edge> {
		int start, end;
		long weight;

		public Edge(int start, int end, long weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
	}
	
	static void make() {
		parents = new int[N+1];
		for (int i = 0; i < N; i++) {
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
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t < T+1; t++) {
			N = Integer.parseInt(br.readLine().trim());
			X = new int[N];
			Y = new int[N];
			st = new StringTokenizer(br.readLine().trim());
			for (int n = 0; n < N; n++) {
				X[n] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine().trim());
			for (int n = 0; n < N; n++) {
				Y[n] = Integer.parseInt(st.nextToken());
			}
			E = Double.parseDouble(br.readLine().trim());
			
			edgeList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					long distX = Math.abs(X[i] - X[j]);
					long distY = Math.abs(Y[i] - Y[j]);
					edgeList.add(new Edge(i, j, (distX * distX + distY * distY)));
				}
			}
			
			edgeList.sort(null);
			
			make();
			
			int cnt = 0; 
			long ans = 0;
			for (Edge edge : edgeList) {
				if (union(edge.start, edge.end)) {
					cnt++;
					ans += edge.weight;
					if (cnt == N-1) break;
				}
			}
			ans = Math.round(ans * E);
			System.out.println("#" + t + " " + ans);
		}  // tc 반복문
	}
}

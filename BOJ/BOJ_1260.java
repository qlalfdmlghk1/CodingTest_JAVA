package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1260 {
	static int N,M,V,u,v;  
	static List<Integer> answer;
	static List<List<Integer>> graph;
	static boolean[] visited; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());  // 정점 수
		M = Integer.parseInt(st.nextToken());  // 간선 수
		V = Integer.parseInt(st.nextToken());  // 탐색 시작 정점 번호
		
		graph = new ArrayList<>();
		for (int n = 0; n < N+1; n++) {
			graph.add(new ArrayList<>());
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine().trim());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
        
		for (int n = 1; n <= N; n++) {
            Collections.sort(graph.get(n));
        }
		
		visited = new boolean[N+1];
		DFS(V);
		System.out.println();
		BFS(V);
		for (int a : answer) {
			System.out.print(a + " ");
		}
	}
	
	public static void DFS(int v) {
		visited[v] = true;
		System.out.print(v + " ");
		
		// 인접 노드들 재귀적 방문
		for (int nex : graph.get(v)) {
			if (!visited[nex]) {
				DFS(nex);
			}
		}
	}
	
	public static void BFS(int v) {
		answer = new ArrayList<>();
		answer.add(v);
		visited = new boolean[N+1];
		visited[v] = true;
		Deque<Integer> q = new ArrayDeque<>();
		q.add(v);
		while (!q.isEmpty()) {
			int cur = q.pollFirst();
			for (int nex : graph.get(cur)) {
				if (!visited[nex]) {
					q.add(nex);
					visited[nex] = true;
					answer.add(nex);
				}
			}
		}
	}
}

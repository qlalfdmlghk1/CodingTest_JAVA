package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18352 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		List<Integer> answer = new ArrayList<>();
		List<List<Integer>> graph = new ArrayList<>(); 
		for (int i = 0; i <= n + 1; i++) {
			graph.add(new ArrayList<>());		// 2중 리스트(리스트 안에 리스트)
		}
		
		boolean[] visited = new boolean[n+1];	// 기본값 : false
		int[] distance = new int[n+1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
		}
		
		bfs(x, graph, visited, distance);
		
		for (int i = 0; i < n + 1; i++) {
			if (distance[i] == k) {
				answer.add(i);
			}
		}
		
		if (answer.isEmpty()) {
			System.out.println(-1);
		} else {
			for (int a : answer) {
				System.out.println(a);
			}
		}
	}
		
	public static void bfs(int v, List<List<Integer>> graph, boolean[] visited, int[] distance) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visited[v] = true;
		distance[v] = 0;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int nex : graph.get(cur)) {
				if (!visited[nex]) {
					visited[nex] = true;
					distance[nex] = distance[cur] + 1;
					q.add(nex);
				}
			}
		}
	}
}

package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_9934 {
	static int K;
	static int x = 0;
	static int[] nodes;
	static List<List<Integer>> answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine().trim());

		st = new StringTokenizer(br.readLine().trim());
		
		int len = (int) Math.pow(2, K) - 1;
		nodes = new int[len];
		
		for (int i = 0; i < len; i++) {
			nodes[i] = Integer.parseInt(st.nextToken());
		}
		
		
		answer = new ArrayList<>();    // 이 줄을 빼먹어서 계속 오류가 났었음
		for (int k = 0; k < K; k++) {
			answer.add(new ArrayList<>());
		}
		makeTree(nodes, 0);
		
		for (List<Integer> ans : answer) {
			for (int a = 0; a < ans.size(); a++) {
				System.out.print(ans.get(a) + " ");
			}
			System.out.println();
		}
		
	}  // main 함수 끝
	

	public static void makeTree(int[]arr, int x) {
		int root = arr.length / 2;
		answer.get(x).add(arr[root]);
		if (root == 0) return;
		
		// 배워갑니다 : copyOfRange(배열, 시작 인덱스, 끝 인덱스)
		int[] leftTree = Arrays.copyOfRange(arr,0,root);
		int[] rightTree = Arrays.copyOfRange(arr,root+1,arr.length);
		
		makeTree(leftTree, x+1);
		makeTree(rightTree, x+1);
	}
}

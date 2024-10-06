package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_1226 {
	static int N;
	static long line;
	static int[][] grid;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 1; t < 11; t++) {
			N = Integer.parseInt(br.readLine().trim());
			grid = new int[16][16];
			for (int i = 0; i < 16; i++) {
				line = Long.parseLong(br.readLine().trim());
				for (int j = 0; j < 16; j++) {
					grid[i][j] = (int) ((line / Math.pow(10,(15-j))) % 10); 
				}
			}
			
			for (int i = 0; i < 16; i++) {
				for (int j = 0; j < 16; j++) {
					if (grid[i][j] == 2) {
						if (bfs(i,j)) {
							System.out.println("#" + N + " " + 1);
						} else {
							System.out.println("#" + N + " " + 0);
						}
					}
				}
			}
		}
		
	}
	
	public static boolean bfs(int r, int c) {
		Deque<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[16][16];
		int[] dr = {1,-1,0,0};
		int[] dc = {0,0,1,-1};
		int[] start = {r,c}; 
		q.add(start);
		
		while (!q.isEmpty()) {
			int[] cur = q.pollFirst();
			int curR = cur[0];
			int curC = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nexR = curR + dr[i];
				int nexC = curC + dc[i];
				if (0 <= nexR && nexR < 16 && 0 <= nexC && nexC < 16 && !visited[nexR][nexC] && grid[nexR][nexC] != 1) {
					if (grid[nexR][nexC] == 3) {
						return true;
					}
					int[] nex = {nexR,nexC};
					q.add(nex);
					visited[nexR][nexC] = true;
				}
			}
		}
		return false;
	}

}

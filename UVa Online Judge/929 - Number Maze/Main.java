import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m;
	private static int[][] grid = new int[1000][1000];
	private static int[][] distance = new int[1000][1000];
	private static int[] dx = {0, 0, -1, 1};
	private static int[] dy = {-1, 1, 0, 0};
	private static boolean[][] visited = new boolean[1000][1000];

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int _ = 0; _ < tc; ++_) {
			n = readInt();
			m = readInt();
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < m; ++j) {
					grid[i][j] = readInt();	
					distance[i][j] = 1000000000;
					visited[i][j] = false;
				}
			}
		//	print();
			System.out.println(dijkstra());	
		}
	}

	private static int dijkstra() {
		PriorityQueue<QEntry> queue = new PriorityQueue<QEntry>();
		queue.add(new QEntry(0, 0, grid[0][0]));
		while (!queue.isEmpty()) {
			QEntry u = queue.poll();
			if (u.x == n-1 && u.y == m-1) return u.dist;
			if (!visited[u.x][u.y]) {
				visited[u.x][u.y] = true;
				for (int i = 0; i < 4; ++i) {
					int xi = u.x + dx[i];
					int yi = u.y + dy[i];
					if (xi >= 0 && xi < n && yi >= 0 && yi < m && u.dist + grid[xi][yi] < distance[xi][yi]) {
						queue.add(new QEntry(xi, yi, u.dist + grid[xi][yi]));
						distance[xi][yi] = u.dist + grid[xi][yi];
					}
				}
			}
		}
		return Integer.MAX_VALUE;
	}

	private static void print() {
		for (int i = 0; i < n+2; ++i) {
			for (int j = 0; j < m+2; ++j) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		} 
		System.out.println();
	}

	private static class QEntry implements Comparable<QEntry> {
		int x, y, dist;
		public QEntry(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		public int compareTo(QEntry q) {
			return dist - q.dist;
		}
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}

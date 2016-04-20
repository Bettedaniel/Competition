import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m;
	private static boolean[][] wetlands;
	private static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		stdin.readLine();
		for (int _ = 0; _ < tc; ++_) {
			int i1 = 1;
			wetlands = new boolean[101][101];
			graph = new ArrayList[10000];
			String s = "";
			while (true) {
				try {
					s = stdin.readLine();
					if (i1 == 1) m = s.length();
					for (int j = 1; j <= s.length(); ++j) {
						if (s.charAt(j-1) == 'W') {
							wetlands[i1][j] = true;
						}
					}
					if ((int)s.charAt(0) >= 48 && (int)s.charAt(0) <= 58) break;
					++i1;
				} catch (Exception e) {
					break;
				}
			}
			n = i1;
			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= m; ++j) {
					graph[i + (j-1)*n] = new ArrayList<Integer>();
				}
			}
			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= m; ++j) {
					if (wetlands[i][j]) {
						int from = i + (j-1)*n;
						for (int a = -1; a <= 1; ++a) {
							for (int b = -1; b <= 1; ++b) {
								if (!(a == 0 && b == 0)) {
									if (wetlands[i+a][j+b]) {
										int to = (i+a) + ((j+b)-1)*n;
										graph[from].add(to);
										graph[to].add(from);
									}	
								}
							}
						}
					}	
				}
			}
			StringTokenizer st1 = new StringTokenizer(s);
			int x = Integer.parseInt(st1.nextToken());
			int y = Integer.parseInt(st1.nextToken());
			while (true) {
				try {
					int start = x + (y-1)*n;
					if (wetlands[x][y]) System.out.println(bfs(start));
					else System.out.println("0");
					s = stdin.readLine();
					if (s.equals("")) break;
					st1 = new StringTokenizer(s);
					x =  Integer.parseInt(st1.nextToken());
					y = Integer.parseInt(st1.nextToken());
				} catch (Exception e) {
					break;
				}
			}
			if (_ != tc-1) System.out.println();
		}
	}

	private static int bfs(int start) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[n*m + 1];
		visited[start] = true;
		queue.add(start);
		int size = 0;
		while (!queue.isEmpty()) {
			int u = queue.poll();
			++size;
			for (Integer v : graph[u]) {
				if (!visited[v]) {
					visited[v] = true;
					queue.add(v);
				}
			}
		}
		return size;
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(stdin.readLine());
		}
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}

import java.util.*;
import java.io.*;

public class Main {

	private static int[][] graveyard; //0 grass, -1 stone, 1 hauntedhole.
	private static int w, h, stones;
	private static HashMap<Integer, Edge> hauntedholes;
	private static HashSet<Edge> edges;
	private static int[] weights;
	private static boolean never;
	private static ArrayList<Integer>[] graph;
	private static boolean[] visited;
	
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = new StringTokenizer("");


	public static void main(String[] args) throws Exception {
		w = readInt();
		h = readInt();
		while (w != 0 || h != 0) {
			stones = readInt();
			graveyard = new int[w][h];
			hauntedholes = new HashMap<Integer, Edge>();
			edges = new HashSet<Edge>();
			weights = new int[w*h];
			graph = new ArrayList[w*h];
			Arrays.fill(graph, new ArrayList<Integer>());
			Arrays.fill(weights, 100000000);
			weights[0] = 0;
			for (int i = 0; i < stones; ++i) {
				int x = readInt();
				int y = readInt();
				graveyard[x][y] = -1;
			}
			int holes = readInt();
			for (int i = 0; i < holes; ++i) {
				int x1 = readInt();
				int y1 = readInt();
				int x2 = readInt();
				int y2 = readInt();
				int t = readInt();
				graveyard[x1][y1] = 1;
				hauntedholes.put(x1 + y1*w, new Edge(x2, y2, t));
			}
			for (int i = 0; i < w; ++i) {
				for (int j = 0; j < h; ++j) {
					int pos = i + j * w;
					if (pos != w*h - 1) {
						if (graveyard[i][j] != -1) {
							if (graveyard[i][j] == 1) {
								Edge e = hauntedholes.get(pos);
								edges.add(new Edge(pos, e.u + (e.v*w), e.w));
								graph[pos].add(e.u + (e.v*w));
							} else {
								for (int a = -1; a < 2; a+=2) {
									if (i + a >= 0 && i + a < w && graveyard[i + a][j] != -1) {
										edges.add(new Edge(pos, (i+a) + j*w, 1));
										graph[pos].add((i+a) + j*w);
										if (graveyard[i+a][j] == 0 && ((i+a) + j*w) != w*h - 1) {
											edges.add(new Edge((i+a) + j*w, pos, 1));
											graph[(i+a) + j*w].add(pos);
										}
									}
									if (j + a >= 0 && j + a < h && graveyard[i][j + a] != -1) {
										edges.add(new Edge(pos, i + (j + a)*w, 1));
										graph[pos].add(i + (j + a)*w);
										if (graveyard[i][j+a] == 0 && (i + (j + a)*w) != w*h - 1) {
											edges.add(new Edge(i + (j + a)*w, pos, 1));
											graph[i + (j + a)*w].add(pos);
										}
									}
								}
							}
						}
					}
				}
			}
			bellmanford();
			if (never) System.out.println("Never");
			else if (weights[w*h - 1] != 100000000) System.out.println(weights[w*h - 1]);
			else System.out.println("Impossible");
			w = readInt();
			h = readInt();
		}
	}

	private static void bellmanford() {
		never = false;
		int[] parent = new int[w*h];
		for (int i = 0; i < w*h - stones - 1; ++i) {
			for (Edge e : edges) {
				if (weights[e.u] != 100000000 && weights[e.v] > weights[e.u] + e.w) {
					weights[e.v] = weights[e.u] + e.w;
					parent[e.v] = e.u;
				}
			}
		}
		for (Edge e : edges) {
			if (weights[e.u] != 100000000 &&weights[e.v] > weights[e.u] + e.w) {
				never = true;
				break;
			}
		}
	}

	private static class Edge {
		int u, v, w;
		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}

		public boolean equals(Object o) {
			return this.u == ((Edge)o).u && this.v == ((Edge)o).v && ((Edge)o).w == this.w;
		}

		public int hashCode() {
			return 3*u + 11*v + 89*w;
		}
	}
	
	static String readString() throws Exception {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(stdin.readLine());
		}
		return st.nextToken();
	}

	// Read next input-token as integer.
	static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}

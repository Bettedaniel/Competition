import java.util.*;
import java.io.*;

public class Main {
	
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m, previous;
	private static ArrayList<Edge>[] graph;
	private static HashSet<Integer>[] map;
	private static boolean[] contained, check;
	private static PriorityQueue<Edge> queue;
	private static ArrayList<Pair> list;

	public static void main(String[] args) throws Exception {
		try {
			int t = 0;
			int testcases = readInt();
			while (true) {
				n = readInt(); //n <= 750
				int[][] input = new int[n+1][2];
				graph = new ArrayList[n+1];
				map = new HashSet[n+1];
				if (t != 0) System.out.println();
				for (int i = 1; i <= n; ++i) {
					int x = readInt();
					int y = readInt();
					input[i][0] = x;
					input[i][1] = y;
					graph[i] = new ArrayList<Edge>();
					map[i] = new HashSet<Integer>();
				}
				m = readInt();
				check = new boolean[n+1];
				for (int i = 0; i < m; ++i) {
					int a = readInt();
					int b = readInt();
					check[a] = true;
					check[b] = true;
					map[a].add(b);
					map[b].add(a);
				}
				for (int i = 1; i <= n; ++i) {
					for (int j = i+1; j <= n; ++j) {
						if (check[i] && check[j] && map[i].contains(j)) {
							graph[i].add(new Edge(i, j, 0.0));
							graph[j].add(new Edge(j, i, 0.0));
						} else {
							double dist = Math.sqrt(Math.pow(input[i][0] - input[j][0], 2) + Math.pow(input[i][1] - input[j][1], 2));
							graph[i].add(new Edge(i, j, dist));
							graph[j].add(new Edge(j, i, dist));
						}
					}
				}
				list = new ArrayList<Pair>();
				contained = new boolean[n+1];
				queue = new PriorityQueue<Edge>();
				queue.add(new Edge(0, 1, 0.0));
				double result = mst();
				if (result != 0.0) {
					for (Pair p : list) {
						if (!map[p.a].contains(p.b) && !map[p.b].contains(p.a) && p.a != p.b) System.out.println(p.a + " " + p.b);
					}
				} else {
					System.out.println("No new highways need");
				}
				++t;
			}
		} catch (Exception e) {
			return;
		}	
	}

	private static class Pair {
		int a, b;
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	private static double mst() {
		int max = n;
		double mstValue = 0;
		int count = 0;
		while (!queue.isEmpty()) {
			Edge e = queue.poll();
			if (contained[e.to]) continue;
			contained[e.to] = true;
			mstValue += e.dist;
			if (e.from != e.to && e.from != 0 && e.dist != 0.0) list.add(new Pair(e.from, e.to));
			++count;
			if (count == max) break;
			for (Edge e1 : graph[e.to]) {
				if (!contained[e1.to]) queue.add(new Edge(e.to, e1.to, e1.dist));
			}
		}
		return mstValue;
	}



	private static class Edge implements Comparable<Edge> {
		int from, to;
		double dist;
		public Edge(int from, int to, double dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}

		public int compareTo(Edge e) {
			return (int)(dist*100000.0) - (int)(e.dist*100000.0);
		}

//		public String toString() {
//			return to + " " + (Math.round(dist*1000.0)/1000);
//		}
	}

	private static String rTDP(double d) {
		String s = Double.toString((double)(Math.round(d*100.0))/100);
		int index = -1;
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '.') {
				index = i;
				break;
			}
		}
		String result = s.substring(0, index+1);
		String ap = s.substring(index+1, s.length());
		while (ap.length() < 2) { 
			ap += "0";
		}
		return result + ap;
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


import java.util.*;
import java.io.*;

public class Main {

	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m;
	private static PriorityQueue<Edge> queue;
	private static ArrayList<Edge> list;
	private static HashSet<Edge> mintree, check;
	private static ArrayList<Integer>[] graph;
	private static ArrayList<Integer> answers;
	private static ArrayList<Integer>[] weights;
	private static boolean[] included;
	private static int[][] identifiers;

	public static void main(String[] args) throws Exception {
		n = readInt();
		m = readInt();
		while (n != 0 || m != 0) {
			queue = new PriorityQueue<Edge>();
			list = new ArrayList<Edge>();
			graph = new ArrayList[n];
			weights = new ArrayList[n];
			mintree = new HashSet<Edge>();
			answers = new ArrayList<Integer>();
			check = new HashSet<Edge>();
			identifiers = new int[n][n];
			for (int i = 0; i < n; ++i) {
				graph[i] = new ArrayList<Integer>(); 
				weights[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < m; ++i) {
				int from = readInt();
				int to = readInt();
				int w = readInt();
				graph[from].add(to);
				graph[to].add(from);
				list.add(new Edge(from, to, w, i+1));
				weights[from].add(w);
				weights[to].add(w);
				identifiers[from][to] = i+1;
				identifiers[to][from] = i+1;
			}
			included = new boolean[n];
			for (int i = 0; i < n; ++i) {
				if (!included[i]) mst(i);
			}
			for (Edge e : list) {
				if (!mintree.contains(e) && !mintree.contains(new Edge(e.to, e.from, e.weight, e.identifier))) {
					answers.add(e.weight);	
					check.add(e);
				}
			}
			Collections.sort(answers);
			if (answers.size() > 0) {
				for (int i = 0; i < answers.size(); ++i) {
					if (i != answers.size() - 1) System.out.print(answers.get(i) + " ");
					else System.out.print(answers.get(i));
				}
			} else System.out.print("forest");
			System.out.println();
			n = readInt();
			m = readInt();
		}
	}

	private static void mst(int start) {
		boolean[] vis = new boolean[n];
		queue.add(new Edge(-1, start, 0, 0));
		int count = 0;
		while (!queue.isEmpty()) {
			Edge e = queue.poll();
			if (!vis[e.to] && e.from != -1) {
				mintree.add(new Edge(e.from, e.to, e.weight, e.identifier));
			}
			if (!vis[e.to]) ++count;
			if (count == n) break;
			vis[e.to] = true;
			included[e.to] = true;
			for (int i = 0; i < graph[e.to].size(); ++i) {
				if (!vis[graph[e.to].get(i)]) {
					queue.add(new Edge(e.to, graph[e.to].get(i), weights[e.to].get(i), identifiers[e.to][graph[e.to].get(i)]));	
				}	
			}	
		}	
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

	private static class Edge implements Comparable<Edge> {
		int from, to, weight, identifier;
		public Edge(int from, int to, int weight, int identifier) {
			this.from = from;
			this.to = to;
			this.weight = weight;
			this.identifier = identifier;
		}

		public int compareTo(Edge e) {
			return weight - e.weight;
		}

		public boolean equals(Object o) {
			return ((Edge)o).from == from && ((Edge)o).to == to && ((Edge)o).weight == weight && ((Edge)o).identifier == identifier; 
		}

		public int hashCode() {
			return 3*from + 83*to + 103*weight;
		}
	}
}

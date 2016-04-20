import java.util.*;
import java.io.*;

public class Main {
	
	private static int v, m, n;
	private static long min;
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st1 = new StringTokenizer("");
	private static long[][] input;
	private static ArrayList<Integer>[] graph;
	private static int[] bfsdist;

	public static void main(String[] args) throws Exception {
		v = readInt();
		m = readInt();
		while (v != 0 || m != 0) {
			min = (long)v*(long)m*1000*60;
			input = new long[1003][2];
			String s = nextLine();
			n = 0; 
			while (!s.equals("")) {
				StringTokenizer st = new StringTokenizer(s);
				long x = (long)(Double.parseDouble(st.nextToken(" ")) * 1000);
				long y = (long)(Double.parseDouble(st.nextToken(" ")) * 1000);
				input[n][0] = x;
				input[n][1] = y;
				++n;
				s = nextLine();
			}
			graph = new ArrayList[n];
			for (int i = 0; i < n; ++i) graph[i] = new ArrayList<Integer>();
			for (int i = 0; i < n-1; ++i) {
				for (int j = i+1; j < n; ++j) {
					long dist = pow2(input[j][0] - input[i][0]) + pow2(input[j][1] - input[i][1]);	
					if (dist < min*min) {
						graph[i].add(j);
						graph[j].add(i);
					}
				}
			}
			bfsdist = new int[n];
			bfs();
			if (bfsdist[1] != 0) System.out.println("Yes, visiting " + (bfsdist[1]-1) + " other holes.");
			else System.out.println("No.");
			v = readInt();
			m = readInt();
		}
	}

	private static void bfs() {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[n];
		queue.add(0);
		visited[0] = true;
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (Integer v : graph[u]) {
				if (!visited[v]) {
					bfsdist[v] = bfsdist[u] + 1;
					queue.add(v);
					visited[v] = true;
				}
			}
		}
	}

	private static long pow2(long k) {return k * k;}

	private static String readString() throws Exception {
		while (!st1.hasMoreTokens()) st1 = new StringTokenizer(stdin.readLine());
		return st1.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}

	private static String nextLine() throws Exception {
		return stdin.readLine();
	}
}

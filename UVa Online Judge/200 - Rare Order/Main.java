import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static ArrayList<Integer>[] graph;
	private static HashSet<Integer>[] has;
	private static ArrayList<String> input;
	private static int[] indegree;
	private static boolean[] included;
	private static int n;

	public static void main(String[] args) throws Exception {
		while (true) {
			try {
				graph = new ArrayList[91];
				has = new HashSet[91];
				input = new ArrayList<String>();
				indegree = new int[91];
				for (int i = 65; i < 91; ++i) {
					graph[i] = new ArrayList<Integer>();
					has[i] = new HashSet<Integer>();
				}
				String s = readString();
				n = 0;
				while (!s.equals("#")) {
					input.add(s);
					++n;
					s = readString();
				}
				included = new boolean[91];
				for (int i = 0; i < n-1; ++i) {
					String a = input.get(i);
					for (int j = i+1; j < n; ++j) {
						String b = input.get(j);
						int k = 0;
						while (b.charAt(k) == a.charAt(k)) {
							++k;
							if (k >= Math.min(b.length(), a.length())) break;
						}
						if (k < Math.min(b.length(), a.length())) {
							int cha = (int)a.charAt(k);
							int chb = (int)b.charAt(k);
							included[cha] = true;
							included[chb] = true;
							if (!has[cha].contains(chb) && cha != chb) {
								graph[cha].add(chb);
								has[cha].add(chb);
								++indegree[chb];
							}
						}
					}
				}
				PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
				for (int i = 65; i < 91; ++i) {
					if (indegree[i] == 0 && included[i]) queue.add(i);
				}
				String result = "";
				while (!queue.isEmpty()) {
					int u = queue.poll();
					result += (char)u;
					for (Integer v : graph[u]) {
						--indegree[v];
						if (indegree[v] == 0) {
							queue.add(v);
						}
					}	
				}
				System.out.println(result);
			} catch (Exception e) {return;}
		}
	}
	
	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}
}

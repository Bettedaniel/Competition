import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int _ = 0; _ < tc; ++_) {
			int p = readInt();
			graph = new ArrayList[p+1];
			for (int i = 1; i <= p; ++i) graph[i] = new ArrayList<Integer>();
			for (int i = 1; i <= p; ++i) {
				String s = stdin.readLine();
				StringTokenizer st1 = new StringTokenizer(s);
				while (st1.hasMoreTokens()) {
					graph[i].add(Integer.parseInt(st1.nextToken()));
				}
			}
			int min = Integer.MAX_VALUE;
			ArrayList<Integer> results = new ArrayList<Integer>();
			for (int i = 1; i <= p; ++i) {
				if (graph[i].size() < min) {
					min = graph[i].size();
					results.clear();
					results.add(i);
				} else if (graph[i].size() == min) {
					results.add(i);
				}
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < results.size(); ++i) {
				if (i == 0) sb.append(results.get(i));
				else sb.append(" " + results.get(i));
			}
			System.out.println(sb.toString());
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

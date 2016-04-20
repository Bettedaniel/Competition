import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int[] frequency;
	private static HashMap<Pair, Integer> map;

	public static void main(String[] args) throws Exception {
		while (true) {
			try {
				int n = readInt();
				int queries = readInt();
				frequency = new int[1000001];
				map = new HashMap<Pair, Integer>();
				for (int i = 1; i <= n; ++i) {
					int t = readInt();
					++frequency[t];
					map.put(new Pair(t, frequency[t]), i);
				}
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < queries; ++i) {
					if (i != 0) sb.append("\n");
					int k = readInt();
					int v = readInt();
					Pair temp = new Pair(v, k);
					if (map.containsKey(temp)) {
						sb.append(map.get(temp));
					} else {
						sb.append("0");
					}
				}
				System.out.println(sb.toString());
			} catch (Exception e) {
			//	e.printStackTrace();
				return;
			}
		}
	}

	private static class Pair {
		int v, k;
		public Pair(int v, int k) {
			this.v = v;
			this.k = k;
		}
		public int hashCode() {
			return 91*v + 22697*k;
		}
		public boolean equals(Object o) {
			Pair p = (Pair)o;
			return p.v == v && p.k == k;
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

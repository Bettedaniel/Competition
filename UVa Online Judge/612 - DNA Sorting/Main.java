import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int l, n;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int t = 0; t < tc; ++t) {
			l = readInt();
			n = readInt();
			if (t != 0) System.out.println();
			PriorityQueue<Entry> results = new PriorityQueue<Entry>();
			for (int i = 0; i < n; ++i) {
				String s = readString();
				results.add(new Entry(i, sortedness(s), s));
			}
			while (!results.isEmpty()) {
				Entry e = results.poll();
				System.out.println(e.s);
			}
		}
	}

	private static int sortedness(String s) {
		char[] sch = s.toCharArray();
		int answer = 0;
		for (int i = 0; i < l; ++i) {
			for (int j = i+1; j < l; ++j) {
				if ((int)sch[i] > (int)sch[j]) {
					++answer;
				}
			}
		}
		return answer;
	}

	private static class Entry implements Comparable<Entry> {
		int index, sortedness;
		String s;
		public Entry(int index, int sortedness, String s) {
			this.index = index;
			this.sortedness = sortedness;
			this.s = s;
		}
		public int compareTo(Entry e) {
			if (sortedness == e.sortedness) return index - e.index;
			return sortedness - e.sortedness;
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
}

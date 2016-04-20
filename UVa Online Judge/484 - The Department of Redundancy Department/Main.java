import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static ArrayList<Pair> list;
	private static HashSet<Integer> visited;
	private static HashMap<Integer, Integer> numbertopos;

	public static void main(String[] args) throws Exception {
		list = new ArrayList<Pair>();
		visited = new HashSet<Integer>();
		numbertopos = new HashMap<Integer, Integer>();
		int i = 0;
		while (true) {
			try {
				int next = readInt();
				if (!visited.contains(next)) {
					visited.add(next);
					list.add(new Pair(next, 1));
					numbertopos.put(next, i);
					++i;					
				} else {
					int index = numbertopos.get(next);
					list.get(index).inc();
				}
			} catch (Exception e) {break;}
		}
		for (int j = 0; j < i; ++j) {
			Pair p = list.get(j);
			System.out.println(p.number + " " + p.freq);
		}
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}

	private static class Pair {
		int number, freq;
		public Pair(int number, int freq) {
			this.number = number;
			this.freq = freq;
		}
		private void inc() {
			++freq;
		}
	}
}

import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static ArrayList<Integer> list;
	private static PriorityQueue<Pair> results;
	private static int goal;

	public static void main(String[] args) {
		while (true) {
			try {
				String s = stdin.readLine();
				list = new ArrayList<Integer>();
				st = new StringTokenizer(s);
				goal = Integer.parseInt(st.nextToken());
				boolean[] visited = new boolean[goal+1];
				st.nextToken();
				while (st.hasMoreTokens()) {
					int a = Integer.parseInt(st.nextToken());
					if (!visited[a]) {
						list.add(a);
						visited[a] = true;
					}
				}
				Collections.sort(list);
				results = new PriorityQueue<Pair>();
				int temp = goal;
				solve("", temp, list.size());
				Pair winner = results.poll();
				System.out.println(winner.s + "sum:" + (goal - winner.sum));
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		}
	}

	private static void solve(String s, int n, int idx) {
		boolean b = true;
		for (int i = idx-1; i >= 0; --i) {
			if (list.get(i) <= n) {
				solve(list.get(i) + " " + s, n-list.get(i), i);
				b = false;
			}
		}
		if (b) {
			if (!results.isEmpty() && results.peek().sum > n) {
				results.add(new Pair(s, n));
			} else if (results.isEmpty()) results.add(new Pair(s, n));
		}
	}

	private static class Pair implements Comparable<Pair> {
		String s;
		int sum;
		public Pair(String s, int sum) {
			this.s = s;
			this.sum = sum;
		}
		public int compareTo(Pair p) {
			return sum - p.sum;
		}
	}
}

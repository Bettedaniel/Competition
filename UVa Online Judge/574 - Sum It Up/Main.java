import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m;
	private static int[] numbers;
	private static ArrayList<String> list;
	private static HashSet<String> vis;

	public static void main(String[] args) throws Exception {
		n = readInt();
		m = readInt();
		while (n != 0 || m != 0) {
			numbers = new int[m];
			for (int i = 0; i < m; ++i) {
				numbers[i] = readInt();
			}
			list = new ArrayList<String>();
			vis = new HashSet<String>();
			solve(n, -1, "");
			Collections.sort(list);
			System.out.println("Sums of " + n + ":");
			if (list.size() > 0) {
				for (int i = list.size()-1; i >= 0; --i) {
					String temp = list.get(i);
					System.out.println(temp.substring(0, temp.length() - 1));
				}
			} else {
				System.out.println("NONE");
			}
			n = readInt();
			m = readInt();
		}
	}

	private static void solve(int k, int idx, String s) {
		if (k == 0) {
			if (!vis.contains(s)) {
				list.add(s);
				vis.add(s);
			}
			return;
		}
		for (int i = idx+1; i < m; ++i) {
			if (numbers[i] <= k) {
				solve(k-numbers[i], i, s+numbers[i]+"+");
			}
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

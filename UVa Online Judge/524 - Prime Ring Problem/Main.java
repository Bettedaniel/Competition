import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static boolean[] primes = new boolean[35];
	private static int n, t;
	private static StringBuilder list;
	private static HashSet<String> vis;

	public static void main(String[] args) throws Exception {
		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;
		for (int i = 2; i <= 34; ++i) {
			if (primes[i]) {
				for (int j = 2*i; j <= 34; j += i) {
					primes[j] = false;
				}
			}
		}
		t = 1;
		while (true) {
			try {
				n = readInt();
				vis = new HashSet<String>();
				list = new StringBuilder();
				if (t != 1) list.append("\n");
				list.append("Case " + t + ":");
				solve("1", 1, 1);
				System.out.println(list.toString());
				++t;
			} catch (Exception e) {
				break;
			}
		}
	}

	private static void solve(String s, int prev, int k) {
		if (n == k && primes[prev+1]) {
			list.append("\n");
			list.append(s);
			return;
		}
		boolean[] visited = new boolean[n+1];
		StringTokenizer st1 = new StringTokenizer(s);
		while (st1.hasMoreTokens()) visited[Integer.parseInt(st1.nextToken())] = true;
		for (int i = 2; i <= n; ++i) {
			if (primes[prev+i] && !visited[i]) {
				int k1 = k + 1;
				solve(s + " " + i, i, k1);
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

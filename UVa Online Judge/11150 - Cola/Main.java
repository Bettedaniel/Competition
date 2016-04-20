import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");

	public static void main(String[] args) throws Exception {
		while (true) {
			try {
				int n = readInt();
				System.out.println(solve(n+1));
			} catch (Exception e) {
			//	e.printStackTrace();
				return;
			}
		}
	}

	private static int solve(int n) {
		int k = n-1;
		while (n > 2) {
			n -= 2;
			++k;
		}
		return k;
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}

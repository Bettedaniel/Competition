import java.util.*;
import java.io.*;

public class Main {
	
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n;
	private static int[] ids;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int _ = 0; _ < tc; ++_) {
			n = readInt();
			ids = new int[n];
			for (int i = 0; i < n; ++i) {
				ids[i] = readInt();
			}
			for (int i = 1; true; ++i) {
				boolean b = true;
				boolean[] visited = new boolean[i];
				for (int j = 0; j < n; ++j) {
					if (visited[ids[j]%i]) {
						b = false;
						break;
					}
					visited[ids[j]%i] = true;
				}
				if (b) {
					System.out.println(i);
					break;
				}
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

import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n;
	private static int[][] input;

	public static void main(String[] args) throws Exception {
		n = readInt();
		while (n != 0) {
			input = new int[2*n][3];
			for (int i = 0; i < 2*n; ++i) {
				int a = readInt();
				int b = readInt();
				int c = readInt();
				input[i][0] = a;
				input[i][1] = b;
				input[i][2] = c;
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

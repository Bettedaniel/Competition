import java.util.*;
import java.io.*;

public class Main {

	private static int n, q;
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int[] input, count, orig;
	
	public static void main(String[] args) throws Exception {
		n = readInt();
		q = readInt();
		int c = 1;
		while (n != 0 || q != 0) {
			input = new int[n];
			count = new int[10010];
			orig = new int[10010];
			for (int i = 0; i < n; ++i) {
				input[i] = readInt();
			}
			orderArray(input);
			System.out.println("CASE# " + c + ":");	
			for (int i = 0; i < q; ++i) {
				int query = readInt();
				if (orig[query] > 0) System.out.println(query + " found at " + ((count[query] - orig[query]) + 1));
				else System.out.println(query + " not found");
			}
			n = readInt();
			q = readInt();
			++c;
		}
	}

	private static void orderArray(int[] in) {
		int max = -1;
		for (int i = 0; i < n; ++i) {
			if (max < in[i]) max = in[i];
			++count[in[i]];
			++orig[in[i]];
		}
		for (int i = 1; i <= max; ++i) {
			count[i] += count[i-1];
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

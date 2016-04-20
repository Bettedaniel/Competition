import java.util.*;
import java.io.*;

public class Main {

	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n;
	private static long result;
	private static int[] input;

	public static void main(String[] args) throws Exception {
		n = readInt();
		while (n != 0) {
			input = new int[n+1];
			for (int i = 1; i <= n; ++i) {
				input[i] = readInt();
			}
			result = 0;
			mergesort(1, n);
			System.out.println(result);
			n = readInt();
		}
	}

	private static void mergesort(int p, int r) {
		if (p < r) {
			int q = (p + r)/2;
			mergesort(p, q);
			mergesort(q+1, r);
			merge(p, q, r);
		}
	}

	private static void merge(int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] L = new int[n1 + 2];
		int[] R = new int[n2 + 2];
		for (int i = 1; i < n1 + 1; ++i) {
			L[i] = input[p + i - 1];
		}
		for (int j = 1; j < n2 + 1; ++j) {
			R[j] = input[q + j];
		}
		L[n1 + 1] = Integer.MAX_VALUE;
		R[n2 + 1] = Integer.MAX_VALUE;
		int i = 1;
		int j = 1;
		for (int k = p; k < r + 1; ++k) {
			if (L[i] <= R[j]) {
				input[k] = L[i];
				++i;
			} else {
				input[k] = R[j];
				result += n1 - (i - 1);
				++j;
			}
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

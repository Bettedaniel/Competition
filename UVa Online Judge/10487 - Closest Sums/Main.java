import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n;
	private static int[] numbers;
	private static ArrayList<Integer> sums;

	public static void main(String[] args) throws Exception {
		n = readInt();
		int t = 1;
		while (n != 0) {
			numbers = new int[n];
			System.out.println("Case " + t + ":");
			for (int i = 0; i < n; ++i) {
				numbers[i] = readInt();
			}
			sums = new ArrayList<Integer>();
			for (int i = 0; i < n; ++i) {
				for (int j = i+1; j < n; ++j) {
					sums.add(numbers[i] + numbers[j]);
				}
			}
			int q = readInt();
			for (int i = 0; i < q; ++i) {
				int query = readInt();
				int min = Integer.MAX_VALUE;
				int result = 0;
				for (int j = 0; j < sums.size(); ++j) {
					if (Math.abs(query - sums.get(j)) < min) {
						min = Math.abs(query - sums.get(j));
						result = sums.get(j);
					}
				}
				System.out.println("Closest sum to " + query + " is " + result + ".");
			}
			n = readInt();
			++t;
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

import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int maxStart, maxEnd, maxSum;
	private static int[] starts;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int t = 1; t <= tc; ++t) {
			int stops = readInt();
			int[] array = new int[stops-1];
			int[] original = new int[stops-1];
			for (int i = 0; i < stops-1; ++i) {
				array[i] = readInt();
				original[i] = array[i];
			}
			solve(array, stops-1);
			if (maxSum < 0) System.out.println("Route " + t + " has no nice parts");
			else {
				System.out.println("The nicest part of route " + t + " is between stops " + maxStart + " and " + maxEnd);
			}
		}
	}

	private static void solve(int[] d, int size) {
		int currentMaxSum = 0;
		maxSum = Integer.MIN_VALUE;
		maxStart = 1;
		maxEnd = 1;
		starts = new int[size];
		int from = 1;
		for (int to = 0; to < size; ++to) {
			currentMaxSum += d[to];
			if (currentMaxSum > maxSum || (currentMaxSum == maxSum && (to + 2 - from > maxEnd - maxStart))) {
				maxSum = currentMaxSum;
				maxStart = from;
				maxEnd = to + 2;
			}
			if (currentMaxSum < 0) {
				currentMaxSum = 0;
				from = to + 2;
				if (maxSum <= 0) {
					maxStart = from;
				} 
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

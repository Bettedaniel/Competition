import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static long start, end;

	public static void main(String[] args) throws Exception {
		start = readLong();
		end = readLong();
		while (start != 0 || end != 0) {
			long max = 0;
			long result = 0;
			for (long i = Math.min(start, end); i <= Math.max(start, end); ++i) {
				long temp = solve(i);
				if (temp > max) {
					max = temp;
					result = i;
				}
			}
			System.out.println("Between " + Math.min(start, end) + " and " + Math.max(end, start) + ", " + result + " generates the longest sequence of " + max + " values.");
			start = readLong();
			end = readLong();
		}
	}

	private static long solve(long k) {
		long count = 0;
		if (k == 1) return 3;
		while (k != 1) {
			if (k % 2 == 0) {
				k /= 2;
				++count;
			} else {
				k = 3*k + 1;
				++count;
			}
		}
		return count;
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static long readLong() throws Exception {
		return Long.parseLong(readString());
	}
}

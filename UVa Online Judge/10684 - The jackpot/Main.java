import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n;
	private static int[] numbers;

	public static void main(String[] args) throws Exception {
		n = readInt();
		while (n != 0) {
			numbers = new int[n];
			for (int i = 0; i < n; ++i) {
				numbers[i] = readInt();
			}
			int result = maxsum();
			if (result <= 0) {
				System.out.println("Losing streak.");
			} else {
				System.out.println("The maximum winning streak is " + result + ".");
			}
			n = readInt();
		}
	}

	private static int maxsum() {
		int maxhere = 0;
		int maxsofar = 0;
		for (int i = 0; i < n; ++i) {
			maxhere = Math.max(0, maxhere + numbers[i]);
			maxsofar = Math.max(maxsofar, maxhere);
		}
		return maxsofar;
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}

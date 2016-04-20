import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static final int MAX = 2000000000;
	private static int[] numbers = new int[700000];

	public static void main(String[] args) throws Exception {
		int size = 0;
		numbers[0] = 1;
		numbers[1] = 2;
		numbers[2] = 4;
		int i = 1;
		for (; numbers[numbers[i] - 1] < MAX; ++i) {
			for (int j = numbers[i]; j < numbers[i+1]; ++j) {
				numbers[j] = numbers[j-1] + i + 1;
			}
		}
		size = numbers[i] - 1;
		int n = readInt();
		while (n != 0) {
			int d = Integer.MAX_VALUE;
			int result = 0;
			for (int j = 0; j <= size; ++j) {
				if (n >= numbers[j] && n <= numbers[j+1]) {
					result = j+1;
				}
			}
			System.out.println(result);
			n = readInt();
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

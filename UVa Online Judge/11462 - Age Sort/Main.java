import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int[] numbers;
	private static int n;

	public static void main(String[] args) throws Exception {
		n = readInt();
		while (n != 0) {
			numbers = new int[101];
			int max = 0;
			for (int i = 0; i < n; ++i) {
		//		numbers[i] = readInt();
				int m = readInt();
				max = Math.max(m, max);
				++numbers[m];
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i <= max; ++i) {
				while (numbers[i] > 0) {
					if (numbers[i] == 1 && i == max) {
						sb.append(""+i);
						--numbers[i];
					} else {
						sb.append(i + " ");
						--numbers[i];
					}
				}
			}
		/*	Arrays.sort(numbers);
			for (int i = 0; i < n; ++i) {
				if (i == 0) System.out.print(numbers[i]);
				else System.out.print(" " + numbers[i]);
			} */
			System.out.println(sb.toString());
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

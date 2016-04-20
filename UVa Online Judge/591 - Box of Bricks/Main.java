import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int[] bricks;

	public static void main(String[] args) throws Exception {
		int n = readInt();
		int t = 1;
		while (n != 0) {
			bricks = new int[n];
			int max = 0;
			for (int i = 0; i < n; ++i) {
				bricks[i] = readInt();
				max += bricks[i];
			}
			int size = max/n;
			int result = 0;
			for (int i = 0; i < n; ++i) {
				if (bricks[i] > size) {
					result += bricks[i] - size;
				}
			}
			System.out.println("Set #" + t);
			System.out.println("The minimum number of moves is " + result + ".");
			System.out.println();
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

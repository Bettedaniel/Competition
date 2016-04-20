import java.util.*;
import java.io.*;

public class Main {

	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int[] jacks;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		System.out.println("Lumberjacks:");
		for (int _ = 0; _ < tc; ++_) {
			jacks = new int[10];
			for (int i = 0; i < 10; ++i) {
				jacks[i] = readInt();
			}
			boolean b = smallsort();
			if (b) System.out.println("Ordered");
			else {
				b = bigsort();
				if (b) System.out.println("Ordered");
				else System.out.println("Unordered");
			}
		}
	}

	private static boolean smallsort() {
		for (int i = 0; i < 9; ++i) {
			if (jacks[i] > jacks[i+1]) return false;
		}
		return true;
	}

	private static boolean bigsort() {
		for (int i = 0; i < 9; ++i) {
			if (jacks[i] < jacks[i+1]) return false;
		}
		return true;
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

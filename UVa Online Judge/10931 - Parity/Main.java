import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n;

	public static void main(String[] args) throws Exception {
		n = readInt();
		while (n != 0) {
			System.out.println("The parity of " + Integer.toBinaryString(n) + " is " + ones(Integer.toBinaryString(n)) + " (mod 2).");
			n = readInt();
		}
	}

	private static int ones(String s) {
		int ones = 0;
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '1') ++ones;
		}
		return ones;
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}

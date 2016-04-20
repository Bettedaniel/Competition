import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static String n;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		StringBuilder sb = new StringBuilder();
		for(int _ = 0; _ < tc; ++_) {
			n = readString();
			if (_ != 0) sb.append("\n");
			BigInteger bi = new BigInteger(n);
			boolean wonderful = true;
			int i = readInt();
			for (int j = 0; j < i; ++j) {
				if (bi.mod(BigInteger.valueOf(readInt())).compareTo(BigInteger.ZERO) != 0) {
					wonderful = false;
				}
			}
			if (wonderful) { 
				sb.append(n + " - Wonderful.");
			} else {
				sb.append(n + " - Simple.");
			}
		}
		System.out.println(sb);
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}

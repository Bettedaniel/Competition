import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");

	public static void main(String[] args) throws Exception {
		int tc = Integer.parseInt(readString());
		for (int _ = 0; _ < tc; ++_) {
			String a = readString();
			String b = readString();
			String ra = reverse(a);
			String rb = reverse(b);
			BigInteger bira = new BigInteger(ra);
			BigInteger birb = new BigInteger(rb);
			String answer = reverse((bira.add(birb)).toString());
			System.out.println(new BigInteger(answer));
		}
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(stdin.readLine());
		}
		return st.nextToken();
	}

	private static String reverse(String s) {
		char[] ori = s.toCharArray();
		String result = "";
		for (int i = s.length() - 1; i >= 0; --i) {
			result += Character.toString(ori[i]);
		} 
		return result;
	}
}

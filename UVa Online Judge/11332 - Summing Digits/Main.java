import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");

	public static void main(String[] args) throws Exception {
		String s = readString();
		while (!s.equals("0")) {
			System.out.println(solve(s));	
			s = readString();
		}	
	}

	private static String solve(String s) {
		if (s.length() == 1) return s;
		else {
			int a = 0;
			for (int i = 0; i < s.length(); ++i) {
				a += Integer.parseInt(Character.toString(s.charAt(i)));
			}
			return solve(Integer.toString(a));
		}
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(stdin.readLine());
		}
		return st.nextToken();
	}
}

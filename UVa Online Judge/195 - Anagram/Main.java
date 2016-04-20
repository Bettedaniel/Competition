import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static ArrayList<String> list;
	private static HashSet<String> added;
	private static int length;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int tc = readInt();
		for (int _ = 0; _ < tc; ++_) {
			list = new ArrayList<String>();
			added = new HashSet<String>();
			String s = readString();
			length = s.length();
			permutation("", s);
			Collections.sort(list);
			for (int i = 0; i < list.size(); ++i) {
				if (i == list.size()-1 && _ == tc-1) sb.append(list.get(i));
				else sb.append(list.get(i) + "\n");
			}
		}
		System.out.println(sb);
	}

	private static void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 0) {
			if (!added.contains(prefix)) {
				added.add(prefix);
				list.add(prefix);
			}
		} else {
			for (int i = 0; i < n; ++i) {
				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
			}
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

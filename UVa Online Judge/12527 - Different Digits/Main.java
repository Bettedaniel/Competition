import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static boolean[] hasRepeat = new boolean[5001];
	private static int[] repeat = new int[5001];

	public static void main(String[] args) throws Exception {
		for (int i = 1; i <= 5000; ++i) {
			String s = Integer.toString(i);
			HashSet<Character> vis = new HashSet<Character>();
			for (int j = 0; j < s.length(); ++j) {
				if (vis.contains(s.charAt(j))) {
					hasRepeat[i] = true;
					break;
				}
				vis.add(s.charAt(j));
			}
		}	
		for (int i = 1; i <= 5000; ++i) {
			if (!hasRepeat[i]) {
				repeat[i] = repeat[i-1] + 1;
			} else {
				repeat[i] = repeat[i-1];
			}
		}
		while (true) {
			try {
				int from = readInt();
			//	System.out.println(from + " " + hasRepeat[from]);
				int to = readInt();
			//	System.out.println(to + " " + hasRepeat[to]);
				int result = repeat[to] - repeat[from];
				if (!hasRepeat[from]) ++result;
				System.out.println(result);
			} catch (Exception e) {
			//	e.printStackTrace();
				return;
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

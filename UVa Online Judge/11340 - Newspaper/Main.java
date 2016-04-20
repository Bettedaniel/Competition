import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static HashMap<Character, Integer> costs;
	private static HashSet<Character> exist;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int _ = 0; _ < tc; ++_) {
			int n = readInt();
			costs = new HashMap<Character, Integer>();
			exist = new HashSet<Character>();
			for (int i = 0; i < n; ++i) {
				char sign = readString().charAt(0);
				int cost = readInt();
				costs.put(sign, cost);
				exist.add(sign);
			}
			int m = readInt();
			long result = 0;
			for (int i = 0; i < m; ++i) {
				String s = stdin.readLine();
				StringTokenizer st1 = new StringTokenizer(s);
				while (st1.hasMoreTokens()) {
					char[] array = st1.nextToken().toCharArray();
					for (int j = 0; j < array.length; ++j) {
						if (exist.contains(array[j])) {
							result += costs.get(array[j]);
						}
					}
				}
			}
			double d = result/100.00;
			System.out.printf("%.2f", d);
			System.out.print("$\n");
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

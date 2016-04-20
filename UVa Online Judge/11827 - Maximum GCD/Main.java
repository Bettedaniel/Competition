import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int[][] gcds = new int[100][100];
	private static StringTokenizer st1;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int t = 0; t < tc; ++t) {
			String s = stdin.readLine();
			ArrayList<Integer> list = new ArrayList<Integer>();
			st1 = new StringTokenizer(s);
			while (st1.hasMoreTokens()) {
				list.add(Integer.parseInt(st1.nextToken()));	
			}
			int max = 0;
			for (int i = 0; i < list.size(); ++i) {
				for (int j = i+1; j < list.size(); ++j) {
					int temp = gcd(list.get(i), list.get(j));
					if (temp > max) max = temp;
				}
			}
			System.out.println(max);
		}
	}

	private static int gcd(int a, int b) {
		while (a != b) {
			if (a > b) a -= b;
			else b -= a;
		}
		return a;
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}

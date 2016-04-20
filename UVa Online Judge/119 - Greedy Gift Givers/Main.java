import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int[] people;
	private static HashMap<Integer, String> map;
	private static HashMap<String, Integer> map2;
	private static int n;

	public static void main(String[] args) throws Exception {
		int t = 1;
		while (true) {
			try {
				n = readInt();
				map = new HashMap<Integer, String>();
				map2 = new HashMap<String, Integer>();
				people = new int[n];
				for (int i = 0; i < n; ++i) {
					String person = readString();
					map.put(i, person);
					map2.put(person, i);
				}
				for (int i = 0; i < n; ++i) {
					String from = readString();
					int value = readInt();
					int m = readInt();
					if (m != 0) people[map2.get(from)] -= value;
					int temp = 0;
					if (m != 0 && value != 0) {
						temp = value/m;
						int keep = value - m*temp;
						people[map2.get(from)] += keep;
					}
					for (int j = 0; j < m; ++j) {
						String to = readString();
						people[map2.get(to)] += temp;
					}
				}
				if (t != 1) System.out.println();
				for (int i = 0; i < n; ++i) {
					System.out.println(map.get(i) + " " + people[i]);
				}
				++t;
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

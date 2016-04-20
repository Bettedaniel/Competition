import java.util.*;
import java.io.*;

public class Main {

	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static ArrayList<String> list;

	public static void main(String[] args) throws Exception {
		int t = readInt();
		for (int _ = 1; _ <= t; ++_) {
			int max = 0;
			list = new ArrayList<String>();
			for (int i = 0; i < 10; ++i) {
				String s = readString();
				int r = readInt();
				if (r > max) {
					max = r;
					list.clear();
					list.add(s);
				} else if (r == max) list.add(s);
			}
			System.out.println("Case #" + _ + ":");
			for (String a : list) {
				System.out.println(a);
			}
		}
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

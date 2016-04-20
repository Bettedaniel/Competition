import java.util.*;
import java.io.*;

public class Main {	
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while (true) {
			try {
				int n = readInt();
				if (t != 1) sb.append("\n");
				if (n % 6 == 0) {
					sb.append("Y");
				} else {
					sb.append("N");
				}
				++t;
			} catch (Exception e) {
			//	e.printStackTrace();
				break;
			}
		}
		System.out.println(sb.toString());
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}


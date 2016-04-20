import java.util.*;
import java.io.*;

public class Main {

	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n;

	public static void main(String[] args) throws Exception {
		n = readInt();
		while (n != 0) {
			System.out.println(decimal(n));
			n = readInt();
		}
	}

	private static int decimal(int x) {
		int sum = 0;
		while (x != 0) {
			int p = x % 10;
			sum += p;
			x = x / 10;
			if (x == 0 && sum > 9) {
				x = sum;
				sum = 0;
			}
		}
		return sum;
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

import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int[] numbers;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int t = 0; t < tc; ++t) {
			StringBuilder sb = new StringBuilder();
			sb.append(readString());
			sb.append(readString());
			sb.append(readString());
			sb.append(readString());
			String s = sb.toString();
			numbers = new int[8];
			int j = 0;
			for (int i = s.length() - 2; i >= 0; i -= 2) {
				numbers[j] = 2*Integer.parseInt(Character.toString(s.charAt(i)));
				++j;
			}
			int sum = 0;
			for (int i = s.length() - 1; i >= 0; i -= 2) {
				sum += Integer.parseInt(Character.toString(s.charAt(i)));
			}
			for (int i = 0; i < 8; ++i) {
				sum += digitsum(numbers[i]);
			}
			if (sum % 10 == 0) System.out.println("Valid");
			else System.out.println("Invalid");
		}
	}

	private static int digitsum(int n) {
		int sum = 0;
		while (n != 0) {
			int p = n % 10;
			sum += p;
			n /= 10;
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

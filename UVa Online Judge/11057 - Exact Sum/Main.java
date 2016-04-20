import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, money;
	private static int[] books;
	private static ArrayList<Integer> booksums;

	public static void main(String[] args) throws Exception {
		while (true) {
			try {
				n = readInt();
				books = new int[n];
				booksums = new ArrayList<Integer>();
				for (int i = 0; i < n; ++i) {
					books[i] = readInt();
				}
				money = readInt();
				int min = Integer.MAX_VALUE;
				int a = 0, b = 0;
				for (int i = 0; i < n; ++i) {
					for (int j = i+1; j < n; ++j) {
						int sum = books[i] + books[j];
						if (sum == money && Math.abs(books[i] - books[j]) < min) {
							min = Math.abs(books[i] - books[j]);
							a = Math.min(books[i], books[j]);
							b = Math.max(books[i], books[j]);
						}	
					}
				}
				System.out.println("Peter should buy books whose prices are " + a + " and " + b + ".");
				System.out.println();
			} catch (Exception e) {
		//		e.printStackTrace();
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

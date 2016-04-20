import java.util.*;
import java.io.*;

public class Main {

	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static String n, m;
	private static int[] first;

	public static void main(String[] args) throws Exception {
		n = readString();
		m = readString();
		while (!n.equals("0") || !m.equals("0")) {
			char[] a = n.toCharArray();
			char[] b = m.toCharArray();
			first = new int[20];
			int j = 0;
			for (int i = n.length()-1; i >= 0; --i) {
				first[j] += Integer.parseInt(Character.toString(a[i]));
				++j;
			}
			j = 0;
			for (int i = m.length()-1; i >= 0; --i) {
				first[j] += Integer.parseInt(Character.toString(b[i]));
				++j;
			}
			int carries = 0;
			for (int i = 0; i < 20; ++i) {
				if (first[i] >= 10) {
					first[i+1] += first[i]/10;
					first[i] = first[i]%10;
					++carries;
				}
			}
			if (carries == 0) {
				System.out.println("No carry operation.");
			} else if (carries == 1) {
				System.out.println("1 carry operation.");
			} else {
				System.out.println(carries + " carry operations.");
			}
			n = readString();
			m = readString();
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

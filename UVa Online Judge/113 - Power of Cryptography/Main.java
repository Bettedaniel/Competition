import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");

	public static void main(String[] args) throws Exception {
		while (true) {
			try {
				String n = readString();
				String p = readString();
				System.out.println(binarySearch(n, p));
			} catch (Exception e) {
		//		e.printStackTrace();
				return;
			}
		}	
	}

	private static String binarySearch(String n, String p) {
		BigInteger bip = new BigInteger(p);
		int bin = Integer.parseInt(n);
		int k = 500000000;
		int search = 500000000;
		while (!(BigInteger.valueOf(k).pow(bin)).equals(bip)) {
			if (BigInteger.valueOf(k).pow(bin).equals(bip)) {
				return Integer.toString(k);
			}
			if (BigInteger.valueOf(k).pow(bin).compareTo(bip) < 0) {
				if (search % 2 == 1) search += 1;
				search /= 2;
				k += search;
			} else if (BigInteger.valueOf(k).pow(bin).compareTo(bip) > 0) {
				if (search % 2 == 1) search += 1;
				search /= 2;
				k -= search;
			}
		}
		return Integer.toString(k);
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}
}

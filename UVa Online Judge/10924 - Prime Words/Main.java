import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static boolean[] primes = new boolean[2000];

	public static void main(String[] args) throws Exception {
		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = true;
		for (int i = 2; i < 2000; ++i) {
			if (primes[i]) {
				for (int j = 2*i; j < 2000; j += i) {
					primes[j] = false;
				}
			}
		}
		while (true) {
			try {
				String s = readString();
				boolean b = solve(s);
				if (b) System.out.println("It is a prime word.");
				else System.out.println("It is not a prime word.");
			} catch (Exception e) {
			//	e.printStackTrace();
				return;
			}
		}
	}

	private static boolean solve(String s) {
		char[] array = s.toCharArray();
		int result = 0;
		for (int i = 0; i < s.length(); ++i) {
			if (Character.isLowerCase(array[i])) {
				result += ((int)array[i]) - 96;
			} else {
				result += ((int)array[i]) - 38;
			}
		}
		if (primes[result]) return true;
		else return false;
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}
}

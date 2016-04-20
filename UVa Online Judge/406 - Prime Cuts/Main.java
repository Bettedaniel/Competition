import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static boolean[] primes = new boolean[1001];
	private static int[] number = new int[1001];
	private static ArrayList<Integer> primenumbers = new ArrayList<Integer>();
	private static int mid;

	public static void main(String[] args) throws Exception {
		Arrays.fill(primes, true);
		primes[0] = false;
		for (int i = 2; i <= 32; ++i) {
			if (primes[i]) {
				for (int j = 2*i; j <= 1000; j += i) {
					primes[j] = false;
				}
			}
		}
		number[1] = 1;
		primenumbers.add(1);
		for (int i = 2; i <= 1000; ++i) {
			if (primes[i]) {
				primenumbers.add(i);
				number[i] = number[i-1] + 1;
			} else {
				number[i] = number[i-1];
			}
		}
		while (true) {
			try {
				int n = readInt();
				int c = readInt();
				StringBuilder sb = new StringBuilder();
				String greater = "";
				String less = "";
				if (2*c - 1 >= number[n]) {
					for (int i = 1; i <= n; ++i) {
						if (primes[i]) sb.append(" " + i);
					}
				} else if (number[n] % 2 == 1) {
					int pos = number[n]/2;
					mid = primenumbers.get(pos);
					int print = 2*c - 1;
					int a = 0;
					int b = 0;
					while (a + b + 1 <= print) {
						++a;
						if (a + b + 1 > print) break;
						less = " " + (primenumbers.get(pos - a)) + less;
						++b;
						if (a + b + 1 > print) break;
						greater = greater + " " + (primenumbers.get(pos+b));
					}
				} else {
					int pos = number[n]/2;
					mid = primenumbers.get(pos);
					int print = 2*c;
					int a = 0;
					int b = 0;
					while (a + b + 1 <= print) {
						++a;
						if (a + b + 1 > print) break;
						less = " " + (primenumbers.get(pos - a)) + less;
						++b;
						if (a + b + 1 > print) break;
						greater = greater + " " + (primenumbers.get(pos+b));
					}
				}
				if (2*c-1 < number[n]) System.out.println(n + " " + c + ":" + less + " " + mid + "" + greater);	
				else System.out.println(n + " " + c + ":" + sb.toString());
				System.out.println();
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

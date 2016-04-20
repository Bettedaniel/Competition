import java.util.*;
import java.io.*;

public class Main {

	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, k;
	private static int[][] sums = new int[1121][15];
	private static boolean[] primes = new boolean[1121];
	private static int[] coins = new int[1121];
	private static int[][] lastadded;

	public static void main(String[] args) throws Exception {
		Arrays.fill(coins, Integer.MAX_VALUE);
		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;
		int j1 = 0;
		for (int i = 2; i <= 1120; ++i) {
			if (primes[i]) {
				coins[j1] = i;
				++j1;
				for (int k = 2*i; k <= 1120; k += i) {
					primes[k] = false;
				}
			} 
		}
		lastadded = new int[1121][15];
		for (int j = 0; j <= 1120; ++j) {
			if (primes[j]) {
				sums[j][1] = 1;
				lastadded[j][1] = j;
			}
		}
		for (int i = 0; i < j1; ++i) System.out.print(coins[i] + " ");
		System.out.println();	
		
		for (int k = 2; k <= 14; ++k) {
			for (int i = 2; i <= 1120; ++i) {
			}
		}

		for (int i = 1; i <= 14; ++i) {
			for (int j = 1; j <= 1120; ++j) {
				System.out.print(sums[j][i] + " ");
			}
			System.out.println();
		}
		System.out.println();
		n = readInt();
		k = readInt();
		while (n != 0 || k != 0) {
			System.out.println(sums[n][k]);	
			n = readInt();
			k = readInt();
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

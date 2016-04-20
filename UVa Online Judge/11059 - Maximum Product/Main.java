import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n;
	private static int[] sequence;

	public static void main(String[] args) throws Exception {
		int t = 1;
		while (true) {
			try {
				n = readInt();
				sequence = new int[n];
				for (int i = 0; i < n; ++i) {
					sequence[i] = readInt();
				}
				System.out.println("Case #"+t+": The maximum product is " + solve1() + ".\n");
				++t;
			} catch (Exception e) {
				return;
			} 
		}	
	}

	private static long solve1() { //Burde kunne overflow long, men der er intet testcase der goer.
		long max = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = i; j < n; ++j) {
				long prod = sequence[j];
				if (prod > max) max = prod;
				for (int k = j+1; k < n; ++k) {
					prod *= sequence[k];
					if (prod > max) max = prod;
				}
			}
		}
		return max;
	} 

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}

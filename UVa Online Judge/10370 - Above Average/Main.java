import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n;
	private static int[] grades;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int _ = 0; _ < tc; ++_) {
			int n = readInt();
			grades = new int[n];
			double average = 0;
			for (int i = 0; i < n; ++i) {
				int a = readInt();
				grades[i] = a;
				average += (double)a;
			}
			average /= n;
			int above = 0;
			for (int i = 0; i < n; ++i) {
				if ((double)grades[i] > average) {
					++above;
				}
			}
			double result = (double)above/(double)n*100.0;
			System.out.printf("%.3f", result);
			System.out.print("%");
			System.out.println();
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

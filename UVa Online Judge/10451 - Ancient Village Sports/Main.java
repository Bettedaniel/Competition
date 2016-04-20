import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n;
	private static double area;

	public static void main(String[] args) throws Exception {
		n = readInt();
		while (n > 2) {
			area = readDouble();
			if (n != 4) {
				if (n > 3) {
					double psi = 360.0/(double)n;
					double degree = (180.0-psi)/2;

				}
			}
		}
	}

	private static double incircle(double a) {
		
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}

	private static double readDouble() throws Exception {
		return Double.parseDouble(readString());
	}
}

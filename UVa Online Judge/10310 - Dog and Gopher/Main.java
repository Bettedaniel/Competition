import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n;
	private static long xgopher, ygopher, xdog, ydog;
	private static long[][] holes;

	public static void main(String[] args) throws Exception {
		while (true) {
			try {
				n = readInt();
				holes = new long[n][2];
				xgopher = (long)(readDouble() * 1000);
				ygopher = (long)(readDouble() * 1000);
				xdog = (long)(readDouble() * 1000);
				ydog = (long)(readDouble() * 1000);
				for (int i = 0; i < n; ++i) {
					long x = (long)(readDouble() * 1000);
					long y = (long)(readDouble() * 1000);
					holes[i][0] = x;
					holes[i][1] = y;
				}
				decide();	
			} catch (Exception e) {
			//	e.printStackTrace();
				return;
			}
		}
	}

	private static void decide() {
		for (int i = 0; i < n; ++i) {
			long gopherdist = pow(holes[i][0] - xgopher) + pow(holes[i][1] - ygopher);
			long dogdist = pow(holes[i][0] - xdog) + pow(holes[i][1] - ydog);
		//	System.out.println(gopherdist + " " + dogdist);
			if (4*gopherdist <= dogdist) {
				System.out.print("The gopher can escape through the hole at (");
				System.out.printf("%.3f", (double)holes[i][0]/1000.0);
				System.out.print(",");
				System.out.printf("%.3f", (double)holes[i][1]/1000.0);
				System.out.println(").");
				return;
			}
		}
		System.out.println("The gopher cannot escape.");
	}

	private static long pow(long a) {
		return a*a;
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

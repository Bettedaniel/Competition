import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");

	public static void main(String[] args) {
		while (true) {
			try {
				String x = readString();
				String y = readString();
				BigInteger bx = new BigInteger(x);
				BigInteger by = new BigInteger(y);
				System.out.println(bx.multiply(by));
			} catch (Exception e) {
				return;
			} 
		}	
	} 

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(stdin.readLine());
		}
		return st.nextToken();
	}
}

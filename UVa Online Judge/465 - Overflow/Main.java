import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static BigInteger MAX = new BigInteger(Integer.toString(Integer.MAX_VALUE));

	public static void main(String[] args) throws Exception {
		while (true) {
			try {
				String s = stdin.readLine();
				if (s != null) System.out.println(s);
				StringTokenizer st = new StringTokenizer(s);
				String a = st.nextToken();
				BigInteger bia = new BigInteger(a);
				String op = st.nextToken();
				String b = st.nextToken();
				BigInteger bib = new BigInteger(b);
				if (!bia.equals(MAX) && bia.max(MAX).equals(bia)) {
					System.out.println("first number too big");
				}
				if (!bib.equals(MAX) && bib.max(MAX).equals(bib)) {
					System.out.println("second number too big");
				}
				if (op.equals("+")) {
					bia = bia.add(bib);
					if (!bia.equals(MAX) && bia.max(MAX).equals(bia)) {
						System.out.println("result too big");
					}
				} else {
					bia = bia.multiply(bib);
					if (!bia.equals(MAX) && bia.max(MAX).equals(bia)) {
						System.out.println("result too big");	
					}
				}
			} catch (Exception e) {
			//	e.printStackTrace();
				return;
			}
		}
	}
}

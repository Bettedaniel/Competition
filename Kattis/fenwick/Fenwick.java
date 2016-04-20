import java.util.*;
import java.math.*;
import java.io.*;

public class Fenwick {

	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	private static String[] readLine() {
		try {
			String line = reader.readLine();
			return line.split("\\s+"); 
		} catch (Exception e) {
			return null;	
		}
	}

	public static void main(String[] args) {
		int N, Q;
		String[] sa = readLine();
		N = Integer.parseInt(sa[0]);
		Q = Integer.parseInt(sa[1]);
		FenwickStructure fs = new FenwickStructure(N);
		StringBuilder sb = new StringBuilder();
		char[] cs = new char[Q];
		int[] indices = new int[Q];
		long[] values = new long[Q];
		for (int i = 0; i < Q; ++i) {
			sa = readLine();
			cs[i] = sa[0].charAt(0);
			indices[i] = Integer.parseInt(sa[1]);
			if (cs[i] == '+') {
				values[i] = Long.parseLong(sa[2]);
			}
		}
		for (int i = 0; i < Q; ++i) {
			if (cs[i] == '+') {
				fs.inc(indices[i], BigInteger.valueOf(values[i]));
			} else {
				BigInteger result = BigInteger.ZERO;
				if (indices[i] > 0) {
					result = fs.query(indices[i]-1);	
				}	
				sb.append(result + "\n");
			}
		}
		System.out.print(sb);
	}

	private static class FenwickStructure {
		private BigInteger[] list;
		private int BM;
		public FenwickStructure(int n) {
			list = new BigInteger[n];	
			for (int i = 0; i < n; ++i)
				list[i] = BigInteger.ZERO;
		}

		public void inc(int x, BigInteger add) {
			for (;x < list.length; x |= x+1) {
				list[x] = list[x].add(add);
			}	
		}

		public BigInteger query(int b) {
			BigInteger sum = BigInteger.ZERO;
			for (; b >= 0; b = (b & (b+1)) - 1) {
				sum = sum.add(list[b]);	
			}
			return sum;
		}
	}	
}

import java.util.*;
import java.io.*;

public class Main {
	
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, k;
	private static int[] zeros, numbers;
	private static int[] minus;
	private static ArrayList<Segment> segments;
	
	public static void main(String[] args) {
		while (true) {
			try {
				n = readInt();
				k = readInt();
				numbers = new int[n+1];
				segments = new ArrayList<Segment>();
				int temp = (int)Math.sqrt(n);
				zeros = new int[n+1];
				minus = new int[n+1];
				for (int i = 1; i <= n; ++i) {
					numbers[i] = readInt();
					if (numbers[i] == 0) zeros[i] = zeros[i-1] + 1;
					else zeros[i] = zeros[i-1];
					if (numbers[i] < 0) minus[i] = minus[i-1] + 1;
					else minus[i] = minus[i-1];
				}
				int lastseg = 0;
				for (int i = 1; i + temp <= n; i += temp) {
					int z = zeros[i+temp-1] - zeros[i];
					int m = minus[i+temp-1] - minus[i];
					if (numbers[i] == 0) ++z;
					if (numbers[i] < 0) ++m;
					segments.add(new Segment(z, m, i, i+temp-1));
					lastseg = i+temp-1;
				}
				int z1 = zeros[n] - zeros[lastseg+1];
				int m1 = minus[n] - minus[lastseg+1];
				if (numbers[lastseg+1] == 0) ++z1;
				if (numbers[lastseg+1] < 0) ++m1;
				segments.add(new Segment(z1, m1, lastseg+1, n));
				StringBuilder result = new StringBuilder();
				for (int i = 0; i < k; ++i) {
					String s = readString();
					int a = readInt();
					int b = readInt();
					if (s.charAt(0) == 'C') {
						update(a, b, numbers[a]);
					} else if (s.charAt(0) == 'P') {
						int r = query(a, b);
						if (r == 0) result.append("0");
						else if (r == -1) result.append("-");
						else result.append("+");
					}
				}	
				System.out.println(result.toString());
			} catch (Exception e) {
				return;
			}
		}	
	}

	private static int query(int from, int to) {
		int z = 0;
		int m = 0;
		int result = 1;
		for (Segment s : segments) {
			if (from >= s.i && from <= s.j) {
				for (int k = from; k <= Math.min(s.j, to); ++k) {
					if (numbers[k] == 0) {
						return 0;
					} else if (numbers[k] < 0) ++m;
				}
			} else if (s.i >= from && s.j <= to) {
				z += s.zeros;
				m += s.minus;
			} else if (from <= s.i && s.j > to) {
				for (int k = s.i; k <= to; ++k) {
					if (numbers[k] == 0) return 0;
					else if (numbers[k] < 0) ++m;
				}
			}
			if (z > 0) {
				return 0;
			}
		}
		if (m % 2 == 1) result = -1;
		return result;
	}

	private static void update(int pos, int news, int prev) {
		for (Segment s : segments) {
			if (pos <= s.j && pos >= s.i) {
				numbers[pos] = news;
				if (prev == 0 && news != 0) {
					s.decreaseZeros();
					if (news < 0) s.increaseMinus();
				} else if (prev < 0 && news >= 0) {
					s.decreaseMinus();
					if (news == 0) s.increaseZeros();
				} else if (prev > 0 && news == 0) s.increaseZeros();
				else if (prev > 0 && news < 0) s.increaseMinus();
			} 
		}
	}

	private static class Segment {
		int zeros, minus, i, j;
		public Segment(int zeros, int minus, int i, int j) {
			this.zeros = zeros;
			this.minus = minus;
			this.i = i;
			this.j = j;
		}
		public void decreaseZeros() {--zeros;}
		public void decreaseMinus() {--minus;}
		public void increaseZeros() {++zeros;}
		public void increaseMinus() {++minus;}
		public String toString() {
			return i + " --> " + j + " (0:" + zeros + ", <0:" + minus + ")";
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

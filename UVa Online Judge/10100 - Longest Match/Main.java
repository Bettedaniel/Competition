import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static String s1, s2;
	private static ArrayList<String> strings1, strings2;
	private static int[][] count;

	public static void main(String[] args) throws Exception {
		int t = 1;
		while (true) {
			try {
				s1 = stdin.readLine();
				st = new StringTokenizer(s1);
				strings1 = new ArrayList<String>();
				while (st.hasMoreTokens()) {
					char[] temp = st.nextToken().toCharArray();
					StringBuilder sb = new StringBuilder();
					for (int i = 0; i < temp.length; ++i) {
						if (temp[i] >= 65 && temp[i] <= 90 || temp[i] >= 97 && temp[i] <= 122 || temp[i] >= 48 && temp[i] <= 57) {
							sb.append(temp[i]);
						} else {
							if (!sb.toString().equals("")) strings1.add(sb.toString());
							sb = new StringBuilder();
						}
					}
					if (!sb.toString().equals("")) strings1.add(sb.toString());
				}
				strings2 = new ArrayList<String>();
				s2 = stdin.readLine();
				st = new StringTokenizer(s2);
				while (st.hasMoreTokens()) {
					char[] temp = st.nextToken().toCharArray();
					StringBuilder sb = new StringBuilder();
					for (int i = 0; i < temp.length; ++i) {
						if (temp[i] >= 65 && temp[i] <= 90 || temp[i] >= 97 && temp[i] <= 122 || temp[i] >= 48 && temp[i] <= 57) {
							sb.append(temp[i]);
						} else {
							if (!sb.toString().equals("")) strings2.add(sb.toString());
							sb = new StringBuilder();
						}
					}
					if (!sb.toString().equals("")) {
						strings2.add(sb.toString());
					}
				}
				int result = lcs(strings1, strings2);
				if (t < 10) {
					if (s1.equals("") || s2.equals("")) System.out.println(" " + t + ". Blank!");
					else System.out.println(" " + t + ". Length of longest match: " + result);
				} else {
					if (s1.equals("") || s2.equals("")) System.out.println(t + ". Blank!");
					else System.out.println(t + ". Length of longest match: " + result);
				}
				++t;
			} catch (Exception e) {
				return;
			}
		}	
	}

	private static int lcs(ArrayList<String> x, ArrayList<String> y) {
		count = new int[x.size()+1][y.size()+1];
		for (int i = 1; i <= x.size(); ++i) {
			for (int j = 1; j <= y.size(); ++j) {
				if (x.get(i-1).equals(y.get(j-1))) {
					count[i][j] = count[i-1][j-1] + 1;
				} else {
					count[i][j] = Math.max(count[i][j-1], count[i-1][j]);
				}
			}
		}
		return count[x.size()][y.size()];
	}
}

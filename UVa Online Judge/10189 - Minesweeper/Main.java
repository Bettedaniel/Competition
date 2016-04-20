import java.util.*;

public class Main {

	private static int n, m;
	private static ArrayList<Integer> mines;
	private static int[][] result; //-1 == mine.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int t = 1;
		while (n != 0 || m != 0) {
			if (t != 1) System.out.println();
			result = new int[n+2][m+2];
			mines = new ArrayList<Integer>();
			sc.nextLine();
			for (int i = 1; i <= n; ++i) {
				String s = sc.nextLine();
				char[] sa = s.toCharArray();
				for (int j = 1; j <= m; ++j) {
					if (sa[j-1] == '*') {
						mines.add(i);
						mines.add(j);
						result[i][j] = -1;
					}
				}
			}
			for (int i = 0; i < mines.size(); i += 2) {
				int x = mines.get(i);
				int y = mines.get(i+1);
				for (int a = -1; a < 2; ++a) {
					for (int b = -1; b < 2; ++b) {
						if (a != 0 || b != 0) {
							if (result[x+a][y+b] != -1) {
								result[x+a][y+b] += 1;
							}
						}
					}
				}
			}
			System.out.println("Field #" + t + ":");
			print(n, m);
			n = sc.nextInt();
			m = sc.nextInt();
			++t;
		}
	}

	private static void print(int dimn, int dimm) {
		for (int i = 1; i <= dimn; ++i) {
			for (int j = 1; j <= dimm; ++j) {
				if (result[i][j] == -1) {
					System.out.print("*");
				} else System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}
}

import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m;
	private static char[][] grid;
	private static ArrayList<String> list;
	private static char[] word = {'I', 'E', 'H', 'O', 'V', 'A', '#'};

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int _ = 0; _ < tc; ++_) {
			n = readInt();
			m = readInt();
			int startx = 0;
			int starty = 0;
			grid = new char[n][m];
			for (int i = 0; i < n; ++i) {
				String s = readString();
				for (int j = 0; j < m; ++j) {
					if (s.charAt(j) == '@') {
						startx = i;
						starty = j;
					}
					grid[i][j] = s.charAt(j);
				}
			}
			list = new ArrayList<String>();
			solve(startx, starty, 0);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < list.size(); ++i) {
				if (i != 0) sb.append(" ");
				sb.append(list.get(i));
			}
			System.out.println(sb.toString());
		}
	}

	private static void solve(int x, int y, int idx) {
		if (x > 0 && grid[x-1][y] == word[idx]) {
			list.add("forth");
			if (word[idx] == '#') return;
			solve(x-1, y, idx + 1);
		} else if (y > 0 && grid[x][y-1] == word[idx]) {
			list.add("left");
			if (word[idx] == '#') return;
			solve(x, y-1, idx+1);
		} else if (y < m-1 && grid[x][y+1] == word[idx]) {
			list.add("right");
			if (word[idx] == '#') return;
			solve(x, y+1, idx+1);
		}
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(stdin.readLine());
		}
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}

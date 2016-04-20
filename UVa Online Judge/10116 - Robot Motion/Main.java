import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m, s, loopx, loopy;
	private static char[][] instructions;
	private static int[][] steps;
	private static boolean loop;

	public static void main(String[] args) throws Exception {
		n = readInt(); m = readInt(); s = readInt();
		while (n != 0 || m != 0 || s != 0) {
			instructions = new char[n+2][m+2];
			steps = new int[n+2][m+2];
			for (int i = 1; i <= n; ++i) {
				String temp = readString();
				for (int j = 0; j < m; ++j) {
					instructions[i][j+1] = temp.charAt(j);
				}
			}
			char start = instructions[1][s];
			loop = false;
			int result = solve(start);
			if (loop) {
				System.out.println(steps[loopx][loopy] + " step(s) before a loop of " + (result - steps[loopx][loopy] + 1) + " step(s)");
			} else {
				System.out.println(result + " step(s) to exit");	
			}
			n = readInt(); m = readInt(); s = readInt();
		}
	}

	private static int solve(char start) {
		int step = 0;
		int x = 1;
		int y = s;
		HashSet<Pair> visited = new HashSet<Pair>();
		while (start == 'N' || start == 'S' || start == 'E' || start == 'W') {
			visited.add(new Pair(x, y));
			steps[x][y] = step;
			if (start == 'N') {
				if (visited.contains(new Pair(x-1, y))) {
					loop = true;
					loopx = x-1;
					loopy = y;
					return step;
				} else {
					x -= 1;
					++step;
					start = instructions[x][y];
				}
			} else if (start == 'S') {
				if (visited.contains(new Pair(x+1, y))) {
					loop = true;
					loopx = x+1;
					loopy = y;
					return step;
				} else {
					x += 1;
					++step;
					start = instructions[x][y];
				}
			} else if (start == 'E') {
				if (visited.contains(new Pair(x, y+1))) {
					loop = true;
					loopx = x;
					loopy = y+1;
					return step;
				} else {
					y += 1;
					++step;
					start = instructions[x][y];
				}
			} else if (start == 'W') {
				if (visited.contains(new Pair(x, y-1))) {
					loop = true;
					loopx = x;
					loopy = y-1;
					return step;
				} else {
					y -= 1;
					++step;
					start = instructions[x][y];
				}
			}
		}
		return step;
	}

	private static class Pair {
		int x, y;
		public Pair (int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int hashCode() {
			return 11*x + 91*y;
		}
		public boolean equals(Object o) {
			Pair p = (Pair)o;
			return p.x == x && p.y == y;
		}
	}

	private static void print() {
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= m; ++j) {
				System.out.print(instructions[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}

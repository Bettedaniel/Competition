import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int man, dog;
	private static int[][] points;
	private static int[][] weights;
	private static int[] parent;
	private static ArrayList<Pair> dogpath;
	private static boolean[] vis;
	

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int t = 0; t < tc; ++t) {
			man = readInt();
			dog = readInt();
			points = new int[man+dog][2];
			weights = new int[man+dog][man+dog];
			for (int i = 0; i < man; ++i) {
				int x = readInt();
				int y = readInt();
				points[i][0] = x;
				points[i][1] = y;
			}
			for (int i = man; i < man+dog; ++i) {
				int x = readInt();
				int y = readInt();
				points[i][0] = x;
				points[i][1] = y;
			}
			for (int i = 0; i < man+dog; ++i) {
				for (int j = i+1; j < man+dog; ++j) {
					int dist = pow(points[j][0] - points[i][0]) + pow(points[j][1] + points[i][1]);
					weights[i][j] = dist;
					weights[j][i] = dist;
				}
			}
			dogpath = new ArrayList<Pair>();
		}
	}

	private static void win() {
		for (int i = 0; i < man-1; ++i) {
			
		}
	}

/*	private static void solve() {
		for (int i = 0; i < man-1; ++i) {
			int dist = weights[i][i+1];
			parent = new int[man+dog];
			int[] steps = new int[man+dog];
			int[] cumdist = new int[man+dog];
			int a = i;
			PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
			while (!queue.isEmpty() && a != i+1) {
				for (int j = man; j < man+dog; ++j) {
					if (a < j && cumdist[a] + weights[a][j] + weights[i+1][j] <= dist) {
						steps[j] = steps[a] + 1;
						cumdist[j] = cumdist[a] + weights[a][j];
						parent[j] = a;
						queue.add(new Pair(j, cumdist[a]));
					}
				}
				if (cumdist[a] + weights[i+a][a] <= dist) {
					if (steps[a] + 1 > steps[i+1]) {
						steps[i+1] = steps[a] + 1;
						parent[i+1] = a;
					}
				}
				a = queue.poll().x;
			}
			ArrayList<Pair> temp = new ArrayList<Pair>();
			temp.add(new Pair(points[i+1][0], points[i+1][1]));
			int v = i+1;
			while (v != i) {
				int u = parent[v];
				v = u;
				temp.add(new Pair(points[v][0], points[v][1]));
			}
			for (int k = temp.size() - 1; k >= 0; --k) {
				dogpath.add(temp.get(k));
			}
			System.out.println(dogpath);
		}
	}
*/
	private static int pow(int k) {return k*k;}

	private static class Pair implements Comparable<Pair> {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int compareTo(Pair p) {
			return y - p.y;
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

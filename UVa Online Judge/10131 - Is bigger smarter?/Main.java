import java.util.*;

public class Main {

	private static ArrayList<Pair> list;
	private static ArrayList<Pair2> list2;
	private static int[][] c;
	private static Coords[][] path;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		list = new ArrayList<Pair>();
		list2 = new ArrayList<Pair2>();
		int i = 1;
		list.add(new Pair(-1, -1, -1));
		list2.add(new Pair2(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE));
		while (sc.hasNext()) {
			int w = sc.nextInt();
			int s = sc.nextInt();
			list.add(new Pair(i, w, s));
			list2.add(new Pair2(i, w, s));
			++i;
		}
		c = new int[i][i];
		path = new Coords[i][i];
		Collections.sort(list);
		Collections.sort(list2);
		LCS(list, list2, i);	
	}	

	private static void LCS(ArrayList<Pair> x, ArrayList<Pair2> y, int size) {
		for (int i = 0; i < size; ++i) {
			path[i][0] = new Coords(0, 0);
			path[0][i] = new Coords(0, 0);
		}
		for (int i = 1; i < size; ++i) {
			for (int j = 1; j < size; ++j) {
				if (x.get(i).name == y.get(j).name && (x.get(i).name != -1 && y.get(j).name != Integer.MAX_VALUE)) {
					c[i][j] = c[i-1][j-1] + 1;
					path[i][j] = new Coords(i-1, j-1);
				} else {
					if (c[i][j-1] >= c[i-1][j]) {
						c[i][j] = c[i][j-1];
						path[i][j] = new Coords(i, j-1);
					} else {
						c[i][j] = c[i-1][j];
						path[i][j] = new Coords(i-1, j);
					}
				}
			}
		}
		ArrayList<Pair> list1 = new ArrayList<Pair>();
		int i = size-1;
		int j = size-1;
		HashSet<Pair> vis = new HashSet<Pair>();
		while (i != 0 && j != 0) {
			if (x.get(i).name == y.get(j).name) {
				if (!vis.contains(x.get(i))) {
					list1.add(x.get(i));
				}
				vis.add(x.get(i));
				i = i-1;
				j = j-1;
			} else if (c[i][j-1] > c[i-1][j]) {
				j = j-1;
			} else {
				i = i-1;
			}
		}
		System.out.println(list1.size());
		for (int i1 = list1.size() - 1; i1 >= 0; --i1) {
			System.out.println(list1.get(i1).name);
		}
	}

	private static class Coords {
		int x, y;
		public Coords(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static class Pair implements Comparable<Pair> {
		int w, s, name;
		public Pair(int name, int w, int s) {
			this.name = name;
			this.w = w;
			this.s = s;
		}
		public int compareTo(Pair p) {
			if (w == p.w) return s - p.s;
			return w - p.w;
		}
		public int hashCode() {
			return 3*w + 91*s;
		}
		public boolean equals(Object o) {
			return w == ((Pair)o).w && s == ((Pair)o).s;
		}
	}

	private static class Pair2 implements Comparable<Pair2> {
		int w, s, name;
		public Pair2(int name, int w, int s) {
			this.name = name;
			this.w = w;
			this.s = s;
		}
		public int compareTo(Pair2 p) {
			if (p.s == s) return p.w - w;
			return p.s - s;
		}
	}
}

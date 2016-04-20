import java.util.*;

public class Main {

	private static int n, m, total;
	private static ArrayList<Edge> list;
	private static int[] parent, rank;
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		while (n != 0 || m != 0) {
			total = 0;
			parent = new int[200001];
			rank = new int[200001];
			list = new ArrayList<Edge>();
			for (int i = 0; i < n; ++i) {
				parent[i] = i;
				rank[i] = 1;
				int x = sc.nextInt();
				int y = sc.nextInt();
				int dist = sc.nextInt();
				list.add(new Edge(x, y, dist));
				total += dist;
			}
			parent[n] = n;
			rank[n] = 1;
			Collections.sort(list);			
			int result = 0;
			int selected = m - 1;
			for (int i = 0; i < n && selected > 0; ++i) {
				int p = findset(list.get(i).from);
				int q = findset(list.get(i).to);
				if (p != q) {
					if (rank[p] > rank[q]) {
						int a = p;
						p = q;
						q = a;
					}
					rank[q] += rank[p];
					parent[p] = q;
					result += list.get(i).weight;
					--selected;
				}
			}
			System.out.println(total - result);
			m = sc.nextInt();
			n = sc.nextInt();
		}
	}

	private static int findset(int x) {
		if (x != parent[x]) parent[x] = findset(parent[x]);
		return parent[x];
	}

	private static class Edge implements Comparable<Edge> {
		int from, to, weight;
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		public int compareTo(Edge e) {
			return weight - e.weight;
		}
	}
}


import java.util.*;

public class Print {
	public static void main(String[] args) {
		ArrayList<Edge> list = new ArrayList<Edge>();
		Random r = new Random();
		for (int i = 1; i <= 1000; ++i) {
			for (int j = i+1; j <= 1000; ++j) {
				list.add(new Edge(i, j, r.nextInt(1000000)));
			}
		}
		System.out.println(1000 + " " + list.size());
		for (Edge e : list) {
			System.out.println(e.u + " " + e.v + " " + e.d);
		}
	}		

	private static class Edge {
		int u, v, d;
		public Edge(int u, int v, int d) {
			this.v = v;
			this.u = u;
			this.d = d;
		}
	}
}

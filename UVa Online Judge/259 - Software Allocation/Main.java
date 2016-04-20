import java.util.*;

/* ASCII 65 - 90 = A-Z.
 * Computers 0-9 = 1-10.
 * Start = 0.
 * end = 91.
 */

public class Main {

	private static ArrayList<Integer>[] graph;
	private static int[][] weights, residual;
	private static int m, check;
	private static int[] p, incoming;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			graph = new ArrayList[93];
			weights = new int[93][93];
			check = 0;
			for (int i = 0; i <= 92; ++i) graph[i] = new ArrayList<Integer>();
			String s = sc.nextLine();
			while (!s.equals("")) {
				StringTokenizer st = new StringTokenizer(s);
				String a1 = st.nextToken();
				String a2 = st.nextToken();
				char app = a1.charAt(0);
				int no = Integer.parseInt(a1.substring(1, a1.length()));
				check += no;
				graph[0].add((int)app);
				weights[0][(int)app] = no;
				char[] temp = a2.toCharArray(); 
				for (int i = 0; i < a2.length() - 1; ++i) {
					int t = Integer.parseInt(Character.toString(temp[i]));
					graph[(int)app].add(t + 1);
					graph[t + 1].add(92);
					graph[t+1].add((int)app);
					weights[(int)app][t + 1] = 1;
					weights[t + 1][92] = 1;
				}
				try {
					s = sc.nextLine();
				} catch (Exception e) {break;}
			}
			int flow = maxflow(0, 92);
			if (flow < check) {
				System.out.println("!");
			} else {
				for (int i = 1; i <= 10; ++i) {
					if (incoming[i] == 0) System.out.print("_");
					else System.out.print((char)incoming[i]);
				}
				System.out.println();
			}
		}
	}

	private static int maxflow(int start, int end) {
		int f = 0;
		residual = new int[93][93];
		incoming = new int[93];
		while (true) {
			m = bfs(start, end);
			if (m == 0) break;
			f += m;
			int v = end;
			while (v != start) {
				int u = p[v];
				incoming[v] = u;
				residual[u][v] += m;
				residual[v][u] -= m;
				v = u;
			}
		}
		return f;
	}

	private static int bfs(int start, int end) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		p = new int[93];
		for (int i = 0; i < 93; ++i) p[i] = -1;
		p[start] = -2;
		int[] w = new int[93];
		w[start] = Integer.MAX_VALUE;
		queue.add(start);
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (Integer v : graph[u]) {
				if (weights[u][v] - residual[u][v] > 0 && p[v] == -1) {
					p[v] = u;
					w[v] = Math.min(w[u], weights[u][v] - residual[u][v]);
					if (v != end) {
						queue.add(v);
					} else {
						return w[end];
					}
				}
			}
		}
		return 0;
	}
}

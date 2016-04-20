import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static ArrayList<Integer>[] graphYoung, graphOld;
	private static int[] distancesYoung, distancesOld;
	private static int[][] weightsOld, weightsYoung;
	private static int n;

	public static void main(String[] args) throws Exception {
		n = readInt();
		while (n != 0) {
			weightsOld = new int[91][91];
			weightsYoung = new int[91][91];
			graphYoung = new ArrayList[91];
			graphOld = new ArrayList[91];
			distancesYoung = new int[91];
			distancesOld = new int[91];
			Arrays.fill(distancesYoung, 10000000);
			Arrays.fill(distancesOld, 10000000);
			for (int i = 65; i <= 90; ++i) {
				graphOld[i] = new ArrayList<Integer>();
				graphYoung[i] = new ArrayList<Integer>(); 
			}
			for (int i = 0; i < n; ++i) {
				String age = readString();
				String direction = readString();
				String from = readString();
				String to = readString();
				int dist = readInt();
				if (age.equals("Y")) {
					if (direction.equals("U")) {
						graphYoung[(int)from.charAt(0)].add((int)to.charAt(0));
						weightsYoung[(int)from.charAt(0)][(int)to.charAt(0)] = dist;
					} else {
						graphYoung[(int)from.charAt(0)].add((int)to.charAt(0));
						graphYoung[(int)to.charAt(0)].add((int)from.charAt(0));
						weightsYoung[(int)from.charAt(0)][(int)to.charAt(0)] = dist;
						weightsYoung[(int)to.charAt(0)][(int)from.charAt(0)] = dist;
					}
				} else {
					if (direction.equals("U")) {
						graphOld[(int)from.charAt(0)].add((int)to.charAt(0));
						weightsOld[(int)from.charAt(0)][(int)to.charAt(0)] = dist;
					} else {
						graphOld[(int)from.charAt(0)].add((int)to.charAt(0));
						graphOld[(int)to.charAt(0)].add((int)from.charAt(0));
						weightsOld[(int)from.charAt(0)][(int)to.charAt(0)] = dist;
						weightsOld[(int)to.charAt(0)][(int)from.charAt(0)] = dist;
					}
				}
			}
			int startYoung = (int)readString().charAt(0);
			int startOld = (int)readString().charAt(0);
			dijkstra(startYoung, distancesYoung, graphYoung, weightsYoung);
			dijkstra(startOld, distancesOld, graphOld, weightsOld);
			int min = Integer.MAX_VALUE;
			ArrayList<Character> results = new ArrayList<Character>();
			for (int i = 65; i <= 90; ++i) {
				int a = distancesYoung[i];
				int b = distancesOld[i];
				if (a != 10000000 && b != 10000000 && min > a+b) {
					min = a+b;
					results.clear();
					results.add((char)i);
				} else if (a != 10000000 && b != 10000000 && min == a+b) {
					results.add((char)i);
				}
			}
			if (min == Integer.MAX_VALUE) {
				System.out.println("You will never meet.");
			} else {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < results.size(); ++i) {
					if (i == 0) sb.append(results.get(i));
					else sb.append(" " + results.get(i));
				}
				System.out.println(min + " " + sb.toString());
			}
			n = readInt();
		}
	}

	private static void dijkstra(int start, int[] distances, ArrayList<Integer>[] graph, int[][] weights) {
		PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
		distances[start] = 0;
		boolean[] visited = new boolean[91];
		queue.add(new Pair(start, 0));
		while (!queue.isEmpty()) {
			Pair u = queue.poll();
			if (!visited[u.name]) {
				visited[u.name] = true;
				for (Integer v : graph[u.name]) {
					if (distances[v] > distances[u.name] + weights[u.name][v]) {
						distances[v] = distances[u.name] + weights[u.name][v];
						queue.add(new Pair(v, distances[v]));
					}
				}
			}
		}
	}

	private static class Pair implements Comparable<Pair> {
		int name, weight;
		public Pair(int name, int weight) {
			this.name = name;
			this.weight = weight;
		}
		public int compareTo(Pair p) {
			return weight - p.weight;
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

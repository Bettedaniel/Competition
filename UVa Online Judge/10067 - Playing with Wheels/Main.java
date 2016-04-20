import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static HashSet<Integer> forbidden;
	private static ArrayList<Integer>[] graph = new ArrayList[10000];
	private static ArrayList<Integer> neighbours;

	public static void main(String[] args) throws Exception {
		for (int i = 0; i <= 9999; ++i) graph[i] = new ArrayList<Integer>();
		for (int i = 0; i <= 9999; ++i) {
			String s = Integer.toString(i);
			if (s.length() < 4) {
				s = padZeros(s, 4-s.length());
			}
			int a = Integer.parseInt(Character.toString(s.charAt(0)));
			int b = Integer.parseInt(Character.toString(s.charAt(1)));
			int c = Integer.parseInt(Character.toString(s.charAt(2)));
			int d = Integer.parseInt(Character.toString(s.charAt(3)));
			for (int z1 = -1; z1 <= 1; z1 += 2) {
				int t1 = a+z1;
				if (t1 < 0) t1 = 9;
				else t1 = t1%10;
				int t2 = b+z1;
				if (t2 < 0) t2 = 9;
				else t2 = t2%10;
				int t3 = c+z1;
				if (t3 < 0) t3 = 9;
				else t3 = t3%10;	
				int t4 = d+z1;
				if (t4 < 0) t4 = 9;
				else t4 = t4%10;
				String s1 = Integer.toString(t1)+Integer.toString(b)+Integer.toString(c)+Integer.toString(d);
				String s2 = Integer.toString(a)+Integer.toString(t2)+Integer.toString(c)+Integer.toString(d);
				String s3 = Integer.toString(a)+Integer.toString(b)+Integer.toString(t3)+Integer.toString(d);
				String s4 = Integer.toString(a)+Integer.toString(b)+Integer.toString(c)+Integer.toString(t4);
				int number1 = Integer.parseInt(s1);
				int number2 = Integer.parseInt(s2);
				int number3 = Integer.parseInt(s3);
				int number4 = Integer.parseInt(s4);
				graph[i].add(number1);
				graph[i].add(number2);
				graph[i].add(number3);
				graph[i].add(number4);
			}
		}
		int tc = readInt();
		for (int _ = 0; _ < tc; ++_) {
			StringBuilder sb1 = new StringBuilder();
			sb1.append(readString()+readString()+readString()+readString());
			StringBuilder sb2 = new StringBuilder();
			sb2.append(readString()+readString()+readString()+readString());
			forbidden = new HashSet<Integer>();
			int t = readInt();
			for (int i = 0; i < t; ++i) {
				StringBuilder sb = new StringBuilder();
				sb.append(readString()+readString()+readString()+readString());
				forbidden.add(Integer.parseInt(sb.toString()));
			}
			int start = Integer.parseInt(sb1.toString());
			int end = Integer.parseInt(sb2.toString());
		//	System.out.println(forbidden);
		//	System.out.println(start + " --> " + graph[start]);
			
			if (forbidden.contains(start) || forbidden.contains(end)) System.out.println("-1");
			else if (start == end) System.out.println("0");
			else System.out.println(bfs(start, end));
		}
	}

	private static int bfs(int start, int end) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[10000];
		int[] distance = new int[10000];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		visited[start] = true;
		queue.add(start);
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (Integer v : graph[u]) {
				if (!visited[v] && !forbidden.contains(v)) {
					visited[v] = true;
					distance[v] = distance[u] + 1;
					queue.add(v);
					if (v == end) {
						return distance[v];
					}
				}
			}
		}
		return -1;
	}

	private static String padZeros(String s, int n) {
		for (int i = 0; i < n; ++i) s = "0"+s;
		return s;
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}

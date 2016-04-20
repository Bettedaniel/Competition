import java.util.*;
import java.io.*;

public class Main {
	private static int n, fail, sucess;
	private static int[] rank, parent; 

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 0; t < tc; ++t) {
			try {
				n = sc.nextInt();;
				fail = 0;
				sucess = 0;
				if (t != 0) System.out.println();
				sc.nextLine();
				rank = new int[n+1];
				parent = new int[n+1];
				for (int i = 1; i <= n; ++i) parent[i] = i;
				String s = sc.nextLine();
				while (!s.equals("")) {
					StringTokenizer st1 = new StringTokenizer(s);
					String tar = st1.nextToken();
					int from = Integer.parseInt(st1.nextToken());
					int to = Integer.parseInt(st1.nextToken());
					if (tar.equals("c")) {
						link(find(from), find(to));
					} else {
						if (find(from) == find(to)) ++sucess;
						else ++fail;
					}
					if (sc.hasNextLine()) s = sc.nextLine();
					else s = "";
				}
				System.out.println(sucess + "," + fail);
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		}
	}

	private static void link(int x, int y) {
		if (rank[x] > rank[y]) {
			parent[y] = x;
		} else { 
			parent[x] = y;
			if (rank[x] == rank[y]) {
				rank[y] += 1;
			}
		}
	}

	private static int find(int x) {
		if (x != parent[x]) {
			parent[x] = find(parent[x]);	
		}
		return parent[x];
	}
}

import java.util.*;

public class Main {

	private static int edges, firestations;
	private static ArrayList<Integer> fs;
	private static int[][] weights;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();;
		for (int _ = 0; _ < testcases; ++_) {
			if (_ != 0) System.out.println();
			firestations = sc.nextInt();
			edges = sc.nextInt();
			fs = new ArrayList<Integer>();
			weights = new int[edges+1][edges+1];
			for (int i = 0; i < firestations; ++i) {
				fs.add(sc.nextInt());
			}
			for (int i = 0; i <= edges; ++i) {
				for (int j = 0; j <= edges; ++j) {
					weights[i][j] = 100000000;
				}
			}
			sc.nextLine();
			String s = sc.nextLine();
			while (!s.equals("") || !sc.hasNextLine()) {
				Scanner sc1 = new Scanner(s);
				int from = sc1.nextInt();
				int to = sc1.nextInt();
				int dist = sc1.nextInt();
				weights[from][to] = dist;
				weights[to][from] = dist;
				if (sc.hasNextLine()) s = sc.nextLine();
				else break;
				if (s.equals("")) break;
			}
			floydwarshall();
			int[] shortest = new int[edges+1];
			int min = Integer.MAX_VALUE;
			int mini = 0;
			for (int i = 1; i <= edges; ++i) {
				int total = 0;
				for (int j = 1; j <= edges; ++j) {
					int min2 = Integer.MAX_VALUE;
					for (Integer k : fs) {
						if (weights[j][k] < min2) {
							min2 = weights[j][k];
						}
						if (j == k && 0 < min2) min2 = 0;
					}
					if (weights[j][i] < min2) {
						min2 = weights[j][i];
					}
					if (i == j && 0 < min2) min2 = 0; 
					total += min2;
				}
				System.out.println(total);
				if (total < min) {
					min = total;
					mini = i;
				}
			}
			System.out.println(mini);
		}
	}

	private static void floydwarshall() {
		for (int k = 1; k <= edges; ++k) {
			for (int i = 1; i <= edges; ++i) {
				for (int j = 1; j <= edges; ++j) {
					weights[i][j] = Math.min(weights[i][j], weights[i][k] + weights[k][j]);
				}
			}
		}
	}
}

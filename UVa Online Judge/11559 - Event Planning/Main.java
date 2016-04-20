import java.util.*;

public class Main {
	
	private static int n, b, h, w, price;
	private static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			n = sc.nextInt();
			b = sc.nextInt();
			h = sc.nextInt();
			w = sc.nextInt();
			dp = new int[h][w+1];
			for (int i = 0; i < h; ++i) {
				dp[i][0] = sc.nextInt();
				for (int j = 1; j <= w; ++j) {
					dp[i][j] = sc.nextInt();
				}
			}
			int min = Integer.MAX_VALUE;
			int temp = 0;
			for (int i = 0; i < h; ++i) {
				int result = 0;
				for (int j = 1; j <= w; ++j) {
					if (dp[i][j] >= n) {
						result = n*dp[i][0];
						if (min > result) min = result;
						break;
					}
				}
			}
			if (min > b) {
				System.out.println("stay home");
			} else System.out.println(min);
		}
	}
}

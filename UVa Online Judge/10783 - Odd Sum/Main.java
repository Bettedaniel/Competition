import java.util.*;

public class Main {

	private static int testcases, a, b;
	private static int[] sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sum = new int[101];
		sum[0] = 1;
		int set = 1;
		for (int i = 1; i < 101; ++i) {
			if (i % 2 == 1) {
				sum[i] = (i) + sum[i - 1];	
				set = sum[i];
			} else sum[i] = set;
		}
		testcases = sc.nextInt();
		for (int t = 1; t <= testcases; ++t) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (a > 0) {
				System.out.println("Case " + t + ": " + (sum[b] - sum[a - 1]));
			} else if (a == 0 && b > 0) {
				System.out.println("Case " + t + ": " + (sum[b] - 1));
			} else if (a == 0 && b == 0) System.out.println("Case " + t + ": 0");
		}
	}
}

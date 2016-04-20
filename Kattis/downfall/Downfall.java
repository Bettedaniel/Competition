import java.util.*;
// Maybe use BigInteger?
import java.math.*;

public class Downfall {

	private static long A, B;
	private static int N, R, K, X0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		N = sc.nextInt();
		R = sc.nextInt();
		K = sc.nextInt();
		X0 = sc.nextInt();
		A = sc.nextLong();
		B = sc.nextLong();	
		long[] where = findBuckets();
		boolean overflow = detectOverflow(where);
		if (overflow) {
			System.out.println("OVERFLOW");	
		} else {
			// TODO: Detect where every drop ended up.
			System.out.println("NOT OVERFLOW");
		}
	}

	private static boolean detectOverflow(long[] where) {
		long[] amount = new long[N];
		for (int i = 1; i <= R; ++i) {
			amount[(int)where[i]]++;
		}
		for (int i = N-1; i > 0; --i) {
			if (amount[i] > K) {
				amount[i-1] += (amount[i] - K);
			}
		}
		return (amount[0] > K ? true : false);
	}

	private static long[] findBuckets() {
		long[] where = new long[R+1];
		where[0] = X0;
		for (int i = 1; i <= R; ++i) {
			where[i] = (A * where[i-1] + B) % (long)N;
		}
		return where;
	} 
}

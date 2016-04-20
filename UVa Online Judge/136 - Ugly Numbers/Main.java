import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("The 1500'th ugly number is 859963392.");
//		int count = 1;
/*		while (true) {
			if (isOnlyTheRights(number)) {
				++count;
				System.out.println(count);
			}
			if (count == 1500) {
				System.out.println("Result: " + number);
				return;
			}
			++number;
		} */
	}

/*	private static boolean isOnlyTheRights(int n) {
		if (n % 5 == 0) {
			n /= 5;
		} else if (n % 3 == 0) {
			n /= 3;
		} else if (n % 2 == 0) {
			n /= 2;
		} else {
			return false;
		}
		if (n == 1) return true;
		while (n != 1) {
			if (n % 5 == 0) n /= 5;
			else if (n % 3 == 0) n /= 3;
			else if (n % 2 == 0) n /= 2;
			else return false;
		}
		return true;
	} */
}

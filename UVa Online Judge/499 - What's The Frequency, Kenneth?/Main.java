import java.util.*;

public class Main {

	private static int[] frequency;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			frequency = new int[123];
			String s = sc.nextLine();
			char[] chars = s.toCharArray();
			for (int i = 0; i < s.length(); ++i) {
				++frequency[(char)chars[i]];
			}
			int max = -1;
			for (int i = 65; i <= 122; ++i) {
				if (frequency[i] > max) max = frequency[i];
				if (i == 90) i = 96;
			}
			for (int i = 65; i <= 122; ++i) {
				if (frequency[i] == max) System.out.print((char)i);
				if (i == 90) i = 96;
			}
			System.out.print(" " + max);
			System.out.println();
		}
	}		
}

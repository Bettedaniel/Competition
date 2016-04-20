import java.util.*;

public class MakeInput {
	public static void main(String[] args) {
		Random r = new Random(10000);
		System.out.println(24);
		for (int i = 0; i < 24; ++i) {
			System.out.println("10000 100000 10000");
			for (int j = 0; j < 100000; ++j) {
				System.out.println((r.nextInt(10000)+1) + " " + (r.nextInt(10000)+1) + " " + r.nextInt(10001));
			}
		}
	}
}

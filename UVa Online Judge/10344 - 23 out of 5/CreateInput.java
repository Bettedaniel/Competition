import java.util.*;

public class CreateInput {
	public static void main(String[] args) {
		Random r = new Random();
		for (int i = 0; i < 50000; ++i) {
			System.out.println(r.nextInt(50) + " " + r.nextInt(50) + " " + r.nextInt(50) + " " + r.nextInt(50) + " " + r.nextInt(50));
		}
		System.out.println("0 0 0 0 0");
	}
}

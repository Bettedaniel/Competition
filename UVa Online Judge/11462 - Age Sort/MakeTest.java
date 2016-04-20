import java.util.*;

public class MakeTest {
	public static void main(String[] args) {
		Random r = new Random();
		System.out.println(2000000);
		for (int i = 0; i < 2000000; ++i) {
			if (i == 0) System.out.print(r.nextInt(100));
			else System.out.println(" " + r.nextInt(100));
		}
		System.out.println(0);
	}		
}

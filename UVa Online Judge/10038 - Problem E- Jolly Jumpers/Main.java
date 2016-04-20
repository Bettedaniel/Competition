import java.util.*;

public class Main {

	private static ArrayList<Integer> input;
	private static boolean[] vis;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			Scanner sc1 = new Scanner(s);
			input = new ArrayList<Integer>();
			while (sc1.hasNextInt()) {
				input.add(sc1.nextInt());
			}
			vis = new boolean[3001];
			vis[0] = true;
			for (int i = 0; i < input.size() - 1; ++i) {
				int abs = Math.abs(input.get(i) - input.get(i+1));
				vis[abs] = true;
			}
			boolean doit = true;
			for (int i = 1; i < input.size() - 1; ++i) {
				if (!vis[i]) {
					System.out.println("Not jolly");
					doit = false;
					break;
				}
			}
			if (doit) System.out.println("Jolly");
		}
	}
}

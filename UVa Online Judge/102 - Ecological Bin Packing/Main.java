import java.util.*;

public class Main {

	private static int[] buckets;
	private static int[] movements;
	private static HashMap<Integer, String> map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new HashMap<Integer, String>();
		map.put(0, "BCG");
		map.put(1, "BGC");
		map.put(2, "CBG");
		map.put(3, "CGB");
		map.put(4, "GBC");
		map.put(5, "GCB");
		while (sc.hasNext()) {
			buckets = new int[9]; //brown: 0 3 6, green 1 4 7, clear 2 5 8.
			movements = new int[6]; //Combinations = 6.
			for (int i = 0; i < 9; ++i) { //0 = Brown, 1 = Green, 2 = Clear.
				int a = sc.nextInt();
				buckets[i] = a;
			}
			movements[0] = count(0, 5, 7); //BCG
			movements[1] = count(0, 4, 8); //BGC
			movements[2] = count(2, 3, 7); //CBG
			movements[3] = count(2, 4, 6); //CGB
			movements[4] = count(1, 3, 8); //GBC
			movements[5] = count(1, 5, 6); //GCB
			int min = Integer.MAX_VALUE;
			int mini = -1;
			for (int i = 0; i < 6; ++i) {
				if (movements[i] < min) {
					min = movements[i];
					mini = i;
				}
			}
			System.out.println(map.get(mini) + " " + min);
		}
	}

	private static int count(int a, int b, int c) {
		int m = 0;
		for (int i = 0; i < 9; ++i) {
			if (i != a && i != b && i != c) {
				m += buckets[i];
			}
		}
		return m;
	}
}

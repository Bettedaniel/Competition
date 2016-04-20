import java.util.*;

public class Main {

	private static String s;
	private static int[][] weights;
	private static int a, b, max;
	private static HashSet<Integer> list1, list2, list3;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = 1;
		while (sc.hasNextLine()) {
			s = sc.nextLine();
			weights = new int[101][101];
			for (int i = 0; i < 101; ++i) Arrays.fill(weights[i], 10000000);
			Scanner sc1 = new Scanner(s);
			max = 0;
			list1 = new HashSet<Integer>();
			a = sc1.nextInt();
			b = sc1.nextInt();
			if (a > max) max = a;
			if (b > max) max = b;
			if (a == 0 && b == 0) break;
			while (a != 0 || b != 0) {
				weights[a][b] = 1;
				list1.add(a);
				list1.add(b);
				a = sc1.nextInt();
				b = sc1.nextInt();
				if (a > max) max = a;
				if (b > max) max = b;
				weights[a][b] = 1;
			}
			double result = 0;
			int count = 0;
			floydwarshall();
			for (Integer i : list1) {
				for (Integer j : list1) {
					if (i != j) {
						++count;
						result += weights[i][j];
					}
				}
			}
			result = result / count;
			System.out.println("Case " + c + ": average length between pages = " + rTDP(result) + " clicks");
			++c;
		}
	}

	private static void floydwarshall() {
		for (Integer k : list1) {
			for (Integer i : list1) {
				for (Integer j : list1) {
					weights[i][j] = Math.min(weights[i][j], weights[i][k] + weights[k][j]);
				}
			}
		}
	}

	private static String rTDP(double d) {
		String s = Double.toString((double)(Math.round(d*1000))/1000);
		int index = -1;
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '.') {
				index = i;
				break;
			}
		}
		String result = s.substring(0, index+1);
		String ap = s.substring(index+1, s.length());
		while (ap.length() < 3) { 
			ap += "0";
		}
		return result + ap;
	}

}

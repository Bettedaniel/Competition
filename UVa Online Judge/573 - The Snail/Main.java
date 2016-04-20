import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int h, u, d, f;
	private static int fatigue;

	public static void main(String[] args) throws Exception {
		h = readInt();
		u = readInt();
		d = readInt();
		f = readInt();
		while (h != 0) {
			fatigue = u*f;
			int height = 0;
			int climb = u*100;
			int day = 1;
			while (height <= h*100 && height >= 0) {
				height += climb;
				if (height > h*100) break;
				height -= d*100;
				climb = Math.max(0, climb - fatigue);
				if (height < 0) break;
				++day;
			}
			if (height < 0) System.out.println("failure on day " + day);
			else System.out.println("success on day " + day);
			h = readInt(); u = readInt(); d = readInt(); f = readInt();
		}
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}

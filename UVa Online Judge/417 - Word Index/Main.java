import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static HashMap<String, Integer> map = new HashMap<String, Integer>();

	public static void main(String[] args) throws Exception {
		int i = 1;
		for (int a = 97; a <= 122; ++a) {
			map.put(Character.toString((char)a), i);
			++i;
		}
		for (int a = 97; a <= 121; ++a) {
			for (int b = a+1; b <= 122; ++b) {
				map.put(Character.toString((char)a)+Character.toString((char)b), i);
				++i;
			}
		}
		for (int a = 97; a <= 120; ++a) {
			for (int b = a+1; b <= 121; ++b) {
				for (int c = b+1; c <= 122; ++c) {
					map.put(Character.toString((char)a)+Character.toString((char)b)+Character.toString((char)c), i);
					++i;
				}
			}
		}
		for (int a = 97; a <= 119; ++a) {
			for (int b = a+1; b <= 120; ++b) {
				for (int c = b+1; c <= 121; ++c) {
					for (int d = c+1; d <= 122; ++d) {
						map.put(Character.toString((char)a)+Character.toString((char)b)+Character.toString((char)c)+Character.toString((char)d), i);
						++i;	
					}
				}
			}
		}
		for (int a = 97; a <= 118; ++a) {
			for (int b = a+1; b <= 119; ++b) {
				for (int c = b+1; c <= 120; ++c) {
					for (int d = c+1; d <= 121; ++d) {
						for (int e = d+1; e <= 122; ++e) {
							map.put(Character.toString((char)a)+Character.toString((char)b)+Character.toString((char)c)+Character.toString((char)d)+Character.toString((char)e), i);
							++i;	
						}
					}
				}
			}
		}
		int t = 1;
		StringBuilder sb = new StringBuilder();
		while (true) {
			try {
				String n = readString();
				if (t != 1) sb.append("\n");
				if (map.get(n) == null) sb.append(0);
				else sb.append(map.get(n));
				++t;
			} catch (Exception e) {
			//	e.printStackTrace();
				break;
			}
		}
		System.out.println(sb);
	} 

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}
}

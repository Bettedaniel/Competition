import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n;
	private static ArrayList<String> list; 

	public static void main(String[] args) throws Exception {
		while (true) {
			try {
				n = readInt();
			/*	list = new ArrayList<String>();
				if (n == 2) {
					for (int i = 0; i < 100; ++i) {
						String s = Integer.toString(i);
						if (s.length() < 2) {
							s = "0"+s;
						}
						int a = Integer.parseInt(s.substring(0, 1));
						int b = Integer.parseInt(s.substring(1, 2));
						if (pow(a+b) == Integer.parseInt(s)) list.add(s);
					}
				} else if (n == 4) {
					for (int i = 0; i < 10000; ++i) {
						String s = Integer.toString(i);
						if (s.length() < 4) {
							s = padZeros(s, 4);
						}
						int a = Integer.parseInt(s.substring(0, 2));
						int b = Integer.parseInt(s.substring(2, 4));
						if (pow(a+b) == Integer.parseInt(s)) list.add(s);
					}
				} else if (n == 6) {
					for (int i = 0; i < 1000000; ++i) {
						String s = Integer.toString(i);
						if (s.length() < 6) {
							s = padZeros(s, 6);
						}
						int a = Integer.parseInt(s.substring(0, 3));
						int b = Integer.parseInt(s.substring(3, 6));
						if (pow(a+b) == Integer.parseInt(s)) list.add(s);
					}
				} else if (n == 8) {
					for (int i = 0; i < 100000000; ++i) {
						String s = Integer.toString(i);
						if (s.length() < 8) {
							s = padZeros(s, 8);
						}
						int a = Integer.parseInt(s.substring(0, 4));
						int b = Integer.parseInt(s.substring(4, 8));
						if (pow(a+b) == Integer.parseInt(s)) list.add(s);
					}
				}
				for (String s : list) {
					System.out.println(s);
				} */
				if (n == 2) {
					System.out.println("00\n01\n81");
				} else if (n == 4) {
					System.out.println("0000\n0001\n2025\n3025\n9801");
				} else if (n == 6) {
					System.out.println("000000\n000001\n088209\n494209\n998001");
				} else if (n == 8) {
					System.out.println("00000000\n00000001\n04941729\n07441984\n24502500\n25502500\n52881984\n60481729\n99980001");
				}
			} catch (Exception e) {
			//	e.printStackTrace();
				return;
			}
		}	
	}

	private static String padZeros(String s, int i) {
		while (s.length() < i) {
			s = "0"+s;
		}
		return s;
	}

	private static long pow(long k) {return k*k;}

	private static String readString() throws Exception {
		while(!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}

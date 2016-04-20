import java.util.*;
import java.io.*;

public class Main {

	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int blocks;
	private static ArrayList<Integer>[] tape;
	
	public static void main(String[] args) throws Exception {
		blocks = readInt();
		tape = new ArrayList[blocks];
		for (int i = 0; i < blocks; ++i) {
			tape[i] = new ArrayList<Integer>();
			tape[i].add(i);
		}
		while (true) {
			String s1 = readString();
			if (s1.equals("quit")) break;
			int from = readInt();
			String s2 = readString();
			int to = readInt();
			if (s1.equals("move") && s2.equals("onto") && tape[from].contains(from) && tape[to].contains(to)) {
				boolean seen = false;
				for (int i = 0; i < tape[to].size(); ++i) {
					int a = tape[to].get(i);
					if (seen) {
						tape[a].add(a);
						tape[to].remove(new Integer(a));
					} else if (a == to) {
						seen = true;
					}
				}
				seen = false;
				for (int i = 0; i < tape[from].size(); ++i) {
					int a = tape[from].get(i);
					if (seen) {
						tape[a].add(a);
						tape[from].remove(new Integer(a));
					} else if (a == from) seen = true;
				}
				tape[to].add(from);
				tape[from].remove(new Integer(from));
			} else if (s1.equals("move") && s2.equals("over")) {
				boolean seen = false;
				for (int i = 0; i < tape[from].size()) {
					
				}
			}
		}
		for (int i = 0; i < blocks; ++i) System.out.println(i + " ---> " + tape[i]);
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(stdin.readLine());
		}
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}

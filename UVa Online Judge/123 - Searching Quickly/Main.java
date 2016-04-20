import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static HashSet<String> forbidden;
	private static ArrayList<String> list;
	private static ArrayList<Pair> answers;

	public static void main(String[] args) throws Exception {
		forbidden = new HashSet<String>();
		String s = readString().toLowerCase();
		while (!s.equals("::")) {
			forbidden.add(s);
			s = readString().toLowerCase();
		}
		answers = new ArrayList<Pair>();
		list = new ArrayList<String>();
		while (true) {
			try {
				String line = stdin.readLine();
				if (line == null) break;
				list.add(line);
			} catch (Exception e) {
		//		e.printStackTrace();
				break;
			}
		}
		int count = 0;
		for (int i = 0; i < list.size(); ++i) {
			StringTokenizer st1 = new StringTokenizer(list.get(i));
			StringBuilder sb = new StringBuilder();
			count = 0;
			while (st1.hasMoreTokens()) {
				String temp = st1.nextToken();
				if (!forbidden.contains(temp.toLowerCase())) {
					answers.add(new Pair(list.get(i), temp.toUpperCase(), i, count));
				}
				++count;
			}
		}
		Collections.sort(answers);
		for (int i = 0; i < answers.size(); ++i) {
			System.out.println(answers.get(i));
		}
	}

	private static class Pair implements Comparable<Pair> {
		String line, keyword;
		int id, wordnum;
		public Pair(String line, String keyword, int id, int wordnum) {
			this.line = line;
			this.keyword = keyword;
			this.id = id;
			this.wordnum = wordnum;
		}
		public int compareTo(Pair p) {
			if (keyword.toLowerCase().compareTo(p.keyword.toLowerCase()) == 0) {
				if (id == p.id) {
					return wordnum - p.wordnum;
				} else return id - p.id;
			}
			return keyword.toLowerCase().compareTo(p.keyword.toLowerCase());
		}
		public String toString() {
			StringTokenizer st1 = new StringTokenizer(line);
			int count = 0;
			StringBuilder sb = new StringBuilder();
			while (st1.hasMoreTokens()) {
				String temp = st1.nextToken();
				if (count != 0) sb.append(" ");
				if (count == wordnum) {
					sb.append(temp.toUpperCase());
				} else {
					sb.append(temp.toLowerCase());
				}
				++count;
			}
			return sb.toString();
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

import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static HashSet<Character> vowels = new HashSet<Character>();

	public static void main(String[] args) throws Exception {
		vowels.add('a'); vowels.add('A');
		vowels.add('e'); vowels.add('E');
		vowels.add('i'); vowels.add('I');
		vowels.add('o'); vowels.add('O');
		vowels.add('u'); vowels.add('U');
		while (true) {
			try {
				String s = stdin.readLine();
				StringTokenizer st = new StringTokenizer(s);
				StringBuilder sb = new StringBuilder();
				int t = 1;
				while (st.hasMoreTokens()) {
					String temp = st.nextToken();
					if (t != 1) sb.append(" ");
					sb.append(findWord(temp));
					++t;
				}
				System.out.println(sb.toString());
			} catch (Exception e) {
		//		e.printStackTrace();
				return;
			}
		}
	}

	private static String findWord(String s) {
		StringBuilder answer = new StringBuilder();
	//	System.out.println(s);
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if ((c >= 65 && c <= 90) || (c <= 122 && c >= 97)) {
				StringBuilder sb = new StringBuilder();
				int j;
				for (j = i; j < s.length(); ++j) {
					char c1 = s.charAt(j);
					if (c1 < 65 || (c > 90 && c < 97) || c > 122) {
						break;
					}
					sb.append(c1);
				}
				answer.append(format(sb.toString()));
				i = j;
				--i;
			} else {
				answer.append(s.charAt(i));
			}
		}
		return answer.toString();
	}

	private static String format(String word) {
		StringBuilder sb = new StringBuilder();
		if (vowels.contains(word.charAt(0))) {
			sb.append(word+"ay");
		} else {
			sb.append(word.substring(1, word.length()));
			sb.append(word.charAt(0));
			sb.append("ay");
		}
		return sb.toString();
	}
}

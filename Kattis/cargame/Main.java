import java.util.*;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int N = sc.nextInt();
		int M = sc.nextInt();
		String[] words = new String[N];
		String[] plates = new String[M];
		for (int i = 0; i < N; ++i) {
			words[i] = sc.next();	
		}
		for (int i = 0; i < M; ++i) {
			plates[i] = sc.next().toLowerCase();	
		}
		for (String plate : plates) {
			String foundWord = "";
			String regExp = "[a-zA-Z]*" + plate.charAt(0)
                            + "[a-zA-Z]*" + plate.charAt(1)
                            + "[a-zA-Z]*" + plate.charAt(2)
                            + "[a-zA-Z]*";
			for (String word : words) {
				if (Pattern.matches(regExp, word)) {
					foundWord = word;	
					break;
				}	
			}
			if ("".equals(foundWord)) {
				System.out.println("No valid word");	
			} else {
				System.out.println(foundWord);	
			}
		}
	}	
}

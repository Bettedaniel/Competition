import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			int result = 0;
			Scanner sc1 = new Scanner(s);
			while (sc1.hasNext()) {
				String a = sc1.next();
				a = a.toLowerCase();
				char[] array = a.toCharArray();
				if (a.length() == 1) {
					if ((int)array[0] >= 97 && (int)array[0] <= 122) {
						++result;
					} 
				} else {
					boolean add = false;
					for (int i = 0; i < a.length(); ++i) {
						if ((int)array[i] >= 97 && (int)array[i] <= 122) {
							add = true;
						} else if ((int)array[i] >= 48 && (int)array[i] <= 57 && add) {
							++result;
							add = false;
						}
					}
					if (add) {
						++result;
					}
				}
			}
			System.out.println(result);
		}
	}
}

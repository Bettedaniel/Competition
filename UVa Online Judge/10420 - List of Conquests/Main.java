import java.util.*;

public class Main {
	
	private static HashSet<String> vis;
	private static HashSet<String>[] list; 
	private static HashMap<String, Integer> map2;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		vis = new HashSet<String>();
		list = new HashSet[2000];
		for (int i = 0; i < 2000; ++i) list[i] = new HashSet<String>();
		map2 = new HashMap<String, Integer>();
		sc.nextLine();
		int name = 0;
		for (int i = 0; i < t; ++i) {
			String s = sc.nextLine();
			StringTokenizer st1 = new StringTokenizer(s);
			String country = st1.nextToken();
			if (!vis.contains(country)) {
				vis.add(country);
				map2.put(country, name);
				list[name].add(s.substring(country.length() + 1, s.length()));
				++name;
			} else {
				int j = map2.get(country);
				list[j].add(s.substring(country.length() + 1, s.length()));
			}
		}
		ArrayList<String> countries = new ArrayList<String>();
		for (String s : vis) countries.add(s);
		Collections.sort(countries);
		for (String s : countries) {
			System.out.println(s + " " + list[map2.get(s)].size());
		}
	}
}

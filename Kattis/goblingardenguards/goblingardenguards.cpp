#include <iostream>
#include <vector>

using namespace std;

int dist(int x1, int y1, int x2, int y2) {
	return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
}

int main() {
	int g, s;
	cin >> g;
	vector<vector<int> > gs(10010, vector<int>(10010, 0));
	int a, b;
	for (int i = 0; i < g; ++i) {
		cin >> a >> b;
		gs[a][b]++;
	}
	cin >> s;
	vector<int> xs(s);
	vector<int> ys(s);
	vector<int> rs(s);
	for (int j = 0; j < s; ++j) {
		cin >> xs[j] >> ys[j] >> rs[j];
	}
	int kills = 0;
	for (int j = 0; j < s; ++j) {
		int startx = xs[j] - rs[j];
		int starty = ys[j] - rs[j];
		for (int x = startx; x <= xs[j] + rs[j]; ++x) {
			for (int y = starty; y <= ys[j] + rs[j]; ++y) {
				if (x < 0 || y < 0) continue;
				if (x > 10000 || y > 10000) continue;
				if (dist(x, y, xs[j], ys[j]) <= rs[j] * rs[j]) {
					kills += gs[x][y];
					gs[x][y] = 0;
				}
			}	
		}
	}
	cout << (g - kills) << endl;
}

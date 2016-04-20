#include <iostream>

using namespace std;

int main() {
	int a, b, c, d, e, f, g, h;
	cin >> a >> b >> c >> d >> e >> f >> g >> h;
	double gunnar1 = 0;
	double gunnar2 = 0;
	double emma1 = 0;
	double emma2 = 0;
	for (int i = a; i <= b; ++i)
		gunnar1 += i;
	for (int i = c; i <= d; ++i)
		gunnar2 += i;
	for (int i = e; i <= f; ++i)
		emma1 += i;
	for (int i = g; i <= h; ++i)
		emma2 += i;
	gunnar1 = gunnar1 / (double)(b - a + 1);
	gunnar2 = gunnar2 / (double)(d - c + 1);
	emma1 = emma1 / (double)(f - e + 1);
	emma2 = emma2 / (double)(h - g + 1);
	if (gunnar1 + gunnar2 > emma1 + emma2) {
		cout << "Gunnar" << endl;
	} else if (emma1 + emma2 > gunnar1 + gunnar2) {
		cout << "Emma" << endl;	
	} else {
		cout << "Tie" << endl;
	}
}

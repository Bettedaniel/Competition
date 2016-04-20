#include <iostream>
#include <cmath>

using namespace std;

typedef long long ll;

int main() {
	string in;
	cin >> in;
	ll x = 0, y = 0;
	for (int i = 0; i < (int)in.size(); ++i) {
		x *= 2;
		y *= 2;
		if (in[i] == '1') {
			x += 1;
		} else if (in[i] == '2') {
			y += 1;
		} else if (in[i] == '3') {
			x += 1;
			y += 1;
		}
	}
	cout << in.size() << " " << x << " " << y << endl;
}

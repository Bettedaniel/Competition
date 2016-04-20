#include <iostream>
#include <algorithm>

using namespace std;

const int INF = (1 << 30);

int main() {
	int t;
	cin >> t;
	int l, n;
	for (int _=0; _<t; ++_) {
		cin >> l >> n;
		vector<int> ants(n);
		for (int i = 0; i < n; ++i) {
			cin >> ants[i];
		}
		int minimum = -1;
		int maximum = INF;
		for (int i = 0; i < n; ++i) {
			minimum = max(minimum, max(ants[i], l - ants[i]));	
		}
	}	
}

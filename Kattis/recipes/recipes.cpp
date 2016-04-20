#include <cstdio>
#include <iostream>
#include <vector>
#include <cmath>
#include <iomanip>

using namespace std;

int main() {
	int T;
	cin >> T;
	cout.precision(1);
	cout << fixed;
	for (int t = 0; t < T; ++t) {
		int R, P, D;
		cin >> R >> P >> D;
		int mainId = -1;
		vector<string> ingredients(R);
		vector<double> weights(R);
		vector<double> bakers(R);
		for (int i = 0; i < R; ++i) {
			cin >> ingredients[i] >> weights[i] >> bakers[i];
			if (bakers[i] == 100.0) {
				mainId = i;	
			}
		}
		double sf = D / (double) P;
		weights[mainId] = weights[mainId] * sf;
		for (int i = 0; i < R; ++i) {
			if (i != mainId) {
				weights[i] = (bakers[i] * weights[mainId]) / 100.0;	
			}	
		}
		cout << "Recipe # " << (t + 1) << endl;
		for (int i = 0; i < R; ++i) {
			cout << ingredients[i] << " " << weights[i] << endl;	
		}
		for (int i = 0; i < 40; ++i) {
			cout << "-";	
		}
		cout << endl;
	}
}

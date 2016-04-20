#include <iostream>
#include <vector>

using namespace std;

int main() {
	int T;
	cin >> T;
	for (int t = 0; t < T; ++t) {
		int N;
		cin >> N;
		vector<int> vec(10, 0);	
		int total = 0;
		int vote = 0;
		for (int i = 0; i < N; ++i) {
			cin >> vote;	
			vec[i] += vote;
			total += vote;
		}
		int winner = -1;
		int max = -1;
		for (int i = 0; i < N; ++i) {
			if (vec[i] > max) {
				max = vec[i];
				winner = i;	
			}	
		}
		for (int i = 0; i < N; ++i) {
			if (winner != i && vec[i] == max) {
				winner = -1;
				break;	
			}	
		}
		if (winner == -1) {
			cout << "no winner" << endl;
			continue;	
		}
		if (max > total / 2.0) {
			cout << "majority winner " << (winner + 1) << endl;	
		} else {
			cout << "minority winner " << (winner + 1) << endl;
		}
	}
}

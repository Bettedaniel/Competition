#include <iostream>
#include <vector>
#include <sstream>

using namespace std;

typedef long long ll;

struct fenwick {
	vector<int> T;
	int BM;
	fenwick(int n) : T(n, 0), BM(0) { while ((1<<(BM+1))<=n)++BM;}
	void inc(int x, ll add) { for (;x<(int)T.size();x|=x+1) T[x]+=add;}	
	ll query(int a, int b) {
		if (a==0) {
			ll sum = 0;
			for (;b>=0;b=(b&(b+1))-1) sum+=T[b];
			return sum;	
		} else return query(0, b) - query(0, a-1);
	}
};

int main() {
	int N, Q;
	cin >> N >> Q;
	char c;
	ll idx, val;
	fenwick fw(N);
	stringstream ss;
	for (int i = 0; i < Q; ++i) {
		cin >> c >> idx;	
		if (c == '+') {
			cin >> val;
			fw.inc(idx, val);
		} else {
			int result;
			if (idx == 0) result = 0; 
			else result = fw.query(0, idx-1);	
			ss << result << "\n";
		}
	}
	cout << ss.str();
}

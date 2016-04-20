#include <iostream>
#include <vector>
#include <cmath>
#include <map>
#include <sstream>

using namespace std;

typedef long long ll;
typedef pair<ll, ll> pll;

const int MAX = 10000;
int N, M;
vector<int> G[MAX];
char OPER[MAX][MAX];
int mL[MAX];
int mR[MAX];
char V[MAX];
int dfs(int u) {
	if (u<0) return 1;	
	if (V[u]) return 0;
	V[u] = 1;
	for (int i=0;i<(int)G[u].size();++i) if (dfs(mR[G[u][i]])) {
		return mL[u]=G[u][i],mR[G[u][i]]=u, 1;	
	}
	return 0;
}
int explore(int u) {
	for (int i=0;i<N;++i) V[i]=0;
	return dfs(u);	
}
int bpm() {
	int ret=0;
	for (int i=0;i<M;++i) mR[i]=-1;
	for (int i=0;i<N;++i) mL[i]=-1;
	for (int i=0;i<N;++i) if (mL[i]<0) ret += explore(i);	
	return ret;
}


int main() {
	int n;
	ios_base::sync_with_stdio(false);
	cin >> n;
	ll a, b;
	vector<pll> nums(n);
	map<ll, int> resultsMap;
	for (int i = 0; i < n; ++i) {
		cin >> a >> b;
		nums[i] = {a, b};
	}
	int k = 0;
	for (int i = 0; i < n; ++i) {
		ll valPlus = nums[i].first + nums[i].second;
		ll valProd = nums[i].first * nums[i].second;
		ll valMinus = nums[i].first - nums[i].second;
		if (resultsMap.find(valPlus) == resultsMap.end()) {
			resultsMap[valPlus] = k++;
		}
		if (resultsMap.find(valProd) == resultsMap.end()) {
			resultsMap[valProd] = k++;	
		}
		if (resultsMap.find(valMinus) == resultsMap.end()) {
			resultsMap[valMinus] = k++;	
		}
		G[i].push_back(resultsMap[valPlus]);
		OPER[i][resultsMap[valPlus]] = 0;
		G[i].push_back(resultsMap[valProd]);
		OPER[i][resultsMap[valProd]] = 1;
		G[i].push_back(resultsMap[valMinus]);
		OPER[i][resultsMap[valMinus]] = 2;
	}
	N = n;
	M = k;
	int res = bpm();
	stringstream ss;
	if (res >= n) {
		for (int i = 0; i < n; ++i) {
			int right = mL[i];
			if (OPER[i][right] == 0) {
				ss << nums[i].first << " + " << nums[i].second << " = " << (nums[i].first + nums[i].second) << "\n";
			} else if (OPER[i][right] == 1) {
				ss << nums[i].first << " * " << nums[i].second << " = " << (nums[i].first * nums[i].second) << "\n";	
			} else if (OPER[i][right] == 2) {
				ss << nums[i].first << " - " << nums[i].second << " = " << (nums[i].first - nums[i].second) << "\n";	
			} else {
				return 1;	
			}
		}	
		cout << ss.str();
	} else {
		cout << "impossible" << endl;	
	}
	return 0;
}

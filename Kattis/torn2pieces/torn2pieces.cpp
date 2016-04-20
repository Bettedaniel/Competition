#include <iostream>
#include <vector>
#include <map>
#include <queue>
#include <sstream>

using namespace std;

int N = 0;
const int MAXV = 1000;

map<string, int> msi;
map<int, string> mis;

void solve(int from, int to, vector<vector<int> > &g) {
	vector<char> visited(MAXV, 0);	
	vector<int> parent(MAXV, -1);	
	queue<int> q;
	q.push(from);
	visited[from] = 1;
	bool path = false;
	while (!q.empty()) {
		int u = q.front();
		q.pop();
		for (int i = 0; i < (int)g[u].size(); ++i) {
			int v = g[u][i];	
			if (!visited[v]) {
				q.push(v);
				visited[v] = 1;
				parent[v] = u;
				if (v == to) {
					path = true;
				} 
			}
		}
	}
	if (path) {
		vector<int> path;
		int v = to;
		path.push_back(v);
		while (v != from) {
			int u = parent[v];	
			path.push_back(u);
			v = u;
		}
		for (int i = path.size()-1; i >= 0; --i) {
			if (i == 0) {
				cout << mis[path[i]] << endl; 
			} else {
				cout << mis[path[i]] << " ";	
			}
		}
	} else {
		cout << "no route found" << endl;	
	}
}

int main() {
	cin >> N;
	vector<vector<int> > graph(MAXV);		
	vector<vector<char> > added(MAXV, vector<char>(MAXV, 0));
	string line;
	int k = 0;
	getline(cin, line);
	for (int i = 0; i < N; ++i) {
		getline(cin, line);
		stringstream ss(line);
		string from, to;
		ss >> from;
		if (msi.find(from) == msi.end()) {
			msi[from] = k++;
			mis[k-1] = from;	
		}
		while (ss >> to) {
			if (msi.find(to) == msi.end()) {
				msi[to] = k++;
				mis[k-1] = to;	
			}
			if (!added[msi[from]][msi[to]]) {
				graph[msi[from]].push_back(msi[to]);
				graph[msi[to]].push_back(msi[from]);
				added[msi[from]][msi[to]] = 1;
				added[msi[to]][msi[from]] = 1;
			}
		}
	}
	string start, end;
	cin >> start >> end;
	solve(msi[start], msi[end], graph);
}

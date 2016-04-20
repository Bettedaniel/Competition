#include <iostream>
#include <vector>
#include <queue>
#include <cmath>
#include <algorithm>
#include <map>

using namespace std;

/*
Some perhaps useful ideas:
(1)	Find stable parts. Stable part being a part of the graph
	where there is no danger of any design sinking.
	Stable parts identified as cycles.

	Now the problem is a forest of trees.

	2 cases:
	(1)	We can use 2 boats to save a long line of designs.
	(2)	We can use 1 boat to save a line of designs from an
		already saved part.

	Can also view the added ships as being connected to a cycle already.
	Then we need to find the longest parts that connect two cycles.	

	(Use first of two cases if second case can't save anything?)

(2)
*/

int N, M, K;

void printGraph(vector<vector<int> > &G) {
	for (int i = 1; i <= N; ++i) {
		cout << "u: " << i << " -> {";
		for (int j = 0; j < (int)G[i].size(); ++j) {
			if (j != (int)G[i].size() - 1) {
				cout << G[i][j] << ", ";
			} else {
				cout << G[i][j] << "}" << endl;	
			}
		}	
	}	
}

// Nodes i included in cycles should have saved[i] = 1.
void removeCycles(vector<char> &saved, vector<vector<int> > &G) {
	vector<int> degree(N+1);
	for (int i = 1; i <= N; ++i) {
		degree[i] = G[i].size();	
	}
	queue<int> q;
	for (int i = 1; i <= N; ++i) {
		if (degree[i] == 1) {
			q.push(i);	
		}	
	}
	while (!q.empty()) {
		int u = q.front();
		q.pop();
		saved[u] = 0;	
		for (int i = 0; i < (int)G[u].size(); ++i) {
			int v = G[u][i];
			degree[v]--;
			if (degree[v] == 1) {
				q.push(v);
			}
		}
	}
}

vector<int> savePath(vector<char> &saved, vector<vector<int> > &G, int start) {
	queue<int> q;	
	q.push(start);
	// Distance from start.
	vector<int> dist(N+1, 0);
	vector<char> visited(N+1, 0);
	vector<int> parent(N+1, 0);
	visited[start] = 1;
	while (!q.empty()) {
		int u = q.front();
		q.pop();
		for (int i = 0; i < (int)G[u].size(); ++i) {
			int v = G[u][i];	
			if (!visited[v] && !saved[v]) {
				q.push(v);	
				visited[v] = 1;
				dist[v] = dist[u] + 1;
				parent[v] = u;
			}
		}	
	}
	int v = -1;
	int mxDist = 0;
	for (int i = 1; i <= N; ++i) {
		if (mxDist < dist[i]) {
			mxDist = dist[i];
			v = i;	
		}	
	}
	vector<int> path; 
	if (v == -1) return path;
	while (v != start) {
		path.push_back(v);
		int u = parent[v];	
		v = u;
	}
	return path;
}

// For every already saved node we compute what the maximum number of nodes can be saved from this one. Then we pick the maximum one and save that path. We then continue with a larger set of saved nodes.
int solve(vector<char> &saved, vector<vector<int> > &G) {
	vector<int> starts;
	for (int i = 1; i <= N; ++i) {
		if (saved[i] == 1) starts.push_back(i);	
	}
	int used = 0;
	while (used < K) {
		map<int, vector<int> > miv;
		int mx = 0;
		for (int i = 0; i < (int)starts.size(); ++i) {
			vector<int> path = savePath(saved, G, starts[i]);
			miv[(int)path.size()] = path;
			mx = max(mx, (int)path.size());
		}
		if (mx > 0) ++used;
		for (int j = 0; j < (int)miv[mx].size(); ++j) {
			saved[miv[mx][j]] = 1;
			starts.push_back(miv[mx][j]);
		}
	}
	return N - starts.size();
}

int main() {
	int tc;
	cin >> tc;
	for (int t = 0; t < tc; ++t) {
		cin >> N >> M >> K;
		vector<vector<int> > G(N+1);
		int a, b;
		for (int i = 0; i < M; ++i) {
			cin >> a >> b;
			G[a].push_back(b);
			G[b].push_back(a);
		}
//		printGraph(G);
		vector<char> saved(N+1, 1);
		removeCycles(saved, G);
		int r = solve(saved, G);
		cout << r << endl;
	}
}

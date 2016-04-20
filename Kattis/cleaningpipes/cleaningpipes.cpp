#include <iostream>
#include <vector>
#include <cmath>
#include <stack>

using namespace std;

typedef pair<int, int> PT;

const int MAXVARS = 1000;
const int MAXNODES = 2*MAXVARS;
int V,N;
vector<int> G[MAXNODES];
bool ASS[MAXNODES];
bool def[MAXNODES];
int neg(int x) {return -x;}
int var(int x) {return ((x>=0) ? 2*(x-1) : 2*((-x)-1)+1);}
void add_edge(int x, int y) {G[var(x)].push_back(var(y));}
void add_impl(int x, int y) {
	add_edge(x,y), add_edge(neg(y), neg(x));	
}
void add_or(int x, int y) {add_impl(neg(x),y);}
void init(int v) {
	V=v, N=2*V;
	for (int i=0;i<N;i++) G[i].clear();
}
bool assign(int i, int start, bool val) {
	if (i/2==start/2 && i!=start) return 0;
	if (def[i/2]) return 1;
	def[i/2]=1, ASS[i/2] = ((i%2==0) ? val : !val);
	for (int k=0;k<G[i].size();k++) if (!assign(G[i][k],start,val))
		return def[i/2]=0;
	return 1;
}
int comp[MAXNODES];
const int MAXV=MAXNODES;
int NSCC;
stack<int> S;
bool on_stack[MAXV];
int depth[MAXV];
int lowlink[MAXV];
int maxdfs;
void DFS(int u) {
	depth[u]=lowlink[u]=maxdfs, maxdfs++,S.push(u),on_stack[u]=true;
	for (int k=0;k<G[u].size();k++) {
		int v=G[u][k];
		if (depth[v]==-1) DFS(v),lowlink[u]=min(lowlink[u],lowlink[v]);	
		else if (on_stack[v]) lowlink[u]=min(lowlink[u],depth[v]);
	}
	if (lowlink[u]==depth[u]) {
		int v;
		do {v=S.top(),comp[v]=NSCC,on_stack[v]=false,S.pop();}while(u!=v);
		NSCC++;	
	}
}
void SCC() {
	NSCC=maxdfs=0;
	for (int i=0;i<N;i++) on_stack[i]=false, depth[i]=-1;
	for (int i=0;i<N;i++) if (depth[i]==-1) DFS(i);
}
bool is_satisfiable() {
	SCC();
	for (int i=1;i<=V;i++) {
		if (comp[var(i)]==comp[var(neg(i))]) return 0;
		def[i]=0;	
	}
	for (int i=1;i<=V;i++)
		assign(var(i),var(i),1) || assign(var(neg(i)),var(neg(i)),1);	
	return 1;
}

// Given three colinear points p, q, r, the function checks if
// point q lies on line segment 'pr'
bool onSegment(PT p, PT q, PT r)
{
    if (q.first <= max(p.first, r.first) && q.first >= min(p.first, r.first) &&
        q.second <= max(p.second, r.second) && q.second >= min(p.second, r.second))
       return true;
 
    return false;
}
 
// To find orientation of ordered triplet (p, q, r).
// The function returns following values
// 0 --> p, q and r are colinear
// 1 --> Clockwise
// 2 --> Counterclockwise
int orientation(PT p, PT q, PT r)
{
    // See http://www.geeksforgeeks.org/orientation-3-ordered-points/
    // for details of below formula.
    int val = (q.second - p.second) * (r.first - q.first) -
              (q.first - p.first) * (r.second - q.second);
 
    if (val == 0) return 0;  // colinear
 
    return (val > 0)? 1: 2; // clock or counterclock wise
}
 
// The main function that returns true if line segment 'p1q1'
// and 'p2q2' intersect.
bool doIntersect(PT p1, PT q1, PT p2, PT q2)
{
    // Find the four orientations needed for general and
    // special cases
    int o1 = orientation(p1, q1, p2);
    int o2 = orientation(p1, q1, q2);
    int o3 = orientation(p2, q2, p1);
    int o4 = orientation(p2, q2, q1);
 
    // General case
    if (o1 != o2 && o3 != o4)
        return true;
 
    // Special Cases
    // p1, q1 and p2 are colinear and p2 lies on segment p1q1
    if (o1 == 0 && onSegment(p1, p2, q1)) return true;
 
    // p1, q1 and p2 are colinear and q2 lies on segment p1q1
    if (o2 == 0 && onSegment(p1, q2, q1)) return true;
 
    // p2, q2 and p1 are colinear and p1 lies on segment p2q2
    if (o3 == 0 && onSegment(p2, p1, q2)) return true;
 
     // p2, q2 and q1 are colinear and q1 lies on segment p2q2
    if (o4 == 0 && onSegment(p2, q1, q2)) return true;
 
    return false; // Doesn't fall in any of the above cases
}

int main() {
	int w, p;
	ios_base::sync_with_stdio(false);
	cin >> w >> p;
	vector<PT> wells(w);
	int x, y;
	for (int i = 0; i < w; ++i) {
		cin >> x >> y;
		wells[i] = {x, y};	
	}
	vector<int> startWell(p);
	vector<int> xs(p);
	vector<int> ys(p);
	for (int i = 0; i < p; ++i) {
		cin >> startWell[i] >> xs[i] >> ys[i];
	}
	init(p);
	for (int i = 0; i < p; ++i) {
		for (int j = i+1; j < p; ++j) {
			if (startWell[i] == startWell[j]) {
				continue;
			}
			PT a = wells[startWell[i]-1];
			PT b = {xs[i], ys[i]};	
			PT c = wells[startWell[j]-1];
			PT d = {xs[j], ys[j]};
			if (doIntersect(a, b, c, d)) {
				add_or(i+1, j+1);
				add_or(neg(i+1), neg(j+1));
			}
		}
	}
	if (is_satisfiable()) {
		cout << "possible" << endl;	
	} else {
		cout << "impossible" << endl;	
	}
	
}

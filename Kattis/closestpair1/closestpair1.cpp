#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

typedef pair<int,int> pii;
typedef long long ll;
const int MAXP = 100000;
struct PT {
	ll x,y; PT(ll a=0, ll b=0) : x(a), y(b) {}	
};
vector<PT> P;
ll sqr(ll x) {return x*x;}
ll dist(int a, int b) {
	return sqr(P[a].x-P[b].x) + sqr(P[a].y-P[b].y);
}
bool xcmp(int a, int b) {return abs(P[a].x<P[b].x);}
bool ycmp(int a, int b) {return abs(P[a].y<P[b].y);}
short M[MAXP]; int I[MAXP];
pii clp(const vector<int>& X, const vector<int>& Y) {
	int n = X.size(); pii ans(-1,-1); ll mind, cur;	
	if (n<=3) {
		for (int i=0;i<n;++i) for (int j=i+1;j<n;++j)
			if (ans.first==-1 || (cur=dist(X[i],X[j]))<mind)
				mind=cur, ans={X[i],X[j]};	
		return ans;
	}
	vector<int> lx(X.begin(),X.begin()+n/2),rx(X.begin()+n/2,X.end());
	vector<int> ly(n/2),ry(n-n/2); int c1=0, c2=0, Icnt=0;
	for (int i=0;i<n/2;++i) M[X[i]]=1;
	for (int i=0;i<n;++i) (M[Y[i]]==1)?ly[c1++]=Y[i]:ry[c2++]=Y[i];
	for (int i=0;i<n/2;++i) M[X[i]]=-1;
	pii cll = clp(lx,ly); ll clldist = dist(cll.first,cll.second);
	pii clr = clp(rx,ry); ll clrdist = dist(clr.first,clr.second);
	if (clldist < clrdist) ans=cll,mind=clldist; else ans=clr,mind=clrdist;
	ll split = (P[X[n/2-1]].x+P[X[n/2]].x)/2ll;
	for (int i=0;i<n;++i)if(abs(P[Y[i]].x-split)<=mind)I[Icnt++]=Y[i];
	for (int i=0;i<Icnt;++i) for (int j=i+1;j<min(Icnt,i+8);++j)
		if ((cur=dist(I[i],I[j]))<mind) mind=cur, ans={I[i],I[j]};
	return ans;
}
pii closestpair(const vector<PT>& v) {
	P = v; int n = P.size(); vector<int> X(n, 0), Y(n, 0);	
	for (int i=0;i<n;++i) X[i]=Y[i]=i, M[i]=-1;
	sort(X.begin(),X.end(),xcmp), sort(Y.begin(),Y.end(),ycmp);
	return clp(X,Y);
}

int main() {
	int n;
	ios_base::sync_with_stdio(false);
	cin >> n;
	while (n != 0) {
		vector<PT> v;
		double x, y;
		for (int i = 0; i < n; ++i) {
			cin >> x >> y;
			v.push_back(PT((ll)(x*100ll), (ll)(y*100ll)));	
		}
		pii r = closestpair(v);
		cout << v[r.first].x / 100.0 << " " << v[r.first].y / 100.0 << " " << v[r.second].x / 100.0 << " " << v[r.second].y / 100.0 << endl;	
		cin >> n;	
	}
}

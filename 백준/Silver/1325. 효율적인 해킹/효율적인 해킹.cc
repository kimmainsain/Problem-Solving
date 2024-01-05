#include <bits/stdc++.h>
using namespace std;

int n, m;
int mem[10001];
vector<int> adj[10001];

int BFS(int x){
    int ret = 0;
    bool vis[n+1];
    memset(vis,0, sizeof(vis));

    queue<int> Q;
    Q.push(x); vis[x] = 1;

    while(!Q.empty()){
        int cur = Q.front(); Q.pop();
        for(auto nx : adj[cur]){
            if(!vis[nx]){
                ret++;
                vis[nx]=1;
                Q.push(nx);
            }
        }
    }

    return ret;
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    cin >> n >> m;

    for(int i=0; i<m; i++){
        int a, b;
        cin >> a >> b;

        adj[b].push_back(a);
    }


    int ans = 0;
    for(int i=1; i<=n; i++){
        mem[i] = BFS(i);
        ans = max(ans, mem[i]);
    }

    for(int i=1; i<=n; i++){
        if(mem[i] == ans){
            cout << i << ' ';
        }
    }


    return 0;
}
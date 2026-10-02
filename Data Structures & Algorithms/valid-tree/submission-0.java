class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] vis = new boolean[n];
        for(int i = 0;i<n;i++){
            if(!vis[i]) if(dfs(i,-1,adj,vis)) return false;
        }
        return true;
    }
    public boolean dfs(int node,int parent,List<List<Integer>> adj,boolean[] vis){
        vis[node] = true;
        for(int n : adj.get(node)){
            if(!vis[n]) {
                if(dfs(n,node,adj,vis)) return true;
            } else if(n!=parent) return true;
        }
        return false;
    }
}

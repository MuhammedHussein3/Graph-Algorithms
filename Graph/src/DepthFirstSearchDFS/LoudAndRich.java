package DepthFirstSearchDFS;

import java.util.ArrayList;

public class LoudAndRich {
    class Solution {
        public int[] loudAndRich(int[][] richer, int[] quiet) {

            int n = quiet.length;
            adj = new ArrayList<>();
            for (int i =1;i<=n;i++){
                adj.add(new ArrayList<>());
            }
            for (int[] row : richer) {
                adj.get(row[1]).add(row[0]);
            }
            int[] res = new int[n];
            for (int i = 0;i<n;i++){
                vis = new boolean[n];
                val = quiet[i];
                ans = -1;
                dfs(i,quiet);

                if (ans == -1){
                    ans = i;
                }
                res[i] = ans;
            }

            return res;
        }
        ArrayList<ArrayList<Integer>> adj;
        int val,ans;
        boolean[]vis;
        void dfs(int child,int [] q){
            vis[child] = true;
            for (int parent : adj.get(child))
            {
                if (!vis[parent]){
                    if (val < q[parent])
                    {
                        val = q[parent];
                        ans = child;
                    }
                    dfs(parent,q);
                }
            }
        }
    }
}

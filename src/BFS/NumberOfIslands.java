package BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {
    class Solution {
        public int numIslands(char[][] grid) {

            boolean[][] vis = new boolean[grid.length][grid[0].length];

            int count = 0;

            for (int i=0;i<grid.length;i++){
                for (int j=0;j<grid[0].length;j++){
                    if (grid[i][j] == '1'){
                        count++;
                        bfs(grid,i,j,vis);
                    }
                }
            }
            return count;
        }
        static int r[]={1,-1,0,0};
        static int c[]={0,0,1,-1};
         class Node{
             int i,j;
             public Node(int i,int j){
                 this.i = i;
                 this.j = j;
             }
         }
        void bfs(char[][] grid, int i, int j,boolean[][] vis) {


            vis[i][j] = true;
            Queue<Node> q = new ArrayDeque<>();

            q.add(new Node(i,j));
            while (!q.isEmpty())
            {
                Node cur = q.poll();
                for (int d = 0;d < 4;d++){
                    int dir1 = cur.i + r[d];
                    int dir2 = cur.j + r[d+1];
                    if (valid(grid.length,grid[0].length,dir1,dir2)&&!vis[dir1][dir2]&&grid[dir1][dir2]=='1'){
                        vis[dir1][dir2] = true;
                        q.add(new Node(dir1,dir2));
                    }
                }
            }
        }
        boolean valid(int n,int m,int i,int j){
             return i>=0 && j>=0 && i<n & j<m;
        }

    }

 }


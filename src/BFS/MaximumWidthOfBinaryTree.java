package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
              this.right = right;
          }
     }

    class Solution {
          public class Node{
              TreeNode node;
              int idx;
              public Node(TreeNode node, int idx) {
                  this.node = node;
                  this.idx = idx;
              }
          }
        public int widthOfBinaryTree(TreeNode root) {
            if(root==null)
                return 0;
            return bfs(root);
        }

        int bfs(TreeNode root)
        {
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(root,0));
            int max = 0;
            while (!queue.isEmpty()){
                int size = queue.size();
                int l =0 ,r =0;
                for (int i = 0; i < size; i++) {
                    var curNod = queue.peek().node;
                    var curIdx = queue.peek().idx;
                    queue.poll();
                    if (i==0)
                        l = curIdx;
                    else if (i==size-1)
                        r = curIdx;
                    if (curNod.left!=null){
                        queue.add(new Node(curNod.left,2*curIdx+1));
                    }
                    if (curNod.right!=null){
                        queue.add(new Node(curNod.right,2*curIdx+2));
                    }

                }
                max = Math.max(max,r-l + 1);
            }
            return max;
        }
    }
}

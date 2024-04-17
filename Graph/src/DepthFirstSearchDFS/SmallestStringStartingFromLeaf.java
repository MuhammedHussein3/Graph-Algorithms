package DepthFirstSearchDFS;

public class SmallestStringStartingFromLeaf {
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

         public String smallestFromLeaf(TreeNode root) {

             path = "";
             res = "";
            dfs(root);
            return res;
        }
        String path;
         String res;
         void dfs(TreeNode root){

             if (root==null) return;
             if (root.left==null && root.right==null){
                 path+=(char)(root.val+97);
                 StringBuilder reverse = new StringBuilder(path).reverse();
                 if (reverse.isEmpty())
                     res = path;
                 if (res.compareToIgnoreCase(new String(reverse))<0)
                 {
                     res = path;
                     System.out.println(res);
                 }
                 path = path.substring(0,path.length()-1);
             }
             path+=(char)(root.val+97);
             dfs(root.left);
             dfs(root.right);
             path = path.substring(0,path.length()-1);
         }
        }
}

package DepthFirstSearchDFS;

public class SumRootToLeafNumbers {


      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
        TreeNode() {}
       TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.left = left;
           this.right = right;
        }
    }

    class Solution {
        public int sumNumbers(TreeNode root) {

            path = "";
         return dfs(root,"");

        }
        String path;
        public int dfs(TreeNode root,String path) {

            if (root==null)
                return 0;
            if (root.left==null&&root.right==null){
                String allPath = path.concat(root.val+"");
                return Integer.parseInt(allPath);
            }
            int sum = 0;
            path += root.val+"";
            sum += dfs(root.left,path+root.val)+dfs(root.right,path+root.val);
            path = path.substring(0,path.length()-1);
            return sum;
        }
    }
}

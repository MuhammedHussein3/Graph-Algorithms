package DepthFirstSearchDFS;

public class AddOneRowToTree {


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
        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            if (root == null) {
                return root;
            }
            if (depth==1){
                newTree = new TreeNode(val);
                newTree.left = root;
                return newTree;
            }

            dfs(root,val,depth-1);

            return root;
        }
        TreeNode newTree;

        void dfs(TreeNode root,int val, int depth) {

            if (root==null) {
                return;
            }



            if (depth-1 == 0){
                TreeNode childRight = new TreeNode(val);
                childRight.right = root.right;
                root.right = childRight;
                TreeNode childLeft = new TreeNode(val);

                childLeft.left = root.left;
                root.left = childLeft;
            }else {
                dfs(root.left, val, depth - 1);
                dfs(root.right, val, depth - 1);

            }

        }

    }
}

package Daily.Nov2023;


import javax.swing.tree.TreeNode;

public class 二叉树中的伪回文路径1457 {
    int ans = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root, 0);
        return ans;
    }
    void dfs(TreeNode root, int cnt) {
        if (root.left == null && root.right == null) {
            cnt ^= 1 << root.val;
            if (cnt == (cnt & -cnt)) ans++;
            return ;
        }
        if (root.left != null) dfs(root.left, cnt ^ (1 << root.val));
        if (root.right != null) dfs(root.right, cnt ^ (1 << root.val));
    }
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
}


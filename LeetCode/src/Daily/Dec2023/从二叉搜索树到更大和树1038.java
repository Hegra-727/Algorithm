package Daily.Dec2023;

public class 从二叉搜索树到更大和树1038 {
    int s=0;
    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }
    void dfs(TreeNode node){
        if(node==null){
            return;
        }
        dfs(node.right);
        s+=node.val;
        node.val=s;
        dfs(node.left);
    }
}

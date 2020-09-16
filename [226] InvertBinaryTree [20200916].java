public class InvertBinaryTree {

    public static void main(String[] args) {

    }


    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        recurse(root);
        return root;
    }

    private void recurse(TreeNode root) {
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        if(root.left != null)
            recurse(root.left);
        if(root.right != null)
            recurse(root.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

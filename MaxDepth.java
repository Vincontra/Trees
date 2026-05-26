public class MaxDepth {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
            left=null;
            right=null;
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(7);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.left.right.left=new TreeNode(5);
        root.left.right.right=new TreeNode(6);

        System.out.println(Height(root));


    }
    public static int Height(TreeNode root){
        if (root==null){
            return 0;
        }
        return 1+Math.max(Height(root.left),Height(root.right));
    }
}

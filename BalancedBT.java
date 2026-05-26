public class BalancedBT {
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
        // for each node:
        // Math.abs(height(left)-height(right))<=1
        // if not it is not a BalBT
        // below is the O(N) solution
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(7);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.left.right.left=new TreeNode(5);
        root.left.right.right=new TreeNode(6);
        System.out.println(isBalanced(root));
    }
    public static boolean isBalanced(TreeNode root) {
        if(height(root)==-1){
            return false;
        }
        return true;
    }
    public static int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        if(lh==-1){
            return -1;
        }
        int rh=height(root.right);
        if(rh==-1){
            return -1;
        }

        if(Math.abs(lh-rh)>1){
            return -1;
        }

        return 1+Math.max(lh,rh);
    }

}
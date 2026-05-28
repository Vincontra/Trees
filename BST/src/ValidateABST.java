public class ValidateABST {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

    }

        public boolean isValidBST(TreeNode root) {
            long min=Long.MIN_VALUE;
            long max=Long.MAX_VALUE;
            return func(min,max,root);
        }
        public static boolean func(long min,long max,TreeNode root){
            if(root==null){
                return true;
            }
            if(root.val<=min||root.val>=max){
                return false;
            }
            boolean left=func(min,root.val,root.left);
            if(!left){
                return false;
            }
            boolean right=func(root.val,max,root.right);
            if(!right){
                return false;
            }
            return true;
        }
}

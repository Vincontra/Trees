public class LCABST {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static void main(String[] args) {

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root==null){
                return null;
            }
            int curr=root.val;
            if(p.val<curr&&q.val<curr){
                return lowestCommonAncestor(root.left,p,q);
            }
            else if(p.val>curr&&q.val>curr){
                return lowestCommonAncestor(root.right,p,q);
            }
            // else{
            //     // if(p.val==curr||curr==q.val){
            //     //     return root;
            //     // }
            //     retut
            // }
            return root;
    }

}

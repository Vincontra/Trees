public class InsertInBST {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }

    public static void main(String[] args) {

    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
            if(root==null){
                TreeNode node=new TreeNode(val);
                return node;
            }
            else if(root.val>val){
                root.left=insertIntoBST(root.left,val);
            }
            else{
                root.right=insertIntoBST(root.right,val);
            }
            return root;
    }


}

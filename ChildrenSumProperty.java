public class ChildrenSumProperty {
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
    public static void changeTree(TreeNode root){
        if (root==null)return;
        int child=0;
        if (root.left!=null){
            child+=root.left.val;
        }
        if (root.right!=null){
            child+=root.right.val;
        }
        if (child>root.val){
            root.val=child;
        }
        else{
            if (root.left!=null){
                root.left.val= root.val;
            }
            if (root.right!=null){
                root.right.val= root.val;
            }
        }
        changeTree(root.left);
        changeTree(root.right);

        int tot=0;
        if (root.left!=null){
             tot+= root.left.val;
        }
        if (root.right!=null){
            tot+=root.right.val;
        }
        if (root.left!=null||root.right!=null){
            root.val=tot;
        }
    }
}

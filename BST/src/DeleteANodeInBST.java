public class DeleteANodeInBST {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }

    public static void main(String[] args) {

    }
        public TreeNode deleteNode(TreeNode root, int key) {
            if(root==null){
                return null;
            }
            if(root.val==key){
                return func(root);
            }
            TreeNode ans=root;
            while(root!=null){
                if(root.val<key){
                    if(root.right!=null&&root.right.val==key){
                        root.right=func(root.right);
                        break;

                    }else{
                        root=root.right;
                    }
                }else{
                    if(root.left!=null&&root.left.val==key){
                        root.left=func(root.left);
                        break;

                    }else{
                        root=root.left;
                    }

                }
            }
            return ans;
        }
        public static TreeNode func(TreeNode root){
            if(root.right==null){
                return root.left;
            }
            else if(root.left==null){
                return root.right;
            }
            else{
                TreeNode rightPart=root.right;
                TreeNode leftPartKaBiggest=func2(root.left);
                leftPartKaBiggest.right=rightPart;
                return root.left;
            }
        }
        public static TreeNode func2(TreeNode root){
            while(root.right!=null){
                root=root.right;
            }
            return root;

        }
}




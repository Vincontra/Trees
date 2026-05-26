//public class CountNodesCOMPLETEBinaryTree {
//    public int countNodes(TreeNode root) {
//        if (root==null){
//            return 0;
//        }
//        int lh=lh(root);
//        int rh=rh(root);
//        if (lh==rh){
//            return ((2<<lh)-1);// height ka formula for complete tree
//        }else{
//            return 1+countNodes(root.left)+countNodes(root.right);
//        }
//    }
//    public static int lh(TreeNode root){
//        int cnt=0;
//        while(root.left!=null){
//            cnt++;
//            root=root.left;
//        }
//        return cnt;
//    }
//    public static int rh(TreeNode root){
//        int cnt=0;
//        while (root.right!=null){
//            cnt++;
//            root=root.right;
//        }
//        return cnt;
//    }
//
//}

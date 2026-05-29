//public class RecoverBST {
//        static TreeNode first;
//        static TreeNode last;
//        static TreeNode middle;
//        static TreeNode prev;
//        public void recoverTree(TreeNode root) {
//            first=null;
//            middle=null;
//            last=null;
//            prev=null;
//            inorder(root);
//            if(first!=null&&last!=null){
//                int t=first.val;
//                first.val=last.val;
//                last.val=t;
//            }else{
//                // adjacent or ek hi gadbad
//                int t=first.val;
//                first.val=middle.val;
//                middle.val=t;
//            }
//        }
//        public static void inorder(TreeNode root){
//            if(root==null){
//                return;
//            }
//            inorder(root.left);
//
//            if(prev!=null&&prev.val>root.val){
//                // first time gadbad
//                if(first==null){
//                    first=prev;
//                    middle=root;
//                }else{
//                    last=root;
//                }
//            }
//            prev=root;
//            inorder(root.right);
//        }
//}

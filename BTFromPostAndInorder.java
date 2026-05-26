//public class BTFromPostAndInorder {
//        public TreeNode buildTree(int[] inorder, int[] postorder) {
//            HashMap<Integer,Integer>hm=new HashMap<>();
//            for(int i=0;i<inorder.length;i++){
//                hm.put(inorder[i],i);
//            }
//            return func(inorder,0,inorder.length-1,postorder,0,postorder.length-1,hm);
//        }
//        public static TreeNode func(int[] inorder,int is,int ie,int postorder[],int ps,int pe,HashMap<Integer,Integer>hm){
//            if(ps>pe||is>ie){
//                return null;
//            }
//            TreeNode root=new TreeNode(postorder[pe]);
//            int idx=hm.get(postorder[pe]);
//            int numsleft=idx-is;
//            root.left=func(inorder,is,idx-1,postorder,ps,ps+numsleft-1,hm);
//            root.right=func(inorder,idx+1,ie,postorder,ps+numsleft,pe-1,hm);
//            return root;
//
//        }
//}
//

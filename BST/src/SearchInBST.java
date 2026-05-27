//import javax.swing.tree.TreeNode;
//
//public class SearchInBST {
//  //  keep in mind that the  bst are invented for less tc so there height is logN for most of the time
//  public static void main(String[] args) {
//
//  }
//  public static boolean func(TreeNode root,int tar){
//      if (root==null){
//          return false;
//      }
//      if (root.val==tar){
//          return true;
//      }
//      if(root.val>tar){
//          return func(root.left,tar)
//      }
//      return func(root.right,tar);
//  }
//  public static boolean method2(TreeNode root,int tar){
// basically this is iterative way to do this
//      while (root!=null&&root.val!=tar){
//          int cval=root.val;
//          if (cval<tar){
//              root=root.right;
//          }else{
//              root=root.left;
//          }
//      }
//  }
//}

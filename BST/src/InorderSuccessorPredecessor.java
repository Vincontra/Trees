public class InorderSuccessorPredecessor {
    public static void main(String[] args) {
        int ans[]=new int[1];
        ans[0]=-1;
    }
    public static void succcessor(ConstructBSTFromPreorder.TreeNode root,int ans[],int key) {
        if (root==null) {
            return;
        }
        if (root.val<=key) {
            succcessor(root.right,ans,key);
        }
        else{
            ans[0]= root.val;
            succcessor(root.left,ans,key);
        }
    }
    public static void predecessor(ConstructBSTFromPreorder.TreeNode root,int ans[],int key){
        if (root==null){
            return;
        }
        if (root.val<key){
            ans[0]=root.val;
            predecessor(root.right,ans,key);
        }
        else{
            predecessor(root.left,ans,key);
        }
    }
}

//TC
//Average: O(log n)
//Worst case skewed tree:O(n)

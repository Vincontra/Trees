import javax.swing.tree.TreeNode;
public class CeilAndFloor {
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
    public static int ceil(TreeNode root,int key){
        int ans=-1;
        while (root!=null){
            if (root.val==key){
                ans= root.val;
                return ans;
            }
            else if (root.val>key){
                ans=root.val;
                root=root.left;
            }
            else{
                root=root.right;
            }
        }
        return ans;
    }
    public static int floor(TreeNode root,int key){
        int ans=-1;
        while (root!=null){
            if (root.val==key){
                ans= root.val;
                return ans;
            }
            else if (root.val<key){
                ans=root.val;
                root=root.right;
            }
            else{
                root=root.left;
            }
        }
        return ans;
    }
}

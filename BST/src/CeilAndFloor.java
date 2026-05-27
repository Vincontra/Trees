import javax.swing.tree.TreeNode;
public class CeilAndFloor {

    // Lc 2476
    // worst case we may have time complexity which is O(height*queries)
    // skew treee me we have height n which can be upto 10^5
    // so even though the function i wrote has tc as logN
    // they wont work in case of skew
    // i guess better would be inorder se array and then uspr binary search that would be nlogn in worst and not n*n

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

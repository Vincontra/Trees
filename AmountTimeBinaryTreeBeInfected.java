import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class AmountTimeBinaryTreeBeInfected {

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
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(5);
        root.right=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.left.right.left=new TreeNode(9);
        root.left.right.right=new TreeNode(2);
        root.right.left=new TreeNode(10);
        root.right.right=new TreeNode(6);

        int start=3;
        // need to find this first
        TreeNode str=inorder(root,start);
        System.out.println( func(root,str));
    }
    public static TreeNode inorder(TreeNode root,int tar){
        if (root==null){
            return null;
        }
        TreeNode left=inorder(root.left,tar);
        if (left!=null){
            return left;
        }
        if (root.val==tar){
            return root;
        }
        return  inorder(root.right,tar);
    }
    public static int func(TreeNode root,TreeNode str){
        // same logic as PrintAllNodeAtDisK
        HashMap<TreeNode,TreeNode>hashMap = new HashMap<>();
        Queue<TreeNode>q1=new LinkedList<>();
        q1.add(root);
        while (!q1.isEmpty()){
            TreeNode curr=q1.remove();
            if (curr.left!=null){
                q1.add(curr.left);
                hashMap.put(curr.left,curr);
            }
            if (curr.right!=null){
                q1.add(curr.right);
                hashMap.put(curr.right,curr);
            }
        }

        // abhi chalu kro from start
        int ans=-1;// time basically
        q1.add(str);
        HashSet<TreeNode>seen=new HashSet<>();// to avoid reacheking
        while (!q1.isEmpty()){ // jab tak pure infect nhi hote tab tak
            // we need to cover all neibour each time kind of bfs
            int s=q1.size();
            for (int i=0;i<s;i++){
                TreeNode curr=q1.remove();
                if(curr.left!=null && !seen.contains(curr.left)){
                    seen.add(curr.left);
                    q1.add(curr.left);
                }
                if(curr.right!=null && !seen.contains(curr.right)){
                    seen.add(curr.right);
                    q1.add(curr.right);
                }
                if(hashMap.containsKey(curr) && !seen.contains(hashMap.get(curr))){
                    seen.add(hashMap.get(curr));
                    q1.add(hashMap.get(curr));
                }
            }
            ans++;
        }
        return ans;
    }

}

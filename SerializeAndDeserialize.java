import java.util.*;
public class SerializeAndDeserialize {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        System.out.println("fbb");

    }

    public static String serialize(TreeNode root){
        if (root==null){
            return "";
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q1.add(root);
        while (!q1.isEmpty()){
            TreeNode curr = q1.remove();
            if (curr == null){
                sb.append("#,");
            }
            else{
                sb.append(curr.val).append(",");

                q1.add(curr.left);
                q1.add(curr.right);
            }
        }
        return sb.toString();
    }

    public static TreeNode Deserialize(String s){
        if (s.equals("")){
            return null;
        }
        String[]arr=s.split(",");
        Queue<TreeNode>q1=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
        int i=1;
        q1.add(root);
        while (!q1.isEmpty()&&i<arr.length){
            TreeNode par=q1.remove();
            if (!arr[i].equals("#")){
                TreeNode left=new TreeNode(Integer.parseInt(arr[i]));
                par.left=left;
                q1.add(left);
            }
            i++;
            if (i<arr.length&&!arr[i].equals("#")){
                TreeNode right=new TreeNode(Integer.parseInt(arr[i]));
                par.right=right;
                q1.add(right);
            }
            i++;
        }
        return root;
    }
}
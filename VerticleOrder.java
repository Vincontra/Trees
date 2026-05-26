import java.sql.SQLOutput;
import java.util.*;

public class VerticleOrder {
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
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(10);
        root.right.left=new TreeNode(9);
        root.right.right=new TreeNode(10);
        root.left.left.right=new TreeNode(5);
        root.left.left.right.right=new TreeNode(6);
        ArrayList<ArrayList<Integer>>l1=new ArrayList<>();
        func(root,l1);
        for (int i=0;i<l1.size();i++){
            ArrayList<Integer>curr=l1.get(i);
            System.out.println("Level : "+(i+1));
            for (int j=0;j<curr.size();j++){
                System.out.print(curr.get(j)+" ");
            }
            System.out.println();
        }
    }
    public static void func(TreeNode root,ArrayList<ArrayList<Integer>>l1){
        Queue<Pair>q1=new LinkedList<>();
        q1.add(new Pair(root,0,0));
        HashMap<Integer,ArrayList<Pair>>hm=new HashMap<>();
        while (!q1.isEmpty()){
            Pair curr=q1.remove();
            TreeNode node=curr.root;
            int vlvl=curr.vlvl;
            int hlvl=curr.hlvl;

            if (!hm.containsKey(vlvl)){
                hm.put(vlvl,new ArrayList<>());
            }
            hm.get(vlvl).add(curr);
            if (node.left!=null){
                q1.add(new Pair(node.left,vlvl-1,hlvl+1));
            }
            if (node.right!=null){
                q1.add(new Pair(node.right,vlvl+1,hlvl+1));
            }
        }
        // abhi isko we need to fill it properly
        // agar same level and same verticle level then sorting in ascending order
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int i: hm.keySet()){
            min=Math.min(min,i);
            max=Math.max(max,i);
        }
        for (int i=min;i<=max;i++){
            ArrayList<Pair>l2=hm.get(i);

            Collections.sort(l2,(a,b)->{
                if (a.hlvl==b.hlvl){
                    return a.root.val-b.root.val;
                }
                return a.hlvl-b.hlvl;

            });
            ArrayList<Integer>l3=new ArrayList<>();
            for (Pair c:l2){
                l3.add(c.root.val);
            }
            l1.add(l3);

        }
    }
    static class Pair{
        TreeNode root;
        int vlvl;
        int hlvl;

        public Pair(TreeNode root,int vlvl,int hlvl){
            this.root=root;
            this.hlvl=hlvl;
            this.vlvl=vlvl;
        }
    }
}

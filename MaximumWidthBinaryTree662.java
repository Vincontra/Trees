import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumWidthBinaryTree662 {
    public static void main(String[] args) {
//        PrintRootNode obj=new PrintRootNode();
        PrintRootNode.main(null); // create the tree first
        System.out.println(func(PrintRootNode.root));
    }
    public static int func(PrintRootNode.TreeNode root){
        // logic is:
        // kuch nhi har ek node ko ek index dena hai
        // start with root as index 0
        // left would be 2*i+1 and right would be 2*i+2
        // this is fine but there might be integer overflow
        // to avoid that we can simply take the min in each level and substract it from each index
        // will results in to avoid overflow do it on papper you will get this

        // After that for each level Max of last-first+1 that is our answer

        // isme ek aur chiz hai  it may possible that there are few node jinke left right node nna ho lekin index unko bhi diya ja rha hai
        // khali wo dikhega nhi but whatever index we are assinging by formula alredy took care of that

        int max=Integer.MIN_VALUE;
        Queue<Pair>q1=new LinkedList<>();
        q1.add(new Pair(0,root));
        while (!q1.isEmpty()){
            int size=q1.size();
            int min=q1.peek().index;
            int mx=Integer.MIN_VALUE;
            for (int i = 0;i<size;i++){
                Pair curr=q1.remove();
                int index=curr.index;
                PrintRootNode.TreeNode node=curr.node;
                mx=Math.max(mx,index);
                if (node.left!=null){
                    q1.add(new Pair(2*(index-min)+1,node.left));
                }
                if (node.right!=null){
                    q1.add(new Pair(2*(index-min)+2,node.right));
                }
            }
            max=Math.max(max,mx-min+1);
        }

        return max;


    }
    static class Pair{
        int index;
        PrintRootNode.TreeNode node;
        public Pair(int val,PrintRootNode.TreeNode node){
            this.index=val;
            this.node=node;
        }
    }
}

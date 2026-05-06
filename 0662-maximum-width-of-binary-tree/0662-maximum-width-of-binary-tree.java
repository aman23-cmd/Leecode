/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 /*
class Solution {
    static class Pair{
        TreeNode node;
        int idx;
        public Pair(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth=-1;
        Queue<Pair>q= new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int level=q.size();
            int index=0;
            int start=q.peek().idx;
            for(int i=0;i<level;i++){
                Pair p=q.poll();
                TreeNode curr=p.node;
                index=p.idx;
                if(curr.left!=null){
                    q.add(new Pair(curr.left, 2*index+1));
                }
                if(curr.right!=null){
                    q.add(new Pair(curr.right,2*index+2));
                }
            }
            maxWidth =Math.max(maxWidth,index-start+1);
        }
        return maxWidth;   
    }
}
*/
class Solution {
    static class Pair{
        TreeNode node;
        int idx;
        public Pair(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth=-1;
        Deque<Pair>q= new ArrayDeque<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int level=q.size();
            int index=0;
            int start=q.peekFirst().idx;
            int end=q.peekLast().idx;
            //maxWidth=Math.max(maxWidth,start,end+1);
            for(int i=0;i<level;i++){
                Pair p=q.poll();
                TreeNode curr=p.node;
                index=p.idx;
                if(curr.left!=null){
                    q.add(new Pair(curr.left, 2*index+1));
                }
                if(curr.right!=null){
                    q.add(new Pair(curr.right,2*index+2));
                }
            }
            maxWidth =Math.max(maxWidth,index-start+1);
        }
        return maxWidth;   
    }
}
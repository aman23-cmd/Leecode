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
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode>map=new HashMap<>();
        TreeNode startNode=buildParentMap(root,null,map,start);
        Queue<TreeNode>q= new LinkedList<>();
        Set<TreeNode>visited= new HashSet<>();
        q.offer(startNode);
        visited.add(startNode);
        int time=-1;
        while(!q.isEmpty()){
            int size=q.size();
            time++;
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if (curr.left != null&&!visited.contains(curr.left)) {
                    visited.add(curr.left);
                    q.offer(curr.left);
                }
                if (curr.right != null&&!visited.contains(curr.right)) {
                    visited.add(curr.right);
                    q.offer(curr.right);
                }
                TreeNode parent =map.get(curr);
                if (parent!=null&&!visited.contains(parent)) {
                    visited.add(parent);
                    q.offer(parent);
                }
            }
        }
        return time;
    }
    public TreeNode buildParentMap(TreeNode node,TreeNode parent,HashMap<TreeNode,TreeNode> map,int start){
        if(node==null)return null;
        map.put(node,parent);
        if(node.val==start)return node;
        TreeNode left=buildParentMap(node.left, node,map,start);
        if(left!=null)return left;
        return buildParentMap(node.right,node,map,start);
    }

}
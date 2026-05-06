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
    int mSize=0;
    int mSum=0;
    static class Info
    {
         boolean isBST;
         int size; 
         int min;
         int max;
         int sum;

         public Info(boolean isBST,int size,int min,int max,int sum)
         {
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;
            this.sum=sum;
         }
    }
    public int maxSumBST(TreeNode root) {
        largestBST(root);
        return mSum;
    }
    public Info largestBST(TreeNode root)
    {
        if(root==null)
        {
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }
        Info leftInfo=largestBST(root.left);
        Info rightInfo=largestBST(root.right);
        int size=leftInfo.size+rightInfo.size+1;
        int sum=leftInfo.sum+rightInfo.sum+root.val;
        int min=Math.min(root.val,Math.min(leftInfo.min,rightInfo.min));
        int max=Math.max(root.val,Math.max(leftInfo.max,rightInfo.max));
        if(leftInfo.isBST && rightInfo.isBST && root.val>leftInfo.max && root.val<rightInfo.min)
        {
            mSize=Math.max(mSize,size);
            mSum=Math.max(mSum,sum);
            return new Info(true,size,min,max,sum);
        }
        return new Info(false,size,min,max,sum);
    }
}
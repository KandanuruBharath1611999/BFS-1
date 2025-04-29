// Time Complexity: O(n) 
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: -

//Approach:
// Perform a DFS traversal while keeping track of the current level.
// If the level doesn't exist in the result list, create a new list for that level.
// Add the current node’s value to its corresponding level list and recursively process left and right children

import java.util.*;
public class binaryTreeLevelOrderTraversal 
{
    public class TreeNode 
    {   
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public void inorder(TreeNode root,List<List<Integer>> al,int l)
    {
        if(root == null)
        {
            return ;
        }
        else
        {
            if(l==al.size())
            {
                List<Integer> ad = new ArrayList<>();
                ad.add(root.val);
                al.add(ad);
            }
            else
            {
                List<Integer> ad = al.get(l);
                ad.add(root.val);
            }
            inorder(root.left,al,l+1);
            inorder(root.right,al,l+1);
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> al = new ArrayList<>();
        inorder(root,al,0);
        return al;
    }
}
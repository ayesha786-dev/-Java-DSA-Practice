package com.abstractfactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CousinTreeII {

    	public TreeNode replaceValueInTree(TreeNode root) {
    	       Queue<TreeNode> q = new LinkedList<>();
    	       List<Integer> sumList = new ArrayList<>();

    	        q.offer(root);
    	        while(!q.isEmpty()){
    	            int size = q.size();
    	            int sum = 0;

    	            for(int i=0;i<size;i++){
    	            TreeNode t = q.poll();
    	             sum +=t.val;
    	             if(t.right!=null){
    	                q.offer(t.right);
    	             }
    	             if(t.left!=null){
    	                q.offer(t.left);
    	             }
    	            }
    	            sumList.add(sum);
    	        }
    	       root.val=0;
    	       q.offer(root);
    	       int level =1;
    	       while(!q.isEmpty()){
    	        int size = q.size();

    	        for(int i=0;i<size;i++){
    	            TreeNode tnode = q.poll();
    	            int siblingSum = (tnode.right!=null?tnode.right.val:0)+(tnode.left!=null?tnode.left.val:0);

    	             if(tnode.right!=null){
    	             tnode.right.val = sumList.get(level)-siblingSum;
    	             q.offer(tnode.right);}
    	             if(tnode.left!=null){
    	             tnode.left.val = sumList.get(level)-siblingSum;
    	             q.offer(tnode.left);
    	             }

    	        }
    	               level++;
    	       }
    	           return root;
    	    }
    
}

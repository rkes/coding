package com.test.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TreeImpl {
	public static int getHeight(Node root) {
		if (root == null)
			return 0;
		else {
			int l = getHeight(root.left);
			int r = getHeight(root.right);
			if (l > r)
				return l + 1;
			else
				return r + 1;
		}
	}

	public static boolean isBST(Node root, int min,int max) {
		if(root!=null){
			if(root.data<min || root.data>max)
				return false;
			return isBST(root.left,min,root.data) && isBST(root.right,root.data,max);
		}
		else
			return true;
			
	}
	public static void rightViewOfBST(Node root,int level,int maxLevel,HashMap<Integer,List<Integer>> levelMap){
		if(root==null)
			return ;
		if(level>maxLevel){
			List<Integer> lst=levelMap.get(level);
			if(levelMap.get(level)==null){
				lst=new ArrayList<Integer>();
			}
			lst.add(root.data);
			levelMap.put(level, lst);
			maxLevel=level;
		}
		rightViewOfBST(root.right, level+1, maxLevel,levelMap);
		rightViewOfBST(root.left, level+1, maxLevel,levelMap);
	}
	
	public static LinkedNode reverseNode(LinkedNode node){
		LinkedNode temp,prev,nodeNext,rev=null;
		temp=node;
		while(temp!=null){
			nodeNext=temp.next;
			temp.next=rev;
			rev=temp;
			temp=nodeNext;
		}
		return rev;
	}
	
}

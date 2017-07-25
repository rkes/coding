package com.test.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TeeImplTest {

	public static void main(String[] args) {
		/*Node root=new Node(1);
		root.left=new Node(-2);
		root.right=new Node(4);
		root.right.left=new Node(3);
		root.right.right=new Node(5);
 		System.out.println(TreeImpl.getHeight(root));
 		System.out.println(TreeImpl.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
 		HashMap<Integer,List<Integer>> levelMap=new HashMap<Integer,List<Integer>>();
 		TreeImpl.rightViewOfBST(root, 1, 0,levelMap);
 		for(Map.Entry<Integer, List<Integer>> mp:levelMap.entrySet()){
 			System.out.println(mp.getValue().get(0));
 		}
 		System.out.println(levelMap);*/
		
		LinkedNode node=new LinkedNode(1);
		node.next=new LinkedNode(2);
		node.next.next=new LinkedNode(3);
		node.next.next.next=new LinkedNode(4);
		node.next.next.next.next=new LinkedNode(5);
		node.next.next.next.next.next=new LinkedNode(6);
		System.out.println();
		LinkedNode temp=node;
		while(temp!=null){
			System.out.printf("%d \t",temp.data);
			temp=temp.next;
		}
		LinkedNode revLst=TreeImpl.reverseNode(node);
		temp=revLst;
		System.out.println();
		while(temp!=null){
			System.out.printf("%d \t",temp.data);
			temp=temp.next;
		}
		List<String> lst=new ArrayList<String>();
		lst.add("Rakesh");
		lst.add("home");
		lst.add("av");
		lst.add("test");
		lst.add("b");
		lst.add("books");
		lst.add("a");
		System.out.println();
		System.out.println(lst);
		Collections.sort(lst,new Comparator<String>() {
			public int compare(String a,String b){
				return a.length()-b.length();
			}
		});
		System.out.println(lst);
		int []ar={1,3,3,3,3,9};
		System.out.println(getFreqCount( 3,ar));
		System.out.println(getHigherIndex( 3,ar));
		System.out.println(getLowerIndex( 3,ar));
	}
	public static int getFreqCount(int number,int []ar){
		return getHigherIndex(number, ar)-getLowerIndex(number, ar)+1;
	}
	public static int getLowerIndex(int number,int []ar){
		int low=0;
		int high=ar.length-1;
		int mid=(low+high)/2;
		while(low<high){
			if(ar[mid]<number)
				low=mid+1;
			else
				high=mid-1;
			if(ar[mid]==number && ar[mid-1]<number)
				return mid;
			mid=(low+high)/2;
		}
		return mid;
	}
	public static int getHigherIndex(int number,int []ar){
		int low=0;
		int high=ar.length-1;
		int mid=(low+high)/2;
		while(low<high){
			if(ar[mid]>number)
				high=mid-1;
			else
				low=mid+1;
			if(ar[mid]==number && ar[mid+1]>number)
				return mid;
			mid=(low+high)/2;
		}
		return mid;
	}
}

package array;

import java.util.ArrayDeque;
import java.util.Queue;

class BST{
	BST left;
	BST right;
	int data;
	public  BST(){
		left=null;
		right=null;
		data=0;
	}
	public BST(int data){
		this();
		this.data=data;
	}
}
 class BSTImple {
	public BST bst;
	public BSTImple(){
		bst=new BST();
	}
	public void inOrderTravers(BST root){
		if(root==null){
			return;
		}
		else{
			inOrderTravers(root.left);
			System.out.printf("%d \t",root.data);
			inOrderTravers(root.right);
		}
	}
	public void postOrderTravers(BST root){
		if(root==null){
			return;
		}
		else{
			postOrderTravers(root.left);
			postOrderTravers(root.right);
			System.out.printf("%d  \t",root.data);
		}
	}
	public void preOrderTravers(BST root){
		if(root==null){
			return;
		}
		else{
			System.out.printf("%d  \t",root.data);
			preOrderTravers(root.left);
			preOrderTravers(root.right);
			
		}
	}
	public BST deleteNode(BST root,int data){
		if(root==null)
			return root;
		else{
			if(root.data>data){
				root.left=deleteNode(root.left, data);
			}
			else
				if(root.data<data)
					root.right=deleteNode(root.right, data);
				else{
					//System.out.println("  -  "+root.left.data+"   "+root.right.data);
					
					if(root.left==null && root.right==null)
						return null;
						else
							if(root.left==null)
								return (root.right);
							else
								if(root.right==null)
									return (root.left);
								else{
										BST temp=findMin(root.right);
										root.data=temp.data;
								//		System.out.println("*******  "+temp.data+" ************");
										root.right=deleteNode(root.right, temp.data);
										
								}
					}
			return root;
		}
			
		}
	public BST findMin(BST root){
		if(root.left==null)
			return root;
		else
			return findMin(root.left);
	}
	public boolean sayItsBST(BST tree,int min,int max){
		if(tree==null)
			return true;
		else{
			if(tree.data<min || tree.data>max){
				return false;
			}
			else{                                                 
				 return (
						 sayItsBST(tree.left, min, tree.data-1)&&
						 sayItsBST(tree.right,tree.data+1,max)
						 );
			}
		}
	}
<<<<<<< HEAD
			
=======
	
	public BST LCA_GeneralTree(BST root,int left,int right){
		if(root==null)
			return null;
		else{
			if(root.data==left||root.data==right)
				return root;
			else{
				BST lt=LCA_GeneralTree(root.left, left, right);
				BST rt=LCA_GeneralTree(root.right, left, right);
				if(lt!=null && rt!=null)
					return root;
				else
					if(lt==null)
						return rt;
					else
						return lt;
			}
		}
	}
>>>>>>> origin/master
	
	public void showPathfromRootToLeaf(BST root,int []ar,int i){
		if(root==null)
			return;
			ar[i]=root.data;
			if(root.left==null&&root.right==null){
				for(int k=0;k<=i;k++)
					System.out.printf("%d  ",ar[k]);
					i=0;
				System.out.println();
				}
			else{
				showPathfromRootToLeaf(root.left, ar, i+1);
				showPathfromRootToLeaf(root.right, ar, i+1);
			}
		
	}
	public boolean addNode(int data){
		boolean res=false;
<<<<<<< HEAD
		System.out.println(" -  "+this.bst.left);
		System.out.println(" +  "+this.bst.right);
=======
>>>>>>> origin/master
		BST node=new BST(data);
		BST temp=this.bst;
		BST parent=null;
		while(temp!=null){
			parent=temp;
			if(temp.data<data){
				temp=temp.right;
			}
			else
				if(temp.data>data){
					temp=temp.left;
				}
				else{
					return false;
				}
		}
		if(parent.data>data){
			parent.left=node;
		}
		else
			parent.right=node;
		return res;
	}
<<<<<<< HEAD
 
=======
	
	public void showAllLeaves(BST tree){
		if(tree==null)
			return;
		else
			if(tree.left==null&&tree.right==null)
				System.out.println(tree.data);
			else{
				showAllLeaves(tree.left);
				showAllLeaves(tree.right);
				}
	}
	public int heightOfTree(BST tree){
		if(tree==null)
			return 0;
		else{
				int l=heightOfTree(tree.left);
				int r=heightOfTree(tree.right);
				if(l>r)
					return l+1;
				else
					return r+1;
			}
	}
	public void levelOrderTraversal(BST tree){
		ArrayDeque<BST> Q=new ArrayDeque<BST>();
		Q.addLast(tree);
		while(!Q.isEmpty()){
			BST tr=Q.poll();
			if(tr.left!=null)
				Q.add(tr.left);
			if(tr.right!=null)
				Q.add(tr.right);
			System.out.printf("%d  ",tr.data);
		}
		
	}
	public int getCatalanNumber(int n){
		return (int) (Math.pow(2, n)-n);
	}
	public void showAllPossibleBST(int low,int high){
		ArrayDeque<BST> Q=new ArrayDeque<BST>();
		if(low<high){
			
		}
	}
	public int diameterOfTree(BST root){
		if(root==null)
			return 0;
		else{
			int l=heightOfTree(root.left);
			int r=heightOfTree(root.right);
			
			int ld=diameterOfTree(root.left);
			int rd=diameterOfTree(root.right);
			return Math.max(l+r+1, Math.max(ld, rd));
		}
	}
	public BST findLCA(BST tree,BST left,BST right){
	//	System.out.println(left.data+"    "+right.data);
		if(tree==null)
			return tree;
		else{
			if((tree.data==left.data)||(tree.data==right.data))
				return tree;
			else{
				BST lt=findLCA(tree.left,left,right);
				BST rt=findLCA(tree.right,left,right);
				if(lt==null && rt==null)
					return tree;
				else
					if(lt==null)
						return rt;
					else
						return lt;
			}
		}
	}
	public BST findNode(BST tree,int data){
		if(tree==null)
			return null;
		if(data>tree.data){
			return findNode(tree.right,data);
		}
		else
			if(data<tree.data)
				return findNode(tree.left,data);
			else
				return tree;
	}
	public int getMax(BST tree){
		int max=Integer.MIN_VALUE;
		if(tree==null)
			return max;
		else{
			int l=getMax(tree.left);
			int r=getMax(tree.right);
			if(l>r)
				max=l;
			else
				max=r;
			if(tree.data>max)
				return tree.data;
			else
				return max;
		}
	}
>>>>>>> origin/master
}

public class BSTImplementation{
	public static void main(String []args){
		BSTImple bstImple=new BSTImple();
		bstImple.addNode(20);
		bstImple.addNode(18);
		bstImple.addNode(22);
		bstImple.addNode(5);
		bstImple.addNode(9);
		bstImple.addNode(10);
		bstImple.addNode(14);
		bstImple.addNode(21);
		bstImple.addNode(25);
		bstImple.addNode(24);
		bstImple.addNode(27);
		/*
		for(int i=0;i<10;i++){
			bstImple.addNode(i+2);
		}*/
		
		///bstImple.deleteNode(data)
		bstImple.inOrderTravers(bstImple.bst);
		System.out.println();
		bstImple.preOrderTravers(bstImple.bst);
		System.out.println();
<<<<<<< HEAD
		/*bstImple.postOrderTravers(bstImple.bst);
=======
		/*bstImple.pos2t03OrderTravers(bstImple.bst);
>>>>>>> origin/master
		bstImple.deleteNode(bstImple.bst,22);
		bstImple.deleteNode(bstImple.bst,200);
		System.out.println("--------------------------------------");
		bstImple.inOrderTravers(bstImple.bst);
	*/
		/*BST bst=new BST(1000);
		BST temp=bstImple.findMin(bstImple.bst);
		temp.left=bst;
		*/
<<<<<<< HEAD
		bstImple.showPathfromRootToLeaf(bstImple.bst,new int[20],0);
		System.out.println(bstImple.sayItsBST(bstImple.bst,Integer.MIN_VALUE,Integer.MAX_VALUE));
=======
		String str=new String("Love");
		System.out.println(str.charAt(4));
		System.out.println(" All Possible Path from Root  ");
		System.out.println(" ----------------------------- ");
		bstImple.showPathfromRootToLeaf(bstImple.bst,new int[20],0);
		System.out.println("  ----------------------------   ");
		System.out.println(bstImple.sayItsBST(bstImple.bst,Integer.MIN_VALUE,Integer.MAX_VALUE));
		
		System.out.println("------------------------------------------");
		System.out.println(bstImple.heightOfTree(bstImple.bst));
		System.out.println(bstImple.diameterOfTree(bstImple.bst));
		System.out.println("-------------------------------------------");
		System.out.println(" Level Order Traversal  ");
		bstImple.levelOrderTraversal(bstImple.bst);
		//bstImple.showAllLeaves(bstImple.bst);
		System.out.println(" ----  ");
		System.out.println(bstImple.getCatalanNumber(5));
		System.out.println(" ----------------------");
		System.out.println(bstImple.findNode(bstImple.bst, 27));
		System.out.println(bstImple.LCA_GeneralTree(bstImple.bst,14 , 27));
		System.out.println("-------------------------------");
		System.out.println(bstImple.getMax(bstImple.bst));
		//System.out.println(bstImple.findLCA(bstImple.bst, bstImple.findNode(bstImple.bst, 14),bstImple.findNode(bstImple.bst, 27)).data);
		
>>>>>>> origin/master
	}
}

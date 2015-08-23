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
		System.out.println(" -  "+this.bst.left);
		System.out.println(" +  "+this.bst.right);
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
		/*bstImple.postOrderTravers(bstImple.bst);
		bstImple.deleteNode(bstImple.bst,22);
		bstImple.deleteNode(bstImple.bst,200);
		System.out.println("--------------------------------------");
		bstImple.inOrderTravers(bstImple.bst);
	*/
		/*BST bst=new BST(1000);
		BST temp=bstImple.findMin(bstImple.bst);
		temp.left=bst;
		*/
		bstImple.showPathfromRootToLeaf(bstImple.bst,new int[20],0);
		System.out.println(bstImple.sayItsBST(bstImple.bst,Integer.MIN_VALUE,Integer.MAX_VALUE));
	}
}
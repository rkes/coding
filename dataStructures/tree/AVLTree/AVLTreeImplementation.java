
class AVLNode{
	
	AVLNode left;
	AVLNode right;
	int data;
	int height;
	
	public AVLNode(){
		left=null;
		right=null;
		data=0;
		height=0;
	}
	public AVLNode(int data){
		this();
		this.data=data;
	}
}
class AVLImpl{
	AVLNode tree;
	public AVLImpl(){
		tree=new AVLNode(0);
	}
	public AVLImpl(int data){
		tree=new AVLNode(data);
	}
	public int height(AVLNode node){
		if(node==null)
			return 0;
		else{
			int l=height(node.left);
			int r=height(node.right);
			if(l>r)
				return l+1;
			else
				return r+1;
		}
	}
	public AVLNode balanceFactorNodeFromTop(AVLNode tree){
		if(tree==null)
			return null;
		else{
			balanceFactorNodeFromTop(tree.left);
			if(Math.abs(height(tree.left)-height(tree.right))>=2)
				return tree;
			else
				return balanceFactorNodeFromTop(tree.right);
		
		}
		
	}
	public int balanceFactor(AVLNode node){
		if(tree==null)
			return 0;
		else
			return(height(node.left)-height(node.right));
	}
	
	public boolean addNode(int data){
		boolean res=false;
		AVLNode node=new AVLNode(data);
		AVLNode temp=this.tree;
		AVLNode parent=null;
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
	public AVLNode leftRotate(AVLNode node){
		
		AVLNode x=node.right;
		AVLNode y=x.left;
		
		x.left=node;
		node.right=y;
		
		node.height=Math.max(height(x.left), height(x.right));
		x.height=Math.max(height(x.left), height(x.right));
		return x;
		
	}
	public AVLNode rightRotate(AVLNode node){
		
		AVLNode x=node.left;
		AVLNode y=x.right;
		
		x.right=node;
		node.left=y;
		
		node.height=Math.max(height(x.left), height(x.right));
		x.height=Math.max(height(x.left), height(x.right));
		
		return x;
		
	}
	public AVLNode getMax(AVLNode tree){
		if(tree.right==null)
			return tree;
		else{
			return getMax(tree.right);
		}
	}
	public AVLNode delete(AVLNode tree,int data){
		if(tree==null)
			return tree;
		else{
			if(data>tree.data)
				tree.right=delete(tree.right,data);
			else
				if(data<tree.data)
					tree.left=delete(tree.left,data);
				else{
					if(tree.left==null && tree.right==null)
						return null;
						else if(tree.left==null)
							return tree.right;
							else if(tree.right==null)
								return tree.left;
							else{
								AVLNode leftMin=getMax(tree.left);
								tree.data=leftMin.data;
								tree.left=delete(tree.left,leftMin.data);
							}
						
						
					}
				}
	/*	tree.height=Math.max(height(tree.left), height(tree.right));
		int balance=balanceFactor(tree);
		if(balance>1 && data<tree.left.data){
			rightRotate(tree);
		}
		if(balance<-1 && data>tree.right.data)
			leftRotate(tree);
		if(balance>1 && data>tree.left.data){
			tree.left=leftRotate(tree.left);
			return rightRotate(tree);
		}
		if(balance<-1 && data<tree.right.data){
			tree.right=rightRotate(tree.right);
			return leftRotate(tree);
		}
	*/	return tree;
		}
	public AVLNode insert(int data,AVLNode tree){
		if(tree==null){
			return (new AVLNode(data));
			}
		if(tree.data>data)
			tree.left=insert(data,tree.left);
		else
			tree.right=insert(data,tree.right);
		
		tree.height=Math.max(height(tree.left), height(tree.right))+1;
		int balance=balanceFactor(tree);
		// Left Left Case hence Right Rotation
		if(balance>1 && data<tree.left.data){
			return rightRotate(tree);
		}
		//Right Right Case hence Left  Rotation
		if(balance<-1 && data>tree.right.data){
			return leftRotate(tree);
		}
		//Left Right Case hence Left and Right Rotation
		if(balance>1 && data>tree.left.data){
			tree.left=leftRotate(tree.left);
			return (rightRotate(tree));
		}
		//Right Left Case hence Right Left Rotation
		if(balance<-1 && data<tree.right.data){
			tree.right=rightRotate(tree.right);
			return (leftRotate(tree));
		}
		return tree;
	}
	public void inOrderTraversal(AVLNode tree){
		if(tree==null)
			return ;
		else{
			inOrderTraversal(tree.left);
			System.out.printf("  %d   ",tree.data);
			inOrderTraversal(tree.right);
		}
	}
	public void preOrderTraversal(AVLNode tree){
		if(tree!=null)
		{
		
			System.out.printf("  %d   ",tree.data);
			inOrderTraversal(tree.left);
			inOrderTraversal(tree.right);
		}
	}
}
public class AVLTreeImplementation {

	public static void main(String[] args) {
		AVLImpl avlImpl=new AVLImpl(10);
		
		//avlImpl.tree = avlImpl.insert(10,avlImpl.tree);
		avlImpl.tree = avlImpl.insert(20,avlImpl.tree);
		avlImpl.tree = avlImpl.insert(30,avlImpl.tree);
		avlImpl.tree = avlImpl.insert(40,avlImpl.tree);
		avlImpl.tree = avlImpl.insert(50,avlImpl.tree);
		avlImpl.tree = avlImpl.insert(25,avlImpl.tree);
		/*avlImpl.tree=avlImpl.insert(-1,avlImpl.tree);
		avlImpl.tree=avlImpl.insert(-2,avlImpl.tree);
		avlImpl.tree=avlImpl.insert(-3,avlImpl.tree);
		avlImpl.tree=avlImpl.insert(-4,avlImpl.tree);
		avlImpl.tree=avlImpl.insert(-5,avlImpl.tree);
		avlImpl.tree=avlImpl.insert(4,avlImpl.tree);
		//avlImpl.inOrderTraversal(avlImpl.tree);
		avlImpl.tree=avlImpl.insert(3,avlImpl.tree);
		avlImpl.tree=avlImpl.insert(2,avlImpl.tree);
		avlImpl.tree=avlImpl.insert(1,avlImpl.tree);
		avlImpl.tree=avlImpl.insert(5,avlImpl.tree);
		avlImpl.tree=avlImpl.insert(10,avlImpl.tree);
		avlImpl.tree=avlImpl.insert(7,avlImpl.tree);
		avlImpl.tree=avlImpl.insert(8,avlImpl.tree);
		avlImpl.tree=avlImpl.insert(9,avlImpl.tree);
		avlImpl.tree=avlImpl.insert(6,avlImpl.tree);*/
	/*	avlImpl.addNode(4);
		avlImpl.addNode(3);
		avlImpl.addNode(2);
		avlImpl.addNode(1);
		avlImpl.addNode(5);
	//	avlImpl.addNode(9);
		avlImpl.addNode(10);
		avlImpl.addNode(7);
		avlImpl.addNode(8);
		avlImpl.addNode(9);
		
		avlImpl.addNode(6);
	*/	
		avlImpl.inOrderTraversal(avlImpl.tree);
		System.out.println("\n---------------------------------");
		avlImpl.delete(avlImpl.tree, 30);
		System.out.println("------------------------------------");
		avlImpl.preOrderTraversal(avlImpl.tree);
		System.out.println("\n--------------------------------------");
		avlImpl.inOrderTraversal(avlImpl.tree);
		//System.out.println(avlImpl.balanceFactorNodeFromTop(avlImpl.tree).data);
		//System.out.println(avlImpl.balanceFactor(avlImpl.balanceFactorNodeFromTop(avlImpl.tree)));
	}

}

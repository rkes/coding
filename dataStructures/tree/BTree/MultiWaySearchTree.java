package array;
import java.util.*;
class Node{
	int data;
	List<Node> nodes;
	int []keys;
	Object [] values;
	int degree;
	int numKeys;
	boolean isLeaf;
	Node parent;
	public Node(){
		
	}
	public Node(int data){
		this.data=data;
		nodes=new ArrayList<Node>();
		
	}
	
}
class Tree{
	Node root;
	Tree(){
		root=new Node();
	}
	public void insertNode(int key,Object object){
		if(!isUpdate(root,key,object))
			if(root.numKeys==2*root.degree-1){
				Node newNode=new Node();
				root.parent=newNode;
				newNode.isLeaf=false;
				newNode.nodes.add(0,root);
				splitNode(newNode,root,key);
				insert(root,key);
		}
		else{
			insert(root,key);
		}
	}
	private void insert(Node root2, int key) {
		// TODO Auto-generated method stub
		
	}
	private boolean isUpdate(Node root2, int key,Object object) {
		int i=0;
		while(root2!=null){
			while(i<root2.numKeys && key>root2.keys[i])
				i++;
			if(i>root2.numKeys)
				return false;
			else{
				if(key==root2.keys[i]){
					root2.keys[i]=key;
					return true;
				}
				if(root2.isLeaf)
					return false;
				else
					root2=root2.nodes.get(i);
		  }
		}
		return false;
	}
	private void splitNode(Node parent, Node child, int key) {
		Node newNode=new Node();
		newNode.isLeaf=child.isLeaf;
		newNode.numKeys=child.degree;
		for(int i=0;i<child.degree;i++){
			newNode.keys[i]=child.keys[i+child.degree];
			newNode.values[i]=child.values[i+child.degree];
		}
		if(!child.isLeaf){
			for(int i=0;i<=child.degree;i++)
				newNode.nodes.add(child.nodes.get(i+child.degree));
			for(int i=child.degree;i<child.numKeys;i++)
				newNode.nodes.add(i,null);
		}	
		
	}
}
public class MultiWaySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

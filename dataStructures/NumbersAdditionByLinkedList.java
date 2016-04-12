
public class NumbersAdditionByLinkedList {

	public static void main(String[] args) {
		NumbersAdditionByLinkedList nAdd=new NumbersAdditionByLinkedList();
		Node root=new Node(1);
		root.next=new Node(2);
		root.next.next=new Node(3);
		root.next.next.next=new Node(4);
		root.next.next.next.next=new Node(5);
		root.next.next.next.next.next=new Node(6);
		
		Node revll1=nAdd.reverseLinkedList(root);
		
		Node root1=new Node(1);
		root1.next=new Node(2);
		root1.next.next=new Node(3);
		root1.next.next.next=new Node(4);
		root1.next.next.next.next=new Node(4);
		root1.next.next.next.next.next=new Node(3);
		
		Node revll2=nAdd.reverseLinkedList(root1);
		
		Node nde=nAdd.addLinkedList(revll1, revll2);
		
		Node finalNode=nAdd.reverseLinkedList(nde);
		
		System.out.println();
	}
	public Node addLinkedList(Node root1,Node root2){
		Node fLL= null;
		boolean flag=true;
		int carry=0;
		while(flag){
			if(root1==null||root2==null)
			{	
				flag=false;
				continue;
			}
			int sum=root1.data+root2.data;
			
			Node node=new Node(sum%10+carry);
			if(sum>9){
				carry=1;
			}
			else
				carry=0;
				node.next=fLL;
				fLL=node;
			root1=root1.next;

			root2=root2.next;
		}
		
		if(carry==1){
			Node node=new Node(1);
			node.next=fLL;
			fLL=node;
		}
		System.out.println();
		return fLL;
	}
	public Node reverseLinkedList(Node lst){
		Node nd=null,t=null;
		Node temp=lst;
		while(temp!=null){
			t=temp.next;
			temp.next=nd;
			nd=temp;
			temp=t;
		}
		return nd;
	}
	public Node reverseKthLinkedList(Node lst,int cnt){
		Node nd=null,t=null;
		Node temp=lst;
		int k=0;
		while(temp!=null && cnt<k){
			t=temp.next;
			temp.next=nd;
			nd=temp;
			temp=t;
			k++;
		}
		if(lst!=null){
			lst.next=reverseKthLinkedList(nd, cnt);
		}
		return nd;
	}
	static class Node{
		int data;
		Node next;
		public Node(int data){
			this.data=data;
			next=null;
		}
		public Node(){
			next=null;
		}
	}
}

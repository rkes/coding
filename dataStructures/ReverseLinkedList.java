class Node {
	Node next;
	int data;

	public Node(int data) {
		this.data = data;
	}
}

public class ReverseLinkedList {

	public static void main(String[] args) {
		Node lst = new Node(1);

		lst.next = new Node(2);
		lst.next.next = new Node(3);
		lst.next.next.next = new Node(4);
		lst.next.next.next.next = new Node(5);
		Node revLst = reverseList(lst, null);
		showLinkedList(revLst);
		System.out.println();
	}

	public static Node reverseList(Node temp, Node prev) {

		if (temp == null) {
			return null;
		}
		if (temp.next == null) {
			temp.next = prev;
			return temp;
		}
		Node rev = reverseList(temp.next, temp);
		temp.next = prev;
		return rev;
	}
	public static void showLinkedList(Node temp) {
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}

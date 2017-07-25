package com.test.tree;

public class Node {
	Node left;
	int data;
	Node right;
	
	Node(int data){
		this.data=data;
	}
	
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	
}
class LinkedNode{
	int data;
	LinkedNode next;
	LinkedNode(int data){
		this.data=data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public LinkedNode getNext() {
		return next;
	}
	public void setNext(LinkedNode next) {
		this.next = next;
	}
	
}
package com.osu.node;

public class Node {

	public int data;
	public Node next;
	public Node previous;
	public Node left;
	public Node right;
	
	public Node(int d) {
		data = d;
		next = null;
		previous = null;
		left = null;
		right = null;
	}

}

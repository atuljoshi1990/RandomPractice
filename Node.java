package com.osu.node;

public class Node {

	public int data;
	public Node next;
	public Node previous;
	
	public Node(int d) {
		data = d;
		next = null;
		previous = null;
	}

}

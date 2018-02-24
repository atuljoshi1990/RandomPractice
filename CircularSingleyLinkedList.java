package com.osu.linkedList;

import com.osu.node.Node;

public class CircularSingleyLinkedList {
	
	Node head;
	Node tail;
	
	public static void main (String[] args){
		
		CircularSingleyLinkedList list = createCircularLinkedList();
		printCList(list);
		System.out.println("==");
		pushAtFront(list, 6);
		printCList(list);
		System.out.println("==");
		pushInBetweenNode(list, 3, 7);
		printCList(list);
		System.out.println("==");
		pushAtTheEnd(list, 8);
		printCList(list);
		System.out.println("==");
		deleteANode(list, 8);
		printCList(list);
	}
	
	private static void deleteANode(CircularSingleyLinkedList list, int i) {
		
		Node head = list.head;
		while(true){
			if(head.data == i){
				list.head = head.next;
				list.tail.next = list.head;
				break;
			}else if(head.next.data == i){
				if(head.next == list.tail){
					list.tail = head;
					list.tail.next = list.head;
				}else{
					head.next = head.next.next;
				}
				break;
			}else{
				head = head.next;
			}
		}
	}

	private static void pushAtTheEnd(CircularSingleyLinkedList list, int i) {
		
		Node newNode = new Node(i);
		Node tail = list.tail;
		newNode.next = tail.next;
		tail.next = newNode;
		list.tail = newNode;
	}

	private static void pushInBetweenNode(CircularSingleyLinkedList list, int i, int j) {
		
		Node newNode = new Node(j);
		Node head = list.head;
		while(true){
			if(head.data == i){
				newNode.next = head.next;
				head.next = newNode;
				break;
			}else{
				head = head.next;
			}
		}
	}

	private static void pushAtFront(CircularSingleyLinkedList list, int i) {
		
		Node newNode = new Node(i);
		newNode.next = list.head;
		list.head = newNode;
		list.tail.next = list.head;
	}

	public static void printCList(CircularSingleyLinkedList list){
		
		Node head = list.head;
		do{
			System.out.println(head.data);
			head = head.next;
		}
		while(head != list.head);
	}
	
	public static CircularSingleyLinkedList createCircularLinkedList(){
		
		CircularSingleyLinkedList list = new CircularSingleyLinkedList();
		Node head = new Node(1);
		Node s = new Node(2);
		Node t = new Node(3);
		Node f = new Node(4);
		Node tail = new Node(5);
		
		list.head = head;
		list.head.next = s;
		s.next = t;
		t.next = f;
		f.next = tail;
		list.tail = tail;
		list.tail.next = list.head;
		return list;
	} 
}

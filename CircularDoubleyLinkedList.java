package com.osu.linkedList;

import com.osu.node.Node;

public class CircularDoubleyLinkedList {

	Node head;
	Node tail;

	public static void main(String[] args) {

		CircularDoubleyLinkedList list = createList();
		printCList(list);
		System.out.println("==");
		addInFront(list, 6);
		printCList(list);
		System.out.println("==");
		addInBetween(list, 6, 7);
		printCList(list);
		System.out.println("==");
		addAtEnd(list, 8);
		printCList(list);
		System.out.println("==");
		deleteFromList(list, 3);
		printCList(list);
		
	}

	private static void deleteFromList(CircularDoubleyLinkedList list, int i) {
		
		Node head = list.head;
		while(true){
			if(head.data == i){
				list.head = list.head.next;
				list.tail.next = list.head;
				list.head.previous = list.tail;
				break;
			}else if(head.next.data ==i){
				if(head.next == list.tail){
					head.next = list.tail.next;
					list.tail = head;
					list.head.previous = list.tail;
				}else{
					head.next = head.next.next;
					head.next.previous = head;
				}
				break;
			}else{
				head = head.next;
			}
		}
	}

	private static void addAtEnd(CircularDoubleyLinkedList list, int i) {

		Node newNode = new Node(i);
		Node tail = list.tail;
		newNode.next = tail.next;
		newNode.previous = tail;
		tail.next = newNode;
		list.tail = newNode;
		list.head.previous = list.tail;
	}

	private static void addInBetween(CircularDoubleyLinkedList list, int i, int j) {

		Node newNode = new Node(j);
		Node head = list.head;
		while (true) {
			if (head.data == i) {
				newNode.next = head.next;
				head.next.previous = newNode;
				newNode.previous = head;
				head.next = newNode;
				break;
			} else {
				head = head.next;
			}
		}
	}

	public static void addInFront(CircularDoubleyLinkedList list, int i) {

		Node newNode = new Node(i);
		Node head = list.head;
		newNode.next = head;
		newNode.previous = head.previous;
		head.previous = newNode;
		list.head = newNode;
		list.tail.next = list.head;
	}

	private static void printCList(CircularDoubleyLinkedList list) {

		Node head = list.head;
		do {
			System.out.println(head.data);
			head = head.next;
		} while (head != list.head);
	}

	private static CircularDoubleyLinkedList createList() {

		CircularDoubleyLinkedList list = new CircularDoubleyLinkedList();
		Node head = new Node(1);
		Node s = new Node(2);
		Node t = new Node(3);
		Node f = new Node(4);
		Node tail = new Node(5);

		list.head = head;
		list.head.next = s;
		s.previous = list.head;
		s.next = t;
		t.previous = s;
		t.next = f;
		f.previous = t;
		f.next = tail;
		list.tail = tail;
		list.tail.previous = f;
		list.tail.next = list.head;
		list.head.previous = list.tail;

		return list;
	}
}

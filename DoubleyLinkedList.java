package com.osu.linkedList;

import com.osu.node.Node;

public class DoubleyLinkedList {

	Node head;
	
	public static void main(String[] args) {
		
		DoubleyLinkedList list = createList();
		Node node = null;
		
		printList(list);
		System.out.println("==");
		printListInReverse(list);
		addInFront(list, 5);
		System.out.println("==");
		printList(list);
		Node head = list.head; 
		while(true){
			if(head.data == 2){
				node = head;
				break;
			}else{
				head = head.next;
			}
		}
		Node newNode = new Node(6);
		Node newNode1 = new Node(7);
		addInBetween(node, newNode);
		System.out.println("==");
		printList(list);
		addAtTheEnd(list, newNode1);
		System.out.println("==");
		printList(list);
		deleteANode(list, 7);
		System.out.println("==");
		printList(list);
	}

	private static void deleteANode(DoubleyLinkedList list, int i) {
		
		Node head = list.head;
		while(true){
			if(head.data == i){
				list.head = head.next;
				list.head.previous = null;
				break;
			}else if(head.next.data == i){
				if(head.next.next != null){
					head.next = head.next.next;
					head.next.previous = head;
				}else{
					head.next = null;
				}
				break;
			}else{
				head = head.next;
			}
		}
	}

	private static void addAtTheEnd(DoubleyLinkedList list, Node newNode){
		
		Node last = list.head;
		while(last.next != null){
			last = last.next;
		}
		last.next = newNode;
		newNode.previous = last;
	}
	
	private static void addInBetween(Node previousNode, Node newNode){
		
		newNode.next = previousNode.next;
		previousNode.next.previous = newNode;
		previousNode.next = newNode;
	}
	
	private static void addInFront(DoubleyLinkedList list, int i){
		
		Node newNode = new Node(i);
		Node head = list.head;
		newNode.next = head;
		head.previous = newNode;
		list.head = newNode;
	}
	
	private static void printList(DoubleyLinkedList list){
		
		Node head = list.head;
		while(head != null){
			System.out.println(head.data);
			head = head.next;
		}
	}
	
	private static void printListInReverse(DoubleyLinkedList list){
		
		Node head = list.head;
		Node last = null;
		while(head != null){
			last = head;
			head = head.next;
		}
		while(last != null){
			System.out.println(last.data);
			last = last.previous;
		}
	}
	private static DoubleyLinkedList createList() {

		DoubleyLinkedList list = new DoubleyLinkedList();
		Node head = new Node(1);
		Node secondN = new Node(2);
		Node thirdN = new Node(3);
		Node fourthN = new Node(4);
		list.head = head;
		list.head.next = secondN;
		secondN.previous = list.head;
		secondN.next = thirdN;
		thirdN.previous = secondN;
		thirdN.next = fourthN;
		fourthN.previous = thirdN;
		
		return list;
	}

}

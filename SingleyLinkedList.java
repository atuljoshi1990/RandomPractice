package com.osu.linkedList;

import com.osu.node.Node;

public class SingleyLinkedList {

	Node head;

	public static void main(String[] args) {

		SingleyLinkedList list = createList();
		printList(list);
		System.out.println("==");
		pushAtFront(list, 4);
		printList(list);
		System.out.println("==");
		pushInBetweenNode(list, 2, 5);
		printList(list);
		System.out.println("==");
		pushAtTheEnd(list, 6);
		printList(list);
		System.out.println("==");
		deleteANode(list, 4);
		printList(list);
	}

	private static void deleteANode(SingleyLinkedList list, int i) {
		
		Node head = list.head;
		while(true){
			if(head.data == i){
				list.head = head.next;
				break;
			}else if(head.next.data == i){
				if(head.next.next != null){
					head.next = head.next.next;
				}else{
					head.next = null;
				}
				break;
			}else{
				head = head.next;
			}
		}
	}

	private static void pushAtTheEnd(SingleyLinkedList list, int i) {

		Node newNode = new Node(i);
		Node last = list.head;
		while (last.next != null) {
			last = last.next;
		}
		last.next = newNode;
	}

	private static void pushInBetweenNode(SingleyLinkedList list, int existingNode, int newNodeToInsert) {

		Node newNode = new Node(newNodeToInsert);
		Node node = list.head;
		while (true) {
			if (node.data == existingNode) {
				newNode.next = node.next;
				node.next = newNode;
				break;
			} else {
				node = node.next;
			}
		}
	}

	private static void pushAtFront(SingleyLinkedList list, int i) {

		Node newNode = new Node(i);
		newNode.next = list.head;
		list.head = newNode;
	}

	private static void printList(SingleyLinkedList list) {

		Node node = list.head;
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}

	private static SingleyLinkedList createList() {

		SingleyLinkedList list = new SingleyLinkedList();
		list.head = new Node(1);
		Node secondNode = new Node(2);
		Node thirdNode = new Node(3);
		list.head.next = secondNode;
		secondNode.next = thirdNode;

		return list;
	}

}

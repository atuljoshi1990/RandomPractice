package com.osu.binaryTree;

import com.osu.node.Node;

public class ConstructTreeFromPreOrderAndPostOrder {

	Node root;
	static int index = 0;
	public static void main(String args[]){
		int pre[] = {1,2,4,5,3,6,7};
		int post[] = {4,5,2,6,7,3,1};
		ConstructTreeFromPreOrderAndPostOrder tree = new ConstructTreeFromPreOrderAndPostOrder();
		Node node = tree.constructTree(post, pre);
		BinaryTree.inOrderTraversal(node);
	}
	
	public Node constructTree(int post[], int pre[]){
		
		return constructTree(post, pre, 0, pre.length-1, pre.length);
	}

	private Node constructTree(int[] post, int[] pre, int i, int j, int length) {

		if(index >= length || i > j){
			return null;
		}
		Node root = new Node(pre[index]);
		index++;
		if(i == j || index >= length){
			return root;
		}
		int k;
		for(k = i; k <= j; k++){
			if(post[k] == pre[index]){
				break;
			}
		}
		if(k <= j){
			root.left = constructTree(post, pre, i, k, pre.length);
			root.right = constructTree(post, pre, k+1, j, pre.length);
		}
		return root;
	}
}

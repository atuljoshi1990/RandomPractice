package com.osu.binaryTree;

import com.osu.node.Node;

public class ConstructTreeFromInOrderAndLevel {
	
	Node root;
	public static void main(String args[]){
		int in[] = {4,2,5,1,6,3};
		int level[] = {1,2,4,5,3,6};
		ConstructTreeFromInOrderAndLevel tree = new ConstructTreeFromInOrderAndLevel();
		Node node = tree.constructTree(in, level);
		BinaryTree.inOrderTraversal(node);
	}
	
	private Node constructTree(int[] in, int[] level) {
		
		Node startNode = null;
		return constructTree(startNode, in, level, 0, level.length-1);
		
	}

	private Node constructTree(Node startNode, int in[], int level[], int start, int end) {
		
		int index = 0;
		boolean nodeFound = false;
		if(start > end){
			return null;
		}
		if(start == end){
			return new Node(in[start]);
		}
		for(int i = 0; i < level.length; i++){
			int data = level[i];
			for(int j = start; j < end; j++){
				if(data == in[j]){
					startNode = new Node(data);
					index = j;
					nodeFound = true;
					break;
				}
			}
			if(nodeFound){
				break;
			}
		}
		startNode.left = constructTree(startNode, in, level, start, index-1);
		startNode.right = constructTree(startNode, in, level, index+1, end);
		
		return startNode;
	}
}

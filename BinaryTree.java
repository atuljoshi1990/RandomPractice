package com.osu.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

import com.osu.node.Node;

public class BinaryTree {

	Node root;
	static int f = 0;
	static int s = 0;
	static int t = 0;

	public static void main(String args[]) {

		BinaryTree tree1 = createTree();

		System.out.println("PreOrder");
		preOrderTraversal(tree1);
		System.out.println("\n==========");
		System.out.println("PostOrder");
		postOrderTraversal(tree1);
		System.out.println("\n==========");
		System.out.println("InOrder");
		inOrderTraversal(tree1);
		System.out.println("\n==========");
		System.out.println("LevelOrder");
		levelOrderTraversal(tree1);
		System.out.println("\n==========");
		System.out.println("LevelOrderUsingQueue");
		levelOrderTraversalUsingQueue(tree1);
		System.out.println("\n==========");
		System.out.println("FindThreeLargestElementsInATree");
		find3LargestElements(tree1);
		System.out.println("\n==========");
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);
		tree.root.right = new Node(22);
		tree.root.right.right = new Node(25);
		System.out.println("FindMirrorTrees");
		boolean flag = areMirrorImages(tree1.root, tree.root);
		System.out.println(flag);
		System.out.println("==========");
		System.out.println("PrintBoundryTree");
		printBoundryOfATree(tree1);
		System.out.println("==========");
		System.out.println("FindLevelOfANode");
		int key = 4;
		int level = findLevelOfANode(tree1, key);
		System.out.println("Level of Node ("+key+"): "+level);
		System.out.println("==========");
		System.out.println("PrintAllAncestorsOfANode");
		printAllAncestors(tree1, key);
		System.out.println("\n==========");
		System.out.println("PrintNodesAtKDistanceFromRoot");
		printNodesAtKDistanceFromRoot(tree1, key);
	}
	
	private static void printNodesAtKDistanceFromRoot(BinaryTree tree1, int key) {
		
		printNodesAtKDistanceFromRoot(tree1.root, key, 0);
	}

	private static void printNodesAtKDistanceFromRoot(Node root, int key, int level) {
		
		if(root == null){
			return;
		}
		if(key == level){
			System.out.print(root.data+" ");
		}
		printNodesAtKDistanceFromRoot(root.left, key, level+1);
		printNodesAtKDistanceFromRoot(root.right, key, level+1);
	}

	public static void printAllAncestors(BinaryTree tree, int key){
		
		printAllAncestors(tree.root, key);
	}

	private static boolean printAllAncestors(Node root, int key) {
		
		if(root == null){
			return false;
		}
		if(root.data == key){
			return true;
		}
		if(printAllAncestors(root.left, key) || printAllAncestors(root.right, key)){
			System.out.print(root.data+" ");
			return true;
		}
		return false;
	}

	public static int findLevelOfANode(BinaryTree tree, int key){
		
		int level = findLevelOfANode(tree.root, key, 1);
		
		return level;
	}
	
	private static int findLevelOfANode(Node root, int key, int level) {
		
		int tempLevel = 0;
		if(root == null){
			return 0;
		}
		if(root.data == key){
			return level;
		}else{
			tempLevel = findLevelOfANode(root.left, key, level+1);
			if(tempLevel!=0){
				return tempLevel;
			}
			tempLevel = findLevelOfANode(root.right, key, level+1);
			if(tempLevel!=0){
				return tempLevel;
			}
		}
		return tempLevel;
	}

	private static void printBoundryOfATree(BinaryTree tree) {

		printBoundryOfATree(tree.root);
	}

	private static void printBoundryOfATree(Node root) {

		if (root != null) {
			System.out.print(root.data + " ");
			printLeftBoundry(root.left);
			printLeaves(root.left);
			printLeaves(root.right);
			printRightBoundry(root.right);
		}
	}

	private static void printRightBoundry(Node right) {

		if (right != null) {
			if (right.right != null) {
				printRightBoundry(right.right);
				System.out.print(right.data + " ");
			} else if (right.left != null) {
				printRightBoundry(right.left);
				System.out.print(right.data + " ");
			}
		}
	}

	private static void printLeaves(Node node) {

		if (node != null) {
			printLeaves(node.left);
			if (node.left == null && node.right == null) {
				System.out.print(node.data + " ");
			}
			printLeaves(node.right);
		}
	}

	private static void printLeftBoundry(Node left) {

		if (left != null) {
			if (left.left != null) {
				System.out.print(left.data + " ");
				printLeftBoundry(left.left);
			} else if (left.right != null) {
				System.out.print(left.data + " ");
				printLeftBoundry(left.right);
			}
		}
	}

	private static boolean areMirrorImages(Node root1, Node root2) {

		if (null == root1 && null == root2) {
			return true;
		}
		if (null == root1 || null == root2) {
			return false;
		}
		return root1.data == root2.data && areMirrorImages(root1.left, root2.right)
				&& areMirrorImages(root1.right, root2.left);
	}

	private static void find3LargestElements(BinaryTree tree) {

		find3LargestElements(tree.root);
		System.out.print("3 Largest elements: " + f + " " + s + " " + t + "");
	}

	private static void find3LargestElements(Node root) {

		if (root == null) {
			return;
		}
		if (root.data > f) {
			t = s;
			s = f;
			f = root.data;
		} else if (root.data > s && root.data != f) {
			t = s;
			s = root.data;
		} else if (root.data > t && root.data != f && root.data != s) {
			t = root.data;
		}
		find3LargestElements(root.left);
		find3LargestElements(root.right);
	}

	private static void levelOrderTraversalUsingQueue(BinaryTree tree) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(tree.root);
		queue.add(null);
		while (!queue.isEmpty()) {
			Node currentNode = queue.poll();
			if (null == currentNode) {
				if (!queue.isEmpty()) {
					queue.add(null);
					System.out.println();
				}
			} else {
				if (currentNode.left != null) {
					queue.add(currentNode.left);
				}
				if (currentNode.right != null) {
					queue.add(currentNode.right);
				}
				System.out.print(currentNode.data + " ");
			}
		}
	}

	private static void levelOrderTraversal(BinaryTree tree) {

		levelOrderTraversal(tree.root);
	}

	private static void inOrderTraversal(BinaryTree tree) {

		inOrderTraversal(tree.root);
	}

	private static void postOrderTraversal(BinaryTree tree) {

		postOrderTraversal(tree.root);
	}

	private static void preOrderTraversal(BinaryTree tree) {

		preOrderTraversal(tree.root);
	}

	private static BinaryTree createTree() {

		BinaryTree tree = new BinaryTree();
		Node root = new Node(1);
		tree.root = root;
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

		return tree;
	}

	public static void inOrderTraversal(Node root) {

		if (root == null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.print(root.data + " ");
		inOrderTraversal(root.right);
	}

	private static void preOrderTraversal(Node root) {

		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	private static void postOrderTraversal(Node root) {

		if (root == null) {
			return;
		}
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data + " ");
	}

	private static void levelOrderTraversal(Node root) {

		int height = calculateTreeHeight(root);
		for (int i = 1; i <= height; i++) {
			printLevelOrderTree(root, i);
		}
	}

	private static void printLevelOrderTree(Node root, int level) {

		if (null == root) {
			return;
		}
		if (level == 1) {
			System.out.print(root.data + " ");
		} else if (level > 1) {
			printLevelOrderTree(root.left, level - 1);
			printLevelOrderTree(root.right, level - 1);
		}
	}

	private static int calculateTreeHeight(Node root) {

		int lHeight = 0;
		int rHeight = 0;
		if (null == root) {
			return 0;
		} else {
			lHeight = calculateTreeHeight(root.left);
			rHeight = calculateTreeHeight(root.right);
			if (lHeight > rHeight) {
				lHeight = lHeight + 1;
				return lHeight;
			} else {
				rHeight = rHeight + 1;
				return rHeight;
			}
		}
	}
}

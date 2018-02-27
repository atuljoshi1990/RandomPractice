package com.osu.binaryTree;

import com.osu.node.Node;

public class ProductOfElementsAtKLevel {

	Node root;
	public static void main(String args[]){
		
		String treeInput = "(8(3(2()())(6(5()())()))(5(10()())(7(13()())())))";
		int level = 2;
		int product = createTree(treeInput, level);
		System.out.println("Product: "+product);
	}
	
	public static int createTree(String treeInput, int k){
		
		char charArr[] = treeInput.toCharArray();
		int level = -1;
		int product = 1;
		for(char c: charArr){
			if(c == '('){
				level = level+1;
				
			}else if(c == ')'){
				level = level-1;
			}else if(level == k){
				product = product * Integer.parseInt(Character.toString(c));
			}
		}
		
		return product;
	}
}

package com.mentes.dsa.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTest {
	
	//tree
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
		}
	}
	
	//complexity O(n) DFS
	public static void preorder(Node root) {
		if(root == null) {
//			System.out.print("-1 ");
			return;
		}
		System.out.print(root.data +" ");
		preorder(root.left);
		preorder(root.right);
		
	}
	//DFS
	public static void inorder(Node root) {
		if(root == null) {
//			System.out.print("-1 ");
			return;
		}
		inorder(root.left);
		System.out.print(root.data +" ");
		inorder(root.right);
		
	}
	
	//DFS
	public static void postorder(Node root) {
		if(root == null) {
//			System.out.print("-1 ");
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data +" ");
		
	}
	
	//level order traversal O(n)
	public static void levelOrder(Node root) {
		Queue<Node> q = new LinkedList<BinaryTreeTest.Node>();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			Node curNode = q.remove();
			if(null == curNode) {
				System.out.println();
				if(q.isEmpty()) {
					break;
				} else {
					q.add(null);
				}
			} else {
				System.out.print(curNode.data +" ");
				if(curNode.left != null)
				q.add(curNode.left);
				
				if(curNode.right != null)
				q.add(curNode.right);
			}
		}
	}
	
	//O(n)
	public static int countNodes(Node root) {
		if(root == null) {
		return 0;
		}
		
		int leftNodes = countNodes(root.left);
		int rightNodes = countNodes(root.right);
		return leftNodes + rightNodes +1;
	}
	
	public static int sumOfNodes(Node root) {
		if(root == null) {
			return 0;
		} 
		
		int leftSum = sumOfNodes(root.left);
		int rightSum = sumOfNodes(root.right);
//		System.out.print(root.data + " " + leftSum +" , "+rightSum + ", ");
		return leftSum + rightSum + root.data;
	}
	
	public static int heightOfTree(Node root) {
		if(root == null) {
			return 0;
		} 
		
		int leftHeight = heightOfTree(root.left);
		int rightHeight = heightOfTree(root.right);
		int height = Math.max(leftHeight, rightHeight) +1;
				
		return height;
	}
	
	public static int diameter(Node root) {
		if(root == null) {
			return 0;
		} 
		
		int leftHeight = diameter(root.left);
		int rightHeight = diameter(root.right);
		int height = Math.max(leftHeight, rightHeight) +1;
				
		return height;
	}
	
	static class BinaryTree{
		static int idx=-1;
		public Node buildTree(int[] nodes) {
			idx++;
			
			if(nodes[idx]== -1) {
				return null;
			}
			
			Node node = new Node(nodes[idx]);
			node.left = buildTree(nodes);
			node.right = buildTree(nodes);
			
			return node;		
			
		}
		
	}
	public static void main(String[] args) {
		int nodes[] = {3,2,4,-1,-1, 6, -1, -1, 5, 7, -1, -1,  1, -1, -1 };
		BinaryTree binaryTree = new BinaryTree();
		Node root = binaryTree.buildTree(nodes);
		
		System.out.println("Root node of tree : -> " +root.data);
		
		System.out.println("PRE Order Traversal");
		preorder(root);
		
		System.out.println("\nIn Order Traversal");
		inorder(root);
		
		System.out.println("\nPost Order Traversal");
		postorder(root);
		
		System.out.println("\n Level Order Traversal");
		levelOrder(root);
		
		System.out.println("\n total number of node counts "+countNodes(root));
		
		System.out.println("\n sum of node counts "+sumOfNodes(root));
		
		System.out.println("\n heightOfTree is  "+heightOfTree(root));
		
		
	}
	/**
	 * 		3(root)
	 *	  2(L)	  	5(R)
	 * 4(L)	 6(R) 7(L)  1(R)
	 * 
	 * 
	 * 
	 */
}

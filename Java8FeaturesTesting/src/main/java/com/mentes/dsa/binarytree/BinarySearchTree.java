package com.mentes.dsa.binarytree;

import java.util.ArrayList;

import com.mentes.dsa.binarytree.BinaryTreeTest.Node;

public class BinarySearchTree {
	
	static class Node {
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static Node insert(Node root, int val) {
		if(root == null) {
			root = new Node(val);
			return root;
		}
		if(root.data > val) {
			root.left = insert(root.left , val);
		} else {
			root.right = insert(root.right , val);
		}
		
		return root;
	}
	
	//left root right
	public static void inorder(Node root) {
		if(root == null) {
			return;
		}
		
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	private static boolean keyFound = false;
	//left root right
		public static boolean search(Node root, int key) {
			if(root == null) {
				return false;
			}
			System.out.print(root.data + " ");
			
			
			if(key < root.data) {
				return search(root.left, key);
			}
			else if(root.data == key) {
				return true;
			}else {
				return search(root.right, key);
			}
			
		}
		
		public static Node deleteNode(Node root, int val) {
			if(root ==null)
				return null;
			
			if(root.data > val) {
				root.left = deleteNode(root.left, val);
			} else if(root.data < val) {
				root.right = deleteNode(root.right, val);
			} else {
				//case 1 leaf node
				if(root.left == null && root.right == null)
					return null;
				
				//case 2 either one leaf present
				if(root.left == null) {
					return root.right;
				} else if(root.right == null) {
					return root.left;
				}
				
				//case 3 both childs present
				Node IS = inorderSuccessor(root.right);
				root.data = IS.data;
				root.right = deleteNode(root.right, IS.data);
				
			}
			
			return root;
		}
	public static Node inorderSuccessor(Node root) {
		while(root.left != null) {
			root = root.left;
		}
		return root;
	}
	
	public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
		if(root == null) {
			return;
		}
		path.add(root.data);
		if(root.left == null && root.right==null) {
			printPath(path);
		} else {
			printRoot2Leaf(root.left, path);
			printRoot2Leaf(root.right, path);
		}
		path.remove(path.size()-1);
	}
	public static void printPath(ArrayList<Integer> leafPath) {
		for(int i=0; i<leafPath.size(); i++) {
			System.out.print(leafPath.get(i) + "->");
		}
		System.out.println();
	}
	//		   5
	//     4	  7
	// 	 2	     6   8
	// 1  3
	public static void main(String[] args) {
		int nodes[] = {5, 4, 2, 3, 7, 6, 8 ,1}; //8,5,3,6,10,11,14
		Node root = null;
		for(int val : nodes) {
			root = insert(root, val);
		}
		
		inorder(root);
		System.out.println();
		inorder(root);
		System.out.println();
		System.out.println("\nIs key present in tree key =3 "+search(root, 3));
		System.out.println("Is key present in tree key =1 "+search(root, 1));
		System.out.println("Is key present in tree key =8  "+search(null, 8));
		System.out.println("Is key present in tree key =5  "+search(root, 5));
		
//		deleteNode(root, 1);
//		inorder(root);
//		System.out.println();
//		
//		deleteNode(root, 6);
//		inorder(root);
//		System.out.println();
		
//		deleteNode(root, 5);
		inorder(root);
		
		System.out.println("\n" +root.data);
		
		printRoot2Leaf(root, new ArrayList<Integer>());
	}

}

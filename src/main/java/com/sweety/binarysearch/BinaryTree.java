package com.sweety.binarysearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	private Node root;
	
	public BinaryTree createBinaryTree() {
	    BinaryTree bt = new BinaryTree();
	 
	    bt.add(6);
	    bt.add(4);
	    bt.add(8);
	    bt.add(3);
	    bt.add(5);
	    bt.add(7);
	    bt.add(9);
	 
	    return bt;
	}

	public Node add(int value) {
		root = addNodeUsingRecursion(root, value);
		return root;
	}
	
	public boolean isEmpty() {
		return this.root == null;
	}

	public Node addNodeUsingRecursion(Node node, int value) {

		Node current = node;

		if (current == null) {
			return new Node(value);
		}

		if (value < current.value) {
			current.left = addNodeUsingRecursion(current.left, value);
		} else if (value > current.value) {
			current.right = addNodeUsingRecursion(current.right, value);
		} else {
			return current;
		}

		return current;
	}

	public boolean containsNode(Node node, int value) {

		if (node == null) {
			return false;
		}
		if (value == node.value) {
			return true;
		}

		return value < node.value ? containsNode(node.left, value) : containsNode(node.right, value);
	}

	public List<Integer> preOrderTraversalWithoutRecursion(Node node) {
		List<Integer> list = new ArrayList();
		Stack<Node> stack = new Stack();
		stack.push(node);

		while (!stack.isEmpty()) {
			Node currentNode = stack.peek();
			list.add(Integer.valueOf(currentNode.value));
			stack.pop();
			if (currentNode.right != null) {
				stack.push(currentNode.right);
			}
			if (currentNode.left != null) {
				stack.push(currentNode.left);
			}
		}
		return list;
	}

	public List<Integer> preOrderTraversal(Node node) {
		List<Integer> list = new ArrayList<Integer>();

		if (node == null) {
			return list;
		}

		list.add(node.value);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);

		return list;
	}

	public List<Integer> postOrderTraversal(Node node) {
		List<Integer> list = new ArrayList<Integer>();

		if (node == null) {
			return list;
		}

		list.add(node.value);
		preOrderTraversal(node.right);
		preOrderTraversal(node.left);

		return list;
	}

	public List<Integer> inOrderTraversal(Node node) {
		List<Integer> list = new ArrayList<Integer>();

		if (node == null) {
			return list;
		}

		preOrderTraversal(node.left);
		list.add(node.value);
		preOrderTraversal(node.right);

		return list;
	}

	public List<Integer> traverseLevelOrder(Node node) {
		List<Integer> list = new ArrayList<Integer>();

		Queue<Node> queue = new LinkedList<BinaryTree.Node>();
		queue.add(node);

		while (!queue.isEmpty()) {
			Node currentNode = queue.peek();
			list.add(currentNode.value);
			queue.remove();

			if (currentNode.left != null) {
				queue.add(currentNode.left);
			}

			if (currentNode.right != null) {
				queue.add(currentNode.right);
			}

		}

		return list;
	}

	public List<Integer> postOrderTraversalWithoutRecursion(Node node) {
		List<Integer> list = new ArrayList();
		Stack<Node> stack = new Stack();
		stack.push(node);

		while (!stack.isEmpty()) {
			Node currentNode = stack.peek();
			list.add(Integer.valueOf(currentNode.value));
			stack.pop();
			if (currentNode.left != null) {
				stack.push(currentNode.left);
			}
			if (currentNode.right != null) {
				stack.push(currentNode.right);
			}
		}
		return list;
	}

//	TODO : 
//	public List<Integer> inOrderTraversalWithoutRecursion(Node node) {
//		return list;
//	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();

		bt.add(6);
		bt.add(4);
		bt.add(8);
		bt.add(3);
		bt.add(5);
		bt.add(7);
		bt.add(9);

		System.out.println(bt);

	}

	public class Node {

		int value;
		Node left = null, right = null;

		public Node(int value) {
			this.value = value;
			left = right = null;
		}

	}

}

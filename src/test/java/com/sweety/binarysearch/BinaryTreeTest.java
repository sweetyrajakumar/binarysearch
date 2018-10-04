package com.sweety.binarysearch;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BinaryTreeTest {

	@Test
	public void shouldAddNodes() {

		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinaryTree();
		assertTrue(!binaryTree.isEmpty());

	}

}

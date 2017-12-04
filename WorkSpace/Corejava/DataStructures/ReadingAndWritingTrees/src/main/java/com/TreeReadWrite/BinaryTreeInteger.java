package com.TreeReadWrite;

import java.io.*;

public class BinaryTreeInteger {
	public BinaryTreeInteger left, right;
	public Integer data;

	public static BinaryTreeInteger tree_AddNumber(BinaryTreeInteger r,
			Integer n) {
		if (r == null) {
			r = new BinaryTreeInteger();
			r.left = r.right = null;
			r.data = n;
		} else if (r.data.compareTo(n) < 0)
			r.right = tree_AddNumber(r.right, n);
		else
			r.left = tree_AddNumber(r.left, n);
		return r;
	}

	public static void tree_InOrderPrint(BinaryTreeInteger r) {
		if (r != null) {
			tree_InOrderPrint(r.left);
			System.out.print(" " + r.data);
			tree_InOrderPrint(r.right);
		}
	}

	public static void tree_FileWrite(BinaryTreeInteger r,
			DataOutputStream output) throws IOException {
		if (r != null) {
			output.writeBoolean(true);
			output.writeInt(r.data.intValue());
			tree_FileWrite(r.left, output);
			tree_FileWrite(r.right, output);
		} else
			output.writeBoolean(false);
	}

	public static BinaryTreeInteger tree_FileRead(BinaryTreeInteger r,
			DataInputStream input) throws IOException {
		if (input.readBoolean()) {
			r = new BinaryTreeInteger();
			r.data = new Integer(input.readInt());
			r.left = tree_FileRead(r.left, input);
			r.right = tree_FileRead(r.right, input);
		} else
			r = null;
		return r;
	}

	public static boolean tree_Compare(BinaryTreeInteger a, BinaryTreeInteger b) {
		if (a != null && b != null) {
			return a.data.compareTo(b.data) == 0
					&& tree_Compare(a.left, b.left)
					&& tree_Compare(a.right, b.right);
		} else if (a == null && b == null)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		File file = new File("BinaryTreeInteger.dat");
		BinaryTreeInteger read_tree = null, tree = null;
		System.out.print("inserting: ");
		for (int i = 0; i < 10; i++) {
			Integer n = new Integer((int) (Math.random() * 100));
			System.out.print(" " + n);
			tree = tree_AddNumber(tree, n);
		}
		System.out.print("\ntree: ");
		tree_InOrderPrint(tree);
		System.out.println("\nwriting to " + file);
		try {
			tree_FileWrite(tree, new DataOutputStream(
					new FileOutputStream(file)));
		} catch (IOException e) {
			System.out.println(e);
		}

		System.out.println("reading from " + file);
		try {
			read_tree = tree_FileRead(read_tree, new DataInputStream(
					new FileInputStream(file)));
		} catch (IOException e) {
			System.out.println(e);
		}

		System.out.print("read tree: ");
		tree_InOrderPrint(read_tree);

		if (tree_Compare(tree, read_tree))
			System.out.println("\nThe two trees are identical.");
		else
			System.out.println("\nThe two trees are different.");
		System.out.println("done ;-)");
	}
}

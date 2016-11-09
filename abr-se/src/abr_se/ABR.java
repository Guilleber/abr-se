package abr_se;

import java.util.List;
import java.util.ArrayList;

public class ABR {
	public class Node {
		private int value;
		public Node childLeft = null;
		public Node childRight = null;
		
		Node(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
	}
	
	private Node root = null;
	private int nbElements = 0;
	
	ABR() {}
	
	public void insert(int value) {
		if(root == null) {
			root = new Node(value);
			nbElements += 1;
		}
		else
			insert(value, root);
	}
	
	private void insert(int value, Node node) {
		if(value != node.getValue()) {
			if(value > node.getValue()) {
				if(node.childRight == null) {
					node.childRight = new Node(value);
					nbElements += 1;
				}
				else
					insert(value, node.childRight);
			} else {
				if(node.childLeft == null) {
					node.childLeft = new Node(value);
					nbElements += 1;
				}
				else
					insert(value, node.childLeft);
			}
		}
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public int nbElements() {
		return nbElements;
	}
	
	public void toList(List<Integer> l) {
		if(root != null)
			toList(l, root);
	}
	
	private void toList(List<Integer> l, Node node) {
		if(node.childLeft != null) {
			List<Integer> listLeft = new ArrayList<Integer>();
			toList(listLeft, node.childLeft);
			l.addAll(listLeft);
		}
		l.add(node.getValue());
		if(node.childRight != null) {
			List<Integer> listRight = new ArrayList<Integer>();
			toList(listRight, node.childRight);
			l.addAll(listRight);
		}
	}
	
	public boolean contains(int value) {
		return contains(value, root);
	}
	
	private boolean contains(int value, Node node) {
		if(node.getValue() == value)
			return true;
		else {
			boolean bl = false;
			boolean br = false;
			if(node.childLeft != null)
				bl = contains(value, node.childLeft);
			if(node.childRight != null)
				br = contains(value, node.childRight);
			return bl || br;
		}
	}
}
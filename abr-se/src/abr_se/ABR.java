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
	
	/**
    * Adds the specified element to this ABR if it is not already present
	* @param value element to be inserted
    */
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
	
	/**
    * Returns true if this ABR contains no elements.
	* @return true if this ABR contains no elements
    */
	public boolean isEmpty() {
		return root == null;
	}
	
	/**
    * Returns the number of element in this ABR
	* @return number of elements in this ABR
    */
	public int nbElements() {
		return nbElements;
	}
	
	/**
    * Fill a list with the elements in this ABR in ascending order.
	* @param l the list into which the elements of the ABR are to be stored
    */
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
	
	/**
    * Returns true if this ABR contains the specified element.
	* @param value element whose presence in this ABR is to be tested
	* @return true if this ABR contains the specified element.
    */
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
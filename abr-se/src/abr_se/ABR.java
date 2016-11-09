package abr_se;

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
}
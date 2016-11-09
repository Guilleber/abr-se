package abr-se;

public class ABR() {
	public class Node() {
		private int value;
		public Node childLeft = null;
		public Node childRight = null;
		
		Node(int value) {
			this.value = value;
		}
	}
	
	private Node root = null;
	
	ABR() {}
}
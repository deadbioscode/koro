package uk.co.pocketinventor.util.device;

// General Device Node
public class Node {

	private String id = "";
	
	public Node(String identifier) {
		this.setId(identifier);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}

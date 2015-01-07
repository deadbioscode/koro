package uk.co.pocketinventor.util.device;

import uk.co.pocketinventor.util.connection.serial.SerialNode;

public class Arduino extends Node implements SerialNode {

	/**
	 *  Creates a new arduino node with a node <code>id</code>
	 *  @param id - Identifier of the node
	 */
	public Arduino(String id) {
		super(id);
	}

}

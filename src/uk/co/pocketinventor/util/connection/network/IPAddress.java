package uk.co.pocketinventor.util.connection.network;

public class IPAddress {

	public int a=255, b=255, c=255, d=255;
	
	/**
	 * Creates address for the given address (a.b.c.d)
	 */
	public IPAddress(int a, int b, int c, int d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	/**
	 * Creates address for local host (127.0.0.1)
	 */
	public IPAddress() {
		this(127, 0, 0, 1);
	}

	/**
	 * Creates address for local network (192.168.c.d)
	 * @param c - network branch
	 * @param d - network leaf
	 */
	public IPAddress(int c, int d) {
		this(192, 168, c, d);
	}
	
	/**
	 * Creates address for local network (192.168.0.d)
	 * @param d - network leaf
	 */
	public IPAddress(int d) {
		this(192, 168, 0, d);
	}
	
	/**
	 * Returns the ip address in string format
	 */
	public String asString() {
		return "" + a + "." + b + "." + c + "." + d;
	}
	
}
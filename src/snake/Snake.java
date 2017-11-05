package snake;

import hacking.sneks.Snek;
import snake.node.Node;

/**
 * Singly linked list implementation of the {@link hacking.sneks.Snek} interface.
 * This class implements all methods specified in the {@link hacking.sneks.Snek} interface.
 * {@code null} is never a valid element.
 */
public class Snake implements Snek {
	Node _head;
	int  _size;
	
	/**
	 * Creates an empty {@link Snek}.
	 */
	public Snake() {
		// TODO
	}
	
	@Override
	public <E> void add(E elem) {
		// TODO
	}
	
	@Override
	public <E> boolean remove(E elem) {
		// TODO
		return false;
	}
	
	@Override
	public <E> E get(int index) {
		// TODO
		return null;
	}
}

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
	
	/**
	 * @throws IllegalArgumentException if the supplied element is {@code null}.
	 */
	@Override
	public <E> void add(E elem) {
		
		if(_head != null) {
			
			Node oldNode = _head; 
			_head = new Node(elem, oldNode);
			
		}
		else {
			
			Node firstOne = new Node(elem, null);
		}
		
	}
	
	/**
	 * @throws IndexOutOfBoundsException if index < 0 && index > size
	 */
	@Override
	public <E> void add(int index, E elem) {
		
	}
	
	/**
	 * @throws NullPointerException if the supplied element is {@code null}.
	 */
	@Override
	public <E> boolean remove(E elem) {
		// TODO
		return false;
	}
	
	/**
	 * @throws IndexOutOfBoundsException if index < 0 && index >= size
	 */
	@Override
	public <E> void remove(int index) {
		// TODO
	}
	
	/**
	 * @throws IndexOutOfBoundsException if index < 0 && index >= size
	 */
	@Override
	public <E> E get(int index) {
		// TODO
		return null;
	}

	@Override
	public <E> int getIndexOf(E elem) {
		// TODO
		return 0;
	}
	
	@Override
	public int size() {
		// TODO
		return 0;
	}
}

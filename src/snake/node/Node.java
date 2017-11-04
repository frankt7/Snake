package snake.node;

import com.sun.org.apache.bcel.internal.generic.Type;

import snake.wrapper.Element;
import snake.wrapper.ElementType;

/**
 * A single entry of a singly linked list. This type of {@code Node} is designed 
 * for the {@link snake.Snake} data structure.
 */
public class Node {
	/**
	 * Fields
	 * 
	 * _next - a reference to the next node.
	 * _elem - the element stored in this node.
	 */
	Node        _next;
	ElementType _elem;
	
	/**
	 * Creates an instance of {@link Node} which has a reference to the next {@link Node}.
	 * @param elem - the element to be stored.
	 * @param next - a reference to the next {@link Node}.
	 */
	public <E> Node(E elem, Node next) {
		
		_elem = new Element<E>(elem);
		
		this._next = next;
	}
	
	/**
	 * Creates an instance of {@link Node}.
	 * @param elem - the element to be stored.
	 */
	public <E> Node(E elem) {
		this(elem, null);
	}
	
	/**
	 * Returns the next {@link Node}.
	 * @return the next {@link Node}.
	 */
	public Node getNext() {

		return _next;
	}
	
	/**
	 * Sets the next {@link Node} to the supplied argument.
	 * @param nextNode - the next {@link Node}.
	 */
	public void setNext(Node nextNode) {
		
		this._next = nextNode;
	}
	
	/**
	 * Sets the element of this {@link Node} to the supplied argument.
	 * @param elem - the new element to be stored.
	 */
	public <E> void setElement(E elem) {
		
		_elem = new Element<E>(elem);
	}
	
	/**
	 * Returns the element stored in this {@link Node}.
	 * Client is responsible for knowing the type of the stored element.
	 * @return the element stored in this {@link Node}.
	 */ 
	public <E> E getElement() {
		
		Element<E> elem = (Element<E>) _elem;
		
		return elem.getElement();
	}
	
	/**
	 * Returns the type of the element of this {@link Node}.
	 * The returned value is whatever returned by calling
	 * {@code (...).getClass().getName()}
	 * @return the type of the element of this {@link Node}.
	 */
	public <E> String getType() {
		
		Element<E> type = (Element<E>) _elem;
		
		return type.getType();
	}
}

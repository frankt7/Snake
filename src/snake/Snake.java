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
		_head=null;
		_size=0;
	}
	
	/**
	 * @throws IllegalArgumentException if the supplied element is {@code null}.
	 */
	@Override
	public <E> void add(E elem) {
		
		if(_head != null) {
			
			add(0, elem);			
		}
		else {
			
			new Node(elem, null);
			++_size;
		}
		
	}
	
	/**
	 * @throws IndexOutOfBoundsException if index < 0 && index > size
	 */
	@Override
	public <E> void add(int index, E elem) {
		
		if(index < 0 || index > _size) {
			
			throw new IndexOutOfBoundsException("index does not exist");
		}	
		else if(index == 0) {
			
			Node oldNode = _head; 
			_head = new Node(elem, oldNode);
			++_size;
		}
		else if(index == _size) {
			
			Node newNode = new Node(elem, null);
			Node oldNode = get(_size);
			oldNode.setNext(newNode);
			++_size;
		}
		else {
			
			Node prevNode = get(_size - 1);
			Node newNode = new Node(elem, prevNode.getNext());
			prevNode.setNext(newNode);
			++_size;
		}
		
	}
	
	/**
	 * @throws NullPointerException if the supplied element is {@code null}.
	 */
	@Override
	public <E> boolean remove(E elem) {
		Node temp=_head;
		Node old=temp;
		if(temp!=null&&temp!=elem)//head is one increment above old
		{
			temp=temp.getNext();
		}
		else if(temp!=null)//if elem is head
		{
			_head=temp.getNext();
			temp.setNext(null);
			return true;
		}
		else
		{
			return false; //can't remove when list is empty
		}
		while(temp!=null&&temp!=elem)
		{
			temp=temp.getNext();
			old=old.getNext();
		}
		if(temp==elem)
		{
			old.setNext(temp.getNext());
			return true;
		}
		
		return false;
	}
	
	/**
	 * @throws IndexOutOfBoundsException if index < 0 && index >= size
	 */
	@Override
	public <E> void remove(int index) {
		Node temp= _head;
		int i=0;
		while(i<this._size){
			if(i+1==index)
			{
				temp.setNext(temp.getNext().getNext());
				break;
			}
			
			temp=temp.getNext();
			i=i+1;
		}
	}
	
	/**
	 * @throws IndexOutOfBoundsException if index < 0 && index >= size
	 */
	@Override
	public <E> E get(int index) {
		int i=0;
		Node temp=_head;
		while(i<this._size){
			if(i== index)
			{
				return temp.getElement();
			}
			temp=temp.getNext();
			i=i+1;
		}
		throw new IndexOutOfBoundsException();
	}

	@Override
	public <E> int getIndexOf(E elem) {
		
		for(int i = 0; i < _size; i++) {
			if(get(i) == elem) {
				return get(i);
			}
		}
		return -1;
	}
	
	@Override
	public int size() {

		return _size;
	}
}

package snake.wrapper;

/**
 * An immutable wrapper class that wraps an element.
 * If the wrapped element is mutable, this class does
 * not guarantee its integrity.
 * @param <E> the type of the element.
 * @see {@link ElementType}
 */
public class Element<E> implements ElementType {
	/**
	 * Fields
	 * 
	 * _elem - the element.
	 * _type - the type of the element.
	 */
	private E        _elem;
	private Class<?> _type;
	
	/**
	 * Creates an instance of {@link Element}. If the supplied
	 * argument is {@code null}, a {@link java.lang.IllegalArgumentException}
	 * is thrown.
	 * @param elem - the element to be stored.
	 * @throws IllegalArgumentException if {@code elem} is {@code null}. 
	 */
	public Element(E elem) {
		if(elem == null) {
			throw new IllegalArgumentException("null is not a valid element for the wrapper");
		}
		
		_elem = elem;
		_type = _elem.getClass();
	}
	
	/**
	 * Returns the wrapped element of this {@link Element} instance.
	 * @return the wrapped element.
	 */
	public E getElement() {
		return _elem;
	}
	
	/**
	 * Returns the wrapped element's type.
	 * @return the wrapped element's type.
	 */
	public Class<?> getType() {
		return _type;
	}
}
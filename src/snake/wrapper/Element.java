package snake.wrapper;

/**
 * An immutable wrapper class that wraps an element.
 * If the wrapped element is mutable, this class does
 * not guarantee its integrity.
 * @param <E> the type of the element.
 */
public class Element<E> {
	/**
	 * Fields
	 * 
	 * _elem - the element.
	 * _type - a string representation of the element's type.
	 *         the string representation is simply the value returned by
	 *         _elem.getClass().getName()
	 */
	private E      _elem;
	private String _type;
	
	/**
	 * Creates an instance of {@link Element}. If the supplied
	 * argument is {@code null}, a {@link java.lang.IllegalArgumentException}
	 * is thrown.
	 * @param elem - the element to be stored.
	 * @throws IllegalArgumentException if {@code elem} is {@code null}. 
	 */
	public Element(E elem) {
		// TODO
	}
	
	/**
	 * Returns the wrapped element of this {@link Element} instance.
	 * @return the wrapped element.
	 */
	public E getElement() {
		// TODO
		return null;
	}
	
	/**
	 * Returns the {@code String} representation of the wrapped element's type.
	 * @return the {@code String} representation of the wrapped element's type.
	 */
	public String getType() {
		// TODO
		return null;
	}
}
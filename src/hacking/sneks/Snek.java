package hacking.sneks;

/**
 * An ordered list of objects of different (or same) types.
 * The user can access the element by their integer index (position in the list).
 * Unlike {@link java.util.Set}s, duplicate elements are allowed. However, {@code null}
 * is never a valid element.
 */
public interface Snek {
	/**
	 * Adds an element to the front of this list.
	 * @param elem - the element to be added
	 */
	public <E> void add(E elem);
	
	/**
	 * Adds an element to the supplied position of this list. This method must throw an unchecked
	 * exception if the supplied index is not a valid position.
	 * @param index - the position of the element to insert.
	 * @param elem  - the element to be added.
	 * @throws RuntimeException if index is not a valid position.
	 */
	public <E> void add(int index, E elem);
	
	/**
	 * Removes the first occurrence of element which is equal to the supplied argument from
	 * the list. If the an element is removed from this list, {@code true} is returned;
	 * otherwise {@code false} is returned. {@link Object#equals(Object)} must be
	 * overridden properly for this method to work.
	 * @param elem - the element to be removed
	 * @return {@code true} if an element is remove; {@code false} otherwise.
	 */
	public <E> boolean remove(E elem);
	
	/**
	 * Removes the element at the supplied index. This method must throw an unchecked exception
	 * if the supplied index is not a valid position.
	 * @param index - the position of the element to be removed.
	 * @throws RuntimeException if index is not a valid position.
	 */
	public <E> void remove(int index);
	
	/**
	 * Returns the index where the supplied argument can be found. If the supplied element does not
	 * exist in the list, -1 is returned. {@link Object#equals(Object)} must be
	 * overridden properly for this method to work.
	 * @param elem - the element to be found.
	 * @return -1 if element cannot be found; otherwise the index of the element.
	 */
	public <E> int getIndexOf(E elem);
	
	/**
	 * Returns the element at the supplied index. This method must throw an unchecked exception
	 * if the supplied index is not a valid position.
	 * @param index - the position of the element.
	 * @return the element at that position
	 * @throws RuntimeExcpetion if index is not a valid position.
	 */
	public <E> E get(int index);
	
	/**
	 * Returns the number of elements stored in this list.
	 * @return the number of elements stored in this list.
	 */
	public int size();
}
